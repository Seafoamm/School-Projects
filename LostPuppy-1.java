/*
 * TCSS 143
 * Professor Schuessler
 * Programming Assignment 3
 * Due: 10/15/19
 */
import java.util.Random;

/**
 * Contains various fields and methods
 * for the LostPuppy game
 * @author Brandon
 * @version 15 October 2019
 */
public class LostPuppy {
	//char array to hold spots where puppy can hide
	private char[][] myHidingPlaces; 
	//the to-be randomized floor for puppy hiding
	private int myFloorLocation; 
	//the to-be randomized room for puppy hiding
	private int myRoomLocation;
	//char to store which player wins
	private char myWinner; 
	//boolean for win condition
	private boolean myFound; 
	
	/**
	 * Constructor for LostPuppy class
	 * sets array size with input
	 * initializes array with all spaces
	 * sets floor and room location to random integers
	 * sets the random spot to be the puppy's hiding spot
	 * set myWinner to nothing (reset game)
	 * set myFound to false (reset game)
	 * @param theFloors the number of floors in the building
	 * @param theRooms the number of rooms in the building
	 */
	public LostPuppy(int theFloors, int theRooms)
	{
		
		myHidingPlaces = new char[theFloors][theRooms]; //set array size
		
		//loop through array and put space in each index
		for(int i = myHidingPlaces.length - 1; i >= 0; i--) 
		{
			for(int j = 0; j < myHidingPlaces[0].length; j++)
			{
				myHidingPlaces[i][j] = ' ';
			}
		}
		
		Random floorNum = new Random(); //create new random
		Random roomNum = new Random(); //create new random
		
		//set floor to random number capped at number of floors in building
		myFloorLocation = floorNum.nextInt(theFloors); 
		//set room to random capped at number of rooms in building
		myRoomLocation = roomNum.nextInt(theRooms); 
		
		//set puppy hiding spot in array to 'P'
		myHidingPlaces[myFloorLocation][myRoomLocation] = 'P';
		
		myWinner = ' '; //reset myWinner
		myFound = false; //reset myFound
	}
	
	/**
	 * method for checking if room has been searched
	 * @param theFloor the floor the room's on
	 * @param theRoom the room number
	 * @return boolean to see if player 1 or 2 have already searched it
	 */
	public boolean roomSearchedAlready(int theFloor, int theRoom)
	{
		
		//if there is a 1 or 2 in the spot,
		//that means the searchRoom() method (see below)
		//has already been executed and therefore it has been searched
		return myHidingPlaces[theFloor][theRoom] == '1' || myHidingPlaces[theFloor][theRoom] == '2';
	}
	
	/**
	 * method for checking if the location input is where
	 * the puppy is hiding
	 * @param theFloor floor number to be checked
	 * @param theRoom room number to be checked
	 * @return boolean if puppy hiding place equals input room
	 */
	public boolean puppyLocation(int theFloor, int theRoom)
	{
		return myHidingPlaces[myFloorLocation][myRoomLocation] == myHidingPlaces[theFloor][theRoom];
	}
	
	/**
	 * method to check if room to be searched is valid for array
	 * @param theFloor floor number to be searched
	 * @param theRoom room number to be searched
	 * @return only return true if:
	 * 1. the floor is within array bounds and at least 0
	 * 2. the room is within array bounds and at least 0
	 */
	public boolean indicesOK(int theFloor, int theRoom)
	{
		
		return theFloor <= myHidingPlaces[0].length + 1 && theFloor >= 0 && theRoom <= myHidingPlaces.length + 1 && theRoom >= 0;
		
	}
	
	/**
	 * method to return number of floors in building
	 * @return return integer amount of floors in the building
	 */
	public int numberOfFloors()
	{
		return myHidingPlaces.length;
	}
	
	/**
	 * method to return number of rooms in building
	 * @return return integer amount of rooms in the building
	 */
	
	public int numberOfRooms()
	{
		return myHidingPlaces[0].length;
	}
	
	/**
	 * method to search a room in the array for puppy
	 * @param theFloor the floor to be searched
	 * @param theRoom the room to be searched
	 * @param thePlayer the player that is searching
	 * @return boolean if the puppy has been found or not
	 * (if false, in main program, continue game)
	 */
	public boolean searchRoom(int theFloor, int theRoom, char thePlayer)
	{
		//set boolean found to if input room matches puppy's room
		boolean found = myHidingPlaces[myFloorLocation][myRoomLocation] == myHidingPlaces[theFloor][theRoom];
		
		//if it's not the puppy's room, set index in the array to the player's number
		if (found == false) 
		{
			myHidingPlaces[theFloor][theRoom] = thePlayer;
		}
		
		else //else, if it is true:
		{
			myWinner = thePlayer; //the player searching is the winner
			myFound = true; //the puppy is found
		}
		
		return found;
	}
	
	/**
	 * the method to display the array/building in a graphic
	 * for the user to see
	 */
	public String toString()
	{
		//display is the string in which we will
		//concatenate the whole graphic in
		String display = " "; //adds a space for roof formatting
		
		//roof of building
		for (int i = 0; i < myHidingPlaces[0].length; i++) 
		{
			if(i == myHidingPlaces[0].length - 1) //if last cell, add 3 '_'
			{
				display += "___";
			}
			
			else //add 4 '_' if not the last cell
			{
				display +="____";
			}
		}
		
		display += " \n"; //start new line for top floor
		
		//main loop for constructing building
		for(int i = myHidingPlaces.length - 1; i >= 0; i--) 
		{
			
			for(int j = 0; j < myHidingPlaces[0].length; j++) //loop through rooms
			{
				//if the the room has a player number in it
				if(myHidingPlaces[i][j] != ' ' && myHidingPlaces[i][j] != myHidingPlaces[myFloorLocation][myRoomLocation])
				{
					if(j == 0) //if it's the first room on the floor
					{
						display += "| "; //add the first wall
						display +=  myHidingPlaces[i][j] + " |"; //add player number in
					}
					
					if (j != 0) //if it's not the first room on the floor
					{
						display += " " + myHidingPlaces[i][j] + " |"; //add player number in
					}
					
					//if it's the last room on the floor, go next line
					if (j == myHidingPlaces[0].length - 1 && i > 0) 
					{
						display += "\n";
					}
				}
				
				//if the room is empty or the puppy's room
				if(myHidingPlaces[i][j] == ' ' || myHidingPlaces[i][j] == 'P') 
				{
				
						if(j == 0) //if it's the first room
						{
							display += "|"; //build first wall
						}
						
						if(!myFound) //if the puppy wasn't found on the last guess
						{
							display += "   |"; //add an empty cell for each cell
						}
						
						else if(myFound) //if the puppy WAS found on the last guess
						{
							if(myHidingPlaces[i][j] == ' ') //if the space was empty
							{
								display += "   |"; //make empty cell
							}
							
							else //if cell is puppy's cell
							{
								display += myWinner + "P" + " |"; //add winner number and 'P' to cell
							}
						}
						
						 //if last cell on row and is not last row
						if (j == myHidingPlaces[0].length - 1 && i > 0) 
						{
							display += "\n"; //add new line
						}
					
				}
			}
			
			if (i == 0) //if last row, add new line
			{
				display += "\n";
			}
			
			display += "|"; //build first wall
			
			//build line of underlines
			for (int j = 0; j < myHidingPlaces[0].length; j++) 
			{
				display += "___|"; //formatting purposes
			}
			
			display += "\n"; //add a new line
			
		}
		
		return display; //return the whole graphic
	}
}
