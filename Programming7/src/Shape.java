/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/10/2019
 */

/**
 * interface that all shapes implement
 * passes on comparable interface to children classes
 * contains methods that shapes should have:
 * 1. to calculate area of the shape
 * 2. to make a defensive copy of itself
 * 3. to get the name of the shape
 * @author Brandon Lu
 * @version 10 November 2019
 */
public interface Shape extends Comparable<Shape> {
	/**
	 * method to calculate area
	 * passed down to shapes
	 * @return the area of the shape
	 */
	public double calculateArea();
	/**
	 * method to return a defensive copy of the shape
	 * makes a new shape of that class and assigns it identical
	 * values for its fields as the original shape
	 * @return a copy of the shape that it was called on
	 */
	public Shape copyShape();
	/**
	 * method to get the name of the shape
	 * name of the shape will be defined in children classes
	 * (type of shape and number)
	 * @return the name of the shape
	 */
	public String getName();
}
