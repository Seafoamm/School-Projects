/*
 * Brandon Lu
 * TCSS 342 - Spring 2020
 * Professor Sakpal
 * 5/15/2020
 */

/**
 * class to build a huffman tree using a huffman
 * frequency table by inserting nodes from the table
 * into a priority queue
 * @author Brandon Lu
 * @version 15 May 2020
 */
public class HuffmanTree {
	/**
	 * root of the tree
	 */
	private HuffmanTreeNode myRoot;
	/**
	 * queue to build the tree from
	 */
	private PriorityQueue myQueue;
	/**
	 * table to get the nodes from
	 */
	private HuffmanFrequencyTable myTable;
	/**
	 * string form of the table
	 */
	private String myPrintableTable;
	
	/**
	 * constructor which makes the huffman tree
	 * by adding elements from the table into 
	 * a priority queue
	 * and then building the huffman tree
	 * also initializes the string form of the table
	 * @param theTable
	 */
	public HuffmanTree(HuffmanFrequencyTable theTable)
	{
		myTable = theTable;
		myQueue = new PriorityQueue();
		
		for(HuffmanTreeNode htn : myTable.getTable())
		{
			myQueue.add(htn);
		}
		
		myRoot = myQueue.peek();
		
		buildHuffmanTree();
		
		myPrintableTable = myTable.toString();
	}
	
	/**
	 * returns the root of the tree
	 * @return
	 */
	public HuffmanTreeNode getHuffmanTree()
	{
		return myRoot;
	}
	
	/**
	 * builds the huffman tree by combining
	 * nodes of smallest frequency 
	 * in the priority queue until there is only 1 left
	 * then assigns codes to each node
	 */
	public void buildHuffmanTree()
	{
		
		while(myQueue.getSize() > 1)
		{
			combineNodes();
		}
		
		myRoot = myQueue.removeNext();

		assignCodes(myRoot, "");
	}
	
	/**
	 * removes 2 nodes from the priority queue and 
	 * combines them with a null node with
	 * the combined frequency, then adds the null
	 * node back into the priority queue
	 */
	private void combineNodes()
	{
		HuffmanTreeNode connector = new HuffmanTreeNode();
		
		HuffmanTreeNode left, right;

		left = myQueue.removeNext();
		right = myQueue.removeNext();
		
		connector.setFrequency(left.getFrequency() + right.getFrequency());
		connector.setLeft(left);
		connector.setRight(right);
		
		myQueue.addElement(connector);
	}
	
	/**
	 * assigns codes to the huffman nodes
	 * using postorder traversal to generate codes
	 * @param theNode the node to start from
	 * @param theCode the code
	 */
	private void assignCodes(HuffmanTreeNode theNode, String theCode)
	{
		if(theNode == null)
		{
			return;
		}
		
		theNode.setCode(theCode);
		
		assignCodes(theNode.getLeft(), theCode += "0");
		
		theCode = theCode.substring(0, theCode.length() - 1);
		
		assignCodes(theNode.getRight(), theCode += "1");
	}
	
	/**
	 * returns the frequency table
	 * @return the frequency table
	 */
	public HuffmanFrequencyTable getTable()
	{
		return myTable;
	}
	
	/**
	 * returns the string of the table
	 * @return the string form of the table
	 */
	public String getPrintableTable()
	{
		return myPrintableTable;
	}
	
	/**
	 * prints each node in the huffman tree
	 * for testing purposes
	 * @param theNode the root
	 */
	public void printNodes(HuffmanTreeNode theNode)
	{
		if(theNode == null)
		{
			return;
		}
		
		printNodes(theNode.getLeft());
		
		printNodes(theNode.getRight());
		if(theNode.getChar() != '\u0000')
		{
			System.out.println(theNode.getChar() +
					" " + theNode.getFrequency() +
					" " + theNode.getCode());
		}
		
		else
		{
			System.out.println("null " + theNode.getFrequency() +
					" " + theNode.getCode());
		}
	}
}
