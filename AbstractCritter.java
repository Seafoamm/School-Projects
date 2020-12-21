/*
 * TCSS143
 * Brandon Lu
 * Professor Schuessler
 * 10/27/2019
 */
/**
 * This class contains fields and methods that all critters should have
 * @author Brandon Lu
 * @version 27 October 2019
 */
public abstract class AbstractCritter implements Critter {
	/**
	 * field for storing the critter's character
	 * to denote which type of critter it is
	 */
	private char critterChar;
	
	/**
	 * generic constructor for a critter
	 * used to initialize the character
	 * @param theChar
	 */
	public AbstractCritter(final char theChar)
	{
		critterChar = theChar;
	}
	
	/**
	 * getter for the critter's character
	 * @return the critter's character
	 */
	public char getChar()
	{
		return critterChar;
	}
	
}
