/*
 * TCSS143
 * Brandon Lu
 * Professor Schuessler
 * 10/27/19
 */
/**
 * Frog class to make frog critters
 * frogs move in random directions in durations of 3
 * they are the only critter that doesn't die when it tries
 * to go to where a stone is, instead it just stops for 1 turn
 * @author Brandon Lu
 * @version October 27 2019
 */
public class Frog extends AbstractCritter{
	/**
	 * constant to determine if
	 * frog goes north
	 */
   public final double FROG_NORTH = .25;
   /**
	 * constant to determine if
	 * frog goes south
	 */
   public final double FROG_SOUTH = .5;
   /**
	 * constant to determine if
	 * frog goes east
	 */
   public final double FROG_EAST = .75;
	/**
   * constant for how long a frog moves
   * in one direction
   */
   public final int FROG_DURATION = 3;
	/**
	 * field used to count to know when to switch directions
	 */
	private int myCounter;
	/**
	 * field used to remember the direction
	 */
	private int myDirection;
	
	/**
	 * constructor to initialize character and to set counter
	 * and direction to 0 by default
	 */
	public Frog()
	{
		super('F');
		myCounter = 0;
		myDirection = 0;
	}
	
	/**
	 * method to get direction to move in
	 * moves in one direction for 3 counts
	 * counter resets after 3 back to 0
	 * counter gets incremented each time method is called
	 * if counter is 0:
	 * gets a random double value between
	 * 0.0 and 1.0 and depending on the result
	 * the direction to go in changes
	 * frogs sit still if they hit a stone instead
	 * of dying
	 * @return the direction to move in
	 */
	public int getMove(CritterInfo theInfo)
	{
		
		double randomDouble = myDirection;
		
		if(myCounter == FROG_DURATION)
		{
			myCounter = 0;
		}
		
		if(myCounter == 0)
		{
			randomDouble = Math.random();
		
		
		
		
			if(randomDouble < FROG_NORTH)
			{
				myDirection = NORTH;
				
			}
			else if(randomDouble < FROG_SOUTH)
			{
				myDirection = SOUTH;
			}
			
			else if(randomDouble < FROG_EAST)
			{
				myDirection = EAST;
				
			}
			else
			{
				myDirection = WEST;
			
			}
		
		}
		
		if(theInfo.getNeighbor(myDirection) == 'S')
		{
			myDirection = CENTER; //If stone, sit still
		}
		
		
		myCounter++;
		
		return myDirection;
		
	}
	
	
}
