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
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;


/**
 * cart class to contain all item orders
 * includes a way to add items to the cart, set membership status, calculate
 * total of items on cart, clear the cart, get the size of cart, and 
 * return a string representation
 * @author Brandon Lu
 * @version 18 January 2020
 */
public class Cart implements Comparable<Cart>, Comparator<Cart>{

      /**
       * arraylist field to store item orders in cart
       */
	  private final ArrayList<ItemOrder> myItemsList;
	  /**
	   * membership status field (determine bulk or not)
	   */
	  private boolean myMembership;
	  
	  /**
	   * constructor that initializes the list and sets membership to default false
	   */
    public Cart() {
        myItemsList = new ArrayList<ItemOrder>();
        myMembership = false;
    }
    
    /**
     * method to add items to cart
     * replaces item order if item is already in cart
     * @param theOrder item order to put in
     */
    public void add(final ItemOrder theOrder) {
        if(theOrder == null)
        {
            throw new NullPointerException("Item order must not be null");
        }
        
        boolean replace = false;
        int index = 0;
        
        for(int i = 0; i < myItemsList.size(); i++)
        {
            if(myItemsList.get(i).getItem().equals(theOrder.getItem()))
            {
                replace = true;
                index = i;
            }
            
        }
        
        if(replace)
        {
            myItemsList.set(index, theOrder);
        }
        
        else
        {
            myItemsList.add(theOrder);
        }
    }

    /**
     * sets the membership to true or false, depending on what's passed in
     * @param theMembership false or true member status
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }


    /**
     * method to calculate the total of items in cart
     * applies bulk discount if membership is active
     * @return total of items in cart
     */
    public BigDecimal calculateTotal() {
    	BigDecimal total = BigDecimal.ZERO; //set total to starting at 0
    	
        if(myMembership) //if customer has a membership
        {
        	for(int i = 0; i < myItemsList.size(); i++)
        	{
        	    //declare variables for easy use
        	    ItemOrder currentItemOrder = myItemsList.get(i);
        	    Item currentItem = currentItemOrder.getItem();
        	    BigDecimal price = currentItem.getPrice();
        	    BigDecimal quantity = new BigDecimal(currentItemOrder.getQuantity());
        	    BigDecimal bulkQuantity = new BigDecimal(currentItem.getBulkQuantity());
        	    BigDecimal bulkPrice = currentItem.getBulkPrice();
        	    
        	    if(currentItem.isBulk()) //if the item has a bulk price
        	    {
        	        //add to the total the excess items over the bulk quantity
        	        total = total.add( 
        	        price.multiply(
        	        quantity.remainder(bulkQuantity)));
        	        //then add the bulk priced quantities
        	        total = total.add( 
        	        bulkPrice.multiply(
        	                        quantity.divideToIntegralValue(bulkQuantity)));
        	    }
        	    //else just add the item times the price
        	    else
        	    {
        	        total = total.add(
        	                  price.multiply(
        	                  quantity));
        	    }
        	}
        }
        //else if customer has no membership
        else
        {
        	for(int i = 0; i < myItemsList.size(); i++)
        	{
        	    ItemOrder currentItemOrder = myItemsList.get(i);
        	    Item currentItem = currentItemOrder.getItem();
        	    BigDecimal price = currentItem.getPrice();
                BigDecimal quantity = new BigDecimal(currentItemOrder.getQuantity());
        	    //add all items with regular price
        	    total = total.add(
        	              price.multiply(
        	              quantity));
        	}
        }
        
        //return the total with 2 decimal places with round half even rule
        return total = total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
    
    /**
     * method to clear all items in the cart
     */
    public void clear() {
        myItemsList.clear();
    }
    
    /**
     * method to get cart size
     * @return size of the list for cart
     */
    public int getCartSize() {
        return myItemsList.size();
    }

    /**
     * method to check if 2 carts are equal
     * returns true if every single item order in the cart is equal to every single
     * item order in the other cart
     * @return if they are equivalent or not
     */
    @Override
    public boolean equals(Object theCart)
    {
        boolean result = false;
        
        if(theCart instanceof Cart)
        {
            result = ((Cart) theCart).myItemsList.size() == myItemsList.size();
            
            if(result)
            {
                Collections.sort(myItemsList);
                Collections.sort(((Cart) theCart).myItemsList);
                
                for(int i = 0; i < myItemsList.size(); i++)
                {
                    if(!((myItemsList.get(i)).equals(((Cart) theCart).myItemsList.get(i))))
                    {
                        result = false;
                        break;
                    }
                }
                
            }
        }
        
        return result;
    }
    
    /**
     * method to compare carts to each other using hashcode for sorting
     * @param theOther other cart to compare to
     * @return integer telling how to sort
     */
    @Override
    public int compareTo(Cart theOther)
    {
        return hashCode() - theOther.hashCode();
    }
    
    /**
     * method to compare carts for sorting
     * returns -1 if in ascending order, 0 if equal, 1 if descending order
     * based on hashcode
     * @return the difference of the hashcodes
     */
    @Override
    public int compare(Cart theFirst, Cart theSecond)
    { 

        return theFirst.hashCode() - theSecond.hashCode();
    }
    
    /**
     * method to return string representation of cart
     * @return each item order in cart
     */
    @Override
    public String toString() {
        String message = "";
        
        for(ItemOrder io : myItemsList)
        {
        	message += io + "\n";
        }
        
        return message;
    }
    
    /**
     * method to generate unique hashCode for cart
     * uses Objects class hash method to generate hash code
     * @return unique hash number
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(myItemsList, myMembership);
    }

}
