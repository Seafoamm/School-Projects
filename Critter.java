/*
 * TCSS143
 * Brandon Lu
 * Professor Schuessler
 * 10 October 2019
 */
/**
 * Contains methods that critter type classes need to have
 * and contains constants for directions
 * @author Brandon
 * @version 10/25/2019
 */
public interface Critter {
	/**
	 * public constants for directions for all classes: 
	 * each direction, including standing still,
	 * corresponds to an integer from 0 to 4
	 * NORTH is 0
	 */
	public final int NORTH = 0;
	/**
	 * WEST is 1
	 */
	public final int WEST = 1;
	/**
	 * SOUTH is 2
	 */
	public final int SOUTH = 2;
	/**
	 * EAST is 3
	 */
	public final int EAST = 3;
	/**
	 * CENTER is 4
	 */
	public final int CENTER = 4;
	
	/**
	 * abstract method, to be detailed more in abstract class
	 * method for getting the critter's character
	 * passed down to abstract class and then to
	 * all the concrete classes
	 * @return the critter's character
	 */
	public char getChar();
	/**
	 * abstract method to be passed down
	 * used to get the direction the critter moves
	 * @param theInfo to be used to determine if anything special
	 * needs to be done
	 * in the case of Frog class, the Frog needs to 
	 * use the getNeighbor method of CritterInfo class
	 * to know to stop when they hit a stone
	 * @return returns the direction the critter moves in
	 */
	public int getMove(CritterInfo theInfo);
}
