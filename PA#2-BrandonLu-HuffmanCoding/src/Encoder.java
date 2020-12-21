/*
 * Brandon Lu
 * TCSS 342 - Spring 2020
 * Professor Sakpal
 * 5/15/2020
 */

/**
 * accepts a string and huffman tree
 * to encode a string into a bit stream
 * @author Brandon Lu
 * @version 15 May 2020
 */
public class Encoder {
	/**
	 * the table to get codes from
	 */
	private HuffmanFrequencyTable myTable;
	/**
	 * the string to encode
	 */
	private String myString;
	/**
	 * the encoded string
	 */
	private String myEncoded;
	
	/**
	 * constructor that initializes the table
	 * and string to encode
	 * also encodes the string
	 * @param theTree the tree to get the codes from
	 * @param theString the string to be encoded
	 */
	public Encoder(HuffmanTree theTree, String theString)
	{
		myTable = theTree.getTable();
		myString = theString;
		myEncoded = encode();
	}
	
	/**
	 * encodes the stream by building a string
	 * based on each character's code
	 * @return the encoded string
	 */
	private String encode()
	{
		char[] charArray = myString.toCharArray();
		StringBuilder encoded = new StringBuilder();
		
		for(char c : charArray)
		{
			for(HuffmanTreeNode htn : myTable.getTable())
			{
				if(htn.getChar() == c)
				{
					encoded.append(htn.getCode());
				}
			}
		}
		
		return encoded.toString();
	}
	
	/**
	 * the encoded string
	 * @return the encoded string
	 */
	public String getEncoded()
	{
		return myEncoded;
	}
}
