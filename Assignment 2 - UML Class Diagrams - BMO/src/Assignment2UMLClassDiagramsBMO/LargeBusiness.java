/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 49 "../../model.ump"
// line 160 "../../model.ump"
public class LargeBusiness extends Adult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LargeBusiness Attributes
  private String companyName;
  private double annualRevenue;
  private String industry;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LargeBusiness(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram, BMOBank aBank, String aSin, String aOccupation, String aCompanyName, double aAnnualRevenue, String aIndustry)
  {
    super(aMemberId, aName, aPoints, aProgram, aBank, aSin, aOccupation);
    companyName = aCompanyName;
    annualRevenue = aAnnualRevenue;
    industry = aIndustry;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCompanyName(String aCompanyName)
  {
    boolean wasSet = false;
    companyName = aCompanyName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAnnualRevenue(double aAnnualRevenue)
  {
    boolean wasSet = false;
    annualRevenue = aAnnualRevenue;
    wasSet = true;
    return wasSet;
  }

  public boolean setIndustry(String aIndustry)
  {
    boolean wasSet = false;
    industry = aIndustry;
    wasSet = true;
    return wasSet;
  }

  public String getCompanyName()
  {
    return companyName;
  }

  public double getAnnualRevenue()
  {
    return annualRevenue;
  }

  public String getIndustry()
  {
    return industry;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "companyName" + ":" + getCompanyName()+ "," +
            "annualRevenue" + ":" + getAnnualRevenue()+ "," +
            "industry" + ":" + getIndustry()+ "]";
  }
}