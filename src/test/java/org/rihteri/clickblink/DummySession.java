package org.rihteri.clickblink;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.Extension;
import javax.websocket.MessageHandler;
import javax.websocket.MessageHandler.Partial;
import javax.websocket.MessageHandler.Whole;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class DummySession implements javax.websocket.Session {

	@Override
	public WebSocketContainer getContainer() {
		return null;
	}

	@Override
	public void addMessageHandler(MessageHandler handler)
			throws IllegalStateException { }

	@Override
	public Set<MessageHandler> getMessageHandlers() {
		return null;
	}

	@Override
	public void removeMessageHandler(MessageHandler listener) { }

	@Override
	public String getProtocolVersion() {
		return null;
	}

	@Override
	public String getNegotiatedSubprotocol() {
		return null;
	}

	@Override
	public List<Extension> getNegotiatedExtensions() {
		return null;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public long getMaxIdleTimeout() {
		return 0;
	}

	@Override
	public void setMaxIdleTimeout(long timeout) { }

	@Override
	public void setMaxBinaryMessageBufferSize(int max) { }

	@Override
	public int getMaxBinaryMessageBufferSize() {
		return 0;
	}

	@Override
	public void setMaxTextMessageBufferSize(int max) { }

	@Override
	public int getMaxTextMessageBufferSize() {
		return 0;
	}

	@Override
	public Async getAsyncRemote() {
		return null;
	}

	@Override
	public Basic getBasicRemote() {
		return basic;
	}
	
	/**
	 * Helper function for constructing the dummy with a desired instance
	 * @param remote
	 * @return
	 */
	public void setBasicRemote(Basic remote) {
		this.basic = remote;
	}
	
	private Basic basic = null;

	@Override
	public String getId() {
		return null;
	}

	@Override
	public void close() throws IOException { }

	@Override
	public void close(CloseReason closeReason) throws IOException { }

	@Override
	public URI getRequestURI() {
		return null;
	}

	@Override
	public Map<String, List<String>> getRequestParameterMap() {
		return null;
	}

	@Override
	public String getQueryString() {
		return null;
	}

	@Override
	public Map<String, String> getPathParameters() {
		return null;
	}

	@Override
	public Map<String, Object> getUserProperties() {
		return null;
	}

	@Override
	public Principal getUserPrincipal() {
		return null;
	}

	@Override
	public Set<Session> getOpenSessions() {
		return null;
	}

	@Override
	public <T> void addMessageHandler(Class<T> clazz, Partial<T> handler)
			throws IllegalStateException { }

	@Override
	public <T> void addMessageHandler(Class<T> clazz, Whole<T> handler)
			throws IllegalStateException { }

}
