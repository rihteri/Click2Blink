package org.rihteri.clickblink;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.websocket.EncodeException;
import javax.websocket.Session;

/**
 * Due to RemoteEndpoint.Basic not being guaranteed thread safe, this
 * class acts as a syncronizer for message sending
 * @author rihteri
 *
 */
public class SafeSession {
	/**
	 * Construct a new safe session object
	 * @param session
	 */
	public SafeSession(Session session) {
		this.session = session;
	}
	
	/**
	 * Send a message when the underlying websocket becomes free
	 * @param obj the data to send
	 * @throws EncodeException may be thrown by underlying RemoteEndpoint.Basic
	 * @throws IOException may be thrown by underlying RemoteEndpoint.Basic
	 */
	public void sendObject(Object obj) throws IOException, EncodeException {
		lock.lock();
		try {
			session.getBasicRemote().sendObject(obj);
		} finally {
			lock.unlock();
		}
	}
	
	Session session = null;
	Lock lock = new ReentrantLock();
}

