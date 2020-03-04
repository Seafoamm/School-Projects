/*
 * TCSS 305 Assignment 2 - UW Bookstore
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import comparators.ItemComparator;
import model.Cart;
import model.Item;
import model.ItemOrder;
import res.R;

/**
 * BookstoreFrame provides the user interface for a UW Bookstore program.
 * 
 * @author Marty Stepp
 * @author Daniel M. Zimmerman (Formatting and Comments)
 * @author Alan Fowler (Numerous changes to code and comments including use of BigDecimal)
 * @author Charles Bryan (Added radio buttons to change campus locations/changed name)
 * @version Autumn 2019
 */
public final class BookstoreFrame extends JFrame {

    /** The Serialization ID. */
    private static final long serialVersionUID = 505198377375189354L;

    // constants to capture screen dimensions
    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

    /**
     * The shopping cart used by this GUI.
     */
    private final Cart myItems;
    
    /**
     * The map that stores each campus name and the campus's bookstore inventory.
     */
    private final Map<String, List<Item>> myCampusInventories; 

    /**
     * The map that stores each campus name and the campus's bookstore inventory.
     */
    private String myCurrentCampus;
    
    /**
     * The text field used to display the total amount owed by the customer.
     */
    private final JTextField myTotal;
    
    /**
     * The panel that holds the item descriptions. Needed to add and remove on
     * the fly when the radio buttons change. 
     */
    private JPanel myItemsPanel;

    /**
     * A List of the item text fields.
     */
    private final List<JTextField> myQuantities;
    
    /**
     * Initializes the bookstore GUI.
     * 
     * @param theCampusInventories The list of items.
     * @param theCurrentCampus The campus that is originally selected when 
     * the application starts. 
     */
    public BookstoreFrame(final Map<String, List<Item>> theCampusInventories, 
                         final String theCurrentCampus) {
        // create frame and order list
        super(); // No title on the JFrame. We can set this later.
        
        myItems = new Cart();

        // set up text field with order total
        myTotal = new JTextField(R.Strings.BF_TEXTFIELD_TOTAL, 
                                 R.Dimensions.BF_TEXTFIELD_TOTAL);
        
        myQuantities = new LinkedList<>();
        
        myCurrentCampus = theCurrentCampus;
        myCampusInventories = theCampusInventories;

        
        setupGUI();
    }    

