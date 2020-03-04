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

import comparators.ItemComparator;
import model.Item;

/**
 * JUnit test class to test Item methods: equals, hashCode, compareTo, compare
 * @author Brandon Lu
 * @version 16 February 2020
 */
class JUnitItemTest {

    Item item;
    Item other;
    Item i4;
    Item i3;
    ItemComparator iC;
    Item i5;
    Item i6;

    /**
     * initialize items and itemcomparator(for compare method)
     * for fresh start on tests each time
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        item = new Item("UW Note pad", new BigDecimal(4.41), 6, new BigDecimal(10.04));
        other = new Item("UW Note pad", new BigDecimal(4.41),
                                 6, new BigDecimal(10.04));
        i4 = new Item("Eraser", new BigDecimal(0.99), 3, new BigDecimal(4.00));
        i3 = new Item("UW Note pad", new BigDecimal(4.41),
                      5, new BigDecimal(10.04));
        iC = new ItemComparator();
        i5 = new Item("Jolly Ranchers", new BigDecimal(0.50), 6, new BigDecimal(2.50));
        i6 = new Item("3 Ring Binder", new BigDecimal(9.99));
    }

    /**
     * set objects to null to clean up after each test
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
        item = null;
        other = null;
        i4 = null;
        i3 = null;
        iC = null;
        i5 = null;
        i6 = null;
    }

    /**
     * test equals, hashcode, compareTo, and compare methods
     */
    @Test
    void test() {
        assertEquals(true, item.equals(other));
        assertEquals(false, item.equals(i4));
        assertEquals(false, item.equals(i3));
        assertEquals(false, item.equals("asdf"));

        assertEquals(item.hashCode(), other.hashCode());
        assertNotEquals(item.hashCode(), i5.hashCode());
        assertNotEquals(item.hashCode(), i3.hashCode());
        assertNotEquals(item.hashCode(), i6.hashCode());
        assertNotEquals(other.hashCode(), i3.hashCode());
        assertNotEquals(other.hashCode(), i5.hashCode());
        assertNotEquals(item.hashCode(), i4.hashCode());
        assertNotEquals(other.hashCode(), i6.hashCode());
        
        assertEquals(item.getName().compareTo(other.getName()), item.compareTo(other));
        assertEquals(other.getName().compareTo(other.getName()), other.compareTo(other));
        assertEquals(other.getName().compareTo(item.getName()), other.compareTo(item));
        assertEquals(item.getName().compareTo(i4.getName()), item.compareTo(i4));
        
        assertEquals(0, iC.compare(item, other));
        assertEquals(0, iC.compare(i5, i5));
        assertEquals(i6.getPrice().subtract(item.getPrice()).intValue(), iC.compare(item, i6));

    }

}
