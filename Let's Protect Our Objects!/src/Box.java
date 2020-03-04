// No need for imports as everything is in the default "java" folder
public class Box implements Comparable<Box>{
  private final double TOLERANCE = 0.00005;
  private double myLength;
  private double myHeight;
  private double myDepth;
  private double myArea;
  private double myVolume;
  
  public Box(final double theLength, final double theHeight, 
             final double theDepth) {
    if (theLength <= 0.0 || theHeight <= 0.0 || theDepth <= 0.0)
      throw new IllegalArgumentException();
    myLength = theLength;
    myHeight = theHeight;
    myDepth = theDepth;
    myArea = 2 * (myLength * myHeight + myHeight * myDepth + myLength * myDepth);
    myVolume = theLength * theHeight * theDepth;
  }
  public Box(Box theBox) {
    this(theBox.getLength(), theBox.getHeight(), theBox.getDepth());
  }
  public Box() {
    this(1.0, 1.0, 1.0);
  }
  public double getLength() {
    return myLength;
  }
  public double getHeight() {
    return myHeight;
  }
  public double getDepth() {
    return myDepth;
  }
  public double getArea() {
    return myArea;
  }
  public double getVolume() {
    return myVolume;
  }
  public void setDimensions(final double theLength, final double theHeight, 
                            final double theDepth) {
    if (theLength <= 0.0 || theHeight <= 0.0 || theDepth <= 0.0)
      throw new IllegalArgumentException();
    myLength = theLength;
    myHeight = theHeight;
    myDepth = theDepth;
    myArea = 2 * (myLength * myHeight + myHeight * myDepth + myLength * myDepth);
    myVolume = theLength * theHeight * theDepth;
  }
  public int compareTo(Box theBox) {
    double temp = myArea - theBox.myArea;
    int result = Math.abs(temp) < TOLERANCE ? 0 : temp < 0.0 ? -1 : 1;
    if (result == 0) {
      if (Math.abs(temp = myLength - theBox.myLength) > TOLERANCE) {
        result = temp < 0.0 ? -1 : 1;
      } else if (Math.abs(temp = myHeight - theBox.myHeight) > TOLERANCE) {
        result = temp < 0.0 ? -1 : 1;
      } else if (Math.abs(temp = myDepth - theBox.myDepth) > TOLERANCE) {
        result = temp < 0.0 ? -1 : 1;
      }
    }
    return result;
  }  

  // overridden methods from class Object
 
  /** {@inheritDoc}  */
    @Override
   public int hashCode() {
    return super.hashCode();
   } 
 
  /** {@inheritDoc}  */
    @Override
  public boolean equals(final Object theOther) {
    if (this == theOther) { 
      return true;        // return true if theOther and this are the same object
    }       
    if (theOther == null) { 
      return false;       // return false if theOther is null
    } 
    if (getClass() != theOther.getClass()) {
            return false; // return false if the parameter is not a Point
    }
    // now we know theOther is a Box, so cast it
    final Box otherBox = (Box) theOther;
  
    // now compare fields for equality.
    // This Box class example uses double values. Remember
    // to compare double values within a small tolerance
    return Math.abs(myLength - otherBox.myLength) < TOLERANCE && 
           Math.abs(myDepth - otherBox.myDepth) < TOLERANCE &&
           Math.abs(myHeight - otherBox.myHeight) < TOLERANCE;
    }

  /**
   * {@inheritDoc}
   */
  @Override
     
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append("{Length = ");
    sb.append(myLength);
    sb.append(", Height = ");
    sb.append(myHeight);
    sb.append(", Depth = ");
    sb.append(myDepth);
    sb.append(", Area = ");
    sb.append(myArea + "}");
    return sb.toString();
  }
} 