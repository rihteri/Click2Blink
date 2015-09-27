package org.rihteri.clickblink;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles encoding arbitrary objects as JSON with the jackson JSON library
 * @author rihteri
 *
 */
public class JsonEncoder implements Encoder.Text<Object> {

	@Override
	public void init(EndpointConfig endpointConfig) {
		mapper = new ObjectMapper();
	}

	@Override
	public void destroy() {
		
	}

	/***
	 * Encodes a message as JSON
	 */
	@Override
	public String encode(Object object) throws EncodeException {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new EncodeException(object, "Cannot create JSON", e);
		}
	}

	private ObjectMapper mapper = null;
}
