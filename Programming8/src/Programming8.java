/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/18/2019
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.TreeSet;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.io.PrintStream;

/**
 * class to demonstrate recursion
 * main method reads and writes to a file based
 * on information gathered by means of helper methods
 * has a method to gather all words from a file with a certain
 * character into 1 string
 * has a method to determine if a string has a character
 * has a method to make a set out of the string's words
 * has a method to make a map of the word lengths mapping
 * to the words
 * @author Brandon Lu
 * @version 18 November 2019
 */
public class Programming8 {

	/**
	 * main driver method that reads from a file and writes
	 * to a file
	 * uses getWordsString() to get the words concatenated
	 * into 1 string
	 * uses getWordSet() to make the set of words from the string
	 * removes the whitespace from the set
	 * uses wordLengthMap() to make the map out of the set
	 * (maps word lengths to a set of words that have that word length)
	 * then, prints the set and map info to the output file
	 * @param theArgs command line input
	 */
	public static void main(String[] theArgs) {
		//first set the scanner and printstream to null
		//will test if valid files later
		Scanner input = null;
		PrintStream output = null;
		
		try
		{ //test the files to see if they are valid
			input = new Scanner(new File("in8.txt"));
			output = new PrintStream(new File("out8.txt"));
		}
		
		catch(FileNotFoundException e)
		{ //if the files are not valid, throw exception
			System.out.println(e);
			System.exit(1);
		}
		//uses the method getWordsString() to get a string of words
		//containing the character 'a' all concatenated and separated
		//by a space
		String wordString = getWordsString(input, 'a');
		
		//makes a tree set from the string made above
		//it takes every word separated by a space and puts
		//each in the set individually
		Set<String> wordSet = getWordSet(wordString);
		
		//remove whitespace element from the set if there is one
		if(wordSet.contains(""))
		{
			wordSet.remove("");
		}
		
		//makes a map from the set of strings
		//the keys are the word lengths
		//the values are the words that have that word length
		Map<Integer, Set<String>> wordLengthMap = 
				getWordLengthMap(wordSet);
		
		//print set size and contents to output file
		output.println("Set size = " + wordSet.size());
		output.println("Set of words containing the letter a:\n" 
										+ wordSet);
		//print map size and contents to output file
		output.println("\nMap size = " + wordLengthMap.size());
		output.println("Map of word lengths containing the letter a:\n" 
										+ wordLengthMap);
	}
	
	/**
	 * recursive method that concatenates all the words
	 * read from the input file that have a certain character
	 * if the file has a next token
	 * AND the token contains the character,
	 * concatenate that next token
	 * with a space and call the method again
	 * else, call method again to consume next token
	 * @param theFile the scanner to access input file
	 * @param theC the character to look for in the word
	 * @return string of all words with certain character concatenated
	 * with a space
	 */
	public static String getWordsString(final Scanner theFile,
																			final char theC)
	{
		String result = "";
		
		if(theFile.hasNext())
		{
			String word = theFile.next();
			
			if(hasCharacter(word, theC))
			{
				result = word + " " + getWordsString(theFile, theC);
			}
			
			else
			{
				result = getWordsString(theFile, theC);
			}
		}
		
		return result;
	}

	/**
	 * method to determine if a string has a certain character in it
	 * first, makes upper and lower case versions of the character
	 * then, checks to see if the first character of the string passed
	 * in is the upper or lower case version of the character,
	 * if it is, return true
	 * if not, call the method again, passing in the string without
	 * the first character
	 * if the string's length is less than 1, return false
	 * (which means it has either been searched through or
	 * it was just an empty string)
	 * @param theS the string to look through
	 * @param theC the character to look for
	 * @return if the string has the character or not
	 */
	public static boolean hasCharacter(final String theS,
																		 final char theC)
	{
		
		boolean result;
		
		char theCLower = convertToLower(theC); //see method below
		char theCUpper = convertToUpper(theC); //see method below
		
		if(theS.length() < 1)
		{
			result = false;
		}
		
		else if(theS.length() > 0 &&
				(theS.charAt(0) == theCLower ||
				theS.charAt(0) == theCUpper))
		{
			result = true;
		}
		
		else
		{
			result = hasCharacter(theS.substring(1), theC);
		}
		
		return result;
	}
	
