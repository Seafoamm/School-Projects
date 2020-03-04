/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 1/24/2020
 * HW#3 TicTacToe
 */

import java.util.*;
import java.io.*;

/**
 * class for main driver method for tictac toe game
 * contains method to get mode of play
 * @author Brandon Lu
 * @version 24 January 2020
 */
public class TicTacToe {

	/**
	 * main driver method for executing tictactoe game
	 * asks for which mode (auto play or manual)
	 * and plays the game accordingly based on user input
	 * @param theArgs command line input
	 */
	public static void main(String[] theArgs) {
		//initializes scanner to console input
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to TicTacToe!");
		System.out.println("Choose which play mode: "
				+ "press \"1\" for manual, press \"2\" for autoplay"
				+ " (playing through input from a file)");
		//get the mode (1 is manual play, 2 is autoplay)
		//see method below
		int mode = getMode(input);
		
		//based on what mode is input
		switch(mode)
		{
		//initialize manual play if 1 was input
			case 1:
				TicTacToeTest.play(input);
				break;
		//initialize autoplay if 2 was input
			case 2:
				//get filename
				System.out.println("Welcome to autoplay!");
				System.out.println("Please type a file to read"
						+ "moves from (e.g. moves.txt). The file's "
						+ "contents should consist of 1 coordinate on each"
						+ "line");
				
				String next = input.next();
				
				Scanner sc = null;
				try
				{
					sc = new Scanner(new File(next));
				}
				
				catch(Exception e)
				{
					System.out.println("Invalid file");
					System.exit(1);
				}
				
				TicTacToeTest.play_auto(sc);
				break;
		//if somehow the mode was not 1 or 2, something is wrong
		//the method to get the mode is supposed to insure that 
		//only 1 or 2 comes out, so if the mode is not 1 or 2
		//something wrong has happened
		//basically, default is never supposed to happen
			default:
				System.out.println("Unknown error occurred");
				System.exit(1);
		}
	}
	
	/**
	 * method to get the game mode based on user input
	 * @param theScanner scanner for user input
	 * @return the mode as an int (1 for manual, 2 for auto)
	 */
	public static int getMode(Scanner theScanner)
	{
		//get the next token the user types
		String next = theScanner.next();
		//have the mode initialized as 0 (invalid)
		int result = 0;
		//have a variable to try to parse, in case user does not
		//type in a number
		boolean parsed = true;
		
		try
		{
			//try to parse the user input and set it to result
			result = Integer.parseInt(next);
		}
		
		catch(Exception e)
		{
			//if the token could not parse to an integer, set flag to false
			parsed = false;
		}
		
		//if the token was not able to be parsed
		//or if the user did not type in 1 or 2
		//drop into if statement and call this method again
		//prompting user to type in a valid input
		if(result != 1 && result != 2 || !parsed)
		{
			System.out.println("Please type 1 or 2 (manual or auto)");
			result = getMode(theScanner);
		}
		
		return result;
	}

	

}
