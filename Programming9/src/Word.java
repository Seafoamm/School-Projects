/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/29/19
 */

import java.util.*;

/**
 * word class to make words
 * stores the normal form and canonical form of the word
 * by converting the normal form using a method
 * has methods to access the forms of the word
 * also has a method to copy itself
 * and a method to compare this word to a different one
 * finally has a method to display itself in string form
 * @author Brandon Lu
 * @version 29 November 2019
 */
public class Word implements Comparable<Word>{
	
	/**
	 * string field to store normal form of the word
	 */
	private String myNorm;
	/**
	 * string field to store canonical form of word
	 */
	private String myCanon;
	
	/**
	 * no parameter constructor, makes empty word
	 */
	public Word()
	{
		this("");
	}
	
	/**
	 * constructor that accepts string parameter to
	 * turn into a Word
	 * stores original string into normal form field
	 * uses helper method to convert to canonical form
	 * and store into canonical form field
	 * @param theWord
	 */
	public Word(final String theWord)
	{
		myNorm = theWord;
		myCanon = canonize(myNorm);
	}
	
	/**
	 * helper method to convert a string into its canonical form
	 * first initializes a stringbuilder, then puts all the 
	 * characters of the string passed in into an array
	 * then sorts the array of characters
	 * then, append the sorted elements of the array
	 * onto the stringbuilder and returns the string representation
	 * of the stringbuilder
	 * @param theWord the string to pass in to canonize
	 * @return returns the word canonized
	 */
	public String canonize(final String theWord)
	{
		StringBuilder sbCanon = new StringBuilder();
		
		char[] wordChars = new char[theWord.length()];
		
		for(int i = 0; i < theWord.length(); i++)
		{
			wordChars[i] = theWord.charAt(i);
		}
		
		Arrays.sort(wordChars);
		
		for(char c : wordChars)
		{
			sbCanon.append(c);
		}
		
		return sbCanon.toString();
	}
	
	/**
	 * getter method for normal form field
	 * can return the field because strings are immutable
	 * @return the normal form of the word
	 */
	public String getNorm()
	{
		return myNorm;
	}
	
	/**
	 * getter method for canonical form field
	 * can return the field because strings are immutable
	 * @return the canonical form of the word
	 */
	public String getCanon()
	{
		return myCanon;
	}
	
	/**
	 * method to make a copy of this word
	 * makes a new word and sets its fields as copies of
	 * this word's fields
	 * @return a copy of this word
	 */
	public Word copyWord()
	{
		Word copyWord = new Word();
		
		copyWord.myNorm = this.myNorm;
		
		copyWord.myCanon = this.myCanon;
		
		return copyWord;
	}
	
	/**
	 * compares the canonical forms of this word to another
	 * @param theOther other word to compare to
	 * @return the order in which the words should be sorted
	 */
	public int compareTo(final Word theOther)
	{
		return this.myCanon.compareTo(theOther.myCanon);
	}
	
	/**
	 * returns the normal form of the word
	 * @return the string representation of the word (normal form)
	 */
	public String toString()
	{
		return myNorm;
	}
}
