/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 43 "../../model.ump"
// line 130 "../../model.ump"
public class Minor extends BMOClient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Minor Attributes
  private String guardianName;
  private double spendingLimit;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Minor(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram, BMOBank aBank, String aGuardianName, double aSpendingLimit)
  {
    super(aMemberId, aName, aPoints, aProgram, aBank);
    guardianName = aGuardianName;
    spendingLimit = aSpendingLimit;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setGuardianName(String aGuardianName)
  {
    boolean wasSet = false;
    guardianName = aGuardianName;
    wasSet = true;
    return wasSet;
  }

  public boolean setSpendingLimit(double aSpendingLimit)
  {
    boolean wasSet = false;
    spendingLimit = aSpendingLimit;
    wasSet = true;
    return wasSet;
  }

  public String getGuardianName()
  {
    return guardianName;
  }

  public double getSpendingLimit()
  {
    return spendingLimit;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "guardianName" + ":" + getGuardianName()+ "," +
            "spendingLimit" + ":" + getSpendingLimit()+ "]";
  }
}