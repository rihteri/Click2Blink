package org.rihteri.clickblink;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
	 * @param sess
	 */
	public void registerSession(Session sess) {
		sessions.add(sess);
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
		for (Session s : sessions) {
			try {
				s.getBasicRemote().sendObject(ev);
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
	 * Gets the shared instance
	 * @return
	 */
	public static BlinkBroker getBroker() {
		return broker;
	}
	
	private static final BlinkBroker broker = new BlinkBroker();
	
	private Set<Session> sessions 
		= Collections.synchronizedSet(new HashSet<Session>());
}
