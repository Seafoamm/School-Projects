/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 2/6/2020
 * HW5 Object Cloning
 */

import java.util.*;

/**
 * toy class that contains the name of the toy and
 * the batteries it contains
 * contains a method to clone the toy and
 * a method to return a string representation of the toy
 * @author Brandon Lu
 * @version 6 February 2020
 */
public class Toy implements Cloneable{
	
	/**
	 * string field to contain name of the toy
	 */
	private String myName;
	/**
	 * array field to contain the batteries in the toy
	 */
	private Battery[] myBatteries;
	
	/**
	 * constructor of toy class
	 * accepts a name and an array of batteries
	 * and sets the fields to the respective parameters
	 * @param theName name of toy
	 * @param theBatteries batteries in toy
	 */
	public Toy(String theName, Battery[] theBatteries)
	{
		myName = theName;
		myBatteries = theBatteries;
	}
	
	/**
	 * clone method for toy that returns a clone of the toy
	 * including everything within the toy (the array of batteries
	 * and the batteries themselves)
	 * @return a complete deep copy of the toy
	 */
	@Override
	public Toy clone()
	{
		Toy newToy;
		
		try
		{
			newToy = (Toy)super.clone();
			newToy.myBatteries = new Battery[myBatteries.length];
			for(int i = 0; i < myBatteries.length; i++)
			{
				newToy.myBatteries[i] = myBatteries[i].clone();
			}
		}
		
		catch(CloneNotSupportedException e)
		{
			newToy = null;
			System.out.println("Cannot clone this object: " +
					this.toString());
		}
		
		return newToy;
	}
	
	/**
	 * returns string representation of the toy
	 * including the name and the array of the batteries 
	 * in the toy
	 * @return toy in a readable format
	 */
	@Override
	public String toString()
	{
		return myName + "\n" + Arrays.toString(myBatteries);
	}
	
	/**
	 * method to test cloning of toys
	 * tests to see if the array and the batteries are cloned
	 * and changes fields to see if they will affect the original 
	 * toy
	 * prints expected and actual results
	 * if expected and actual are the same, cloning is success
	 */
	public static void testClone()
	{
		Battery[] batteries = 
			{
				new Battery(111, "Lu", new Date()),
				new Battery(222, "Lu2", new Date(System.currentTimeMillis() +
						222222222)),
				new Battery(333, "Lu3", new Date(System.currentTimeMillis() +
						333333333))
			};
		Toy t1 = new Toy("Dino", batteries);
		
		Toy t2 = t1.clone();
		Battery b1 = new Battery(12345, "Lew", 
		new Date(t2.myBatteries[0].getExpiration().getTime() + 99999999));
		t2.myBatteries[0] = b1;
		
		System.out.println("Now testing toy clone:\n");
		System.out.println("Expected results: ");
		System.out.println("Dino\n"
				+ "[Battery111\nManufacturer: Lu\n"
				+ "Expires: " +
				batteries[0].getExpiration() + 
				", Battery222\nManufacturer: Lu2\n"
						+ "Expires: " +
						batteries[1].getExpiration() +
						", Battery333\nManufacturer: Lu3\n"
								+ "Expires: " +
								batteries[2].getExpiration() + "]");
		System.out.println("Dino\n"
				+ "[Battery12345\nManufacturer: Lew\n"
				+ "Expires: " +
				b1.getExpiration() + 
				", Battery222\nManufacturer: Lu2\n"
						+ "Expires: " +
						batteries[1].getExpiration() +
						", Battery333\nManufacturer: Lu3\n"
								+ "Expires: " +
								batteries[2].getExpiration() + "]");
		
		System.out.println("\nActual results: ");
		System.out.println(t1);
		System.out.println(t2);
	}
}
