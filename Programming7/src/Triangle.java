/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/11/2019
 */

/**
 * triangle class to make triangles
 * triangle is defined with 3 values for its 3 sides
 * class contains: a way to make triangles, a way to set each side, 
 * a way to calculate the area, a way to calculate the area, as well
 * as a way to display the triangle's info
 * @author Brandon Lu
 * @version 11 November 2019
 */
public class Triangle extends AbstractShape {

	/**
	 * field to store the first side of triangle
	 */
	private double mySideA;
	/**
	 * field to store the second side of the triangle
	 */
	private double mySideB;
	/**
	 * field to store the third side of the triangle
	 */
	private double mySideC;
	/**
	 * field to store the id of triangle
	 * static, so therefore shared between all triangles
	 * to distinguish one from the others
	 */
	private static int myID;
	
	/**
	 * no param constructor
	 * calls other constructor, with values of 1.0 for all sides
	 */
	public Triangle()
	{
		this(1.0, 1.0, 1.0);
	}
	
	/**
	 * constructs a triangle
	 * calls super constructor to initialize name and increment ID
	 * sides are valid if they are more than 0
	 * AND if the longest side is not more than the other 2 added
	 * together
	 * appropriate exceptions are thrown for each case
	 * and ID is decremented to preserve the order
	 * after all checks, sides are initialized
	 * @param theSideA first side of triangle
	 * @param theSideB second side of triangle
	 * @param theSideC third side of triangle
	 */
	public Triangle(final double theSideA, 
			final double theSideB, final double theSideC)
	{
		
		super("Triangle", ++myID);
		
		if(theSideA <= 0 || theSideB <= 0 || theSideC <= 0)
		{
			myID--;
			throw new IllegalArgumentException("ERROR! Negative or 0 " +
												"value can't be applied to a triangle sides.");
		}
		
		double maxSide = theSideA;
		double smallSide1 = theSideB;
		double smallSide2 = theSideC;
		
		if(theSideB > theSideA && theSideB > theSideC)
		{
			maxSide = theSideB;
			smallSide1 = theSideA;
			smallSide2 = theSideC;
		}
		
	  if(theSideC > theSideA && theSideC > theSideB)
	  {
	  	maxSide = theSideC;
	  	smallSide1 = theSideA;
	  	smallSide2 = theSideB;
	  }
	  
	  if(smallSide1 + smallSide2 <= maxSide)
	  {
	  	myID--;
	  	throw new IllegalArgumentException("ERROR! The longest side" +
					" of the triangle must be lesser than the other" +
	  			" two sides combined.");
	  }
		
		mySideA = theSideA;
		mySideB = theSideB;
		mySideC = theSideC;
	}
	
	/**
	 * method to set the sideA of the triangle
	 * has all the checks that the constructor has for
	 * valid sides (side must be greater than 0 length and also
	 * the longest side must not be greater than the sum of the
	 * smaller sides)
	 * if it fails the validation conditions, exception will be 
	 * thrown
	 * @param theSideA the side to set the sideA of this triangle to
	 */
	public void setSideA(final double theSideA)
	{
		double maxSide = theSideA;
		double smallSide1 = mySideB;
		double smallSide2 = mySideC;
		
		if(mySideB > theSideA && mySideB > mySideC)
		{
			maxSide = mySideB;
			smallSide1 = theSideA;
			smallSide2 = mySideC;
		}
		
	  if(mySideC > theSideA && mySideC > mySideB)
	  {
	  	maxSide = mySideC;
	  	smallSide1 = theSideA;
	  	smallSide2 = mySideB;
	  }
	  
		if(theSideA > 0 && !(smallSide1 + smallSide2 <= maxSide))
		{
			mySideA = theSideA;
		}
		else if(!(theSideA > 0))
		{
			throw new IllegalArgumentException("ERROR! Negative or 0 " +
					"value can't be applied to a triangle sides.");
		}
		else if(smallSide1 + smallSide2 <= maxSide)
		{
			throw new IllegalArgumentException("ERROR! The longest side" +
					" of the triangle must be lesser than the other" +
	  			" two sides combined.");
		}
		
		
	
	}
	
