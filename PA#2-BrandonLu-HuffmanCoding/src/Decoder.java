/*
 * Brandon Lu
 * TCSS 342 - Spring 2020
 * Professor Sakpal
 * 5/15/2020
 */

/**
 * decoder class 
 * takes in a coded bitstream
 * and a huffman tree
 * to decode the string
 * @author Brandon Lu
 * @version 15 May 2020
 */
public class Decoder {

	/**
	 * the encoded bit stream
	 */
	private String myEncoded;
	/**
	 * the decoded string
	 */
	private String myDecoded;
	/**
	 * the huffman tree to use codes from
	 */
	private HuffmanTree myTree;
	
	/**
	 * constructor that initializes the encoded and decoded
	 * strings and decodes the encoded string
	 * @param theTree the tree to get codes from
	 * @param the encoded string
	 */
	public Decoder(HuffmanTree theTree, String theEncoded)
	{
		myEncoded = theEncoded;
		myTree = theTree;
		myDecoded = decode();
	}
	
	/**
	 * decodes the encoded string by 
	 * taking instructions from the bit stream
	 * 0 for left, 1 for right until a null is hit
	 * @return the decoded string
	 */
	private String decode()
	{
		char[] charArray = myEncoded.toCharArray();
		
		HuffmanTreeNode currentNode = myTree.getHuffmanTree();
		
		StringBuilder decoded = new StringBuilder();
		
		for(char c : charArray)
		{
			if(c == '0')
			{
				if(currentNode.getLeft() == null)
				{
					decoded.append(currentNode.getChar());
					currentNode = myTree.getHuffmanTree();
				}
				
				currentNode = currentNode.getLeft();
			}
			
			else if(c == '1')
			{
				if(currentNode.getRight() == null)
				{
					decoded.append(currentNode.getChar());
					currentNode = myTree.getHuffmanTree();
				}
				
				currentNode = currentNode.getRight();
			}
		}
		
		decoded.append(currentNode.getChar());
		
		return decoded.toString();
	}
	
	/**
	 * returns the decoded string
	 * @return the decoded string
	 */
	public String getDecoded()
	{
		return myDecoded;
	}
}
