/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.1.8821.95a16eedb modeling language!*/

package Assignment2UMLClassDiagramsBMO;
import java.sql.Date;

/**
 * Association class: one Redemption = one Client + one Reward + a date
 */
// line 67 "../model.ump"
// line 180 "../model.ump"
public class Redemption
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Redemption Attributes
  private Date date;

  //Redemption Associations
  private Client client;
  private Reward reward;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetClient;
  private boolean canSetReward;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Redemption(Date aDate, Client aClient, Reward aReward)
  {
    cachedHashCode = -1;
    canSetClient = true;
    canSetReward = true;
    date = aDate;
    boolean didAddClient = setClient(aClient);
    if (!didAddClient)
    {
      throw new RuntimeException("Unable to create redemption due to client. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddReward = setReward(aReward);
    if (!didAddReward)
    {
      throw new RuntimeException("Unable to create redemption due to reward. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }
  /* Code from template association_GetOne */
  public Client getClient()
  {
    return client;
  }
  /* Code from template association_GetOne */
  public Reward getReward()
  {
    return reward;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setClient(Client aClient)
  {
    boolean wasSet = false;
    if (!canSetClient) { return false; }
    if (aClient == null)
    {
      return wasSet;
    }

    Client existingClient = client;
    client = aClient;
    if (existingClient != null && !existingClient.equals(aClient))
    {
      existingClient.removeRedemption(this);
    }
    if (!client.addRedemption(this))
    {
      client = existingClient;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setReward(Reward aReward)
  {
    boolean wasSet = false;
    if (!canSetReward) { return false; }
    if (aReward == null)
    {
      return wasSet;
    }

    Reward existingReward = reward;
    reward = aReward;
    if (existingReward != null && !existingReward.equals(aReward))
    {
      existingReward.removeRedemption(this);
    }
    if (!reward.addRedemption(this))
    {
      reward = existingReward;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Redemption compareTo = (Redemption)obj;
  
    if (getClient() == null && compareTo.getClient() != null)
    {
      return false;
    }
    else if (getClient() != null && !getClient().equals(compareTo.getClient()))
    {
      return false;
    }

    if (getReward() == null && compareTo.getReward() != null)
    {
      return false;
    }
    else if (getReward() != null && !getReward().equals(compareTo.getReward()))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (getClient() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getClient().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (getReward() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getReward().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetClient = false;
    canSetReward = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Client placeholderClient = client;
    this.client = null;
    if(placeholderClient != null)
    {
      placeholderClient.removeRedemption(this);
    }
    Reward placeholderReward = reward;
    this.reward = null;
    if(placeholderReward != null)
    {
      placeholderReward.removeRedemption(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "client = "+(getClient()!=null?Integer.toHexString(System.identityHashCode(getClient())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "reward = "+(getReward()!=null?Integer.toHexString(System.identityHashCode(getReward())):"null");
  }
}