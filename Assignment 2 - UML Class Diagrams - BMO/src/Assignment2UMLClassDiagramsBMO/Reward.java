/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.util.*;
import java.sql.Date;

// line 60 "../../model.ump"
// line 175 "../../model.ump"
public class Reward
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Reward Attributes
  private String name;
  private int pointsCost;

  //Reward Associations
  private List<Redemption> redemptions;
  private LoyaltyProgram program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Reward(String aName, int aPointsCost, LoyaltyProgram aProgram)
  {
    name = aName;
    pointsCost = aPointsCost;
    redemptions = new ArrayList<Redemption>();
    boolean didAddProgram = setProgram(aProgram);
    if (!didAddProgram)
    {
      throw new RuntimeException("Unable to create reward due to program. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPointsCost(int aPointsCost)
  {
    boolean wasSet = false;
    pointsCost = aPointsCost;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getPointsCost()
  {
    return pointsCost;
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
  public Redemption addRedemption(Date aDate, Client aClient)
  {
    return new Redemption(aDate, aClient, this);
  }

  public boolean addRedemption(Redemption aRedemption)
  {
    boolean wasAdded = false;
    if (redemptions.contains(aRedemption)) { return false; }
    Reward existingReward = aRedemption.getReward();
    boolean isNewReward = existingReward != null && !this.equals(existingReward);
    if (isNewReward)
    {
      aRedemption.setReward(this);
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
    //Unable to remove aRedemption, as it must always have a reward
    if (!this.equals(aRedemption.getReward()))
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
      existingProgram.removeReward(this);
    }
    program.addReward(this);
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
      placeholderProgram.removeReward(this);
    }
  }

  // line 63 "../../model.ump"
  public void listRedemptions(){
    for (Redemption r : getRedemptions()) { System.out.println("   by " + r.getClient().getName()); }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "pointsCost" + ":" + getPointsCost()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program = "+(getProgram()!=null?Integer.toHexString(System.identityHashCode(getProgram())):"null");
  }
}