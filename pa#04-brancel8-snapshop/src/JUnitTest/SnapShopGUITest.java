/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 3/8/2020
 * PA#04 
 */
package JUnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gui.SnapShopGUI;

/**
 * JUnit class to test SnapShopGUI
 * @author Brandon Lu
 * @version 8 March 2020
 */
class SnapShopGUITest {

    /**
     * test SnapShopGUI variable
     */
    SnapShopGUI testGUI;

    /**
     * initializes an instance of SnapShopGUI for testing
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        testGUI = new SnapShopGUI();
    }

    /**
     * sets testGUI to null
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
        testGUI = null;
    }

    /**
     * tests the start method of GUI, which calls all the other methods
     * in the class
     */
    @Test
    void testStart() {
        testGUI.start();
    }

}
