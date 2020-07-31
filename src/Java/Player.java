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
  private CharacterCard character;
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

  public Player(CharacterCard aAssignedCharacter)
  {
    character = aAssignedCharacter;
    location = character.getStartLocation();
    playerStatus = false;
    playerHand = new ArrayList<Card>();
  }
  //------------------------
  // INTERFACE
  //------------------------

  public void addToHand(Card card) {
	  playerHand.add(card);
  }
  public int move(int roll) {
	  return roll;
  }
  
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

//  public boolean setPlayerHand(Hand aPlayerHand)
//  {
//    boolean wasSet = false;
//    playerHand = aPlayerHand;
//    wasSet = true;
//    return wasSet;
//  }
//
//  public boolean setPlayerStatus(boolean aPlayerStatus)
//  {
//    boolean wasSet = false;
//    playerStatus = aPlayerStatus;
//    wasSet = true;
//    return wasSet;
//  }
//
//  public Character getAssignedCharacter()
//  {
//    return assignedCharacter;
//  }
//
//  public Cell getLocation()
//  {
//    return location;
//  }
//
  public ArrayList<Card> getPlayerHand()
  {
    return playerHand;
  }
//
//  public boolean getPlayerStatus()
//  {
//    return playerStatus;
//  }
//  /* Code from template attribute_IsBoolean */
//  public boolean isPlayerStatus()
//  {
//    return playerStatus;
//  }
//  /* Code from template association_GetOne */
//  public Game getGame()
//  {
//    return game;
//  }
//  /* Code from template association_GetOne */
//  public Cell getCell()
//  {
//    return cell;
//  }
//  /* Code from template association_GetOne */
//  public CharacterCard getCharacterCard()
//  {
//    return characterCard;
//  }
//  /* Code from template association_SetOneToAtMostN */
//  public boolean setGame(Game aGame)
//  {
//    boolean wasSet = false;
//    //Must provide game to player
//    if (aGame == null)
//    {
//      return wasSet;
//    }
//
//    //game already at maximum (6)
//    if (aGame.numberOfPlayers() >= Game.maximumNumberOfPlayers())
//    {
//      return wasSet;
//    }
//    
//    Game existingGame = game;
//    game = aGame;
//    if (existingGame != null && !existingGame.equals(aGame))
//    {
//      boolean didRemove = existingGame.removePlayer(this);
//      if (!didRemove)
//      {
//        game = existingGame;
//        return wasSet;
//      }
//    }
//    game.addPlayer(this);
//    wasSet = true;
//    return wasSet;
//  }
//
//  public void delete()
//  {
//    Game placeholderGame = game;
//    this.game = null;
//    if(placeholderGame != null)
//    {
//      placeholderGame.removePlayer(this);
//    }
//    Cell existingCell = cell;
//    cell = null;
//    if (existingCell != null)
//    {
//      existingCell.delete();
//    }
//    CharacterCard existingCharacterCard = characterCard;
//    characterCard = null;
//    if (existingCharacterCard != null)
//    {
//      existingCharacterCard.delete();
//    }
//  }

  // line 95 "model.ump"
//   public void move(){
//    
//  }
//
//
//  public String toString()
//  {
//    return super.toString() + "["+
//            "assignedCharacter" + ":" + getAssignedCharacter()+ "," +
//            "playerStatus" + ":" + getPlayerStatus()+ "]" + System.getProperties().getProperty("line.separator") +
//            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
//            "  " + "playerHand" + "=" + (getPlayerHand() != null ? !getPlayerHand().equals(this)  ? getPlayerHand().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
//            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null") + System.getProperties().getProperty("line.separator") +
//            "  " + "cell = "+(getCell()!=null?Integer.toHexString(System.identityHashCode(getCell())):"null") + System.getProperties().getProperty("line.separator") +
//            "  " + "characterCard = "+(getCharacterCard()!=null?Integer.toHexString(System.identityHashCode(getCharacterCard())):"null");
//  }
}