/*
 * TCSS 143 - Fall - 2017
 * Programming_1.java
 */

import java.util.*;

/**
 * Programming Assignment 1. The user will input the population for 5 towns when prompted,
 * then the program will print out a "population graph" with the population of each town
 * represented as asterisks for each 1000 people in the town. 
 * 
 * @author Brandon Lu brancel8@uw.edu
 * @version 1 October 2019
 */
public class Programming1 {

	/**
	 * Driver method of the input population and draw population graph.
	 * 
	 * @param theArgs is used for command line input.
	 */
	public static void main(String[] theArgs) {
	
		
		Scanner keyboard = new Scanner(System.in); //Scanner-keyboard input
		
		int townPop1 = getPopulation(1, keyboard); //Initializes a variable by calling method (see below)
		int townPop2 = getPopulation(2, keyboard); //Initializes a variable by calling method (see below)
		int townPop3 = getPopulation(3, keyboard); //Initializes a variable by calling method (see below)
		int townPop4 = getPopulation(4, keyboard); //Initializes a variable by calling method (see below)
		int townPop5 = getPopulation(5, keyboard); //Initializes a variable by calling method (see below)
		
		System.out.println(); //Space to separate graph and prompts
		
		System.out.println("POPULATION GRAPH:"); //prints the title of the graph
		drawPopulationBar(1, townPop1); //prints a bar of the graph by calling a method (see below)
		drawPopulationBar(2, townPop2); //prints a bar of the graph by calling a method (see below)
		drawPopulationBar(3, townPop3); //prints a bar of the graph by calling a method (see below)
		drawPopulationBar(4, townPop4); //prints a bar of the graph by calling a method (see below)
		drawPopulationBar(5, townPop5); //prints a bar of the graph by calling a method (see below)
	}
	
	
	/**
	 * Prompts the user for a population for the town and returns the input.
	 * 
	 * @param theTownNumber - number that represents town entered.
	 * @param theInput - Scanner to read from keyboard.
	 * @return An integer containing the town's population.
	 */
	public static int getPopulation (int theTownNumber, Scanner theInput)
	{
		int populationNum = 0;
		//Prompt user and read the integer
		System.out.print("Enter the population of town " + theTownNumber + ": ");
		populationNum = theInput.nextInt();
		
		return populationNum;
	}
	/**
	 * Prints out a graph of each town's population represented in the thousands by asterisks.
	 * 
	 * @param theTownNumber - number to represent which town's population.
	 * @param thePopulation - integer that represents the actual town's population.
	 */
	public static void drawPopulationBar (int theTownNumber, int thePopulation)
	{
		int numOfAsterisks = thePopulation / 1000; //integer to store how many asterisks for each town.
		String populationBar = "Town " + theTownNumber + ": "; //base String message to add asterisks to.
		for (int i = 1; i <= numOfAsterisks; i++) //concatenates an asterisk to the message until 
		{										  //the index number is at the number of asterisks for the town.
			populationBar += "*";
		}
		System.out.println(populationBar); //prints out the bar of the graph for the town entered.
	}
}