	/**
	 * method to set the sideB of this triangle
	 * has checks to see if the side is valid 
	 * (the side must be more than 0 and also
	 * the longest side of the triangle must be less than the sum
	 * of the 2 smaller sides)
	 * errors thrown when side doesn't pass checks
	 * @param theSideB the side to set the sideB of triangle to
	 */
	public void setSideB(final double theSideB)
	{
		double maxSide = mySideA;
		double smallSide1 = theSideB;
		double smallSide2 = mySideC;
		
		if(theSideB > mySideA && theSideB > mySideC)
		{
			maxSide = theSideB;
			smallSide1 = mySideA;
			smallSide2 = mySideC;
		}
		
	  if(mySideC > mySideA && mySideC > theSideB)
	  {
	  	maxSide = mySideC;
	  	smallSide1 = mySideA;
	  	smallSide2 = mySideB;
	  }
		
		if(theSideB > 0 && !(smallSide1 + smallSide2 <= maxSide))
		{
			mySideA = theSideB;
		}
		else if(!(theSideB > 0))
		{
			throw new IllegalArgumentException("ERROR! Negative or 0 " +
					"value can't be applied to a triangle sides.");
		}
		else if(smallSide1 + smallSide2 <= maxSide)
		{
			throw new IllegalArgumentException("ERROR! The longest side" +
					" of the triangle must be lesser than the other" +
	  			" two sides combined.");
		}
	}
	
	/**
	 * method to set the sideC of this triangle
	 * has checks to see if incoming side is valid
	 * (must be greater than 0 and longest side of triangle
	 * must be less than the sum of the other 2 sides)
	 * errors will be thrown if it doesn't pass the checks
	 * @param theSideC the length to set this triangle's sideC to
	 */
	public void setSideC(final double theSideC)
	{
		double maxSide = mySideA;
		double smallSide1 = mySideB;
		double smallSide2 = theSideC;
		
		if(mySideB > mySideA && mySideB > theSideC)
		{
			maxSide = mySideB;
			smallSide1 = mySideA;
			smallSide2 = theSideC;
		}
		
	  if(theSideC > mySideA && theSideC > mySideB)
	  {
	  	maxSide = theSideC;
	  	smallSide1 = mySideA;
	  	smallSide2 = mySideB;
	  }
		
		if(theSideC > 0 && !(smallSide1 + smallSide2 <= maxSide))
		{
			mySideA = theSideC;
		}
		
		else if(!(theSideC > 0))
		{
			throw new IllegalArgumentException("ERROR! Negative or 0 " +
					"value can't be applied to a triangle sides.");
		}
		
		else if(smallSide1 + smallSide2 <= maxSide)
		{
			throw new IllegalArgumentException("ERROR! The longest side" +
					" of the triangle must be lesser than the other" +
	  			" two sides combined.");
		}
	}
	
	/**
	 * method to calculate area of triangle
	 * uses Heron's formula to calculate area
	 * Heron's formula says the area is the square root of
	 * (half the perimeter times the perimeter minus side a, times the
	 * perimeter minus side b, and times the perimeter minus side c)
	 * @return the area of the triangle
	 */
	public double calculateArea()
	{
		double halfPerim = (mySideA + mySideB + mySideC) / 2;
		return Math.sqrt(halfPerim * (halfPerim - mySideA) *
				(halfPerim - mySideB) * (halfPerim - mySideC));
	}
	
	/**
	 * makes a defensive copy of the triangle
	 * makes new triangle and sets fields to identical values
	 * as the triangle to copy from
	 * @return the copy of the triangle
	 */
	public final Shape copyShape()
	{
		Triangle newT = new Triangle();
		newT.mySideA = mySideA;
		newT.mySideB = mySideB;
		newT.mySideC = mySideC;
		return newT;
	}
	
	/**
	 * displays triangle's info
	 * displays: all 3 sides and the area
	 * all numbers shown to 2 decimal places
	 * @return the triangle's info
	 */
	public String toString()
	{
		return String.format(getName() + "[SideA: %.2f, " +
				"SideB: %.2f, SideC: %.2f] Area: %.2f", mySideA, mySideB,
																						mySideC, calculateArea());
	}
	
}
