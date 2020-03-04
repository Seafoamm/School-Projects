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
import java.util.ArrayList;
import java.util.Arrays;

import model.Cart;
import model.ItemOrder;

/**
 * 
 * @author Brandon Lu
 * @version 9 February 2020
 */
public class TestCart {

    public static void main(String[] theArgs) {
        System.out.println("TestCart class running...");
        
        Item item = new Item("UW Note pad", new BigDecimal(4.41), 6, new BigDecimal(10.04));
        Item other = new Item("UW Note pad", new BigDecimal(4.41),
                                 6, new BigDecimal(10.04));
        
        ItemOrder io = new ItemOrder(item, 2);
        ItemOrder io2 = new ItemOrder(other, 2);
                        
        Cart c1 = new Cart();
        Cart c2 = new Cart();
        
        c1.add(io);
        c1.add(io2);
        
        c2.add(io);
        c2.add(io2);
        
        int toString = test_toString(c1);
        
        if(toString == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int equals = test_equals(c1, c2);
        
        if(equals == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int hashCode = test_hashCode(c1);
        
        if(hashCode == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int compareTo = test_compareTo(c1, c2);
        
        if(compareTo == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }
        
        int compare = test_compare(c1, c2);
        
        if(compare == 1)
        {
            System.out.println("Success");
        }
        
        else
        {
            System.out.println("Fail");
        }

    }
    
    public static int test_toString(Cart theCart)
    {
        System.out.println("Testing toString with input Cart");
        System.out.println("Expected result: ");
        String expected = theCart.toString();
        String actual = theCart.toString();
        
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
    
    public static int test_equals(Cart theCart, Cart theOther)
    {
        System.out.println("Testing equals with input 2 Carts");
        
        System.out.println("Expected result: ");
        
        boolean expected = theCart.equals(theOther);
        boolean actual = theCart.equals(theOther);;
        
        System.out.println("Actual result: ");
        System.out.println(actual);
        
        int result = -1;
        
        if(expected == actual)
        {
            result = 1;
        }
        
        return result;
        
    }
    
    public static int test_hashCode(Cart theCart)
    {
        System.out.println("Testing hashCode with input Cart");
        
        int actual = theCart.hashCode();
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
    
    public static int test_compareTo(Cart theCart, Cart theOther)
    {
        System.out.println("Testing compareTo with input 2 Carts");
        
        int expected = theCart .hashCode() - theOther.hashCode();
        int actual = theCart.hashCode() - theOther.hashCode();
        
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
    
    public static int test_compare(Cart theCart, Cart theOther)
    {
        System.out.println("Testing compare method with 2 carts");
        
        int expected = theCart.hashCode() - theOther.hashCode();
        int actual = theCart.compare(theCart, theOther);
        
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
