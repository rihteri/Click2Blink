package org.rihteri.clickblink;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;

import javax.websocket.EncodeException;
import javax.websocket.RemoteEndpoint;

/**
 * A dummy endpoint for testing. Keeps track of message send count
 * @author rihteri
 *
 */
public class DummyBasicRemote implements RemoteEndpoint.Basic {

	@Override
	public void setBatchingAllowed(boolean batchingAllowed)
			throws IOException { }

	@Override
	public boolean getBatchingAllowed() {
		return false;
	}

	@Override
	public void flushBatch() throws IOException { }

	@Override
	public void sendPing(ByteBuffer applicationData)
			throws IOException, IllegalArgumentException { }

	@Override
	public void sendPong(ByteBuffer applicationData)
			throws IOException, IllegalArgumentException { }

	@Override
	public void sendText(String text) throws IOException { }

	@Override
	public void sendBinary(ByteBuffer data) throws IOException { }

	@Override
	public void sendText(String fragment, boolean isLast) throws IOException {	}

	@Override
	public void sendBinary(ByteBuffer partialByte, boolean isLast) throws IOException {	}

	@Override
	public OutputStream getSendStream() throws IOException {
		return null;
	}

	@Override
	public Writer getSendWriter() throws IOException {
		return null;
	}

	@Override
	public void sendObject(Object data) throws IOException, EncodeException {
		objectCount++;
	}

	public int getObjectCount() {
		return objectCount;
	}
	
	private int objectCount = 0;
}
