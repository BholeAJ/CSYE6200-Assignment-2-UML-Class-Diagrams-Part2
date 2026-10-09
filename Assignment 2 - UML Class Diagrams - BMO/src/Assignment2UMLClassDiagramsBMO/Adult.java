/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 45 "../../model.ump"
// line 140 "../../model.ump"
public class Adult extends BMOClient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Adult Attributes
  private String sin;
  private String occupation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Adult(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram, BMOBank aBank, String aSin, String aOccupation)
  {
    super(aMemberId, aName, aPoints, aProgram, aBank);
    sin = aSin;
    occupation = aOccupation;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSin(String aSin)
  {
    boolean wasSet = false;
    sin = aSin;
    wasSet = true;
    return wasSet;
  }

  public boolean setOccupation(String aOccupation)
  {
    boolean wasSet = false;
    occupation = aOccupation;
    wasSet = true;
    return wasSet;
  }

  public String getSin()
  {
    return sin;
  }

  public String getOccupation()
  {
    return occupation;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "sin" + ":" + getSin()+ "," +
            "occupation" + ":" + getOccupation()+ "]";
  }
}