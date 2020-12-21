/*
 * TCSS143
 * Professor Schuessler
 * Programming Assignment 2
 * Due: 10/8/19
 */
/**
 * Contains static methods to perform matrix operations
 * on 2 arrays for main method
 * @author Brandon
 * @version 8 October 2019
 */
public class ArrayMath {

	/**
	 * Method to add matrices
	 * @param theFirstArray: first matrix
	 * @param theSecondArray: second matrix
	 * @return resulting array
	 */
	public static int[][] AddArrays(int[][] theFirstArray, int[][] theSecondArray)
	{
		int[][] newArray = new int[theFirstArray[0].length][theSecondArray.length]; //initializes array with dimensions of original arrays
																					//note: dimensions of both matrices must be the same
																					//if performing subtraction and addition
		for (int i = 0; i < theFirstArray.length; i++) {	//loop through rows						
			
			 for (int j = 0; j < theFirstArray[i].length; j++) { //loop through columns
				 
			 newArray[i][j] = theFirstArray[i][j] + theSecondArray[i][j]; //add values together and put in new array
			 
			 }
			 
			
		}
		 return newArray; //return the resulting array
	}
	
	/**
	 * Method to subtract matrices
	 * @param theFirstArray: first matrix
	 * @param theSecondArray: second matrix
	 * @return resulting array
	 */
	public static int[][] SubtractArrays(int[][] theFirstArray, int[][] theSecondArray)
	{
			int[][] newArray = new int[theFirstArray[0].length][theSecondArray.length]; //initializes new array to store result into
			
			for (int i = 0; i < theFirstArray.length; i++) { //loop through rows
				
				 for (int j = 0; j < theFirstArray[i].length; j++) { //loop through columns
					 
				 newArray[i][j] = theFirstArray[i][j] - theSecondArray[i][j] ; //subtracts first array value from second and put in new array
				 
				 }
				 
		}
			return newArray; //return resulting array
		
	}
	/**
	 * Method to multiply matrices together
	 * @param theFirstArray: first matrix
	 * @param theSecondArray: second matrix
	 * @return resulting matrix
	 */
	public static int[][] MultiplyArrays(int[][] theFirstArray, int[][] theSecondArray)
	{
		int[][] newArray = new int[theFirstArray.length][theSecondArray[0].length]; //initializes resulting matrix with specific dimensions:
																					//when multiplying matrices, the resulting matrix
																					//will always have the column size of the first matrix
																					//and the row size of the second
		
		for (int k = 0; k < theSecondArray[0].length; k++) //loop through second array's rows
		{
		
			for (int i = 0; i < theFirstArray.length; i++) { //loop through first array's columns
		
				 int number = 0; //initialize number to store sums of products
				
				 for (int j = 0; j < theFirstArray[0].length; j++) { //loop through first array's rows
					 
				 number += theFirstArray[i][j] * theSecondArray[j][k]; //add product to sum
					 
				 }
				 
				 newArray[i][k] = number; //set the corresponding index to sum, going through resulting array's rows first
			}
	
		}
		
		 return newArray; //return resulting array
	}
	
	
}

