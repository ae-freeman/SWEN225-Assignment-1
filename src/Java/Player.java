/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.util.ArrayList;

// line 87 "model.ump"
// line 170 "model.ump"
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private Character assignedCharacter;
  private Cell location;
  private ArrayList<Card> playerHand;
  private boolean playerStatus;

  //Player Associations
  private Game game;
  private Cell cell;
  private CharacterCard characterCard;

  //why do we need character card?

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(Character aAssignedCharacter, Cell aLocation, ArrayList aPlayerHand, boolean aPlayerStatus, Game aGame, Cell aCell, CharacterCard aCharacterCard)
  {
    assignedCharacter = aAssignedCharacter;
    location = aLocation;
    playerHand = aPlayerHand;
    playerStatus = aPlayerStatus;
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create player due to game. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aCell == null || aCell.getPlayer() != null)
    {
      throw new RuntimeException("Unable to create Player due to aCell. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    cell = aCell;
    if (aCharacterCard == null || aCharacterCard.getPlayer() != null)
    {
      throw new RuntimeException("Unable to create Player due to aCharacterCard. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    characterCard = aCharacterCard;
  }

  public Player(Character aAssignedCharacter, Cell aLocation, Hand aPlayerHand, boolean aPlayerStatus, Game aGame, int aXValueForCell, int aYValueForCell, Room aRoomForCell, Board aBoardForCell, String aNameForCharacterCard, Game aGameForCharacterCard, Cell aStartLocationForCharacterCard)
  {
    assignedCharacter = aAssignedCharacter;
    location = aLocation;
    playerHand = aPlayerHand;
    playerStatus = aPlayerStatus;
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create player due to game. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    cell = new Cell(aXValueForCell, aYValueForCell, aRoomForCell, this, aBoardForCell);
    characterCard = new CharacterCard(aNameForCharacterCard, aGameForCharacterCard, aStartLocationForCharacterCard, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAssignedCharacter(Character aAssignedCharacter)
  {
    boolean wasSet = false;
    assignedCharacter = aAssignedCharacter;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(Cell aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlayerHand(Hand aPlayerHand)
  {
    boolean wasSet = false;
    playerHand = aPlayerHand;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlayerStatus(boolean aPlayerStatus)
  {
    boolean wasSet = false;
    playerStatus = aPlayerStatus;
    wasSet = true;
    return wasSet;
  }

  public Character getAssignedCharacter()
  {
    return assignedCharacter;
  }

  public Cell getLocation()
  {
    return location;
  }

  public Hand getPlayerHand()
  {
    return playerHand;
  }

  public boolean getPlayerStatus()
  {
    return playerStatus;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isPlayerStatus()
  {
    return playerStatus;
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_GetOne */
  public Cell getCell()
  {
    return cell;
  }
  /* Code from template association_GetOne */
  public CharacterCard getCharacterCard()
  {
    return characterCard;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setGame(Game aGame)
  {
    boolean wasSet = false;
    //Must provide game to player
    if (aGame == null)
    {
      return wasSet;
    }

    //game already at maximum (6)
    if (aGame.numberOfPlayers() >= Game.maximumNumberOfPlayers())
    {
      return wasSet;
    }
    
    Game existingGame = game;
    game = aGame;
    if (existingGame != null && !existingGame.equals(aGame))
    {
      boolean didRemove = existingGame.removePlayer(this);
      if (!didRemove)
      {
        game = existingGame;
        return wasSet;
      }
    }
    game.addPlayer(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Game placeholderGame = game;
    this.game = null;
    if(placeholderGame != null)
    {
      placeholderGame.removePlayer(this);
    }
    Cell existingCell = cell;
    cell = null;
    if (existingCell != null)
    {
      existingCell.delete();
    }
    CharacterCard existingCharacterCard = characterCard;
    characterCard = null;
    if (existingCharacterCard != null)
    {
      existingCharacterCard.delete();
    }
  }

  // line 95 "model.ump"
   public void move(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "assignedCharacter" + ":" + getAssignedCharacter()+ "," +
            "playerStatus" + ":" + getPlayerStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "playerHand" + "=" + (getPlayerHand() != null ? !getPlayerHand().equals(this)  ? getPlayerHand().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "cell = "+(getCell()!=null?Integer.toHexString(System.identityHashCode(getCell())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "characterCard = "+(getCharacterCard()!=null?Integer.toHexString(System.identityHashCode(getCharacterCard())):"null");
  }
}