/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 1/16/2020
 * Homework 2, Question 5
 * BJP5 Exercise 11.21: pairCounts
 */

import java.util.*;

/**
 * this class was made to solve the practice it problem:
 * BJP5 Exercise 11.21: pairCounts
 * make a pairCounts() method that when:
 * given a list of words, find all 2-character sequences in 
 * each word and tally them all up 
 * @author Brandon Lu
 * @version 16 January 2020
 */
public class paircounts {

	/**
	 * main driver of the class to run the "pairCounts()" method
	 * @param theArgs command line input
	 */
	public static void main(String[] theArgs) {
		
		List<String> list = new ArrayList<String>(); //make test list
		
		//add words to list
		list.add("banana");
		list.add("bends");
		list.add("i");
		list.add("mend");
		list.add("sandy");
		
		//print out the pairCounts() result
		System.out.println(pairCounts(list));
	}
	
	/**
	 * pairCounts() method to find all 2-character sequences in 
	 * each word and tally them all up
	 * @param theList list to take strings from
	 * @return the map of 2 character tallies
	 */
	public static Map<String, Integer> pairCounts(List<String> theList)
	{
		//make map to store the 2 character sequences and tallies
		Map<String, Integer> returnMap = new TreeMap<String, Integer>();
		
		//loop through the string list
		for(String s : theList)
		{
			//if the string has at least 2 characters
			if(s.length() > 1)
			{
				//loop through the string's characters
				for(int i = 0; i < s.length() - 1; i++)
				{
					//by using substrings to pull out 2 characters at a time
					String twoChar = s.substring(i, i + 2);
					//add 1 to the tally of the key, if the string is
					//already a key
					if(returnMap.keySet().contains(twoChar))
					{
						returnMap.put(twoChar, returnMap.get(twoChar) + 1);
					}
					//else, start a new key and start the tally at 1
					else
					{
						returnMap.put(twoChar, 1);
					}
					
				}
				
			}
			
		}
		//return the map
		return returnMap;
	}

}
