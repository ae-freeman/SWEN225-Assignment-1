/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/



// line 105 "model.ump"
// line 175 "model.ump"
public class CharacterCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CharacterCard Attributes
  private Cell startLocation;

  //CharacterCard Associations
  private Player player;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CharacterCard(String aName, Game aGame, Cell aStartLocation, Player aPlayer)
  {
    super(aName, aGame);
    startLocation = aStartLocation;
    if (aPlayer == null || aPlayer.getCharacterCard() != null)
    {
      throw new RuntimeException("Unable to create CharacterCard due to aPlayer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    player = aPlayer;
  }

  public CharacterCard(String aName, Game aGame, Cell aStartLocation, Character aAssignedCharacterForPlayer, Cell aLocationForPlayer, Hand aPlayerHandForPlayer, boolean aPlayerStatusForPlayer, Game aGameForPlayer, Cell aCellForPlayer)
  {
    super(aName, aGame);
    startLocation = aStartLocation;
    player = new Player(aAssignedCharacterForPlayer, aLocationForPlayer, aPlayerHandForPlayer, aPlayerStatusForPlayer, aGameForPlayer, aCellForPlayer, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartLocation(Cell aStartLocation)
  {
    boolean wasSet = false;
    startLocation = aStartLocation;
    wasSet = true;
    return wasSet;
  }

  public Cell getStartLocation()
  {
    return startLocation;
  }
  /* Code from template association_GetOne */
  public Player getPlayer()
  {
    return player;
  }

  public void delete()
  {
    Player existingPlayer = player;
    player = null;
    if (existingPlayer != null)
    {
      existingPlayer.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startLocation" + "=" + (getStartLocation() != null ? !getStartLocation().equals(this)  ? getStartLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null");
  }
}