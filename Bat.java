/*
 * TCSS143
 * Brandon Lu
 * Professor Schuessler
 * 10/27/2019
 */
import java.util.Random;

/**
 * Bat class to make bat critters
 * Bats move randomly
 * @author Brandon
 * @version 27 October 2019
 */
public class Bat extends AbstractCritter {
	/**
	 * constructor for bat (uses super constructor to initialize)
	 * shows up as a 'B' character on the graphic
	 */
	public Bat()
	{
		super('B');
	}
	/**
	 * getMove method implemented from Critter interface
	 * returns a random integer from 0 to 4
	 * 0 to 4 correspond to directions 
	 * (constants defined in critter interface)
	 * @return the direction to move in
	 */
	public int getMove(CritterInfo theInfo)
	{
		Random move = new Random();
		return move.nextInt(CENTER + 1);
	}
}
