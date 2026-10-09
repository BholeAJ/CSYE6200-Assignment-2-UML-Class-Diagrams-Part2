/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 46 "../../model.ump"
// line 145 "../../model.ump"
public class Investor extends Adult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Investor Attributes
  private String riskProfile;
  private double portfolioValue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Investor(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram, BMOBank aBank, String aSin, String aOccupation, String aRiskProfile, double aPortfolioValue)
  {
    super(aMemberId, aName, aPoints, aProgram, aBank, aSin, aOccupation);
    riskProfile = aRiskProfile;
    portfolioValue = aPortfolioValue;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRiskProfile(String aRiskProfile)
  {
    boolean wasSet = false;
    riskProfile = aRiskProfile;
    wasSet = true;
    return wasSet;
  }

  public boolean setPortfolioValue(double aPortfolioValue)
  {
    boolean wasSet = false;
    portfolioValue = aPortfolioValue;
    wasSet = true;
    return wasSet;
  }

  public String getRiskProfile()
  {
    return riskProfile;
  }

  public double getPortfolioValue()
  {
    return portfolioValue;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "riskProfile" + ":" + getRiskProfile()+ "," +
            "portfolioValue" + ":" + getPortfolioValue()+ "]";
  }
}