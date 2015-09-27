package org.rihteri.clickblink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BlinkBrokerTests {

	@Test
	public void testSend() {
		BlinkBroker b = BlinkBroker.getBroker();
		
		assertNotNull("Singleton instance creation", b);
		
		DummySession s = new DummySession();
		DummyBasicRemote basic = new DummyBasicRemote();
		s.setBasicRemote(basic);
		
		b.registerSession(s);
		
		assertEquals(basic.getObjectCount(), 0);
		
		b.sendBlink(new BlinkEvent());
		
		assertEquals(basic.getObjectCount(), 1);
		
		b.deregisterSession(s);
		b.sendBlink(new BlinkEvent());
		
		assertEquals("Must not send after dereg", basic.getObjectCount(), 1);
	}

}