	/**
	 * helper method for hasCharacter()
	 * converts the character to the lowercase version if
	 * it is not already lowercase
	 * @param theC the character to convert (or not)
	 * @return the converted (or not) version of the character
	 */
	public static char convertToLower(final char theC)
	{
		char result = theC;
		
		if(theC >= 'A' && theC <= 'Z')
		{
			result += 32;
		}
		
		return result;
	}
	
	/**
	 * helper method for hasCharacter()
	 * converts the character to the uppercase version if
	 * it is not already uppercase
	 * @param theC the character to convert (or not)
	 * @return the converted (or not) version of the character
	 */
	public static char convertToUpper(final char theC)
	{
		char result = theC;
		
		if(theC >= 'a' && theC <= 'z')
		{
			result -= 32;
		}
		
		return result;
	}
	
	/**
	 * makes a set of strings based on the words
	 * separated by a space found in a string
	 * adds a substring from the beginning of the string to
	 * the index of the first space, and then calls the overloaded
	 * method to do the same thing with the substring of the string
	 * minus the first word and passes in the set to add it to
	 * if there is no spaces left, add the string
	 * @param theS the string to get words from
	 * @return the set of words
	 */
	public static Set<String> getWordSet(final String theS)
	{
		Set<String> wordSet = new TreeSet<String>();
		
	
		if(theS.indexOf(' ') == -1)
		{
			wordSet.add(theS);
		}
		else
		{
			wordSet.add(theS.substring(0, theS.indexOf(' ')));
			getWordSet(theS.substring(theS.indexOf(' ') + 1), wordSet);
		}
		
		return wordSet;
  }
	
	/**
	 * helper recursive method to the getWordSet method
	 * passes in the string to get words from and the set
	 * to add the words to
	 * adds substrings of the string from the beginning of the string
	 * to the first space, and then calls the method again, without
	 * the first word
	 * if there are no more spaces left, just add the string
	 * @param theS the string to get words from
	 * @param theSet the set to add the words to
	 * @return the set of words
	 */
	public static Set<String> getWordSet(final String theS,
																			final Set<String> theSet)
	{
		if(theS.indexOf(' ') == -1)
		{
			theSet.add(theS);
		}
		else
		{
			theSet.add(theS.substring(0, theS.indexOf(' ')));
			getWordSet(theS.substring(theS.indexOf(' ') + 1), theSet);
		}
		
		return theSet;
	}
	
	/**
	 * method to make a map of word lengths mapping to a set of
	 * words that have that word length
	 * makes a new map and then an iterator over the set is passed in
	 * the method returns the result of the recursive method
	 * which will fill the map
	 * @param theSet the set to iterate on
	 * @return the recursive method, which will return the map
	 */
	public static Map<Integer, Set<String>> getWordLengthMap
																					(Set<String> theSet)
	{
		Map<Integer, Set<String>> wordLengthMap = 
				new TreeMap<Integer, Set<String>>();
		
		Iterator<String> itr = theSet.iterator();
		
		return getWordLengthMap(wordLengthMap, itr);
	}
	
	/**
	 * recursive method to complement
	 * the non-recursive getWordLengthMap()
	 * receives the map to fill and the iterator of the set 
	 * to use to fill the map
	 * while the set's iterator has a next element, 
	 * if the map's keyset doesn't already have the element, 
	 * put the word length in the map 
	 * and make a new set for that word length
	 * and add the word to the word length
	 * then, call getWordLengthMap() again 
	 * (the iterator.next() should be updated)
	 * if there was already that word length as a key
	 * in the map, just add the word to the keyset of that key
	 * then, remove the word from the iterator
	 *  and call the getWordLengthMap() again
	 * @param theWordLengths the map to fill
	 * @param theWordSetItr the iterator of the set to fill the map with
	 * @return the map filled
	 */
	public static Map<Integer, Set<String>> getWordLengthMap
														(Map<Integer, Set<String>> theWordLengths,
																			Iterator<String> theWordSetItr)
	{
		if(theWordSetItr.hasNext())
		{
			String word = theWordSetItr.next();
			
			if(!(theWordLengths.keySet().contains(word.length())))
			{
				theWordLengths.put(word.length(), new TreeSet<String>());
				theWordLengths.get(word.length()).add(word);
				getWordLengthMap(theWordLengths, theWordSetItr);
			}
			else
			{
				theWordLengths.get(word.length()).add(word);
				getWordLengthMap(theWordLengths, theWordSetItr);
			}
		}
		
		return theWordLengths;
	}
																								
}
