/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

/**
 * ---------------- ACCOUNTS ----------------
 */

public class Account
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Account> accountsByAccountNumber = new HashMap<String, Account>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private String accountNumber;
  private double monthlyFee;

  //Account Associations
  private BMOBank bank;
  private List<BMOClient> owners;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aAccountNumber, double aMonthlyFee, BMOBank aBank, BMOClient... allOwners)
  {
    monthlyFee = aMonthlyFee;
    if (!setAccountNumber(aAccountNumber))
    {
      throw new RuntimeException("Cannot create due to duplicate accountNumber.");
    }
    boolean didAddBank = setBank(aBank);
    if (!didAddBank)
    {
      throw new RuntimeException("Unable to create account due to bank.");
    }
    owners = new ArrayList<BMOClient>();
    boolean didAddOwners = setOwners(allOwners);
    if (!didAddOwners)
    {
      throw new RuntimeException("Unable to create Account, must have 1 to 4 owners.");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountNumber(String aAccountNumber)
  {
    boolean wasSet = false;
    String anOldAccountNumber = getAccountNumber();
    if (anOldAccountNumber != null && anOldAccountNumber.equals(aAccountNumber)) {
      return true;
    }
    if (hasWithAccountNumber(aAccountNumber)) {
      return wasSet;
    }
    accountNumber = aAccountNumber;
    wasSet = true;
    if (anOldAccountNumber != null) {
      accountsByAccountNumber.remove(anOldAccountNumber);
    }
    accountsByAccountNumber.put(aAccountNumber, this);
    return wasSet;
  }

  public boolean setMonthlyFee(double aMonthlyFee)
  {
    boolean wasSet = false;
    monthlyFee = aMonthlyFee;
    wasSet = true;
    return wasSet;
  }

  /**
   * if Umple complains, delete the word "unique"
   */
  public String getAccountNumber()
  {
    return accountNumber;
  }
  /* Code from template attribute_GetUnique */
  public static Account getWithAccountNumber(String aAccountNumber)
  {
    return accountsByAccountNumber.get(aAccountNumber);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithAccountNumber(String aAccountNumber)
  {
    return getWithAccountNumber(aAccountNumber) != null;
  }

  public double getMonthlyFee()
  {
    return monthlyFee;
  }
  /* Code from template association_GetOne */
  public BMOBank getBank()
  {
    return bank;
  }
  /* Code from template association_GetMany */
  public BMOClient getOwner(int index)
  {
    BMOClient aOwner = owners.get(index);
    return aOwner;
  }

  public List<BMOClient> getOwners()
  {
    List<BMOClient> newOwners = Collections.unmodifiableList(owners);
    return newOwners;
  }

  public int numberOfOwners()
  {
    int number = owners.size();
    return number;
  }

  public boolean hasOwners()
  {
    boolean has = owners.size() > 0;
    return has;
  }

  public int indexOfOwner(BMOClient aOwner)
  {
    int index = owners.indexOf(aOwner);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBank(BMOBank aBank)
  {
    boolean wasSet = false;
    if (aBank == null)
    {
      return wasSet;
    }

    BMOBank existingBank = bank;
    bank = aBank;
    if (existingBank != null && !existingBank.equals(aBank))
    {
      existingBank.removeAccount(this);
    }
    bank.addAccount(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfOwnersValid()
  {
    boolean isValid = numberOfOwners() >= minimumNumberOfOwners() && numberOfOwners() <= maximumNumberOfOwners();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOwners()
  {
    return 1;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfOwners()
  {
    return 4;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addOwner(BMOClient aOwner)
  {
    boolean wasAdded = false;
    if (owners.contains(aOwner)) { return false; }
    if (numberOfOwners() >= maximumNumberOfOwners())
    {
      return wasAdded;
    }

    owners.add(aOwner);
    if (aOwner.indexOfAccount(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOwner.addAccount(this);
      if (!wasAdded)
      {
        owners.remove(aOwner);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMNToMany */
  public boolean removeOwner(BMOClient aOwner)
  {
    boolean wasRemoved = false;
    if (!owners.contains(aOwner))
    {
      return wasRemoved;
    }

    if (numberOfOwners() <= minimumNumberOfOwners())
    {
      return wasRemoved;
    }

    int oldIndex = owners.indexOf(aOwner);
    owners.remove(oldIndex);
    if (aOwner.indexOfAccount(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOwner.removeAccount(this);
      if (!wasRemoved)
      {
        owners.add(oldIndex,aOwner);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMNToMany */
  public boolean setOwners(BMOClient... newOwners)
  {
    boolean wasSet = false;
    ArrayList<BMOClient> verifiedOwners = new ArrayList<BMOClient>();
    for (BMOClient aOwner : newOwners)
    {
      if (verifiedOwners.contains(aOwner))
      {
        continue;
      }
      verifiedOwners.add(aOwner);
    }

    if (verifiedOwners.size() != newOwners.length || verifiedOwners.size() < minimumNumberOfOwners() || verifiedOwners.size() > maximumNumberOfOwners())
    {
      return wasSet;
    }

    ArrayList<BMOClient> oldOwners = new ArrayList<BMOClient>(owners);
    owners.clear();
    for (BMOClient aNewOwner : verifiedOwners)
    {
      owners.add(aNewOwner);
      if (oldOwners.contains(aNewOwner))
      {
        oldOwners.remove(aNewOwner);
      }
      else
      {
        aNewOwner.addAccount(this);
      }
    }

    for (BMOClient anOldOwner : oldOwners)
    {
      anOldOwner.removeAccount(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOwnerAt(BMOClient aOwner, int index)
  {  
    boolean wasAdded = false;
    if(addOwner(aOwner))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOwners()) { index = numberOfOwners() - 1; }
      owners.remove(aOwner);
      owners.add(index, aOwner);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOwnerAt(BMOClient aOwner, int index)
  {
    boolean wasAdded = false;
    if(owners.contains(aOwner))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOwners()) { index = numberOfOwners() - 1; }
      owners.remove(aOwner);
      owners.add(index, aOwner);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOwnerAt(aOwner, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    accountsByAccountNumber.remove(getAccountNumber());
    BMOBank placeholderBank = bank;
    this.bank = null;
    if(placeholderBank != null)
    {
      placeholderBank.removeAccount(this);
    }
    ArrayList<BMOClient> copyOfOwners = new ArrayList<BMOClient>(owners);
    owners.clear();
    for(BMOClient aOwner : copyOfOwners)
    {
      aOwner.removeAccount(this);
    }
  }

  // line 14 "../../model.ump"
  public void listOwners(){
    System.out.println("Owners of " + getAccountNumber() + ":");
    for (BMOClient c : getOwners()) { System.out.println("   " + c.getName()); }
  }


  public String toString()
  {
    return super.toString() + "["+
            "accountNumber" + ":" + getAccountNumber()+ "," +
            "monthlyFee" + ":" + getMonthlyFee()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bank = "+(getBank()!=null?Integer.toHexString(System.identityHashCode(getBank())):"null");
  }
}