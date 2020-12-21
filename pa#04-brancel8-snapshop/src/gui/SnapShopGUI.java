/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 3/8/2020
 * PA#4
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import filters.*;
import image.*;
import javax.swing.*;

/**
 * class to make snap shop GUI
 * @author Brandon Lu
 * @version 8 March 2020
 */
public class SnapShopGUI {
    /**
     * frame for GUI
     */
    JFrame myFrame;
    
    /**
     * north panel in border layout for GUI
     */
    JPanel myNorthPanel;
    /**
     * center panel in border layout for GUI
     */
    JPanel myCenterPanel;
    /**
     * south panel in border layout for GUI
     */
    JPanel mySouthPanel;
    
    /**
     * button for edge detect
     */
    JButton myEdgeDetect;
    /**
     * button for edge highlight
     */
    JButton myEdgeHighlight;
    /**
     * button for flip horizontal
     */
    JButton myFlipHorizontal;
    /**
     * button for flip vertical
     */
    JButton myFlipVertical;
    /**
     * button for grayscale
     */
    JButton myGrayscale;
    /**
     * button for sharpen
     */
    JButton mySharpen;
    /**
     * button for soften
     */
    JButton mySoften;
    /**
     * button for open
     */
    JButton myOpen;
    /**
     * button for save as
     */
    JButton mySaveAs;
    /**
     * button for close image
     */
    JButton myCloseImage;
    
    /**
     * filter for edge detect
     */
    Filter myEdgeDetectFilter;
    /**
     * filter for edge highlight
     */
    Filter myEdgeHighlightFilter;
    /**
     * filter for horizontal filter
     */
    Filter myFlipHorizontalFilter;
    /**
     * filter for vertical filter
     */
    Filter myFlipVerticalFilter;
    /**
     * filter for grayscale
     */
    Filter myGrayscaleFilter;
    /**
     * filter for sharpen
     */
    Filter mySharpenFilter;
    /**
     * filter for soften
     */
    Filter mySoftenFilter;
    
    /**
     * label to display image
     */
    JLabel myLabel;
    /**
     * image to display
     */
    PixelImage myImage;
    
    /**
     * file chooser for opening and saving
     */
    JFileChooser myFileChooser;
    
    /**
     * list of buttons to disable/enable
     */
    LinkedList<JButton> myToggleList;
    /**
     * list of filter buttons
     */
    LinkedList<JButton> myFilterButtonsList;
    /**
     * list of filters
     */
    LinkedList<Filter> myFilterList;
    
    /**
     * method to make/start the GUI
     * initializes all components and lists and frame
     */
    public void start() {
        makeFilterButtons();
        makeFilters();
        
        myFilterList = new LinkedList<Filter>();
        addToList(myFilterList, myEdgeDetectFilter, myEdgeHighlightFilter,
                  myFlipHorizontalFilter, myFlipVerticalFilter, myGrayscaleFilter,
                  mySharpenFilter, mySoftenFilter);
        
        myFilterButtonsList = new LinkedList<JButton>();
        addToList(myFilterButtonsList, myEdgeDetect, myEdgeHighlight, myFlipHorizontal,
                  myFlipVertical, myGrayscale, mySharpen, mySoften);
        //FOLLOWING REQUIREMENTS IMPLEMENTED IN MAKENORTHPANEL()
        //REQUIREMENT 4.1
        //REQUIREMENT 5
        makeNorthPanel();
        //FOLLOWING REQUIREMENTS IMPLEMENTED IN MAKENORTHPANEL()
        //REQUIREMENT 3.1
        //REQUIREMENT 3.2
        makeCenterPanel();
        //FOLLOWING REQUIREMENTS IMPLEMENTED IN MAKESOUTHPANEL()
        //REQUIREMENT 1.4
        //REQUIREMENT 2.1
        //REQUIREMENT 2.2
        //REQUIREMENT 2.3
        //REQUIREMENT 3.1
        //REQUIREMENT 3.2
        //REQUIREMENT 6.1
        //REQUIREMENT 7
        //REQUIREMENT 8
        makeSouthPanel();
        
        myToggleList = new LinkedList<JButton>();
        addToList(myToggleList, myEdgeDetect, myEdgeHighlight, myFlipHorizontal,
                  myFlipVertical, myGrayscale, mySharpen, mySoften, mySaveAs,
                  myCloseImage);
        //FOLLOWING REQUIREMENTS IMPLEMENTED HERE
        //REQUIREMENT 1.3
        toggleButtons(myToggleList);

        //FOLLOWING REQUIREMENTS IMPLEMENTED HERE
        //REQUIREMENT 1.1
        myFrame = new JFrame("TCSS 305 - Assignment 4 brancel8");
        //FOLLOWING REQUIREMENTS IMPLEMENTED HERE
        //REQUIREMENT 9
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myFrame.setSize(1000, 200);
        myFrame.setResizable(true);
        myFrame.setLayout(new BorderLayout());
        //FOLLOWING REQUIREMENTS IMPLEMENTED HERE/IN MAKENORTHPANEL()
        //REQUIREMENT 1.2
        myFrame.add(myNorthPanel, BorderLayout.NORTH);
        myFrame.add(myCenterPanel, BorderLayout.CENTER);
        myFrame.add(mySouthPanel, BorderLayout.SOUTH);
        
        myFrame.pack();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        myFrame.setLocation(
               dim.width / 2 - (int)(myFrame.getSize().width / 2),
               dim.height / 2 - myFrame.getSize().height / 2);
    }

