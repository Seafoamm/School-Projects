/*
 * Brandon Lu
 * TCSS 305 - 2020
 * Professor Dincer
 * 1/24/2020
 * HW#3 TicTacToe
 */

import java.util.*;

/**
 * class that contains play modes
 * executes the actual game based on which mode
 * manual (executes 1 iteration at a time)
 * auto (reads moves from a file and executes all iterations)
 * also has a method to check if move is valid to make
 * @author Brandon Lu
 * @version 24 January 2020
 */
public class TicTacToeTest {

	/**
	 * manual play method where user inputs
	 * commands and places Xs or Os on the board
	 * @param theScanner to gather user input
	 * @return which player has won
	 */
	public static int play(Scanner theScanner)
	{
		Board board = new Board();
		
		int i = 0; //to keep track of which player's turn
		
		int player = 0; //to keep track of which player won
		
		while(!board.checkWin()) //while there is no win on the board yet
		{
			//alternate between player 1 and 2
			if(i % 2 == 0)
			{
				System.out.println("X\'s turn!");
				player = 1;
			}
			
			else
			{
				System.out.println("O\'s turn!");
				player = 2;
			}
			
			System.out.println("Enter the X and Y coordinates "
					+ "of your next move, e.g. 0 2 or 1 1, "
					+ "or \'quit\' to exit.");
			//check if the move inputted is valid
			//by putting their input into an array
			//and using a method to check (see below)
			String[] move = checkValidMove(theScanner, board);
			
			//can parse here because any validation is done within
			//the check valid move method (see below)
			int x = Integer.parseInt(move[0]);
			int y = Integer.parseInt(move[1]);
			
			//place on board (see board class for method)
			board.placeOnBoard(x, y, player);
			
			System.out.println(board);
			//check to see if anyone won, if so, end the game
			if(board.checkWin())
			{
				System.out.println("Congratulations Player " +
						board.getWinner() + ", you have won!");
				break;
			}
			//check to see if there is a tie, if so, end the game
			if(board.isTie())
			{
				System.out.println("There are no more valid moves and"
						+ "the board is full! Tie game!");
				break;
			}
			//add to i, to alternate players
			i++;
		}
		
		return board.getWinner();
		
	}
	
	/**
	 * method to auto play TicTacToe based on
	 * inputs from a file
	 * @param theScanner file to read from
	 */
	public static void play_auto(Scanner theScanner)
	{
		Board board = new Board();
		//keep track of which player's turn
		int i = 0;
		//keep track of which player
		int player = 0;
		//while there is a next line in the input file
		while(theScanner.hasNextLine())
		{
			//alternate between players
			if(i % 2 == 0)
			{
				player = 1;
			}
			
			else
			{
				player = 2;
			}
			//split the next line into 2 numbers (hopefully)
			String[] move = theScanner.nextLine().split("\\s+");

			int xCoordinate = 0;
			int yCoordinate = 0;
			
			boolean parsed = true;
			//parse it into coordinates
			try
			{
				xCoordinate = Integer.parseInt(move[0]);
				yCoordinate = Integer.parseInt(move[1]);
			}
			
			catch(Exception e)
			{
				parsed = false;
			}
			//if there is an invalid move, exit program
			if(!parsed || xCoordinate < 0 || yCoordinate < 0 || 
					xCoordinate > 2 || yCoordinate > 2 ||
					!board.spaceIsEmpty(xCoordinate, yCoordinate))
			{
				System.out.println(
						"Invalid move in file, now quitting program");
				System.exit(1);
			}
			//place on the board
			board.placeOnBoard(xCoordinate, yCoordinate, player);
			//check for wins
			if(board.checkWin())
			{
				System.out.println("Player " +
						board.getWinner() + ", has won!");
				break;
			}
			//check for ties
			if(board.isTie())
			{
				System.out.println("Tie game!");
				break;
			}
			//check for if there is enough moves to finish game
			if(!theScanner.hasNextLine() &&
					!board.checkWin() &&
					!board.isTie())
			{
				System.out.println(
						"Not enough moves to finish game. Now exiting...");
				break;
			}
			
			i++;
			
		}
	}
	
	/**
	 * method to check if user input are valid coordinates to
	 * place on the board
	 * @param theScanner user input
	 * @param theBoard the tictactoe board
	 * @return an array with valid coordinates
	 */
	public static String[] checkValidMove(
																		Scanner theScanner, Board theBoard)
	{
		//get input as an array
		String[] move = theScanner.nextLine().split("\\s+");
		//if user types quit, exit program
		if(move[0].equals("quit"))
		{
			System.out.println("Now exiting program...");
			System.exit(1);
		}
		//if user typed 2 tokens try to parse
		else if(move.length == 2)
		{
				int xCoordinate = 0;
				int yCoordinate = 0;
				
				boolean parsed = true;
				
				try
				{
					xCoordinate = Integer.parseInt(move[0]);
					yCoordinate = Integer.parseInt(move[1]);
				}
				
				catch(Exception e)
				{
					parsed = false;
				}
				//if the coordinates are not valid coordinates, ask again
				if(!parsed || xCoordinate < 0 || yCoordinate < 0 || 
						xCoordinate > 2 || yCoordinate > 2)
				{
					System.out.println("Please enter valid coordinates");
					move = checkValidMove(theScanner, theBoard);
				}
				//if space is already filled, ask again
				else if(!theBoard.spaceIsEmpty(xCoordinate, yCoordinate))
				{
					System.out.println("That space is already filled "
							+ "please choose another space");
					move = checkValidMove(theScanner, theBoard);
				}
				
		}
		//else, if the user typed anything else, ask again
		else
		{
			System.out.println("Please enter 2 coordinates");
			move = checkValidMove(theScanner, theBoard);
		}
		
		return move;
	}
}
