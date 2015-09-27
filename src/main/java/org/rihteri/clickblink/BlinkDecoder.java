package org.rihteri.clickblink;

import java.io.IOException;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class handles decoding of JSON messages
 * @author rihteri
 *
 */
public class BlinkDecoder  implements Decoder.Text<BlinkEvent>  {

	@Override
	public void init(EndpointConfig endpointConfig) {
		mapper = new ObjectMapper();		
	}

	@Override
	public void destroy() {	}

	/**
	 * Decode a BlinkEvent object from JSON
	 */
	@Override
	public BlinkEvent decode(String s) throws DecodeException {
		try {
			return mapper.readValue(s, BlinkEvent.class);
		} catch (IOException e) {
			throw new DecodeException(s, "Cannot decode", e);
		}
	}

	@Override
	public boolean willDecode(String s) {
		return true;
	}

	private ObjectMapper mapper;
}