    /**
     * Setup the various parts of the GUI.
     * 
     */
    private void setupGUI() {
        // hide the default JFrame icon
        //final Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        
        
        // replace the default JFrame icon
        final ImageIcon img = 
                        new ImageIcon(R.Strings.IO_FILE_LOCATION + R.Strings.IO_ICON_FILE);
        setIconImage(img.getImage());
        
        setTitle(R.Strings.BF_FRAME_TITLE);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(makeClearAndTotalPanel(), BorderLayout.SOUTH);
        
        myItemsPanel = makeItemsPanel(myCampusInventories.get(myCurrentCampus)); 
        add(myItemsPanel, BorderLayout.CENTER);
        
        add(makeCheckBoxPanel(), BorderLayout.NORTH);
        
        // adjust size to just fit
        pack();
        
        // make the GUI so that it cannot be resized by the user dragging a corner
        setResizable(false);
        
        // position the frame in the center of the screen
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2,
                    SCREEN_SIZE.height / 2 - getHeight() / 2);
        setVisible(true);
    }
    
    /**
     * Creates the panel to hold the campus location radio buttons. 
     * 
     * @return The created JPanel
     */
    private JPanel makeCampusPanel() {
        final JPanel p = new JPanel();
        p.setBackground(R.Colors.HEADER_FOOTER_BG);
        
        final ButtonGroup g = new ButtonGroup();
        for (final Object campus : myCampusInventories.keySet()) {
            final JRadioButton rb = new JRadioButton(campus.toString());
            rb.setForeground(R.Colors.HEADER_FOOTER_TEXT);
            rb.setBackground(R.Colors.HEADER_FOOTER_BG);
            rb.setSelected(campus.equals(myCurrentCampus));
            g.add(rb);
            p.add(rb);
            
            
            rb.addActionListener(ae -> {
                    myCurrentCampus = rb.getText();
                    
                    //remove the old panel and add the new one
                    remove(myItemsPanel);
                    myItemsPanel = makeItemsPanel(myCampusInventories.get(myCurrentCampus));
                    add(myItemsPanel, BorderLayout.CENTER);
                    
                    //clear previous data from the ShppingCart and
                    //update the total in the GUI
                    myItems.clear();
                    updateTotal();
                    
                    //redraw the UI with the new panel
                    pack();
                    revalidate();
                } 
            
            );
        } 

        
        
        
        return p;
    }

    //PROBLEM 1.D PA#3
    //MOVED CHECKBOX TO THIS METHOD TO JOIN WITH THE CAMPUS PANEL
    /**
     * Creates a panel to hold the CheckBox. 
     * 
     * @return The created panel
     */
    private JPanel makeCheckBoxPanel() {
        
        
        final JPanel p = new JPanel(new BorderLayout());
        p.add(makeCampusPanel(), BorderLayout.NORTH);
        
        //MOVED CHECKBOX TO BELOW THE CAMPUS PANEL
        final JCheckBox cb = new JCheckBox(R.Strings.BF_CHECKBOX_MEMBER);
        cb.setForeground(R.Colors.HEADER_FOOTER_TEXT);
        cb.setBackground(R.Colors.HEADER_FOOTER_BG);
        cb.addActionListener(theEvent -> {
            myItems.setMembership(cb.isSelected());
            updateTotal();
        });
        //CENTERED CHECKBOX ON SCREEN
        cb.setMargin(new Insets(0, 100, 0, 0));
        p.add(cb);
        
        return p;
    }

    /**
     * Creates a panel to hold the specified list of items.
     * 
     * @param theItems The items
     * @return The created panel
     */
    private JPanel makeItemsPanel(final List<Item> theItems) {
        final JPanel p = new JPanel(new GridLayout(theItems.size(),
                                                   R.Dimensions.BF_ITEMS_COLS));
        p.setBorder(BorderFactory.
                    createEmptyBorder(R.Dimensions.V_PADDING, R.Dimensions.H_PADDING,
                                      R.Dimensions.V_PADDING, R.Dimensions.H_PADDING));
        p.setBackground(R.Colors.CONTENT_BG);
        
        
        //SORTING THE ITEMS
        
        if(myCurrentCampus.equals("Bothell Bookstore"))
        {
            Collections.sort(theItems, new ItemComparator());
        }
        
        else
        {
            
            /*
             * object oriented
             * Collections.sort(theCampusInventories.get("Tacoma"), new ItemComparator());
             */
            //lambda expression
            Collections.sort(theItems, (Item theFirst, Item theSecond)
                             -> {
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
                             });
        }
        
        for (final Item item : theItems) {
            addItem(item, p);
        }
        
       
         
       
        
        
        return p;
    }
    //PA#3 1.E MOVED ORDER TOTAL TO THIS METHOD
    //JOINED CLEAR BUTTON AND TOTAL TEXT BOX
    /**
     * Creates and returns the clear and total panel.
     * 
     * @return the checkbox panel
     */
    private JPanel makeClearAndTotalPanel() {
        final JPanel p = new JPanel();
        p.setBackground(R.Colors.HEADER_FOOTER_BG);
        //MOVE TOTAL PANEL TO LEFT OF CLEAR
        final JPanel totalPanel = new JPanel();
        totalPanel.setBackground(R.Colors.HEADER_FOOTER_BG);
        final JLabel l = new JLabel(R.Strings.BF_LABEL_TOTAL);
        l.setForeground(R.Colors.HEADER_FOOTER_TEXT);
        totalPanel.add(l);
        totalPanel.add(myTotal);
        p.add(totalPanel, BorderLayout.CENTER);
        
        final JButton clearButton = new JButton(R.Strings.BF_BUTTON_CLEAR);
        clearButton.addActionListener(theEvent -> {
            myItems.clear();
            for (final JTextField field : myQuantities) {
                field.setText("");
            }
            updateTotal();
        });
        p.add(clearButton);
        
        // tweak the text field so that users can't edit it, and set
        // its color appropriately

        myTotal.setEditable(false);
        myTotal.setEnabled(false);
        myTotal.setDisabledTextColor(R.Colors.CONTENT_TEXT);

        // create the panel, and its label

        
        
        return p;
    }

    /**
     * Adds the specified product to the specified panel.
     * 
     * @param theItem The product to add.
     * @param thePanel The panel to add the product to.
     */
    private void addItem(final Item theItem, final JPanel thePanel) {
        final JPanel sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sub.setBackground(R.Colors.CONTENT_BG);
        final JTextField quantity = new JTextField(R.Dimensions.BF_TEXTFIELD_QUANITITY);
        myQuantities.add(quantity);
        quantity.setHorizontalAlignment(SwingConstants.CENTER);
        quantity.addActionListener(theEvent -> quantity.transferFocus());
        quantity.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent theEvent) {
                updateItem(theItem, quantity);
            }
        });
        sub.add(quantity);
        final JLabel l = new JLabel(theItem.toString());
        l.setForeground(R.Colors.HEADER_FOOTER_BG);
        sub.add(l);
        thePanel.add(sub);
    }

    /**
     * Updates the set of items by changing the quantity of the specified
     * product to the specified quantity.
     * 
     * @param theItem The product to update.
     * @param theQuantity The new quantity.
     */
    private void updateItem(final Item theItem, final JTextField theQuantity) {
        final String text = theQuantity.getText().trim();
        int number;
        try {
            number = Integer.parseInt(text);
            if (number < 0) {
                // disallow negative numbers
                throw new NumberFormatException();
            }
        } catch (final NumberFormatException e) {
            number = 0;
            theQuantity.setText("");
        }
        myItems.add(new ItemOrder(theItem, number));
        updateTotal();
    }

    /**
     * Updates the total displayed in the window.
     */
    private void updateTotal() {
        final double total = myItems.calculateTotal().doubleValue();
        myTotal.setText(NumberFormat.getCurrencyInstance().format(total));
    }
    

}

// end of class BookstoreFrame
