/*
 * TCSS143
 * Brandon Lu
 * Professor Schuessler
 * 10/27/19
 */
import java.util.Random;

/**
 * mouse class to make mouse critters
 * mice move in zigzags and change directions
 * to zigzag in random intervals
 * @author Brandon Lu
 * @version 27 October 2019
 */
public class Mouse extends AbstractCritter {
	/**
	 * int constant to determine how long mice
	 * move in 1 general direction
	 */
	public final int MOUSE_DURATION = 15;
	
	/**
	 * field for random to get random intervals
	 */
	private Random myInterval;
	/**
	 * field for duration to zigzag in a certain direction
	 */
	private int myDuration;
	/**
	 * field to know whether to zig or zag
	 */
	private boolean myZig;
	/**
	 * field to remember direction
	 */
	private int myDirection;
	/**
	 * constructor
	 * initializes character
	 * initializes the Random object to get a duration from
	 * initializes myZig as true (mouse will zig first)
	 * initializes a random direction to start in
	 */
	public Mouse()
	{
		super('M');

		myInterval = new Random();
		myDuration = myInterval.nextInt(MOUSE_DURATION);
		myZig = true;
		myDirection = myInterval.nextInt(CENTER);
	}
	/**
	 * first local variable for direction is initialized
	 * to myDirection default field
	 * if the duration is 0, get a new random duration
	 * (duration will slowly go from original value to 0, 
	 * like a countdown)
	 * and get a new random direction
	 * 
	 * if it's time to zig (move in default direction)
	 * set myZig to opposite value and decrement myDuration
	 * (don't change the direction)
	 * 
	 * otherwise, it's time to zag
	 * if the original direction is 3 (east), change to 0 (north)
	 * otherwise, just add 1 (to move to adjacent to make the zag
	 * direction of the zigzag)
	 * decrement the duration, set myZig to opposite value
	 * 
	 * calling the method will alternate between zigging and zagging
	 * due to setting myZig to opposite values
	 * @return the direction to move in
	 */
	public int getMove(CritterInfo theInfo)
	{
		int direction = myDirection;
		if(myDuration == 0)
		{
			myDuration = myInterval.nextInt(MOUSE_DURATION);
			myDirection = myInterval.nextInt(CENTER);
		}
		
		if(myZig)
		{
			myZig = !myZig;
			myDuration--;
		}
	
		else
		{
			if(direction == EAST)
			{
				direction = NORTH;
			}
			else
			{
				direction = myDirection + 1;
			}
			myZig = !myZig;
			myDuration--;
		}
		
		return direction;

		
		
	}
}
