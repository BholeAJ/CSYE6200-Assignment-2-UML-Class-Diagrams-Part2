/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;

// line 56 "../../model.ump"
// line 170 "../../model.ump"
public class LoyaltyProgram
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LoyaltyProgram Associations
  private BMOBank bank;
  private List<Reward> rewards;
  private List<Client> members;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LoyaltyProgram(BMOBank aBank)
  {
    if (aBank == null || aBank.getProgram() != null)
    {
      throw new RuntimeException("Unable to create LoyaltyProgram due to aBank. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    bank = aBank;
    rewards = new ArrayList<Reward>();
    members = new ArrayList<Client>();
  }

  public LoyaltyProgram()
  {
    bank = new BMOBank(this);
    rewards = new ArrayList<Reward>();
    members = new ArrayList<Client>();
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
  public Reward getReward(int index)
  {
    Reward aReward = rewards.get(index);
    return aReward;
  }

  public List<Reward> getRewards()
  {
    List<Reward> newRewards = Collections.unmodifiableList(rewards);
    return newRewards;
  }

  public int numberOfRewards()
  {
    int number = rewards.size();
    return number;
  }

  public boolean hasRewards()
  {
    boolean has = rewards.size() > 0;
    return has;
  }

  public int indexOfReward(Reward aReward)
  {
    int index = rewards.indexOf(aReward);
    return index;
  }
  /* Code from template association_GetMany */
  public Client getMember(int index)
  {
    Client aMember = members.get(index);
    return aMember;
  }

  public List<Client> getMembers()
  {
    List<Client> newMembers = Collections.unmodifiableList(members);
    return newMembers;
  }

  public int numberOfMembers()
  {
    int number = members.size();
    return number;
  }

  public boolean hasMembers()
  {
    boolean has = members.size() > 0;
    return has;
  }

  public int indexOfMember(Client aMember)
  {
    int index = members.indexOf(aMember);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRewards()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Reward addReward(String aName, int aPointsCost)
  {
    return new Reward(aName, aPointsCost, this);
  }

  public boolean addReward(Reward aReward)
  {
    boolean wasAdded = false;
    if (rewards.contains(aReward)) { return false; }
    LoyaltyProgram existingProgram = aReward.getProgram();
    boolean isNewProgram = existingProgram != null && !this.equals(existingProgram);
    if (isNewProgram)
    {
      aReward.setProgram(this);
    }
    else
    {
      rewards.add(aReward);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReward(Reward aReward)
  {
    boolean wasRemoved = false;
    //Unable to remove aReward, as it must always have a program
    if (!this.equals(aReward.getProgram()))
    {
      rewards.remove(aReward);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRewardAt(Reward aReward, int index)
  {  
    boolean wasAdded = false;
    if(addReward(aReward))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRewards()) { index = numberOfRewards() - 1; }
      rewards.remove(aReward);
      rewards.add(index, aReward);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRewardAt(Reward aReward, int index)
  {
    boolean wasAdded = false;
    if(rewards.contains(aReward))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRewards()) { index = numberOfRewards() - 1; }
      rewards.remove(aReward);
      rewards.add(index, aReward);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRewardAt(aReward, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMembers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Client addMember(String aMemberId, String aName, int aPoints)
  {
    return new Client(aMemberId, aName, aPoints, this);
  }

  public boolean addMember(Client aMember)
  {
    boolean wasAdded = false;
    if (members.contains(aMember)) { return false; }
    LoyaltyProgram existingProgram = aMember.getProgram();
    boolean isNewProgram = existingProgram != null && !this.equals(existingProgram);
    if (isNewProgram)
    {
      aMember.setProgram(this);
    }
    else
    {
      members.add(aMember);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMember(Client aMember)
  {
    boolean wasRemoved = false;
    //Unable to remove aMember, as it must always have a program
    if (!this.equals(aMember.getProgram()))
    {
      members.remove(aMember);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMemberAt(Client aMember, int index)
  {  
    boolean wasAdded = false;
    if(addMember(aMember))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMembers()) { index = numberOfMembers() - 1; }
      members.remove(aMember);
      members.add(index, aMember);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMemberAt(Client aMember, int index)
  {
    boolean wasAdded = false;
    if(members.contains(aMember))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMembers()) { index = numberOfMembers() - 1; }
      members.remove(aMember);
      members.add(index, aMember);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMemberAt(aMember, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    BMOBank existingBank = bank;
    bank = null;
    if (existingBank != null)
    {
      existingBank.delete();
    }
    while (rewards.size() > 0)
    {
      Reward aReward = rewards.get(rewards.size() - 1);
      aReward.delete();
      rewards.remove(aReward);
    }
    
    for(int i=members.size(); i > 0; i--)
    {
      Client aMember = members.get(i - 1);
      aMember.delete();
    }
  }

  // line 57 "../../model.ump"
  public void listRewards(){
    for (Reward r : getRewards()) { System.out.println("   " + r.getName() + " - " + r.getPointsCost()); }
  }

  // line 58 "../../model.ump"
  public void listMembers(){
    for (Client c : getMembers()) { System.out.println("   " + c.getName()); }
  }

}