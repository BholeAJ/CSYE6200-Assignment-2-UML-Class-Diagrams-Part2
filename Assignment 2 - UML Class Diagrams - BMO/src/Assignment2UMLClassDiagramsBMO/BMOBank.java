/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

/**
 * ---------------- BANK, PROGRAM, REWARDS ----------------
 */
// line 52 "../../model.ump"
// line 165 "../../model.ump"
public class BMOBank
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BMOBank Associations
  private List<Account> accounts;
  private List<BMOClient> clients;
  private LoyaltyProgram program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BMOBank(LoyaltyProgram aProgram)
  {
    accounts = new ArrayList<Account>();
    clients = new ArrayList<BMOClient>();
    if (aProgram == null || aProgram.getBank() != null)
    {
      throw new RuntimeException("Unable to create BMOBank due to aProgram. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    program = aProgram;
  }

  public BMOBank()
  {
    accounts = new ArrayList<Account>();
    clients = new ArrayList<BMOClient>();
    program = new LoyaltyProgram(this);
  }

  //------------------------
  // INTERFACE
  //------------------------
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
  /* Code from template association_GetMany */
  public BMOClient getClient(int index)
  {
    BMOClient aClient = clients.get(index);
    return aClient;
  }

  public List<BMOClient> getClients()
  {
    List<BMOClient> newClients = Collections.unmodifiableList(clients);
    return newClients;
  }

  public int numberOfClients()
  {
    int number = clients.size();
    return number;
  }

  public boolean hasClients()
  {
    boolean has = clients.size() > 0;
    return has;
  }

  public int indexOfClient(BMOClient aClient)
  {
    int index = clients.indexOf(aClient);
    return index;
  }
  /* Code from template association_GetOne */
  public LoyaltyProgram getProgram()
  {
    return program;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAccounts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Account addAccount(String aAccountNumber, double aMonthlyFee, BMOClient... allOwners)
  {
    return new Account(aAccountNumber, aMonthlyFee, this, allOwners);
  }

  public boolean addAccount(Account aAccount)
  {
    boolean wasAdded = false;
    if (accounts.contains(aAccount)) { return false; }
    BMOBank existingBank = aAccount.getBank();
    boolean isNewBank = existingBank != null && !this.equals(existingBank);
    if (isNewBank)
    {
      aAccount.setBank(this);
    }
    else
    {
      accounts.add(aAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccount(Account aAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccount, as it must always have a bank
    if (!this.equals(aAccount.getBank()))
    {
      accounts.remove(aAccount);
      wasRemoved = true;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfClients()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public BMOClient addClient(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram)
  {
    return new BMOClient(aMemberId, aName, aPoints, aProgram, this);
  }

  public boolean addClient(BMOClient aClient)
  {
    boolean wasAdded = false;
    if (clients.contains(aClient)) { return false; }
    BMOBank existingBank = aClient.getBank();
    boolean isNewBank = existingBank != null && !this.equals(existingBank);
    if (isNewBank)
    {
      aClient.setBank(this);
    }
    else
    {
      clients.add(aClient);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeClient(BMOClient aClient)
  {
    boolean wasRemoved = false;
    //Unable to remove aClient, as it must always have a bank
    if (!this.equals(aClient.getBank()))
    {
      clients.remove(aClient);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addClientAt(BMOClient aClient, int index)
  {  
    boolean wasAdded = false;
    if(addClient(aClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClients()) { index = numberOfClients() - 1; }
      clients.remove(aClient);
      clients.add(index, aClient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveClientAt(BMOClient aClient, int index)
  {
    boolean wasAdded = false;
    if(clients.contains(aClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClients()) { index = numberOfClients() - 1; }
      clients.remove(aClient);
      clients.add(index, aClient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addClientAt(aClient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=accounts.size(); i > 0; i--)
    {
      Account aAccount = accounts.get(i - 1);
      aAccount.delete();
    }
    for(int i=clients.size(); i > 0; i--)
    {
      BMOClient aClient = clients.get(i - 1);
      aClient.delete();
    }
    LoyaltyProgram existingProgram = program;
    program = null;
    if (existingProgram != null)
    {
      existingProgram.delete();
    }
  }

  // line 53 "../../model.ump"
  public void listAccounts(){
    for (Account a : getAccounts()) { System.out.println("   " + a.getAccountNumber()); }
  }

  // line 54 "../../model.ump"
  public void listClients(){
    for (BMOClient c : getClients()) { System.out.println("   " + c.getName()); }
  }

}