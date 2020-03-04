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

import model.Item;
import model.ItemOrder;

/**
 * JUnit test class to test ItemOrder methods: equals, hashCode, compareTo
 * @author Brandon Lu
 * @version 16 February 2020
 */
class JUnitItemOrderTest {



    Item item;
    Item other;
    Item i4;
    
    ItemOrder io;
    ItemOrder io2;
    ItemOrder io3;
    ItemOrder io4;


    /**
     * initializes items and itemorders for fresh start
     * on each test
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        item = new Item("UW Note pad", new BigDecimal(4.41), 6, new BigDecimal(10.04));
        other = new Item("UW Note pad", new BigDecimal(4.41),
                                 6, new BigDecimal(10.04));
        i4 = new Item("Eraser", new BigDecimal(0.99), 3, new BigDecimal(4.00));
        
        io = new ItemOrder(item, 2);
        io2 = new ItemOrder(other, 2);
        io3 = new ItemOrder(other, 3);
        io4 = new ItemOrder(i4, 4);
    }

    /**
     * sets objects to null to clean up after each test
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
        item = null;
        other = null;
        i4 = null;
        io = null;
        io2 = null;
        io3 = null;
        io4 = null;
    }

    /**
     * test equals, hashcode, and compareTo methods
     */
    @Test
    void test() {
        assertEquals(true, io.equals(io2));
        assertEquals(false, io.equals(io3));
        assertEquals(false, io.equals(io4));
        
        assertEquals(io.hashCode(), io2.hashCode());
        assertNotEquals(io.hashCode(), io3.hashCode());
        assertNotEquals(io.hashCode(), io4.hashCode());
        assertNotEquals(io2.hashCode(), io3.hashCode());
        assertNotEquals(io2.hashCode(), io4.hashCode());
        
        assertEquals(io.hashCode() - io2.hashCode(), io.compareTo(io2));
        assertEquals(io.hashCode() - io.hashCode(), io.compareTo(io));
        assertEquals(io2.hashCode() - io.hashCode(), io2.compareTo(io));
        
        
    }

}
