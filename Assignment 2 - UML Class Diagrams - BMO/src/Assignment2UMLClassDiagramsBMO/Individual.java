/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 47 "../../model.ump"
// line 150 "../../model.ump"
public class Individual extends Adult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Individual Attributes
  private double annualIncome;
  private String employmentStatus;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Individual(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram, BMOBank aBank, String aSin, String aOccupation, double aAnnualIncome, String aEmploymentStatus)
  {
    super(aMemberId, aName, aPoints, aProgram, aBank, aSin, aOccupation);
    annualIncome = aAnnualIncome;
    employmentStatus = aEmploymentStatus;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAnnualIncome(double aAnnualIncome)
  {
    boolean wasSet = false;
    annualIncome = aAnnualIncome;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmploymentStatus(String aEmploymentStatus)
  {
    boolean wasSet = false;
    employmentStatus = aEmploymentStatus;
    wasSet = true;
    return wasSet;
  }

  public double getAnnualIncome()
  {
    return annualIncome;
  }

  public String getEmploymentStatus()
  {
    return employmentStatus;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "annualIncome" + ":" + getAnnualIncome()+ "," +
            "employmentStatus" + ":" + getEmploymentStatus()+ "]";
  }
}