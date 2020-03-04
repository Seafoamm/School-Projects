/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/29/19
 */

import java.util.*;

/**
 * comparator class to compare anagram families together
 * for specific sorting
 * @author Brandon Lu
 * @version 29 November 2019
 */
public class AnagramFamilyComparator 
																implements Comparator<AnagramFamily>{

	/**
	 * compare method implemented from comparator
	 * sorts based on descending order of family sizes
	 * (subtracts them, and then negates to turn from
	 * ascending to descending)
	 * @param theFirst the first anagram family to compare with
	 * @param theSecond the second anagram family to compare with
	 * @return integer result to know order to sort
	 */
	public int compare(AnagramFamily theFirst, AnagramFamily theSecond)
	{
		return -(theFirst.getFamilyCount() - theSecond.getFamilyCount());
	}
}
