/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/11/2019
 */

/**
 * rectangle class to make rectangles
 * a rectangle is defined by a length and a width
 * this class contains a way to make a rectangle, ways to change
 * the length and width, a way to calculate the area, and a way
 * to copy this shape as well as a way to display it's stats
 * @author Brandon Lu
 * @version 11 November 2019
 */
public class Rectangle extends AbstractShape {

	/**
	 * field to store length of rectangle
	 */
	private double myLength;
	/**
	 * field to store width of rectangle
	 */
	private double myWidth;
	/**
	 * static field to store ID of rectangle
	 * shared amongst all rectangle to distinguish
	 * one rectangle from others
	 */
	private static int myID;
	
	/**
	 * no param constructor calls other constructor with values
	 * 1.0 for length and 1.0 for width
	 */
	public Rectangle()
	{
		this(1.0, 1.0);
	}
	
	/**
	 * constructor that allows for a length and a width to be
	 * sent into the rectangle
	 * the values sent in must be valid (more than 0)
	 * if not valid, exception is thrown, to be caught and displayed
	 * in driver program (ID decremented to avoid skipping IDs)
	 * also calls super constructor to initialize name and increment
	 * ID
	 * @param theLength length to set rectangle's length to
	 * @param theWidth width to set rectangle's width to
	 */
	public Rectangle(final double theLength, final double theWidth)
	{
		super("Rectangle", ++myID);
		
		if(theLength <= 0.0 || theWidth <= 0.0)
		{
			myID--;
			throw new IllegalArgumentException("ERROR! Negative or 0 " +
					"value can't be applied to a rectangle width or length.");
		}
		
		myLength = theLength;
		myWidth = theWidth;
	}
	
	/**
	 * method to set length of rectangle
	 * throws exception if length is 0 or less
	 * @param theLength the length to set the length to
	 */
	public void setLength(final double theLength)
	{
		if(theLength > 0)
		{
			myLength = theLength;
		}
		
		else
		{
			throw new IllegalArgumentException("ERROR! Negative or 0" +
					"value can't be applied to a rectangle length.");
		}
	}
	
	/**
	 * method to set width of rectangle to
	 * throws exception if width is 0 or less
	 * @param theWidth width to set rectangle's width to
	 */
	public void setWidth(final double theWidth)
	{
		if(theWidth > 0)
		{
			myWidth = theWidth;
		}
		
		else
		{
			throw new IllegalArgumentException("ERROR! Negative or 0" +
					"value can't be applied to a rectangle width.");
		}
	}
	
	/**
	 * method to calculate area
	 * area of rectangles is calculated by multiplying
	 * the length by the width
	 * @return the area of the rectangle
	 */
	public double calculateArea()
	{
		return myLength * myWidth;
	}
	
	/**
	 * method to make defensive copy of rectangle
	 * makes new rectangle and sets its length and width to
	 * have identical values as the rectangle to copy from
	 * @return copy of rectangle
	 */
	public final Shape copyShape()
	{
		Rectangle newR = new Rectangle();
		newR.myLength = myLength;
		newR.myWidth = myWidth;
		return newR;
	}
	
	/**
	 * method to display info about rectangle
	 * displays: name, length, width, and area
	 * all numbers are shown to 2 decimal places
	 * @return the rectangle's info
	 */
	public String toString()
	{
		return String.format(getName() +
				" [Length: %.2f, Width: %.2f] " +
				"Area: %.2f", myLength, myWidth, calculateArea());
	}
}
