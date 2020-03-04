/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 1/24/2020
 * HW#3 TicTacToe
 */

/**
 * class to construct tictactoe board
 * contains various methods to check the board
 * if it's full, if a player has won, if there is a tie
 * and a method for representing the board as a string
 * @author Brandon
 * @version 24 January 2020
 */
public class Board {
	/**
	 * field to store board as 2d array
	 */
	private int[][] myBoard;
	/**
	 * field to store the winner of the game
	 */
	private char myWinner;
	
	/**
	 * constructor for tictactoe board
	 * initializes the board as a 3x3 board
	 * initializes mywinner as a default 0
	 */
	public Board()
	{
		myBoard = new int[3][3];
		myWinner = '0';
	}
	
	/**
	 * method to determine if the board is full
	 * loops through the board and if there is a space
	 * on the board that is 0 then the board is not full
	 * @return if the board is full or not
	 */
	public boolean isFull()
	{
		boolean result = true;
		//loop through each column and row
		for(int[] line : myBoard)
		{
			
			for(int space : line)
			{
				
				if(space == 0)
				{
					result = false;
				}
				
			}
			
		}
		
		return result;
	}
	
	/**
	 * method to check to see if there is a winner on the board
	 * first checks for 3 in a row horizontally or vertically
	 * then checks diagonally
	 * also initializes the myWinner field if there is a winner
	 * @return if there is a winner or not
	 */
	public boolean checkWin()
	{
		boolean result = false;
		//checks for horizontal wins
		for(int[] line : myBoard)
		{
			//player 1 adds 2s to the array
			//player 2 adds 5s to the array
			//if the total is 6, that means player 1 has
			//3 cells occupied within that row/column
			//if the total is 15, that means player 2
			//has 3 cells occupied within that row/column
			int total = 0;
			
			for(int space : line)
			{
				total += space;
				
				if(total == 6 || total == 15)
				{
					
					switch(total)
					{
					case 6:
						myWinner = 'X';
						break;
						
					case 15:
						myWinner = 'O';
						break;
					}
					
					 result = true;
				 }
				
			 }
			
		}
		
		//check for vertical wins
		for(int j = 0; j < myBoard[0].length; j++)
		{
			int total = 0;
			
			for(int i = 0; i < myBoard.length; i++)
			{
				total += myBoard[i][j];
			}
			
			if(total == 6 || total == 15)
			{
				
				switch(total)
				{
				case 6:
					myWinner = 'X';
					break;
					
				case 15:
					myWinner = 'O';
					break;
				}
				
				 result = true;
			}
		 }
		
			//check for diagonal wins if there is no
			//horizontal/vertical wins
			if(!result)
			{
				//check first diagonal
				//upper left to lower right
				int check = myBoard[0][0] + myBoard[1][1] + myBoard[2][2];
				
				if(check == 6 || check == 15)
				{
					
					switch(check)
					{
					case 6:
						myWinner = 'X';
						break;
						
					case 15:
						myWinner = 'O';
						break;
					}
					
					 result = true;
			   }
				//check second diagonal if 1st diagonal was not a win
				//upper right to lower left
				else
				{
					check = myBoard[0][2] + myBoard[1][1] + myBoard[2][0];
					
					if(check == 6 || check == 15)
					{
						
						switch(check)
						{
						case 6:
							myWinner = 'X';
							break;
							
						case 15:
							myWinner = 'O';
							break;
						}
						
						 result = true;
				   }
				}
			
		   }
		
		return result;
	}
	
	/**
	 * method to determine if there is a tie
	 * if there is no winner and the board is full, it is a tie
	 * @return if game is tied or not
	 */
	public boolean isTie()
	{
		return isFull() && !checkWin();
	}
	
	/**
	 * method to check if a space is empty or not
	 * @param theX the x coordinate
	 * @param theY the y coordinate
	 * @return if the space on the board is empty
	 */
	public boolean spaceIsEmpty(int theX, int theY)
	{
		return myBoard[theX][theY] == 0;
	}
	
	/**
	 * method to place x or o on the board
	 * @param theX the x coordinate
	 * @param theY the y coordinate
	 * @param thePlayer which player is placing x or o
	 */
	public void placeOnBoard(int theX, int theY, int thePlayer)
	{
		if(thePlayer == 1)
		{
			myBoard[theX][theY] = 2;
		}
		
		else
		{
			myBoard[theX][theY] = 5;
		}
	}
	
	public char getWinner()
	{
		return myWinner;
	}
	
	/**
	 * method to return string representation of 
	 * tictactoe board
	 * @return string representation of tictactoe board
	 */
	@Override
	public String toString()
	{
		//initialize stringbuilder to build board on
		//faster than concatenating strings
		StringBuilder board = new StringBuilder();
		
		//loop through the rows and columns of the board
		for(int i = 0; i < myBoard[0].length; i++)
		{
			
			for(int j = 0; j < myBoard.length; j++)
			{
				//if it is not the last cell in the row
				if(j != 2)
				{
					//if there is nothing in the cell
					if(myBoard[i][j] == 0)
					{
						board.append("   |");
					}
					//if there is something in the cell
					else
					{
						//if player 1 has an x in the space
						if(myBoard[i][j] == 2)
						{
							if(j != 2)
							{
								board.append(" X |");
							}
							
							else
							{
								board.append(" X ");
							}
						}
						//if player 2 has an o in the space
						else
						{
							if(j != 2)
							{
								board.append(" O |");
							}
							
							else
							{
								board.append(" O ");
							}
						}
						
					}
					
				}
				//if it is the last cell in the row
				else
				{
					//if there is nothing in the cell
					if(myBoard[i][j] == 0)
					{
						board.append("   ");	
					}
					//if there is something in the cell
					else
					{
						//if player 1 has an x in the cell
						if(myBoard[i][j] == 2)
						{
							if(j != 2)
							{
								board.append(" X |");
							}
							
							else
							{
								board.append(" X ");
							}
						}
						//if player 2 has an o in the cell
						else
						{
							if(j != 2)
							{
								board.append(" O |");
							}
							
							else
							{
								board.append(" O ");
							}
						}
						
					}
					//add a new line (end of row)
					board.append("\n");
					
				}
				
			}
			//if it is not the last column
			//add a divider row
			if(i != 2)
			{
				board.append("---|---|---\n");
			}
			
		}
		
		return board.toString();
	}
}

