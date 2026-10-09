/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 21 "../../model.ump"
// line 105 "../../model.ump"
public class InvestmentAccount extends NicknamedAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InvestmentAccount Attributes
  private String investmentType;
  private double marketValue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InvestmentAccount(String aAccountNumber, double aMonthlyFee, BMOBank aBank, String aNickname, String aInvestmentType, double aMarketValue, BMOClient... allOwners)
  {
    super(aAccountNumber, aMonthlyFee, aBank, aNickname, allOwners);
    investmentType = aInvestmentType;
    marketValue = aMarketValue;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setInvestmentType(String aInvestmentType)
  {
    boolean wasSet = false;
    investmentType = aInvestmentType;
    wasSet = true;
    return wasSet;
  }

  public boolean setMarketValue(double aMarketValue)
  {
    boolean wasSet = false;
    marketValue = aMarketValue;
    wasSet = true;
    return wasSet;
  }

  public String getInvestmentType()
  {
    return investmentType;
  }

  public double getMarketValue()
  {
    return marketValue;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "investmentType" + ":" + getInvestmentType()+ "," +
            "marketValue" + ":" + getMarketValue()+ "]";
  }
}