/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 19 "../../model.ump"
// line 95 "../../model.ump"
public class SavingsAccount extends NicknamedAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SavingsAccount Attributes
  private double interestRate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SavingsAccount(String aAccountNumber, double aMonthlyFee, BMOBank aBank, String aNickname, double aInterestRate, BMOClient... allOwners)
  {
    super(aAccountNumber, aMonthlyFee, aBank, aNickname, allOwners);
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