/*
 * TCSS143
 * Brandon Lu
 * Professor Schuessler
 * 10/27/2019
 */
/**
 * wolf class to make wolf critters
 * wolves move as one, in rectangles of increasing size
 * @author Brandon
 * @version 27 October 2019
 */
public class Wolf extends AbstractCritter{

	/**
	 * field to remember last direction
	 */
	private int myDirection;
	/**
	 * field to use to increment until target is met
	 * (used in rectangle pathing process)
	 */
	private int myCount;
	/**
	 * boolean field to toggle
	 * (used in rectangle pathing process)
	 */
	private boolean myFirst;
	/**
	 * int field to increment if myFirst is false
	 * (used in rectangle pathing process)
	 */
	private int myTarget;
	
	/**
	 * constructor for wolf
	 * initializes wolf critter's character
	 * initializes fields' default values:
	 * sets default direction as east
	 * sets myCount to 0
	 * sets myFirst to true
	 * sets myTarget to 1
	 */
	public Wolf()
	{
		super('W');
		myDirection = EAST;
		myCount = 0;	
		myFirst = true;
		myTarget = 1;
	}
	
	/**
	 * method to return direction to move in
	 * increments the count each time
	 * if the count is equal to the target:
	 * if myFirst is false, increment the target
	 * (this causes the wolves to go further)
	 * toggle myFirst, reset myCount
	 * then switch direction the wolves are going in, counterclockwise
	 * @return the direction to move in
	 */
	public int getMove(CritterInfo theInfo)
	{
		
		int direction = myDirection;
		myCount++;
		
		if(myCount == myTarget)
		{
			if(myFirst == false)
			{
				myTarget++;
			}
			
			myFirst = !myFirst;
			myCount = 0;
			
			if(myDirection == EAST)
			{
				myDirection = NORTH;
			}
			else
			{
				myDirection++;
			}
		}
		
		return direction;
	}
}
