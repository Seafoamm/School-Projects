/*
 * TCSS143
 * Brandon Lu
 * Professor Schuessler
 * 10/27/2019
 */
import java.util.Random;

/**
 * turtle class to make turtle critters
 * turtles only take an action every 3 turns, and even then
 * they don't necessarily move
 * which means turtles don't all start at the same time
 * they move in random directions
 * there are 2 sets of moves they can make
 * based on a random boolean, they have a set of moves that includes
 * moving CENTER (sitting still) and a set of moves that doesn't
 * include moving CENTER
 * @author Brandon Lu
 * @version 27 October 2019
 */
public class Turtle extends AbstractCritter{
	/**
	 * constant int from which Turtle can
	 * pull a random integer from 0 to
	 * the constant number to determine
	 * which direction to go
	 */
	public final int FIRST_MOVE_SET = 13;
	/**
	 * constant int from which Turtle can
	 * pull a random integer from 0 to
	 * the constant number to determine
	 * which direction to go
	 */
	public final int SECOND_MOVE_SET = 11;
	/**
	 * int constant to determine when turtles
	 * make a move
	 */
	public final int TURTLE_DURATION = 3;
	/**
	 * Random field to make a random boolean from
	 */
	private Random myRandom;
	/**
	 * field to count to 3
	 * turtles move every 3 counts
	 */
	private int myCount;
	
  /**
   * constructor for turtle
   * initializes character (T)
   * initalizes Random object to use later
   * sets count to 0, default value
   */
	public Turtle()
	{
		super('T');
		myRandom = new Random();
		myCount = 0;
	}
	/**
	 * method to get direction to move in
	 * turtles' moves are CENTER, until the counter reaches
	 * every 3
	 * then, a random boolean is chosen (true or false)
	 * if true: get a random integer between 0 and 12 inclusive
	 * and determine move based on integer
	 * 
	 * else: get an integer from 0 to 10 and determine move;
	 * turtles cannot move center
	 * in this set of moves
	 * 
	 * increments to the counter each time method is called
	 * @return the direction to move in
	 */
	public int getMove(CritterInfo theInfo)
	{
		boolean randomBool = myRandom.nextBoolean();
		int randomInt;
		int myMove = CENTER;
		myCount++;
		
		if(myCount % TURTLE_DURATION == 0)
		{
			if(randomBool)
			{
				randomInt = myRandom.nextInt(FIRST_MOVE_SET);
				switch(randomInt)
				{
				case 0:
				case 1:
					myMove = NORTH;
					break;
				case 2:
				case 3:
					myMove = EAST;
					break;
				case 4:
					myMove = SOUTH;
					break;
				case 5:
				case 6:
				case 7:
					myMove = WEST;
					break;
				case 8:
				case 9:
				case 10:
				case 11:
				case 12:
					myMove = CENTER;
					break;
				}
			}
			
			else
			{
				randomInt = myRandom.nextInt(SECOND_MOVE_SET);
				switch(randomInt)
				{
				case 0:
				case 1:
				case 2:
				case 3:
					myMove = SOUTH;
					break;
				case 4:
				case 5:
					myMove = WEST;
					break;
				case 6:
				case 7:
					myMove = NORTH;
					break;
				case 8:
				case 9:
				case 10:
					myMove = EAST;
					break;
				}
			}
		}
		return myMove;
	}
}