    /**
     * makes the north panel with all the filter buttons
     * wires the filter buttons to events
     */
    public void makeNorthPanel()
    {
        myNorthPanel = 
              new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        myNorthPanel.add(myEdgeDetect);
        myNorthPanel.add(myEdgeHighlight);
        myNorthPanel.add(myFlipHorizontal);
        myNorthPanel.add(myFlipVertical);
        myNorthPanel.add(myGrayscale);
        myNorthPanel.add(mySharpen);
        myNorthPanel.add(mySoften);
        
        class FilterButtonListener implements ActionListener
        {
            private Filter myFilter;
            
            public FilterButtonListener(Filter theFilter)
            {
                myFilter = theFilter;
            }
            
            @Override
            public void actionPerformed(ActionEvent theArg) {
                    myFilter.filter(myImage);
                    myLabel.setIcon(new ImageIcon(myImage));
            }
            
        }
        
        Iterator<Filter> filterListIterator = myFilterList.iterator();
        for(JButton button : myFilterButtonsList)
        {
            button.addActionListener(
            new FilterButtonListener(filterListIterator.next()));
        }
             
    }
    
    /**
     * makes the center panel with the center label
     */
    public void makeCenterPanel()
    {
        myCenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        myLabel = new JLabel();
        
        myCenterPanel.add(myLabel);
    }
    
    /**
     * makes the south panel with the open, save, and close image
     * buttons
     * and wires events to the buttons
     */
    public void makeSouthPanel()
    {
        mySouthPanel = 
              new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        myOpen = new JButton("Open...");
        mySaveAs = new JButton("Save As...");
        myCloseImage = new JButton("Close Image");
        
        ImageIcon openIcon = new ImageIcon("icons/open.gif");
        ImageIcon saveIcon = new ImageIcon("icons/save.gif");
        ImageIcon closeIcon = new ImageIcon("icons/close.gif");
        
        myOpen.setIcon(openIcon);
        mySaveAs.setIcon(saveIcon);
        myCloseImage.setIcon(closeIcon);
        
        mySouthPanel.add(myOpen);
        mySouthPanel.add(mySaveAs);
        mySouthPanel.add(myCloseImage);
        
        myFileChooser = new JFileChooser(".");
        
        myOpen.addActionListener(theEvent ->
        {
            int choice = myFileChooser.showOpenDialog(null);
            File image = myFileChooser.getSelectedFile();
            
            if(choice == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                   myImage = PixelImage.load(image);
                   myLabel.setIcon(new ImageIcon(myImage));
                   toggleButtons(myToggleList);
                   Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                   myFrame.pack();
                   myFrame.setLocation(
                                       dim.width / 2 - (int)(myFrame.getSize().width / 2),
                                       dim.height / 2 - myFrame.getSize().height / 2);
                }
                
                catch(IOException e)
                {
                    JOptionPane.showMessageDialog(null,
                               "The selected file did not contain an image!\n\n"
                                + myFileChooser.getSelectedFile().getName()
                                + "\n\n",
                               "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
        );
        
        mySaveAs.addActionListener(theEvent ->
        {
            int choice = myFileChooser.showSaveDialog(null);
            
            if(choice == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    myImage.save(myFileChooser.getSelectedFile());
                    toggleButtons(myToggleList);
                    myLabel.setIcon(null);
                    myFrame.pack();
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    myFrame.setLocation(
                                        dim.width / 2 - (int)(myFrame.getSize().width / 2),
                                        dim.height / 2 - myFrame.getSize().height / 2);
                }
                
                catch(IOException e)
                {
                    JOptionPane.showMessageDialog(null, 
                                                  "File can't be saved"
                                                  + "\n\n"
                                                  + myFileChooser.getSelectedFile()
                                                  + "\n\n",
                                                  "Error!",
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        myCloseImage.addActionListener(theEvent ->
        {
            myLabel.setIcon(null);
            toggleButtons(myToggleList);
            myFrame.pack();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            myFrame.setLocation(
                                dim.width / 2 - (int)(myFrame.getSize().width / 2),
                                dim.height / 2 - myFrame.getSize().height / 2);
        });
        
    }
    
    /**
     * initializes filter buttons
     */
    public void makeFilterButtons()
    {
        myEdgeDetect = new JButton("Edge Detect");
        myEdgeHighlight = new JButton("Edge Highlight");
        myFlipHorizontal = new JButton("Flip Horizontal");
        myFlipVertical = new JButton("Flip Vertical");
        myGrayscale = new JButton("Grayscale");
        mySharpen = new JButton("Sharpen");
        mySoften = new JButton("Soften");
    }
    
    /**
     * initializes filters
     */
    public void makeFilters()
    {
        myEdgeDetectFilter = new EdgeDetectFilter();
        myEdgeHighlightFilter  = new EdgeHighlightFilter();
        myFlipHorizontalFilter = new FlipHorizontalFilter();
        myFlipVerticalFilter = new FlipVerticalFilter();
        myGrayscaleFilter = new GrayscaleFilter();
        mySharpenFilter = new SharpenFilter();
        mySoftenFilter = new SoftenFilter();
    }
    
    /**
     * toggles the enabled state of all buttons in list provided
     * @param theList list of buttons to toggle
     */
    public static void toggleButtons(LinkedList<JButton> theList)
    {
        for(JButton button : theList)
        {
            button.setEnabled(!button.isEnabled());
        }
    }
    
    /**
     * adds jbuttons to a list
     * @param theList list to add to
     * @param theButtons jbuttons to add
     */
    public static void addToList(LinkedList<JButton> theList, JButton... theButtons)
    {
        for(JButton button : theButtons)
        {
            theList.add(button);
        }
    }
    
    /**
     * adds filters to a list
     * @param theList list to add to
     * @param theFilters filters to add
     */
    public static void addToList(LinkedList<Filter> theList, Filter... theFilters)
    {
        for(Filter filter : theFilters)
        {
            theList.add(filter);
        }
    }
}