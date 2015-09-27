package org.rihteri.clickblink;

/**
 * A JSON serializable message which describes the details of a blink
 * event
 * @author rihteri
 *
 */
public class BlinkEvent {
	/**
	 * Construct an empty blink event
	 */
	public BlinkEvent() { }
	
	/**
	 * Construct a blink event with random color on the given coordinates
	 * @param x The X coordinate, [0, 1]
	 * @param y The Y coordinate, [0, 1]
	 */
	public BlinkEvent(double x, double y) {
		this.x = x;
		this.y = y;
		
		this.red = getColor();
		this.green = getColor();
		this.blue = getColor();
	}
	
	/**
	 * Get the color of this blink event as a hex string
	 * @return An HTML color
	 */
	public String getColorString() {
		return "#"
				+ Integer.toHexString(this.red)
				+ Integer.toHexString(this.green)
				+ Integer.toHexString(this.blue);
	}
	
	/**
	 * Generate a random color value, e.g. integer between 0 .. 255
	 * @return
	 */
	private int getColor() {
		return (int)(Math.random() * 255);
	}
	
	/**
	 * Gets the X coordinate of this event
	 * @return a number between 0 .. 1
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Gets the Y coordinate of this event
	 * @return a number between 0 .. 1
	 */
	public double getY() {
		return this.y;
	}
	
	private double x = 0.0;
	private double y = 0.0;
	
	private int red = 0;
	private int green = 0;
	private int blue = 0;
}
