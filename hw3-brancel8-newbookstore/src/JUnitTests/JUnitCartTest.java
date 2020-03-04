/**
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 2/16/2020
 * HW#6
 */

package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Cart;
import model.Item;
import model.ItemOrder;

/**
 * JUnit test class to test Cart methods: equals, hashCode
 * @author Brandon Lu
 * @version 16 February 2020
 */
class JUnitCartTest {
    
    
    Item item;
    Item other;
    Item i3;
    Item i4;
    
    ItemOrder io;
    ItemOrder io2;
    ItemOrder io3;
    ItemOrder io4;
                    
    Cart c1;
    Cart c2;
    Cart c3;
    Cart c4;

    /**
     * initializes items, itemOrders, and Carts to set up
     * with fresh start for each test
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        item = new Item("UW Note pad", new BigDecimal(4.41), 6, new BigDecimal(10.04));
        other = new Item("UW Note pad", new BigDecimal(4.41),
                                 6, new BigDecimal(10.04));
        i3 = new Item("Pencil", new BigDecimal(1.05), 6, new BigDecimal(5.05));
        i4 = new Item("Eraser", new BigDecimal(0.99), 3, new BigDecimal(4.00));
        
        io = new ItemOrder(item, 2);
        io2 = new ItemOrder(other, 2);
        io3 = new ItemOrder(i3, 3);
        io4 = new ItemOrder(i4, 4);
        
        c1 = new Cart();
        c2 = new Cart();
        c3 = new Cart();
        c4 = new Cart();
        
        c1.add(io);
        c1.add(io3);
        
        c2.add(io);
        c2.add(io3);
        
        c3.add(io);
        c3.add(io2);
        c3.add(io3);
        
        c4.add(io3);
        c4.add(io4);
    }

    /**
     * sets objects to null to clean up after each 
     * test
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
        item = null;
        other = null;
        i3 = null;
        i4 = null;
        io = null;
        io2 = null;
        io3 = null;
        io4 = null;
        c1 = null;
        c2 = null;
        c3 = null;
        c4 = null;
    }
    
    
    /**
     * tests equals and hashCode methods
     */
    @Test
    void test() {
        assertEquals(true, c1.equals(c2));  
        assertEquals(true, c1.equals(c3));
        assertEquals(false, c1.equals(c4));
        assertEquals(false, c1.equals(io));
        
        assertEquals(c1.hashCode(), c2.hashCode());
        assertEquals(c1.hashCode(), c3.hashCode());
        assertNotEquals(c1.hashCode(), c4.hashCode());
        assertNotEquals(c2.hashCode(), c4.hashCode());
        assertNotEquals(c3.hashCode(), c4.hashCode());
    }

}
