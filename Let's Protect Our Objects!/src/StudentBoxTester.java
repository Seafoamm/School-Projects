/*
 * TCSS 143
 * StudentBoxTester.java
 *
 * Demonstrates encapsulation violations that occur when we do not practice
 * proper defensive copying of objects within a class!
 *
 * The issues that need correcting in this example occur ONLY in 
 * StudentABoxClubMember.  That said, do not change any code in the
 * other 2 class.
 *
 * Make sure you properly protect the integrity of the Box object from the
 * aspect of the client by getting user input choices 1, 2, & 3 to work
 * properly before you concern yourself on input 4.  Get 4 corrected before
 * correcting 5.
 */
import java.io.*;
import java.util.*;
public class StudentBoxTester { // throws FileNotFoundException is used here
                                // for demonstration purposes only. Do not do this!
  public static void main(String[] theArgs) throws FileNotFoundException {
    Scanner console = new Scanner(System.in);
    Scanner s = new Scanner(new File("BoxInput.txt"));
    ArrayList<Box> boxes = new ArrayList<Box>();
    StudentABoxClubMember aBC = null;
    Box aBox = null;
    Box b2 = null;
    int id;
    double l, h, d;
    String name = "";
    // Input format (2 lines for each box owner):
    // Box owner name (last, first)
    // owner ID followed by groups of 3 doubles:  XX   XX.X XX.X XX.X  
    // The above owner has just 1 box.
    while (s.hasNext()) {
      name = s.nextLine();
      id = s.nextInt();
      if (s.hasNext()) {  // It should have but, just in case.
        String boxLine = s.nextLine();
        Scanner line = new Scanner(boxLine);
        while (line.hasNext()) {  // Assume input is correct format
          l = line.nextDouble();
          h = line.nextDouble();
          d = line.nextDouble();
          aBox = new Box(l, h, d);
          boxes.add(aBox);
        }
      }
      aBC = new StudentABoxClubMember(id, name, boxes);
    }
    System.out.println("Enter 1, 2, or 3 for the 3 constructor errors.\n" +
                       "4 for an encapsulation violation on a List field.\n" +
                       "5 for an encapsulation violation on a List field's" +
                       "\nBox element( > 5 tests Box equals & compareTo):");
    int errorCheck = console.nextInt();
    if (errorCheck > 0 && errorCheck < 6) {
      System.out.println("This is the Correct Output:\n" + aBC);
    }

    if (errorCheck == 1) {    
      System.out.println("Encapsulation Violations: Shallow copy in" +
                         " the Constructor - Error 1:");
      System.out.println("ArrayList from Driver passed to constructor\n" +
                         "still references a Box Member's Boxes" +
                         "(Note the 2nd box):");   
      boxes.add(1, new Box(1, 1, 1));  // First error in constructor
      System.out.println(aBC);
    } else if (errorCheck == 2) { 
      System.out.println("Encapsulation Violations: Shallow copy in" +
                         " the Constructor - Error 2:");
      System.out.println("Instance of a Box object from Driver still\n" +
                         "references a Box Member's Box(Note the last box):");   
      aBox.setDimensions(1, 1, 1);    // Second error in constructor
      System.out.println(aBC);
    } else if (errorCheck == 3) { 
      System.out.println("Encapsulation Violations: Shallow copy in" +
                         " the Constructor - Error 3:");
      System.out.println("ArrayList from Driver passed to constructor\n" +
                         "still references a Box Member's Boxes" +
                         "(Note the 2nd box):");   
      boxes.get(1).setDimensions(2, 2, 2); // Third error in constructor
      System.out.println(aBC);
    } else if (errorCheck == 4) {
      // Do this after you completely fixed the StudentABoxClubMember
      // constructor.
      System.out.println("Incorrectly return a Member's List.  Client\n" +
                         "now has access to the Box Member's Boxes" +
                         "(Note the 3rd box):");   
      List<Box> l2 = aBC.getBoxList();// get a list of Boxes owned by a member
      b2 = l2.get(2);             // get a box from the list(index 2 is ok)
      b2.setDimensions(3, 3, 3);      // set this local Box (b2) dimensions
      System.out.println(aBC);        // Display the member's boxes... Ooops!
    } else if (errorCheck == 5) {
      // Do the following after you fixed the previous issue.
      System.out.println("Incorrectly return a Member's Box from their " +
                         "list.  Client\n now has access to the Box " +
                         "Member's Boxes(Note the 4th box):");   
      b2 = aBC.getBoxAtIndex(3);
      b2.setDimensions(10, 10, 10);
      System.out.println(aBC);          // Display the member's boxes...  Ooops!
    }
if (errorCheck > 5 || errorCheck < 1) {
// Just a check for the equals & compareTo methods-change accuracy
// These should all be ok so do not spend time on equals or compareTo.
System.out.println((new Box(3.0, 3.0, 1.00002)).equals(new Box(3.0, 3.0, 1.00003)));
System.out.println((new Box(1.0, 3.0, 3.0)).compareTo(new Box(1.0, 3.0, 3.0)));
}
  }
}
    