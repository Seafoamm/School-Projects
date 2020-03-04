/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer 
 * 2/9/2020
 * PA#3 New Bookstore
 */

package tests;

import model.Item;
import comparators.ItemComparator;
import model.Cart;
import model.ItemOrder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Brandon Lu
 * @version 9 February 2020
 */
public class TestItem {

    public static void main(String[] theArgs) {
        System.out.println("TestItem class running...");
        Item item = new Item("UW Note pad", new BigDecimal(4.41), 6, new BigDecimal(10.04));
        Item other = new Item("UW Note pad", new BigDecimal(4.41),
                                 6, new BigDecimal(10.04));
        int toString = test_toString(item);
        
        if(toString == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int equals = test_equals(item, other);
        
        if(equals == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int hashCode = test_hashCode(item);
        
        if(hashCode == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int compareTo = test_compareTo(item, other);
        
        if(compareTo == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int compare = test_compare(item, other);
        
        if(compare == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
    }

    public static int test_toString(Item theItem)
    {
        System.out.println("Testing toString with input " + theItem.getName());
        System.out.println("Expected result: ");
        String expected;
        String actual = theItem.toString();
        
        if(theItem.isBulk())
        {
            expected = String.format(
                                     theItem.getName() +
                                     ",  $%.2f (" + 
                                     theItem.getBulkQuantity() +
                                     " for " +
                                     "$%.2f)"
                                     , theItem.getPrice(), theItem.getBulkPrice()
                                     );
        }
        
        else
        {
            expected = String.format(
                                    theItem.getName() +
                                    ",  $%.2f", theItem.getPrice()
                                    );
        }
    
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
    
    public static int test_equals(Item theItem, Item theOther)
    {
        System.out.println("Testing equals with input " + theItem.getName() + " and "
                           + theOther.getName());
        System.out.println("Expected result: ");
        
        boolean expected = (theItem.getName()).equals(theOther.getName());
        
        if(expected)
        {
            expected = (theItem.getPrice()).equals(theOther.getPrice());
        }
        
        if(expected)
        {
            expected = theItem.getBulkQuantity() == theOther.getBulkQuantity();

        }
        
        if(expected)
        {
            expected = theItem.getBulkPrice().equals(theOther.getBulkPrice());
        }

        System.out.println(expected);
        
        boolean actual = theItem.equals(theOther);
        
        System.out.println("Actual result: ");
        System.out.println(actual);
        
        int result = -1;
        
        if(expected == actual)
        {
            result = 1;
        }
        
        return result;
        
    }
    
    public static int test_hashCode(Item theItem)
    {
        System.out.println("Testing hashCode with input " + theItem.getName());
        
        int actual = theItem.hashCode();
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
    
    public static int test_compareTo(Item theItem, Item theOther)
    {
        System.out.println("Testing compareTo with input " + theItem.getName() + " and "
                        + theOther.getName());
        
        int expected = theItem.getName().compareTo(theOther.getName());
        int actual = theItem.compareTo(theOther);
        
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
    
    public static int test_compare(Item theItem, Item theOther)
    {
        System.out.println("Testing compare method with 2 items...");
        
        ArrayList<String> bothell = 
                        (ArrayList<String>)Arrays.asList("Jolly Ranchers", "Laffy Taffy",
                                                  "Snickers Bar", "Heath Bar",
                                                  "Bottled Water", "Turkey Sandwich",
                                                  "Tim\'s Chips");
        int expected;
        
        if(bothell.contains(theItem.getName()))
        {
            expected = ((theItem.getPrice().subtract(theOther.getPrice())).toBigInteger()).intValue();
        }
        
        else
        {
            expected = ((theOther.getPrice().subtract(theItem.getPrice())).toBigInteger()).intValue();
        }
        
        int actual = new ItemComparator().compare(theItem, theOther);
        
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
