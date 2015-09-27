package org.rihteri.clickblink;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * This class takes care of receiving new clicks on our web app
 * @author rihteri
 *
 */
@ServerEndpoint(value = "/clicks",
				encoders = { JsonEncoder.class },
				decoders = { BlinkDecoder.class },
				configurator = BlinkWebsocketConfigurator.class)
public class BlinkChannelHandler {
	/**
	 * Called when a new session is being opened. It will be stored in
	 * the 'broker' for message propagation.
	 * @param session
	 * @throws IOException
	 */
	@OnOpen
    public void onOpen(Session session) throws IOException {
		BlinkBroker.getBroker().registerSession(session);
    }

	/**
	 * Called when a click is received on the web app
	 * @param ev
	 */
    @OnMessage
    public void createBlink(BlinkEvent ev) {
		BlinkBroker.getBroker().sendBlink(ev);
    }

    /**
     * Called when a client disconnects. They will no longer receive
     * new blinks after that
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
    	BlinkBroker.getBroker().deregisterSession(session);
    }
}
