package org.rihteri.clickblink;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.Session;

/**
 * A silly class for handling message passing between servlets. In a
 * real system, we would use a real message broker.
 * @author rihteri
 *
 */
public class BlinkBroker {	
	/**
	 * Add a new session to be messaged for
	 * @param sess The session to register. After this, do not 
	 *             send messages to the session from elsewhere
	 * @throws IllegalStateException thrown if the session given has already
	 * 								 been added
	 */
	public void registerSession(Session sess)
			throws IllegalStateException {
		if (sessions.containsKey(sess)) {
			throw new IllegalStateException("Item already added");
		}
		
		sessions.put(sess, new SafeSession(sess));
	}
	
	/**
	 * Remove a session after the user left
	 * @param sess
	 */
	public void deregisterSession(Session sess) {
		sessions.remove(sess);
	}
	
	/**
	 * Send a blink event to all connected clients
	 * @param ev
	 */
	public void sendBlink(BlinkEvent ev) {
		for (SafeSession s : sessions.values()) {
			try {
				s.sendObject(ev);
			} catch (IOException e) {
				// other side disconnected
				sessions.remove(s);
			} catch (EncodeException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	/**
	 * Gets the singleton instance
	 * @return
	 */
	public static BlinkBroker getBroker() {
		return broker;
	}
	
	private static final BlinkBroker broker = new BlinkBroker();
	
	private Map<Session, SafeSession> sessions 
		= Collections.synchronizedMap(new HashMap<Session, SafeSession>());
}
