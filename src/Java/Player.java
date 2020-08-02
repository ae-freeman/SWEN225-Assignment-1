/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.util.ArrayList;
import java.util.Scanner;

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
  
  public int getHandLength() {
	  return playerHand.size();
  }
  
  public ArrayList<Card> getPlayerHand()
  {
    return playerHand;
  }
  
  public void setPlayerStatus() {
	  playerStatus = true;
  }
  
  public boolean getPlayerStatus() {
	  return playerStatus;
  }
 
  
  public String getCharacterName() {
	  return character.getName();
  }
  
  public Player getNextPlayer(Player player, ArrayList<Player> listOfPlayers) {
	  // go through list of players to get index of current player
	  int i = 0;
	  while (listOfPlayers.get(i).getCharacterName() != player.getCharacterName()) {
		  i++;
	  }
	  // return
	  return listOfPlayers.get(i + 1);
//	  return listOfPlayers.get(i + 1).getCharacterName();
  }
  
  
  /* Oliver's code starts */

  /**
   * Checks whether a move is valid
   *
   * @param board     being played upon
   * @param direction to be moved
   * @return
   */
  public Cell getTargetCell(Board board, String direction) {
      Cell targetCell = new Cell(0, 0);
      int playerX = location.getxValue();
      int playerY = location.getyValue();

      switch (direction) {
          case "w":
              targetCell = board.getBoard()[playerX - 1][playerY];
              break;
          case "a":
              targetCell = board.getBoard()[playerX][playerY - 1];
              break;
          case "s":
              targetCell = board.getBoard()[playerX + 1][playerY];
              break;
          case "d":
              targetCell = board.getBoard()[playerX][playerY + 1];
              break;
      }
      return targetCell;
  }

  /**
   * Moves player along board in direction specified by user
   *
   * @param numMoves number of times player can move
   * @param board    board being played upon
   */
  public void movePlayer(int numMoves, Board board) {
      Scanner scanner = new Scanner(System.in);
      while (numMoves > 0) {
          board.printBoardWithCurrentPlayer(this);
          // get direction of moves
          System.out.println("You have: " + numMoves + " moves remaining. ");
          System.out.println("Enter w to move up, s to move down, a to move left and d to move right:");
          String direction = scanner.nextLine();

          // if valid direction entered get old and target cells
          if ((direction.equals("w") || direction.equals("a") ||
                  direction.equals("s") || direction.equals("d"))) {
              Cell oldCell = getLocation();
              Cell targetCell = getTargetCell(board, direction);

              // if can move to that cell change player location and update cells
              if (targetCell.isAccessible()) {
                  oldCell.setAccessible(true);
                  oldCell.setPlayer(null);
                  setLocation(targetCell);
                  targetCell.setAccessible(false);
                  targetCell.setPlayer(this);

                  numMoves -= 1;
                  System.out.println("You are currently in the " + getLocation().getRoom().getName());
                  if (numMoves == 0) System.out.println("Turn over.");
              } else {
                  System.out.print("You cannot move to that cell, please try again.");
              }

          } else {
              System.out.print("Invalid move, please try again.");
          }
      }
  }


  public Cell getLocation() {
      return location;
  }

  /* Oliver's code ends */
  
  
//  public boolean setAssignedCharacter(Character aAssignedCharacter)
//  {
//    boolean wasSet = false;
//    assignedCharacter = aAssignedCharacter;
//    wasSet = true;
//    return wasSet;
//  }
//
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