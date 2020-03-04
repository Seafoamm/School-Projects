/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/10/2019
 */

/**
 * abstract class to pass down generic methods to
 * children shape classes
 * @author Brandon
 * @version 11 November 2019
 */
public abstract class AbstractShape implements Shape {

	/**
	 * field to store the name of shape
	 */
	private String myName;
	
	/**
	 * constructor to initialize name of shape
	 * name is the type of shape concatenated with a number
	 * (which will be the ID in the children classes)
	 * @param theName name of shape
	 * @param theNum ID number to distinguish from others
	 */
	public AbstractShape(String theName, int theNum)
	{
		myName = theName + theNum;
	}
	
	/**
	 * method to compare shapes together
	 * first compares the class names
	 * if the class names are the same, compare areas
	 * the area is multiplied by negative 1 to reverse them
	 * @param theOther the shape to compare the caller's info to
	 * @return an integer indicating if this shape 
	 * should be below or above the other shape
	 */
	public int compareTo(Shape theOther)
	{
		int result = 
					this.getClass().toString().compareTo(
							theOther.getClass().toString());
		if(this.getClass() == theOther.getClass())
			{
			result = 
					-(int)((calculateArea() - theOther.calculateArea()) * 1000);
			}
		return result;
	}
	
	/**
	 * method to return the name of shape
	 * @return the name of shape
	 */
	public String getName()
	{
		return myName;
	}
}