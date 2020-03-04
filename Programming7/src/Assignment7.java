/*
 * Brandon Lu 
 * TCSS143
 * Professor Schuessler
 * 11/11/2019
 */
import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 * class that contains the driver main to run tests on the 
 * shape classes
 * reads from a file, makes a shape list and a copy of it, 
 * then outputs the lists to a file and prints any exceptions to 
 * the console
 * also contains methods to properly input and output data
 * to and from lists and files
 * @author Brandon Lu
 * @version 11 November 2019
 */
public class Assignment7 {

	/**
	 * main driver class to input and output to files
	 * and make lists and print errors to the console
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {
		//initialize scanner and print stream as null
		//will test if the file is valid later
		Scanner input = null;
		PrintStream output = null;
		
		try
		{ 
			//test to see if the files specified are found/valid
			input = new Scanner(new File("in7.txt"));
			output = new PrintStream(new File("out7.txt"));
		}
		
		catch(Exception e)
		{
			//if not valid, write to console and stop the program
			//no point in continuing the program if you can't write
			//or read from the correct files
			System.out.println(e + " Please use valid filenames");
			System.exit(1); 
		}
		
		//make a linked list to store the original list of shapes
		List<Shape> shapeList = new LinkedList<Shape>();
		
		//make a list that is a copy of the original list
		//the method called also fills the original list
		//see below for details on gatherInput() method
		List<Shape> copyList = gatherInput(input, shapeList);
					
		//print the original list unsorted
		output.println("Original List[unsorted]:");
		outputContents(output, shapeList);
		
		//print the copied list sorted
		Collections.sort(copyList);
		output.println("\nCopied List[sorted]: ");
		outputContents(output, copyList);
		
		//print the original list again, to make sure unsorted
		output.println("\nOriginal List[unsorted]:");
		outputContents(output, shapeList);
	}
	
	/**
	 * method to fill the shape list and also return a copy of
	 * the shape list in the form of an arraylist
	 * fills the shapelist with information parsed from
	 * the input text file
	 * @param theScanner to read from input file
	 * @param theList the list to fill and copy
	 * @return the copied list as array list
	 */
	public static ArrayList<Shape> gatherInput(Scanner theScanner, 
																						List<Shape> theList)
	{
		//make arraylist to copy the input list
		ArrayList<Shape> returnList = new ArrayList<Shape>();
		
		//while the file has a next line
		while(theScanner.hasNextLine())
		{
			//split the line by spaces (or whitespace in case of multiple)
			//each token goes into the array
			String[] lineData = theScanner.nextLine().split("\\s");
			
			//declare a parse boolean to determine
			//if the parse was successful
			//(need to parse from string to double)
			boolean parsed;
			
			//switch based on length of the array that
			//split the line
			switch(lineData.length)
			{
			
			//if there was only 1 token, try to make circle
			case 1:
				//first we have to check whether it can parse or not
					Double radius = null;
					
					try
					{
						radius = Double.parseDouble(lineData[0]);
						parsed = true;
					}  // try to parse, if it fails, set parsed to false
					catch(NumberFormatException e)
					{
						parsed = false;
					}
					catch(Exception e)
					{
						System.out.println(e + " Unknown error occurred");
						parsed = false;
					}
					
					//if the parse failed, don't try to make a circle
					if(parsed)
					{
						try //now, try to make a circle
						{
							Circle newCircle = new Circle(radius);
							theList.add(newCircle);
						}
						catch(IllegalArgumentException e)
						{
							//if the values are negative or 0, circle class
							//will catch it
							System.out.println(e);
						}
						catch(Exception e)
						{
							System.out.println(e + " Unknown error occurred");
						}
					}
					
					break;
					
					//if there is 2 tokens in the array
					//try to make a rectangle
			case 2:
				//first we have to check if we can parse the input
				Double length = null;
				Double width = null;
				
				try
				{
					length = Double.parseDouble(lineData[0]);
					width = Double.parseDouble(lineData[1]);
					parsed = true;
				} //if we can't parse either of them
					//the program will jump immediately to the catch
					//and set parsed to false
				catch(NumberFormatException e)
				{
					parsed = false;
				}
				catch(Exception e)
				{
					System.out.println(e + " Unknown error occurred");
					parsed = false;
				}
				
				//if it can be parsed, try to make a new rectangle
				if(parsed)
				{
					try
					{
						Rectangle newRectangle = new Rectangle(length, width);
						theList.add(newRectangle);
					} //the rectangle class will catch invalid numbers
					catch(IllegalArgumentException e)
					{
						System.out.println(e);
					}
					catch(Exception e)
					{
						System.out.println(e + " Unknown error occurred");
					}
				}
				
				break;
				
				//if there is 3 token in the array, try to make a triangle
			case 3:
				Double sideA = null;
				Double sideB = null;
				Double sideC = null;
				//we need to try to parse it first
				try
				{
					sideA = Double.parseDouble(lineData[0]);
					sideB = Double.parseDouble(lineData[1]);
					sideC = Double.parseDouble(lineData[2]);
					parsed = true;
				} //catch will be jumped to as soon as one of them can't parse
				catch(NumberFormatException e)
				{
					parsed = false;
				}
				catch(Exception e)
				{
					System.out.println(e + " Unknown error occurred");
					parsed = false;
				}
				
				//if parse all successful, try to make new triangle
				if(parsed)
				{
					try //try to make a new triangle
					{
						Triangle newTriangle = new Triangle(sideA, sideB, sideC);
						theList.add(newTriangle);
					} //the triangle class will catch any invalid numbers
					catch(IllegalArgumentException e)
					{
						System.out.println(e);
					}
					catch(Exception e)
					{
						System.out.println(e + " Unknown error occurred");
					}
				}
				
				break;
				
				//any other case: no tokens, more than 3, anything else
				//it's not defined, so throw an exception and display
				//in the console
				default:
					try
					{
						throw new IllegalArgumentException();
					}
					catch(IllegalArgumentException e)
					{
						System.out.println(e +
								": ERROR! Shapes are only defined with 1-3 numbers!"
								);
					}
					
					break;
			}
			
		}
		//make an iterator based on the list
		//to loop through it
		Iterator<Shape> itr = theList.iterator();
		//while the iterator has a next element
		//make a copy of it and add it to the array list
		while(itr.hasNext())
		{
			returnList.add(itr.next().copyShape());
		}
		
		return returnList;
	}

	/**
	 * method to write to the output file
	 * @param theOutput the printstream object to write with
	 * @param theList the list to write to the file
	 */
	public static void outputContents(PrintStream theOutput,
																		List<Shape> theList)
	{
		//uses iterator to loop through the list
		Iterator<Shape> itr = theList.iterator();
		//while iterator has a next element, print it to output file
		while(itr.hasNext())
		{
			theOutput.println(itr.next());
		}
	}
}
