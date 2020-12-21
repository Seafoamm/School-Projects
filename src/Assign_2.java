/*
 * TCSS143
 * Professor Schuessler
 * Programming Assignment 2
 * Due: 10/8/19
 */

import java.util.Scanner;
import java.io.*;

/**
 * Reads an input file and populates arrays based
 *  on the contents of the input file, 
 *  then performs matrix math on the arrays
 *  with help of the ArrayMath class attached
 *  and then prints to an output file the 
 *  original arrays and the results of
 *  operations applied to arrays.
 *  
 * @author Brandon
 * @version 8 October 2019
 */
public class Assign_2 {

	/**
	 * Main method to execute project's purpose
	 * @param theArgs for command line input
	 */
        public static void main(String[] theArgs) {
	
        Scanner input = null; //Scanner - set to null until tested
        PrintStream output = null; //PrintStream - set to null until tested
        
		int[][] arrayA = null; //All arrays set to null until input/output tested
		int[][] arrayB = null;
		int[][] arrayC = null;
		int[][] arrayD = null;
		
		boolean filesOk = false; //Will be set to true once scanner and printstream tested
		
		try //test the scanner and printstream
		{
			input = new Scanner(new File("in2.txt")); //tries to set the scanner and printstream
			output = new PrintStream(new File("out2.txt"));
			filesOk = true; //if the above throws no exception, set to true
		}
		catch (FileNotFoundException e) //if exception is thrown when setting scanner and printstream
		{
			System.out.println("Can't open file - " + e); //tell user what happened
		}
		
		if (filesOk) //execute the main purpose if scanner and printstream can find their files
		{
			arrayA = get2DArray(input); //populate the arrays' data with method (see below)
			arrayB = get2DArray(input);
			arrayC = get2DArray(input);
			arrayD = get2DArray(input);
			
			int[][] additionArray = ArrayMath.AddArrays(arrayA, arrayB); //see ArrayMath class
			int[][] subtractionArray = ArrayMath.SubtractArrays(arrayA, arrayB); //see ArrayMath class
			int[][] multiplicationArray = ArrayMath.MultiplyArrays(arrayC, arrayD); //see ArrayMath class
			
			printArray(output, arrayA, "Array A"); //prints original arrays (see method below)
			printArray(output, arrayB, "Array B");
			printArray(output, arrayC, "Array C");
			printArray(output, arrayD, "Array D");
			
			printArrayResult(output, additionArray, "A", "B", "+"); //prints array results after operations (see method below)
			printArrayResult(output, subtractionArray, "A", "B", "-");
			printArrayResult(output, multiplicationArray, "C", "D", "*");
			
		}
		
	}
        /**
         * Method to populate arrays
         * @param theIn: scanner to read data for arrays
         * @return an array that is fully populated
         */
        public static int[][] get2DArray(Scanner theIn) 
        {
        	int rowSize = theIn.nextInt(); //first number is rowsize
        	int colSize = theIn.nextInt(); //second number is column size
        	
        	int[][] array = new int[rowSize][colSize]; //sets dimensions
        	
        	for (int i = 0; i < array.length; i++) //loops through row
        	{
        		for (int j = 0; j < array[i].length && theIn.hasNextInt(); j++) //loops through columns of row
        		{
        			array[i][j] = theIn.nextInt(); //sets data at correct spot for the array
        		}
        	}
        	
        	return array;
        }

        /**
         * Method to print original array contents
         * @param theOutput: the printstream to output array contents
         * @param theArray: the original array to output
         * @param theArrayName: the heading of the array
         */
        public static void printArray(PrintStream theOutput, int[][] theArray, String theArrayName)
        {
        	String printMessage = theArrayName + ": \n"; //initializes the message to be output as heading of array
        	
        	for (int i = 0; i < theArray.length; i++)  //row
        	{
        		for (int j = 0; j < theArray[i].length; j++) //column
        		{
        			printMessage += theArray[i][j] + " "; //concatenates the value of each cell in array to message
        		}
        		
        		printMessage += "\n"; //add a new line after each row
        	}
        	
        	theOutput.println(printMessage); //prints the final message
        	
        }
        
        /**
         * Method to print arrays' contents after operation
         * @param theOutput: printstream to output array result to
         * @param theArray: the array result to print
         * @param theFirstArrayName: the letter of the first array's name
         * @param theSecondArrayName: the letter of the second array's name
         * @param theOperation: what operation was performed to the 2 arrays to get resulting array
         */
        public static void printArrayResult(PrintStream theOutput, int[][] theArray, String theFirstArrayName, String theSecondArrayName, String theOperation)
        {
        	String printMessage = theFirstArrayName + " " + theOperation + " " + theSecondArrayName + ": \n"; //initializes message as heading of array
        	
        	for (int i = 0; i < theArray.length; i++) { //row
				
				 for (int j = 0; j < theArray[i].length; j++) { //column
					 
				 printMessage += theArray[i][j] + " "; //concatenates array content to message
				 
				 }
        		
        		printMessage += "\n"; //add line after each row
        	}
        	
        	theOutput.println(printMessage); //print final message
        }

}
