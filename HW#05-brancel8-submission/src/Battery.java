/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 2/6/2020
 * HW5 Object Cloning
 */

import java.util.*;

/**
 * battery class to make batteries
 * each battery contains a unique ID
 * a manufacturer
 * and an expration date
 * and ways to get and set the properties
 * of the battery
 * also contains a method to clone the battery
 * and a way to return a string representation of the battery
 * @author Brandon Lu
 * @version 6 February 2020
 */
public class Battery implements Cloneable{
	/**
	 * ID field containing a unique integer ID
	 * to identify battery
	 */
	private int myID;
	/**
	 * String field to contain manufacturer of this battery
	 */
	private String myManufacturer;
	/**
	 * Date field to contain information about
	 * when this battery will expire
	 */
	private Date myExpiration;
	
	/**
	 * constructor for battery object
	 * accepts an ID number, a manufacturer, and an expiration date
	 * sets the fields to their respective parameters
	 * @param theID the ID of the battery
	 * @param theManufacturer the manufacturer of the battery
	 * @param theExpiration the expiration date of the battery
	 */
	public Battery(int theID, String theManufacturer, Date theExpiration)
	{
		myID = theID;
		myManufacturer = theManufacturer;
		myExpiration = theExpiration;
	}
	
	/**
	 * returns the ID of the battery
	 * @return ID of battery
	 */
	public int getID()
	{
		return myID;
	}
	
	/**
	 * returns manufacturer of the battery
	 * @return manufacturer of battery
	 */
	public String getManufacturer()
	{
		return myManufacturer;
	}
	
	/**
	 * returns expiration date of battery
	 * @return expiration date of battery
	 */
	public Date getExpiration()
	{
		return (Date)myExpiration.clone();
	}
	
	/**
	 * sets the ID of the battery
	 * (useful for distinguishing batteries after you clone them)
	 * @param theID the ID to change to
	 */
	public void setID(int theID)
	{
		myID = theID;
	}
	
	/**
	 * sets the manufacturer of the battery
	 * can be used for test cases or if manufacturer was mistaken
	 * or if cloner is different
	 * @param theManufacturer the manufacturer to change to
	 */
	public void setManufacturer(String theManufacturer)
	{
		myManufacturer = theManufacturer;
	}
	
	/**
	 * sets the date of the battery
	 * useful for testing or if wrong expiration date was put on
	 * originally or for clones
	 * @param theExpiration expiration date to change to
	 */
	public void setExpiration(Date theExpiration)
	{
		myExpiration = theExpiration;
	}
	
	/**
	 * clones this battery
	 * everything is a deep copy including the date
	 * @return a clone of this battery
	 */
	@Override
	public Battery clone()
	{
		Battery newBattery;
		
		try
		{
			newBattery = (Battery)super.clone();
			newBattery.myExpiration = (Date)myExpiration.clone();
		}
		
		catch(CloneNotSupportedException e)
		{
			newBattery = null;
			System.out.println("Cannot clone this object: " +
			this.toString());
		}
		
		return newBattery;
	}
	
	/**
	 * returns the battery ID, manufacturer, and expiration date
	 * in a readable format
	 * @return string representation of the battery
	 */
	@Override
	public String toString()
	{
		return String.format("Battery%d\nManufacturer: %s\n"
				+ "Expires: %s", myID, myManufacturer, myExpiration);
	}
	
	/**
	 * method to test the cloning of battery
	 * makes a battery and clones it
	 * tests to see if clone fields can be changed without affecting
	 * original battery
	 * prints out expected and actual results to the console
	 * if expected and actual are the same, cloning is success
	 */
	public static void testClone()
	{
		System.out.println("Testing battery clone method:\n");
		
		Battery b1 = new Battery(123, "Brandon", new Date());
		
		Battery b2 = b1.clone();
		b2.setID(234);
		b2.setExpiration(new Date(b2.getExpiration().getTime() + 999999));
		b2.setManufacturer("Brandon2");
		
		System.out.println("Expected result:\n"
				+ "Battery123\nManufacturer: Brandon\n"
				+ "Expires: " + b1.getExpiration());
		System.out.println("Battery234\nManufacturer: Brandon2\n"
				+ "Expires: " +
				new Date(b1.getExpiration().getTime() + 999999));
		
		System.out.println("\nActual results: ");
		System.out.println(b1);
		System.out.println(b2);
	}
}
