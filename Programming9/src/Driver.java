/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/29/19
 */

import java.util.*;
import java.io.*;

/**
 * driver class to read from input file of words
 * and make a word list and anagram family list
 * and output specific anagram families to output file
 * @author Brandon Lu
 * @version 29 November 2019
 */
public class Driver {

	/**
	 * main driver method makes a scanner and printstream
	 * to read and write to files
	 * first makes a word list based on words in the input file
	 * then makes an anagram family list based on words in the 
	 * word list
	 * finally prints specific anagram families to the output file 
	 * @param theArgs command line input
	 */
	public static void main(String[] theArgs) {

		//first set to null, will test file validity below
		Scanner input = null;
		PrintStream output = null;
		
		try
		{
			input = new Scanner(new File("words.txt"));
			output = new PrintStream(new File("out9.txt"));
		}
		
		catch(FileNotFoundException e)
		//if files are not valid, print error and don't run program
		{
			System.out.println(e);
			System.exit(1);
		}
		
		//makes a linked list of words from input file
		//uses helper method (see below)
		LinkedList<Word> wordList = createAndSortWordList(input);
		
		//makes linked list of anagram families
		//uses helper method (see below)
		LinkedList<AnagramFamily> anagramFamilies =
				createAndSortAnagramFamilyList(wordList);
		
		//prints output to output file
		//uses helper method (see below)
		printOutput(anagramFamilies, output);

	}
	
	/**
	 * method to make and sort a word list
	 * based on words in the input file
	 * @param theS the scanner to access input file
	 * @return list based on words in input file
	 */
	public static LinkedList<Word> createAndSortWordList(Scanner theS)
	{
		//make new list
		LinkedList<Word> returnList = new LinkedList<Word>();
		
		//while the input file has a next token
		//add a new word to the list, passing in the token to the 
		//word constructor
		while(theS.hasNext())
		{
			returnList.add(new Word(theS.next()));
		}
		
		//sort the list using the compareto method
		Collections.sort(returnList);
		
		return returnList;
	}

	/**
	 * helper method to make and sort an anagram family list
	 * makes a list to store anagram families
	 * makes a map to group words based on their canonical form
	 * then passes each list in the map to an anagram family
	 * constructor to then add to the anagram family list
	 * @param theList the list to grab words from
	 * @return the anagram family list
	 */
	public static LinkedList<AnagramFamily> 
										createAndSortAnagramFamilyList(List<Word> theList)
	{
		//make new linked list of anagram family
		LinkedList<AnagramFamily> anagramFamilies =
				new LinkedList<AnagramFamily>();
		
		//make list iterator to traverse list
		ListIterator<Word> itr = theList.listIterator();
		
		//make a temporary list for single family lists
		LinkedList<Word> singleFamily = new LinkedList<Word>();
		//while there's a next word
			while(itr.hasNext())
			{
					//store the next element
					Word next = itr.next();
					//add it to the family
					singleFamily.add(next);
					//if there's a next element
					if(itr.hasNext())
					{
						//while the original element has the same canonical form
						//as the next element
						while(next.getCanon().equalsIgnoreCase(itr.next().getCanon()))
						{
							//add it
							singleFamily.add(itr.previous());
							//go to next element
							itr.next();
						}
						//go to previous element
						itr.previous();
					}
				//sort the family	
				Collections.sort(singleFamily, new WordComparator());
				//add it as an anagram family to the anagram family list
				anagramFamilies.add(new AnagramFamily(singleFamily));
				//clear list for another family
				singleFamily.clear();
			}
			
		//sort the anagram family list using the anagram
		//family comparator
		Collections.sort(anagramFamilies, new AnagramFamilyComparator());
		
		return anagramFamilies;
	}
	
	
	/**
	 * makes an iterator on the list passed in
	 * iterates over the list, printing out in the output file
	 * the top 5 anagram families,
	 * all families with 8 words in them, and the last
	 * anagram family
	 * @param theList the list to iterate over
	 * @param theP the printstream to access output file
	 */
	public static void printOutput(List<AnagramFamily> theList,
																						PrintStream theP)
	{
			Iterator<AnagramFamily> itr = theList.iterator();
			
			//local variable to keep track of element in list
			int i = 0;
			theP.println("The top 5 AnagramFamilies: ");
			while(i < 5)
			{
				theP.println(itr.next());	
				
				i++;
			}
			
			theP.println("\nAll AnagramFamilies with size 8: ");
			while(i < theList.size() - 1)
			{
				AnagramFamily next = itr.next();
				if(next.getFamilyCount() == 8)
				{
					theP.println(next);
				}
				i++;
			}
			
			theP.println("\nThe last AnagramFamily: ");
			theP.println(itr.next());
			
		
	}
}



