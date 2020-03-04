// To make scrolling up and down and correcting encapsulation violations
// easier, very little documentation has been included.
// There are 3 major encapsulation violations in this code, find and fix them!
import java.util.*;
public class StudentABoxClubMember implements Comparable<StudentABoxClubMember> {
  private int myID;
  private String myName;
  private List<Box> myBoxes;  // can be a member with no Boxes
  
  public StudentABoxClubMember(final int theID, final String theName,
                        final List<Box> theBoxes) {
    if (theID < 0 || theName.length() == 0) {
      throw new IllegalArgumentException();
    }
    if (theName == null || theBoxes == null) {
      throw new NullPointerException();
    }
    myID = theID;
    myName = theName;

    myBoxes = new LinkedList<Box>();
    for(Box box : theBoxes)
    {
    	Box copyBox = new Box(box);
    	myBoxes.add(copyBox);
    }
  }
  public List<Box> getBoxList() {
  	List<Box> copyList = new LinkedList<Box>();
    for(Box box : myBoxes)
    {
    	Box copyBox = new Box(box);
    	copyList.add(copyBox);
    }
    return copyList;
  }
  public Box getBoxAtIndex(final int theIndex) {
    if (theIndex >= myBoxes.size() || theIndex < 0) {
      throw new IllegalArgumentException();
    }
    Box copyBox = new Box(myBoxes.get(theIndex));
    return copyBox;
  } 
  public int getID() {
    return myID;
  }
  public String getName() {
    return myName;
  }
  public int compareTo(StudentABoxClubMember theOther) {
    int result = myBoxes.size() - theOther.myBoxes.size();
    if (result == 0) {
      result = myName.compareToIgnoreCase(theOther.getName());
    }
    return result;
  }
  public String toString() {
    String s = "ID: " + myID + ", " + myName + " has " + myBoxes.size() +
               " boxes:\n\t{" + myBoxes.get(0).toString();
    for (int i = 1; i < myBoxes.size(); i++) {
      s += "\n\t " + myBoxes.get(i).toString();
    }
    s += "}\n";
    return s;
  }
}
     