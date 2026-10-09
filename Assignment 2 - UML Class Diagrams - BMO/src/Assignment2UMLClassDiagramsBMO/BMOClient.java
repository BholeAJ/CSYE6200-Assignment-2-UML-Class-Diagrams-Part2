/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 36 "../../model.ump"
// line 125 "../../model.ump"
public class BMOClient extends Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BMOClient Associations
  private BMOBank bank;
  private List<Account> accounts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BMOClient(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram, BMOBank aBank)
  {
    super(aMemberId, aName, aPoints, aProgram);
    boolean didAddBank = setBank(aBank);
    if (!didAddBank)
    {
      throw new RuntimeException("Unable to create client due to bank. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    accounts = new ArrayList<Account>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public BMOBank getBank()
  {
    return bank;
  }
  /* Code from template association_GetMany */
  public Account getAccount(int index)
  {
    Account aAccount = accounts.get(index);
    return aAccount;
  }

  public List<Account> getAccounts()
  {
    List<Account> newAccounts = Collections.unmodifiableList(accounts);
    return newAccounts;
  }

  public int numberOfAccounts()
  {
    int number = accounts.size();
    return number;
  }

  public boolean hasAccounts()
  {
    boolean has = accounts.size() > 0;
    return has;
  }

  public int indexOfAccount(Account aAccount)
  {
    int index = accounts.indexOf(aAccount);
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
      existingBank.removeClient(this);
    }
    bank.addClient(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAccounts()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addAccount(Account aAccount)
  {
    boolean wasAdded = false;
    if (accounts.contains(aAccount)) { return false; }
    accounts.add(aAccount);
    if (aAccount.indexOfOwner(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAccount.addOwner(this);
      if (!wasAdded)
      {
        accounts.remove(aAccount);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeAccount(Account aAccount)
  {
    boolean wasRemoved = false;
    if (!accounts.contains(aAccount))
    {
      return wasRemoved;
    }

    int oldIndex = accounts.indexOf(aAccount);
    accounts.remove(oldIndex);
    if (aAccount.indexOfOwner(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAccount.removeOwner(this);
      if (!wasRemoved)
      {
        accounts.add(oldIndex,aAccount);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAccountAt(Account aAccount, int index)
  {  
    boolean wasAdded = false;
    if(addAccount(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccountAt(Account aAccount, int index)
  {
    boolean wasAdded = false;
    if(accounts.contains(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccountAt(aAccount, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    BMOBank placeholderBank = bank;
    this.bank = null;
    if(placeholderBank != null)
    {
      placeholderBank.removeClient(this);
    }
    ArrayList<Account> copyOfAccounts = new ArrayList<Account>(accounts);
    accounts.clear();
    for(Account aAccount : copyOfAccounts)
    {
      if (aAccount.numberOfOwners() <= Account.minimumNumberOfOwners())
      {
        aAccount.delete();
      }
      else
      {
        aAccount.removeOwner(this);
      }
    }
    super.delete();
  }

  // line 39 "../../model.ump"
  public void listAccounts(){
    System.out.println("Accounts of " + getName() + ":");
    for (Account a : getAccounts()) { System.out.println("   " + a.getAccountNumber()); }
  }

}