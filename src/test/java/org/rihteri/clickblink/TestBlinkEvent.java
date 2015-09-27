package org.rihteri.clickblink;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBlinkEvent {

	@Test
	public void testEmptyConstruction() {
		BlinkEvent be = new BlinkEvent();
		
		assertEquals(be.getX(), 0.0, 0.001);
		assertEquals(be.getY(), 0.0, 0.001);
	}
	
	@Test
	public void testCoordConstruction() {
		BlinkEvent be = new BlinkEvent(1.5, 2.5);
		
		assertEquals(be.getX(), 1.5, 0.001);
		assertEquals(be.getY(), 2.5, 0.001);
	}
	
	@Test
	public void testColorRoulette() {
		BlinkEvent be = new BlinkEvent();
		
		assertEquals(be.getColorString().length(), 7);
		assertEquals(be.getColorString().charAt(0), '#');
	}
}
