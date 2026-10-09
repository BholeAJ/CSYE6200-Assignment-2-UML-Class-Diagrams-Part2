/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 35 "../../model.ump"
// line 120 "../../model.ump"
public class OtherBankClient extends Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OtherBankClient Attributes
  private String bankName;
  private String externalClientId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OtherBankClient(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram, String aBankName, String aExternalClientId)
  {
    super(aMemberId, aName, aPoints, aProgram);
    bankName = aBankName;
    externalClientId = aExternalClientId;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBankName(String aBankName)
  {
    boolean wasSet = false;
    bankName = aBankName;
    wasSet = true;
    return wasSet;
  }

  public boolean setExternalClientId(String aExternalClientId)
  {
    boolean wasSet = false;
    externalClientId = aExternalClientId;
    wasSet = true;
    return wasSet;
  }

  public String getBankName()
  {
    return bankName;
  }

  public String getExternalClientId()
  {
    return externalClientId;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "bankName" + ":" + getBankName()+ "," +
            "externalClientId" + ":" + getExternalClientId()+ "]";
  }
}