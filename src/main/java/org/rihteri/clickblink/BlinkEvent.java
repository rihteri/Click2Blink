package org.rihteri.clickblink;

/**
 * A JSON serializable message which describes the details of a blink
 * event
 * @author rihteri
 *
 */
public class BlinkEvent {
	/**
	 * Construct an empty blink event with a random color
	 */
	public BlinkEvent() {
		setRandomColor();
	}
	
	/**
	 * Construct a blink event with random color on the given coordinates
	 * @param x The X coordinate, [0, 1]
	 * @param y The Y coordinate, [0, 1]
	 */
	public BlinkEvent(double x, double y) {
		this.x = x;
		this.y = y;
		
		setRandomColor();
	}
	
	/**
	 * Get the color of this blink event as a hex string
	 * @return An HTML color
	 */
	public String getColorString() {
		return "#"
				+ getColorStringPart(this.red)
				+ getColorStringPart(this.green)
				+ getColorStringPart(this.blue);
	}
	
	private String getColorStringPart(int val) {
		String ret = Integer.toHexString(val);
		
		if (ret.length() == 1) {
			return "0" + ret;
		} else {
			return ret;
		}
	}
	
	/**
	 * Generate a random color value, e.g. integer between 0 .. 255
	 * @return
	 */
	private int getColor() {
		return (int)(Math.random() * 255.0);
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
	
	/**
	 * Sets the color of this event randomly
	 */
	private void setRandomColor() {
		this.red = getColor();
		this.green = getColor();
		this.blue = getColor();
	}
	
	
	private double x = 0.0;
	private double y = 0.0;
	
	private int red = 0;
	private int green = 0;
	private int blue = 0;
}
