/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 20 "../../model.ump"
// line 100 "../../model.ump"
public class CheqingAccount extends NicknamedAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CheqingAccount Attributes
  private double overdraftLimit;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CheqingAccount(String aAccountNumber, double aMonthlyFee, BMOBank aBank, String aNickname, double aOverdraftLimit, BMOClient... allOwners)
  {
    super(aAccountNumber, aMonthlyFee, aBank, aNickname, allOwners);
    overdraftLimit = aOverdraftLimit;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOverdraftLimit(double aOverdraftLimit)
  {
    boolean wasSet = false;
    overdraftLimit = aOverdraftLimit;
    wasSet = true;
    return wasSet;
  }

  public double getOverdraftLimit()
  {
    return overdraftLimit;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "overdraftLimit" + ":" + getOverdraftLimit()+ "]";
  }
}