/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 22 "../../model.ump"
// line 110 "../../model.ump"
public class LoanAccount extends Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LoanAccount Attributes
  private double interestRate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LoanAccount(String aAccountNumber, double aMonthlyFee, BMOBank aBank, double aInterestRate, BMOClient... allOwners)
  {
    super(aAccountNumber, aMonthlyFee, aBank, allOwners);
    interestRate = aInterestRate;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setInterestRate(double aInterestRate)
  {
    boolean wasSet = false;
    interestRate = aInterestRate;
    wasSet = true;
    return wasSet;
  }

  public double getInterestRate()
  {
    return interestRate;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "interestRate" + ":" + getInterestRate()+ "]";
  }
}