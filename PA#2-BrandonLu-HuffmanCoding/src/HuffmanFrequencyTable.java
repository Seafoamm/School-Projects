/*
 * Brandon Lu
 * TCSS 342 - Spring 2020
 * Professor Sakpal
 * 5/15/2020
 */

import java.util.LinkedList;

/**
 * class to build huffman frequency table
 * from a string
 * @author Brandon Lu
 * @version 15 May 2020
 */
public class HuffmanFrequencyTable {
	/**
	 * list of huffman tree nodes
	 * containing the character and frequency of each
	 */
	private final LinkedList<HuffmanTreeNode> myTable =
			new LinkedList<HuffmanTreeNode>();
	
	/**
	 * the table in string form
	 */
	private final StringBuilder myOutput;
	
	/**
	 * header for string form of table
	 */
	private final String myHeader = "char     frequency     code" +
	"\n--------------------------------\n";
	
	/**
	 * constructor which makes the list of huffman tree nodes
	 * @param theString the string to make table from
	 */
	public HuffmanFrequencyTable(String theString)
	{
		if(theString.length() < 2)
		{
			System.out.println("Cannot make HuffmanFrequencyTable from 1 character");
			System.exit(1);
		}
		
		myOutput = new StringBuilder();
		myOutput.append(myHeader);
		
		char[] charArray = theString.toCharArray();
		for(char c : charArray)
		{
			addCharacter(c);
		}
		
	}

	/**
	 * adds a character to the list of nodes, increments its
	 * frequency by 1 if the list already contains the character
	 * @param theCharacter
	 */
	public void addCharacter(char theCharacter)
	{
		boolean isIn = false;
		HuffmanTreeNode toIncrement = null;
		
		for(HuffmanTreeNode htn : myTable)
		{
			if(htn.getChar() == theCharacter)
			{
				isIn = true;
				toIncrement = htn;
				break;
			}
		}
		
		if(isIn)
		{
			toIncrement.setFrequency(toIncrement.getFrequency() + 1);
		}
		
		else
		{
			myTable.add(new HuffmanTreeNode(theCharacter));
		}
		
	}
	
	/**
	 * returns the list of tree nodes
	 * @return the lsit of tree nodes
	 */
	public LinkedList<HuffmanTreeNode> getTable()
	{
		return myTable;
	}
	
	/**
	 * returns string representation of the table
	 */
	@Override
	public String toString()
	{
		for(HuffmanTreeNode htn : myTable)
		{
			myOutput.append(String.format("%-9s%-14d%s%n",
					htn.getChar(), htn.getFrequency(), htn.getCode()));
		}
		return myOutput.toString();
	}
}
