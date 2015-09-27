package org.rihteri.clickblink;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ServerEndpoint(value = "/clicks", encoders = { JsonEncoder.class })
public class BlinkChannelHandler {
	@OnOpen
    public void onOpen(Session session) throws IOException {
		BlinkBroker.getBroker().registerSession(session);
    }

    @OnMessage
    public void createBlink(String message)
    		throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();
		BlinkEvent ev = mapper.readValue(message, BlinkEvent.class);
		
		BlinkBroker.getBroker().sendBlink(ev);
    }

    @OnClose
    public void onClose(Session session) {
    	BlinkBroker.getBroker().deregisterSession(session);
    }
}
