/*
 * Brandon Lu
 * TCSS 342 - Spring 2020
 * Professor Sakpal
 * 5/15/2020
 */

/**
 * priority queue class implemented with
 * an array heap to build the huffman tree with
 * @author Brandon Lu
 * @version 15 May 2020
 */
public class PriorityQueue extends ArrayHeap {
	
	/**
	 * method to add element to priority queue
	 * adds element to underlying arrayheap
	 * @param theElement the element to add
	 */
	public void addElement(HuffmanTreeNode theElement)
	{
		add(theElement);
	}
	
	/**
	 * method to remove next element in priority queue
	 * removes element from underlying arrayheap
	 * @return the removed node
	 */
	public HuffmanTreeNode removeNext()
	{
		return removeMin();
	}
	
	
}
