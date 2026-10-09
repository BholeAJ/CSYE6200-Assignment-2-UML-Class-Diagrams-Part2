/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;
import java.sql.Date;

/**
 * ---------------- CLIENTS ----------------
 */
// line 25 "../../model.ump"
// line 115 "../../model.ump"
public class Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private String memberId;
  private String name;
  private int points;

  //Client Associations
  private List<Redemption> redemptions;
  private LoyaltyProgram program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Client(String aMemberId, String aName, int aPoints, LoyaltyProgram aProgram)
  {
    memberId = aMemberId;
    name = aName;
    points = aPoints;
    redemptions = new ArrayList<Redemption>();
    boolean didAddProgram = setProgram(aProgram);
    if (!didAddProgram)
    {
      throw new RuntimeException("Unable to create member due to program. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMemberId(String aMemberId)
  {
    boolean wasSet = false;
    memberId = aMemberId;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPoints(int aPoints)
  {
    boolean wasSet = false;
    points = aPoints;
    wasSet = true;
    return wasSet;
  }

  public String getMemberId()
  {
    return memberId;
  }

  public String getName()
  {
    return name;
  }

  public int getPoints()
  {
    return points;
  }
  /* Code from template association_GetMany */
  public Redemption getRedemption(int index)
  {
    Redemption aRedemption = redemptions.get(index);
    return aRedemption;
  }

  public List<Redemption> getRedemptions()
  {
    List<Redemption> newRedemptions = Collections.unmodifiableList(redemptions);
    return newRedemptions;
  }

  public int numberOfRedemptions()
  {
    int number = redemptions.size();
    return number;
  }

  public boolean hasRedemptions()
  {
    boolean has = redemptions.size() > 0;
    return has;
  }

  public int indexOfRedemption(Redemption aRedemption)
  {
    int index = redemptions.indexOf(aRedemption);
    return index;
  }
  /* Code from template association_GetOne */
  public LoyaltyProgram getProgram()
  {
    return program;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRedemptions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Redemption addRedemption(Date aDate, Reward aReward)
  {
    return new Redemption(aDate, this, aReward);
  }

  public boolean addRedemption(Redemption aRedemption)
  {
    boolean wasAdded = false;
    if (redemptions.contains(aRedemption)) { return false; }
    Client existingClient = aRedemption.getClient();
    boolean isNewClient = existingClient != null && !this.equals(existingClient);
    if (isNewClient)
    {
      aRedemption.setClient(this);
    }
    else
    {
      redemptions.add(aRedemption);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRedemption(Redemption aRedemption)
  {
    boolean wasRemoved = false;
    //Unable to remove aRedemption, as it must always have a client
    if (!this.equals(aRedemption.getClient()))
    {
      redemptions.remove(aRedemption);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRedemptionAt(Redemption aRedemption, int index)
  {  
    boolean wasAdded = false;
    if(addRedemption(aRedemption))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRedemptions()) { index = numberOfRedemptions() - 1; }
      redemptions.remove(aRedemption);
      redemptions.add(index, aRedemption);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRedemptionAt(Redemption aRedemption, int index)
  {
    boolean wasAdded = false;
    if(redemptions.contains(aRedemption))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRedemptions()) { index = numberOfRedemptions() - 1; }
      redemptions.remove(aRedemption);
      redemptions.add(index, aRedemption);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRedemptionAt(aRedemption, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setProgram(LoyaltyProgram aProgram)
  {
    boolean wasSet = false;
    if (aProgram == null)
    {
      return wasSet;
    }

    LoyaltyProgram existingProgram = program;
    program = aProgram;
    if (existingProgram != null && !existingProgram.equals(aProgram))
    {
      existingProgram.removeMember(this);
    }
    program.addMember(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=redemptions.size(); i > 0; i--)
    {
      Redemption aRedemption = redemptions.get(i - 1);
      aRedemption.delete();
    }
    LoyaltyProgram placeholderProgram = program;
    this.program = null;
    if(placeholderProgram != null)
    {
      placeholderProgram.removeMember(this);
    }
  }

  // line 29 "../../model.ump"
  public void earnPoints(int p){
    setPoints(getPoints() + p);
  }

  // line 31 "../../model.ump"
  public void listRedemptions(){
    System.out.println("Redemptions of " + getName() + ":");
    for (Redemption r : getRedemptions()) { System.out.println("   " + r.getReward().getName()); }
  }


  public String toString()
  {
    return super.toString() + "["+
            "memberId" + ":" + getMemberId()+ "," +
            "name" + ":" + getName()+ "," +
            "points" + ":" + getPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program = "+(getProgram()!=null?Integer.toHexString(System.identityHashCode(getProgram())):"null");
  }
}