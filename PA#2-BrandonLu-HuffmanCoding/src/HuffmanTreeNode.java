/*
 * Brandon Lu
 * TCSS 342 - Spring 2020
 * Professor Sakpal
 * 5/15/2020
 */

/**
 * a node to build huffman tree from
 * has a character, frequency, and a code
 * as well as a left and right pointer
 * @author Brandon Lu
 * @version 15 May 2020
 */
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
	/**
	 * the character in the node
	 */
	private char myChar;
	/**
	 * the frequency of the character
	 */
	private int myFrequency;
	/**
	 * the code of the character
	 */
	private String myCode;
	/**
	 * the right pointer node
	 */
	private HuffmanTreeNode myRight;
	/**
	 * the left pointer node
	 */
	private HuffmanTreeNode myLeft;
	
	/**
	 * constructs an empty node
	 * with character of "null" equivalent for char
	 */
	public HuffmanTreeNode()
	{
		myChar = '\u0000';
	}
	
	/**
	 * constructs a node with given character
	 * and 1 frequency
	 * @param theChar the character to make node with
	 */
	public HuffmanTreeNode(char theChar)
	{
		myChar = theChar;
		myFrequency = 1;
	}
	
	/**
	 * returns the character of the node
	 * @return char of the node
	 */
	public char getChar()
	{
		return myChar;
	}
	
	/**
	 * returns the frequency of the node
	 * @return frequency of the node
	 */
	public int getFrequency()
	{
		return myFrequency;
	}
	
	/**
	 * returns the code of the node
	 * @return the code of the node
	 */
	public String getCode()
	{
		return myCode;
	}
	
	/**
	 * returns the right pointer of this node
	 * @return the right pointer of this node
	 */
	public HuffmanTreeNode getRight()
	{
		return myRight;
	}
	
	/**
	 * returns the left pointer of this node
	 * @return the left pointer of this node
	 */
	public HuffmanTreeNode getLeft()
	{
		return myLeft;
	}
	
	/**
	 * sets this node's code
	 * @param theCode the code to set this node to
	 */
	public void setCode(String theCode)
	{
		myCode = theCode;
	}
	
	/**
	 * sets this node's frequency
	 * @param theFreq the number to set the frequency to
	 */
	public void setFrequency(int theFreq)
	{
		myFrequency = theFreq;
	}
	
	/**
	 * sets this node's right pointer
	 * @param theRight the node to point to
	 */
	public void setRight(HuffmanTreeNode theRight)
	{
		myRight = theRight;
	}
	
	/**
	 * sets this node's left pointer
	 * @param theLeft the node to point to
	 */
	public void setLeft(HuffmanTreeNode theLeft)
	{
		myLeft = theLeft;
	}

	/**
	 * compares one node's frequency to another
	 * if this node's frequency is bigger than the other
	 * return positive number
	 * if they are the same return 0
	 * else negative number
	 * @return integer indicating how to sort
	 */
	@Override
	public int compareTo(HuffmanTreeNode theOther)
	{
		return myFrequency - theOther.getFrequency();
	}
	
	/**
	 * returns string form of this node with the character and frequency
	 * for testing purposes
	 * @return string form of this node
	 */
	public String toString()
	{
		if(myChar != '\u0000')
		{
			return "(" + myChar + ", " + myFrequency + ")";
		}
		
		return "(null, " + myFrequency + ")";
	}
}
