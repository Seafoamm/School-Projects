/*
 * TCSS143
 * Brandon Lu
 * Professor Schuessler
 * 10/27/2019
 */
/**
 * class to make stone "critters"
 * stones just get placed on the board at the beginning of
 * the simulation
 * they don't move, so they always return center for their move
 * @author Brandon Lu
 * @version 27 October 2019
 */
public class Stone extends AbstractCritter {
	
	/**
	 * constructor for stone
	 * passes in an S for their critter character
	 */
	public Stone()
	{
		super('S');
	}
	/**
	 * stones can't move. this method will always return CENTER
	 * for the direction they move in (center means sit still)
	 * @return always returns CENTER for the direction
	 * because stones can't move
	 */
	public int getMove(CritterInfo theInfo)
	{
		return CENTER;
	}
	
}
