/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 18 "../../model.ump"
// line 90 "../../model.ump"
public class NicknamedAccount extends Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //NicknamedAccount Attributes
  private String nickname;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NicknamedAccount(String aAccountNumber, double aMonthlyFee, BMOBank aBank, String aNickname, BMOClient... allOwners)
  {
    super(aAccountNumber, aMonthlyFee, aBank, allOwners);
    nickname = aNickname;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNickname(String aNickname)
  {
    boolean wasSet = false;
    nickname = aNickname;
    wasSet = true;
    return wasSet;
  }

  public String getNickname()
  {
    return nickname;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "nickname" + ":" + getNickname()+ "]";
  }
}