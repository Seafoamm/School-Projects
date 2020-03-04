/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/28/19
 */

import java.util.*;

/**
 * anagram family class to store a list of all the words
 * that have the same alphabetical anagram
 * also contains a count of how many words in the list there are
 * there is also a class list of all anagrams
 * that have a family already
 * there is also a way to get a copy of the list, 
 * a way to get the amount of words in the list
 * and a way to display the contents of the AnagramFamily
 * @author Brandon Lu
 * @version 28 November 2019
 */
public class AnagramFamily {
	
	/**
	 * list field to store list of words that have same anagram
	 */
	private final List<Word> myFamilyList;
	
	/**
	 * field to store amount of elements in list
	 */
	private int myFamilyCount;
	
	/**
	 * class field to keep track of which anagrams already have a family
	 */
	public static final HashSet<String> myAllAnagrams =
			new HashSet<String>();
	
	/**
	 * constructor
	 * accepts a list of words
	 * adds in copies of words from list passed in to anagram list
	 * initializes the family list, sets the family count size
	 * uses an iterator to populate values in the list
	 * @param theList list to add values in from
	 */
	public AnagramFamily(final List<Word> theList)
	{
			myFamilyList = new LinkedList<Word>();
			myFamilyCount = theList.size();
			Iterator<Word> itr = theList.iterator();
			while(itr.hasNext())
			{
				myFamilyList.add(itr.next().copyWord());
			}
	}

	/**
	 * getter for list of words
	 * makes a defensive copy and returns that
	 * @return the defensive copy of the list
	 */
	public List<Word> getFamilyList()
	{
		List<Word> copyList = new LinkedList<Word>();
		
		for(Word word : myFamilyList)
		{
			copyList.add(word.copyWord());
		}
		
		return copyList;
	}
	
	/**
	 * returns an integer representing the number of words in
	 * the list
	 * @return the number of words in the list
	 */
	public int getFamilyCount()
	{
		return myFamilyCount;
	}
	
	/**
	 * returns a string representation of the list
	 * @return the list contents
	 */
	public String toString()
	{
		return myFamilyList.toString();
	}
}
