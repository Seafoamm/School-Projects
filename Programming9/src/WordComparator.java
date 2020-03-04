/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/29/19
 */

import java.util.*;

/**
 * comparator class for comparing words
 * sorts based on descending normal form order
 * @author Brandon Lu
 * @version 29 November 2019
 */
public class WordComparator implements Comparator<Word>{
	
	/**
	 * uses string compare to method and negates that on
	 * the normal forms of the words 
	 * this causes the words to be sorted descending
	 * order based on normal form
	 * @param theFirst first word to compare with
	 * @param theSecond second word to compare with
	 * @return integer result to know sorting order
	 */
	public int compare(final Word theFirst, final Word theSecond)
	{
		return -(theFirst.getNorm().compareTo(theSecond.getNorm()));
	}
}
