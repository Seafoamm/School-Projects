/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 2/13/2020
 * PA#3 New Bookstore 
 */

package comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import model.Item;

/**
 * object oriented comparator class
 * @author Brandon Lu
 * @version 13 February 2020
 */
public class ItemComparator implements Comparator<Item> {

    /**
     * method to compare 2 items for sorting
     * if the item is within the bothell item stock, 
     * sort by ascending, if it's within tacoma, sort descending
     * all sorts based on price order
     * @return int indicating how to sort
     */
    @Override
    public int compare(Item theFirst, Item theSecond)
    {
        ArrayList<String> bothell = new ArrayList<String>();
        bothell.add("Jolly Ranchers");
        bothell.add("Laffy Taffy");
        bothell.add("Snickers Bar");
        bothell.add("Heath Bar");
        bothell.add("Bottled Water");
        bothell.add("Turkey Sandwich");
        bothell.add("Tim's Chips");

        int result;
        
        if(bothell.contains(theFirst.getName()))
        {
            result = ((theFirst.getPrice().subtract(theSecond.getPrice())).toBigInteger()).intValue();
        }
        
        else
        {
            result = ((theSecond.getPrice().subtract(theFirst.getPrice())).toBigInteger()).intValue();
        }
        
        return result;
        
    }
}
