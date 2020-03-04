/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 1/18/2020
 * PA#2 Bookstore Application
 */

package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/*
 * NOTE:
 * COMPARE() METHOD IN SEPARATE COMPARATOR CLASS FOR
 * OBJECT ORIENTED IMPLEMENTATION
 */

/**
 * class for defining Items
 * includes all the information about an item:
 * name, price, bulk quantity, bulk price, and if it's bulkable
 * also contains methods to get info about item, 
 * return a string representation of an item, 
 * and compare 2 items to see if they are equal
 * @author Brandon Lu
 * @version 18 January 2020
 */
public final class Item implements Comparable<Item>{

	  /**
	   * field to store item's name
	   */
    private final String myName;
    /**
     * field to store item's price
     */
    private final BigDecimal myPrice;
    /**
     * field to store number of items to receive bulk discount
     */
    private final int myBulkQuantity;
    /**
     * field to store price of item with bulk discount
     */
    private final BigDecimal myBulkPrice;
    /**
     * field to store if item has bulk discount
     */
    private final boolean myIsBulk;
    
    /**
     * constructor for item with no bulk
     * initializes fields, sets non-use fields to default values
     * @param theName name of item
     * @param thePrice price of item
     */
    public Item(final String theName, final BigDecimal thePrice) {
        if(theName == "" || thePrice.compareTo(BigDecimal.ZERO) < 0)
        {
            throw new IllegalArgumentException(
                      "Name of item required and price cannot be negative");
        }
        if(theName == null || thePrice == null)
        {
            throw new NullPointerException("Parameters must not be null");
        }
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = 0;
        myBulkPrice = new BigDecimal(0);
        myIsBulk = false;
    }

    /**
     * constructor for item with bulk pricing
     * initializes fields to respective values
     * @param theName name of item
     * @param thePrice price of item
     * @param theBulkQuantity number of item to receive discount
     * @param theBulkPrice price of item after discount
     */
    public Item(final String theName, final BigDecimal thePrice,
    		final int theBulkQuantity, final BigDecimal theBulkPrice) {
        if(theName == "" || thePrice.compareTo(BigDecimal.ZERO) < 0 || 
                        theBulkQuantity < 0 || theBulkPrice.compareTo(BigDecimal.ZERO) < 0)
        {
            throw new IllegalArgumentException(
                      "Item name required and prices and quantities cannot be negative");
        }
        if(theName == null || thePrice == null || theBulkPrice == null)
        {
            throw new NullPointerException("Parameters must not be null");
        }
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;
        myIsBulk = true;
    }

    /**
     * getter method to return name of item
     * @return the name of the item
     */
    public String getName()
    {
    	return myName;
    }
    
    /**
     * getter method to return the price of the item
     * @return the price of the item
     */
    public BigDecimal getPrice() {
        return myPrice;
    }

    /**
     * getter method to return amount of item
     * required for bulk discount
     * @return the bulk quantity
     */
    public int getBulkQuantity() {
        return myBulkQuantity;
    }

    /**
     * getter method for price after bulk discount
     * @return price after bulk discount
     */
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }

    /**
     * getter method for if item has bulk discount
     * @return if item has bulk discount
     */
    public boolean isBulk() {
        return myIsBulk;
    }


    /**
     * method to display item in a 
     * string representation
     * string includes: name, bulk quantity, price, and bulk price
     * different string if bulk item or not
     * @return string representation of the item
     */
    @Override
    public String toString() {
        String message;
        
        if(myIsBulk)
        {
        	message = String.format(
        			myName +
        			",  $%.2f (" + 
        			myBulkQuantity +
        			" for " +
        			"$%.2f)"
        			, myPrice, myBulkPrice
        			);
        }
        
        else
        {
        	message = String.format(
              myName +
              ",  $%.2f", myPrice
              );
        }
        
        return message;
    }
    
    /**
     * method to compare items to other ones
     * (sorts in ascending order)
     * @return how to sort the items
     */
    @Override
    public int compareTo(Item theOther)
    {
        return (this.getName()).compareTo(theOther.getName());
    }
    
    
    /**
     * method to check if another item is equal to
     * this one (needs to have same name, price, bulk quantity and
     * bulk price)
     * @param theItem to compare to this item
     * @return if they are equal or not
     */
    @Override
    public boolean equals(final Object theItem) {
        boolean result = false;
        
        if(theItem instanceof Item)
            {
                result = myName.equals(((Item) theItem).myName);
            
            if(result)
            {
            	result = myPrice.equals(((Item) theItem).myPrice);
            }
            
            if(result)
            {
            	result = myBulkQuantity == ((Item) theItem).myBulkQuantity;
            }
            
            if(result)
            {
            	result = myBulkPrice.equals(((Item) theItem).myBulkPrice);
            }
        }
        
        return result;
    	
    }
    
    /**
     * method to generate hash code for objects
     * uses hash method from Objects class to generate unique hash code
     * @return hash code for this object
     */
    @Override
    public int hashCode() {

        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice, myIsBulk);
    }

}
