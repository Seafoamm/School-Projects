/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 1/18/2020
 * PA#2 Bookstore Application
 */
package model;

import java.util.Objects;

/**
 * this class includes information about an order of items
 * it contains the item and the quantity
 * also contains a method to display as a string
 * @author Brandon Lu
 * @version 1/18/2020
 */
public final class ItemOrder implements Comparable<ItemOrder> {

    /**
     * field to store type of item
     */
    private Item myItem;
    /**
     * field to store quantity of item
     */
    private int myQuantity;

    /**
     * constructor that accepts the item type and quantity
     * @param theItem item ordered
     * @param theQuantity quantity ordered
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        if(theQuantity < 0)
        {
            throw new IllegalArgumentException("Quantity must not be negative");
        }
        if(theItem == null)
        {
            throw new NullPointerException("Item must not be null");
        }
        myItem = theItem;
        myQuantity = theQuantity;
    }

    /**
     * return item that was ordered
     * does not require defensive copy because all fields
     * in Item class are final (constant/unchangable once set)
     * @return the item
     */
    public Item getItem() {
        return myItem;
    }
    
    /**
     * getter method for the number of items ordered
     * @return number of items ordered
     */
    public int getQuantity() {
        return myQuantity;
    }
    
    /**
     * method to compare ItemOrders to others for sorting in the cart
     * @param theOther other item order to compare to
     * @return return integer indicating how to sort item orders
     */
    @Override
    public int compareTo(ItemOrder theOther)
    {
        return hashCode() - theOther.hashCode();
    }
    
    /**
     * returns if the item order being compared to is equal to this item order
     * only returns true if the quantity and item type is the same
     * @param theOther other itemorder(or object) to compare to
     * @return if the 2 objects are equal
     */
    @Override
    public boolean equals(Object theOther)
    {
        boolean result = false;
        
        if(theOther instanceof ItemOrder)
        {
            result = myItem.equals(((ItemOrder)theOther).myItem) 
                            && myQuantity == ((ItemOrder)theOther).myQuantity;
        }
        
        return result;
    }
    
    /**
     * method to return string representation of item order
     * @return item type and quantity
     */
    @Override
    public String toString() {

        return myItem + " " + myQuantity;
    }

    /**
     * method to return unique hashcode number with Objects class hash method
     * @return unique hashcode number
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(myItem, myQuantity);
    }
}
