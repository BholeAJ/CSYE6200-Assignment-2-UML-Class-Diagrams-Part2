/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 48 "../../model.ump"
// line 155 "../../model.ump"
public class SmallBusiness extends Adult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SmallBusiness Attributes
  private String businessName;
  private int numberOfEmployees;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SmallBusiness(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram, BMOBank aBank, String aSin, String aOccupation, String aBusinessName, int aNumberOfEmployees)
  {
    super(aMemberId, aName, aPoints, aProgram, aBank, aSin, aOccupation);
    businessName = aBusinessName;
    numberOfEmployees = aNumberOfEmployees;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBusinessName(String aBusinessName)
  {
    boolean wasSet = false;
    businessName = aBusinessName;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumberOfEmployees(int aNumberOfEmployees)
  {
    boolean wasSet = false;
    numberOfEmployees = aNumberOfEmployees;
    wasSet = true;
    return wasSet;
  }

  public String getBusinessName()
  {
    return businessName;
  }

  public int getNumberOfEmployees()
  {
    return numberOfEmployees;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "businessName" + ":" + getBusinessName()+ "," +
            "numberOfEmployees" + ":" + getNumberOfEmployees()+ "]";
  }
}