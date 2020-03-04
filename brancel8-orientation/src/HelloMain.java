/*
 * Brandon Lu
 * TCSS305 - Winter 2020
 * Professor Dincer
 * Assignment 1 - Orientation
 * 1/9/2020
 */

import java.awt.Color;

/**
 * This program displays a "Hello World!" statement using another class's method:
 * Hello.java. 
 * @author Brandon Lu
 * @version 9 January 2020
 */
public class HelloMain {

    /**
     * main driver method to execute the program
     * also has a averageRedValue() method that will accept 
     * any amount of Color objects as parameters
     * and will take the Color objects and return the average
     * of their red values
     * @param theArgs
     */
    public static void main(String[] theArgs) {
       
        Hello hello1 = new Hello(); //make new Hello object to use its method
        hello1.printHello(); //use the hello object's method to print "Hello World!"
    }

    /**
     * this method takes any number of Color objects and loops through them to 
     * get each red value and add them up. then, it calculates the average red value
     * and returns it.
     * @param theC: all the Color objects input to iterate through and get the red values from
     * @return the average of the red values
     */
    public static double averageRedValue(Color ... theC)
    {
        int totalRedValue = 0;
        int colorCount = 0;
        
        for(Color color : theC)
        {
           totalRedValue += color.getRed();
           colorCount++;
        }
        
        return totalRedValue / colorCount;
    }
}
