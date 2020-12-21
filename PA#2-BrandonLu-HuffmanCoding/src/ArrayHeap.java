/*
 * Brandon Lu
 * TCSS 342 - Spring 2020
 * Professor Sakpal
 * 5/15/2020
 */

/**
 * arrayheap class
 * minheap with array heap implementation
 * used to implement priority queue based on frequency
 * @author Brandon Lu
 * @version 15 May 2020
 */
public class ArrayHeap {

	/**
	 * array that contains elements in the heap
	 */
	private HuffmanTreeNode[] myArray;
	/**
	 * number of elements in the heap
	 */
	private int mySize;
	
	/**
	 * constructor which initializes empty arrayheap
	 */
	public ArrayHeap()
	{
		myArray = new HuffmanTreeNode[15];
		mySize = 0;
	}
	
	/**
	 * returns the first element in the arrayheap without removing it
	 * @return the first element
	 */
	public HuffmanTreeNode peek()
	{
		return myArray[0];
	}
	
	/**
	 * adds an element to the heap
	 * maintains the ordering and resizes if needed
	 * @param theNode the node to add
	 */
	public void add(HuffmanTreeNode theNode)
	{
		if(mySize == myArray.length)
		{
			resize();
		}
		
		myArray[mySize] = theNode;
		mySize++;

		if(mySize > 1)
		{
			heapifyAdd();
		}
	}
	
	/**
	 * returns the number of elements in the arrayheap
	 * @return the number of elements in the array heap
	 */
	public int getSize()
	{
		return mySize;
	}
	
	/**
	 * removes the minimum element in the array heap
	 * maintains the ordering of the array heap
	 * will print to the console if array is empty and
	 * an attempt to remove is made
	 * @return the minimum element in the array heap
	 */
	public HuffmanTreeNode removeMin()
	{
		if(isEmpty())
		{
			System.out.println("Underflow error");
			return null;
		}
		
		HuffmanTreeNode maxElement = myArray[0];
		myArray[0] = myArray[mySize - 1];
		myArray[mySize - 1] = null;
		mySize--;
		heapifyRemove();

		
		return maxElement;
	}
	
	/**
	 * method to maintain the ordering
	 * when an element is added
	 * compares the added element with its parent
	 * and swaps if it is greater
	 */
	private void heapifyAdd()
	{
		HuffmanTreeNode temp;
	  int next = mySize - 1;
	  temp = myArray[next];

	  while(next != 0 && temp.compareTo(myArray[(next - 1) / 2]) < 0)
	  {
	  	myArray[next] = myArray[(next - 1) / 2];
	  	next = (next - 1) / 2;
	  }
	  
	  myArray[next] = temp;
	}
	
	/**
	 * method to maintain ordering when element is removed
	 * swaps the last element with root
	 * and compares with children and swaps if it is greater
	 */
	private void heapifyRemove()
	{
		HuffmanTreeNode temp = myArray[0];
		int parent = 0, left = 1, right = 2;

		while(parent < mySize)
		{
			if(parent >= myArray.length ||
					right >= myArray.length ||
					left >= myArray.length)
			{
				parent = mySize;
			}
			
			else if(myArray[left] == null && myArray[right] == null)
			{
				parent = mySize;
			}
			
			else if(myArray[right] == null && temp.compareTo(myArray[left]) > 0)
			{
				HuffmanTreeNode temp2 = myArray[parent];
				myArray[parent] = myArray[left];
				myArray[left] = temp2;
				parent = left;
				left = (2 * parent) + 1;
				right = (2 * parent) + 2;
			}
			
			else if(myArray[right] != null && myArray[left].compareTo(myArray[right]) <= 0 &&
					temp.compareTo(myArray[left]) > 0)
			{
				HuffmanTreeNode temp2 = myArray[parent];
				myArray[parent] = myArray[left];
				myArray[left] = temp2;
				parent = left;
				left = (2 * parent) + 1;
				right = (2 * parent) + 2;
			}
			
			else if(myArray[right] != null && myArray[right].compareTo(myArray[left]) <= 0 &&
					temp.compareTo(myArray[right]) > 0)
			{
				HuffmanTreeNode temp2 = myArray[parent];
				myArray[parent] = myArray[right];
				myArray[right] = temp2;
				parent = right;
				left = (2 * parent) + 1;
				right = (2 * parent) + 2;
			}
			
			else
			{
				parent = mySize;
			}
		}
	}
	
	/**
	 * resizes the array to double size
	 * and copies elements over
	 */
	private void resize()
	{
		HuffmanTreeNode[] newArray = new HuffmanTreeNode[myArray.length * 2];
		
		for(int i = 0; i < myArray.length; i++)
		{
			newArray[i] = myArray[i];
		}
		
		myArray = newArray;
	}
	
	/**
	 * returns if the array is empty
	 * @return true if empty
	 */
	public boolean isEmpty()
	{
		if(myArray[0] == null)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * prints out the contents of the array heap
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int i = 0; i < mySize; i++)
		{
			sb.append(myArray[i]);
			if(i != mySize - 1)
			{
				sb.append(", ");	
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
}
