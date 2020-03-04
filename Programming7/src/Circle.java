/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/11/2019
 */

/**
 * class that defines a circle
 * a circle is defined mainly by its radius
 * this class contains a way to make a circle, 
 * a way to change the radius, a way to calculate the area, 
 * a way to make a defensive copy of the circle, 
 * and a way to display the circle and its statistics
 * @author Brandon Lu
 * @version 11 November 2019
 */
public class Circle extends AbstractShape {

	/**
	 * field to store the radius of the circle
	 */
	private double myRadius;
	/**
	 * field to store the ID of the circle
	 * this field is static, and therefore shared amongst
	 * all circles, so that when a circle is created
	 * the ID is incremented, allowing no two circles to
	 * have the same ID
	 */
	private static int myID;
	
	/**
	 * no parameter constructor, calls the other constructor,
	 * sending a 1.0 radius value in
	 */
	public Circle()
	{
		this(1.0);
	}
	
	/**
	 * constructor allowing for radius to be input
	 * first, calls the super constructor in AbstractShape, 
	 * initializing the name of the shape and incrementing ID
	 * then, checks if the radius is a valid value (more than 0)
	 * and if not, decrements the ID (to prevent skipping of ID) and
	 * throws an error, to be caught and displayed in the driver
	 * if all is fine, radius field is initialized with the incoming
	 * radius
	 * @param theRadius the radius to set the circle at
	 */
	public Circle(final double theRadius)
	{
		super("Circle", ++myID);
		
		if (theRadius <= 0.0)
		{
			myID--;
			throw new IllegalArgumentException("ERROR! Negative or 0 " +
												"value can't be applied to a circle radius.");
		}
		myRadius = theRadius;
	}
	
	/**
	 * method to change or set a radius for the circle
	 * follows the same validation process as the constructor:
	 * radius must be more than 0
	 * @param theRadius the radius to set this circle's radius to
	 */
	public void setRadius(final double theRadius)
	{
		if(theRadius > 0)
		{
			myRadius = theRadius;
		}
		else
		{
			throw new IllegalArgumentException("ERROR! Negative or 0" +
					"value can't be applied to a circle radius.");
		}
	}
	
	/**
	 * method to calculate the area of the circles
	 * uses the formula pi times the radius squared
	 * uses math.pi, which gives pi to a certain amount of decimals
	 * @return the area of the circle, calculated with math.pi
	 */
	public double calculateArea()
	{
		return Math.pow(myRadius, 2) * Math.PI;
	}
	
	/**
	 * method to make a defensive copy of the circle
	 * makes a new circle, and sets the radius of that circle to
	 * the identical value of this circle's radius
	 * @return the copy of this circle
	 */
	public final Shape copyShape()
	{
		Circle newC = new Circle();
		newC.myRadius = myRadius;
		return newC;
	}
	
	/**
	 * method to display the circle's statistics
	 * displays: the name, the radius, and the area
	 * all numbers are shown to 2 decimal places
	 * @return the circle's info
	 */
	public String toString()
	{ 
		return String.format(getName() +
				" [Radius : %.2f] Area: %.2f", myRadius, calculateArea());
	}
}
