/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer 
 * 2/9/2020
 * PA#3 New Bookstore
 */

package tests;

import model.Item;

import java.math.BigDecimal;

import model.Cart;
import model.ItemOrder;

/**
 * 
 * @author Brandon Lu
 * @version 9 February 2020
 */
public class TestItemOrder {

    public static void main(String[] theArgs) {
        System.out.println("TestItemOrder class running...");
        
        Item item = new Item("UW Note pad", new BigDecimal(4.41), 6, new BigDecimal(10.04));
        Item other = new Item("UW Note pad", new BigDecimal(4.41),
                                 6, new BigDecimal(10.04));
        
        ItemOrder io = new ItemOrder(item, 2);
        ItemOrder io2 = new ItemOrder(other, 2);
                        
        int toString = test_toString(io);
        
        if(toString == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int equals = test_equals(io, io2);
        
        if(equals == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int hashCode = test_hashCode(io);
        
        if(hashCode == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int compareTo = test_compareTo(io, io2);
        
        if(compareTo == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }

    }
    
    public static int test_toString(ItemOrder theItemOrder)
    {
        System.out.println("Testing toString with input " + theItemOrder.getItem() +
                           theItemOrder.getQuantity());
        System.out.println("Expected result: ");
        String expected;
        String actual = theItemOrder.toString();
        
        expected = theItemOrder.getItem() + " " + theItemOrder.getQuantity();
    
        System.out.println(expected);
        System.out.println("Actual Result: ");
        System.out.println(actual);
        
        int result = -1;
        
        if(expected.equals(actual))
        {
            result = 1;
        }
        
        return result;
    }
    
    public static int test_equals(ItemOrder theItemOrder, ItemOrder theOther)
    {
        System.out.println("Testing equals with input " + theItemOrder.getItem() +
                           theItemOrder.getQuantity() + " and " + theOther.getItem() +
                           theOther.getQuantity());
        
        System.out.println("Expected result: ");
        
        boolean expected = theItemOrder.getItem().equals(theOther.getItem());
        
        if(expected)
        {
            expected = theItemOrder.getQuantity() == theOther.getQuantity();
        }
        
        boolean actual = theItemOrder.equals(theOther);
        
        System.out.println("Actual result: ");
        System.out.println(actual);
        
        int result = -1;
        
        if(expected == actual)
        {
            result = 1;
        }
        
        return result;
        
    }
    
    public static int test_hashCode(ItemOrder theItemOrder)
    {
        System.out.println("Testing hashCode with input " + theItemOrder.getItem() +
        theItemOrder.getQuantity());
        
        int actual = theItemOrder.hashCode();
        boolean success = true;
        
        try
        {
            Integer i = new Integer(actual);
        }
        catch(NumberFormatException e)
        {
            success = false;
        }
        
       System.out.println("Expected result: ");
       System.out.println("An integer.");
       
       System.out.println("Actual result");
       System.out.println(actual);
       
       int result = -1;
       
       if(success)
       {
           result = 1;
       }
       
       return result;
    }
    
    public static int test_compareTo(ItemOrder theItemOrder, ItemOrder theOther)
    {
        System.out.println("Testing compareTo with input " + theItemOrder.getItem() +
                           theItemOrder.getQuantity() + " and "
                        + theOther.getItem() + theItemOrder.getQuantity());
        
        int expected = theItemOrder.hashCode() - theOther.hashCode();
        int actual = theItemOrder.hashCode() - theOther.hashCode();
        
        System.out.println("Expected result: ");
        System.out.println(expected);
        
        System.out.println("Actual result: ");
        System.out.println(actual);
        
        int result = -1;
        
        if(expected == actual)
        {
            result = 1;
        }
        
        return result;
    }

}
