/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer 
 * 2/6/2020
 * HW5 Object Cloning
 */

/**
 * class to test cloning of toys and batteries
 * @author Brandon Lu
 * @version 6 February 2020
 */
public class CloneTester {

	/**
	 * main driver class to execute test cases for cloning
	 * @param theArgs command line input
	 */
	public static void main(String[] theArgs) {
	
		//test case 1: cloning a battery and comparing fields
		Battery.testClone();
		
		System.out.println();
		
		//test case 2: cloning toy and comparing fields
		Toy.testClone();
	}

}
