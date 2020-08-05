//package Java;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5092.1e2e91fc6 modeling language!*/


import java.util.*;

// line 44 "model.ump"
// line 120 "model.ump"
public class Player
{


//------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private boolean playerStatus;

  //Player Associations
  private Cell location;
  private CharacterCard assignedCharacter;
  private ArrayList<Card> playerHand;
  private Scanner scanner = new Scanner(System.in);
	
  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(CharacterCard aAssignedCharacter)
  {
    assignedCharacter = aAssignedCharacter;
    location = assignedCharacter.getStartLocation();
    playerStatus = false;
    playerHand = new ArrayList<Card>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  public Player getNextPlayer(Player player, ArrayList<Player> listOfPlayers){
	  // go through list of players to get index of current player
	  int i = 0;
	  while (listOfPlayers.get(i).getCharacterCard() != player.getCharacterCard()) {
		  i++;
	  }
	  // return
	  return listOfPlayers.get(i + 1);
//	  return listOfPlayers.get(i + 1).getCharacterName();
  }
  
  /**
   * Checks whether a move is valid
   *
   * @param board     being played upon
   * @param direction to be moved
   * @return
   */
  public Cell getTargetCell(Board board, String direction) {
      Cell targetCell = new Cell(0, 0);
      int playerX = location.getXValue();
      int playerY = location.getYValue();
      targetCell = board.getBoard()[playerX][playerY];

      switch (direction) {
      case "w":
          if (playerY > 0) targetCell = board.getBoard()[playerX][playerY - 1];
          break;
      case "a":
          if (playerX > 0) targetCell = board.getBoard()[playerX - 1][playerY];
          break;
      case "s":
          if (playerY < 24) targetCell = board.getBoard()[playerX][playerY + 1];
          break;
      case "d":
          if (playerX < 23) targetCell = board.getBoard()[playerX + 1][playerY];
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
      int choice;

      if(this.getCell().getRoom() != "Hallway" ) {
    	  System.out.println("Would you like to stay in this room and make an accusation/suggestion?");
    	  System.out.println("Press 1 to make an accusation or suggestion\n" + "Press 2 to move\n");
  		do{
  			System.out.println("Please enter your action");
  			while(!scanner.hasNextInt()) {
  				System.out.println("Please enter 1 or 2");
  				scanner.hasNext();
  			}
  			choice = scanner.nextInt();
  		}while (scanner.nextInt() < 1 || scanner.nextInt() > 2);
  		if(choice == 1) {
//  			scanner.close();
  			return;
  		}
  		if(choice == 2) {
  			move(numMoves,board);
  			
  			
  			
  		}
      } else {
    	 move(numMoves,board);
			
    	  
      }
//   scanner.close();
      return;   
  }
  
  
  // Where does this need to go:
//  
  
  public void move(int numMoves, Board board) {
  while (numMoves > 0) {
      board.printBoardWithCurrentPlayer(this);
      // get direction of moves
      System.out.println("You have: " + numMoves + " moves remaining. ");
      System.out.println("Enter w to move up, s to move down, a to move left and d to move right:"); // this doesn't correspond with the direction it actually goes in
      String direction = scanner.nextLine();
      
      
      // tried moving left with Mrs White and got an index out of bounds exception, maybe need an extra check here? 

      // if valid direction entered get old and target cells
      if ((direction.equals("w") || direction.equals("a") ||
              direction.equals("s") || direction.equals("d"))) {
          Cell oldCell = getCell();
          Cell targetCell = getTargetCell(board, direction);
          
          
          int targetX = targetCell.getXValue();
          int targetY = targetCell.getYValue();
          int oldX = oldCell.getXValue();
          int oldY = oldCell.getYValue();

          // if can move to that cell change player location and update cells
          if (targetCell.getIsAccessible() && !(oldX == targetX && oldY == targetY)) {
              oldCell.setIsAccessible(true);
              oldCell.setPlayer(null);
              setLocation(targetCell);
              targetCell.setIsAccessible(false);
              targetCell.setPlayer(this);
              // If your move contains the hallway, decrease counter by 1 (you can move as many times as you like inside a room)
              if (targetCell.getRoom().equals("Hallway") ||
                      oldCell.getRoom().equals("Hallway"))  {
                  numMoves -= 1;
              }
              // If you arrive in a room, you moves are over
              if (!targetCell.getRoom().equals("Hallway") && oldCell.getRoom().equals("Hallway"))  {
                  numMoves = 0;
              }
              
              System.out.println("You are currently in the " + getCell().getRoom());
              
              if (numMoves == 0) {
            	 	 

            	  return;
              }
          } else {
              System.out.print("You cannot move to that cell, please try again.");
          }

      } else {
          System.out.print("Invalid move, please try again.");
          }
      }
  
  return;
  }
  
  public String getRoom() {
	  return getCell().getRoom();
  }
  public void addToHand(Card card) {
	  playerHand.add(card);
  }
  public int move(int roll) {
	  return roll;
  }
  public boolean setLocation(Cell aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
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
  public Cell getCell()
  {
    return location;
  }
  /* Code from template association_GetOne */
  public CharacterCard getCharacterCard()
  {
    return assignedCharacter;
  }
  /* Code from template association_GetMany */
  public Card getCard(int index)
  {
    Card aCard = playerHand.get(index);
    return aCard;
  }

  public ArrayList<Card> getHand()
  {
	  return playerHand;
  }

  public int numberOfCards()
  {
    int number = playerHand.size();
    return number;
  }

  public boolean hasCards()
  {
    boolean has = playerHand.size() > 0;
    return has;
  }

  /* Code from template association_SetUnidirectionalOne */
  public boolean setCell(Cell aNewCell)
  {
    boolean wasSet = false;
    if (aNewCell != null)
    {
      location = aNewCell;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setCharacterCard(CharacterCard aNewCharacterCard)
  {
    boolean wasSet = false;
    if (aNewCharacterCard != null)
    {
      assignedCharacter = aNewCharacterCard;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCards()
  {
    return 3;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfCards()
  {
    return 6;
  }
  public String toString()
  {
    return super.toString() + "["+
            "playerStatus" + ":" + getPlayerStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cell = "+(getCell()!=null?Integer.toHexString(System.identityHashCode(getCell())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "characterCard = "+(getCharacterCard()!=null?Integer.toHexString(System.identityHashCode(getCharacterCard())):"null");
  }
}