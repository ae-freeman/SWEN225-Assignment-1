/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/

//
//import java.util.*;

// line 70 "model.ump"
// line 155 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  private Cell[][] board;
  private int length = 25;
  private int width = 24;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board(){
    board = new Cell[length][width];
    populateBoard();
    
  }


  
  private void populateBoard() {
		
		 String boardString =
		         "000000000 0000 000000000" +
		                 "KKKKKW0   WBBW   0WCCCCC" +
		                 "KKKKKW  WWWBBWWW  WCCCCC" +
		                 "KKKKKW  WBBBBBBW  WCCCCC" +
		                 "KKKKKW  WBBBBBBW  CCCCCC" +
		                 "KKKKKW  BBBBBBBB   WWWW0" +
		                 "0WWWKW  WBBBBBBW        " +
		                 "        WBWWWWBW       0" +
		                 "0                 WWWWWW" +
		                 "WWWWW             IIIIII" +
		                 "DDDDWWWW  XXXXX   WIIIII" +
		                 "DDDDDDDW  XXXXX   WIIIII" +
		                 "DDDDDDDD  XXXXX   WWWWWW" +
		                 "DDDDDDDW  XXXXX        0" +
		                 "DDDDDDDW  XXXXX   WWLWW0" +
		                 "WWWWWWDW  XXXXX  WWLLLLL" +
		                 "0         XXXXX  LLLLLLL" +
		                 "                 WWLLLLL" +
		                 "0        WWHHWW   WWWWW0" +
		                 "WWWWWWL  WHHHHW         " +
		                 "OOOOOOW  WHHHHH        0" +
		                 "OOOOOOW  WHHHHW  SWWWWWW" +
		                 "OOOOOOW  WHHHHW  WSSSSSS" +
		                 "OOOOOOW  WHHHHW  WSSSSSS" +
		                 "OOOOOO0 0HHHHHH0 0SSSSSSE";


		 
		 String out = "";
		 for (int row = 0; row < 24; row++){
		     for (int col = 0; col < 23; col++){
		         char currentChar = boardString.charAt((row * 24) + col);

		     switch (currentChar) {
		         case 'K':
		             board[row][col].setRoom(new Room("Kitchen"));
		             board[row][col].setAccessible(true);
		         case 'B':
		             board[row][col].setRoom(new Room("Ballroom"));
		             board[row][col].setAccessible(true);
		         case 'C':
		             board[row][col].setRoom(new Room("Conservatory"));
		             board[row][col].setAccessible(true);
		         case 'D':
		             board[row][col].setRoom(new Room("Dining room"));
		             board[row][col].setAccessible(true);
		         case 'I':
		             board[row][col].setRoom(new Room("Billiard Room"));
		             board[row][col].setAccessible(true);
		         case 'L':
		             board[row][col].setRoom(new Room("Library"));
		             board[row][col].setAccessible(true);
		         case 'O':
		             board[row][col].setRoom(new Room("Lounge"));
		             board[row][col].setAccessible(true);
		         case 'H':
		             board[row][col].setRoom(new Room("Hall"));
		             board[row][col].setAccessible(true);
		         case 'S':
		             board[row][col].setRoom(new Room("Study"));
		             board[row][col].setAccessible(true);
		         case ' ':
		             board[row][col].setRoom(new Room("Hallway"));
		             board[row][col].setAccessible(true);
		         case 'W':
		             board[row][col].setRoom(new Room("Wall"));
		             board[row][col].setAccessible(false);
		         case '0':
		             board[row][col].setRoom(new Room("OutOfBounds"));
		             board[row][col].setAccessible(false);
		         case 'X':
		             board[row][col].setRoom(new Room("Cellar"));
		             board[row][col].setAccessible(false);
		     }
		         out = out.concat(" " + boardString.charAt((row * 24) + col) + " ");
		     }
		     System.out.println();
		     out = out.concat("\n");



		 }
		 System.out.print(out);
	}



}



///*PLEASE DO NOT EDIT THIS CODE*/
///*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/
//
//
//import java.util.*;
//
//// line 70 "model.ump"
//// line 155 "model.ump"
//public class Board
//{
//
//  //------------------------
//  // MEMBER VARIABLES
//  //------------------------
//
//  //Board Attributes
//  private List<Cell> tiles;
//
//  //Board Associations
//  private Game game;
//  private List<Cell> cells;
//
//  //------------------------
//  // CONSTRUCTOR
//  //------------------------
//
//  public Board()
//  {
//    tiles = new ArrayList<Cell>();
//    cells = new ArrayList<Cell>();
//  }
//
//  public Board(Board aGameBoardForGame, ArrayList aListOfPlayersForGame, boolean aGameOverForGame, ArrayList<WeaponCard> aWeaponsForGame, ArrayList<CharacterCard> aCharactersForGame, ArrayList<RoomCard> aRoomsForGame, ArrayList aMurderDeckForGame)
//  {
//    tiles = new ArrayList<Cell>();
//    game = new Game(aGameBoardForGame, aListOfPlayersForGame, aGameOverForGame, aWeaponsForGame, aCharactersForGame, aRoomsForGame, aMurderDeckForGame, this);
//    cells = new ArrayList<Cell>();
//  }
//
//  //------------------------
//  // INTERFACE
//  //------------------------
//  /* Code from template attribute_SetMany */
//  public boolean addTile(Cell aTile)
//  {
//    boolean wasAdded = false;
//    wasAdded = tiles.add(aTile);
//    return wasAdded;
//  }
//
//  public boolean removeTile(Cell aTile)
//  {
//    boolean wasRemoved = false;
//    wasRemoved = tiles.remove(aTile);
//    return wasRemoved;
//  }
//  /* Code from template attribute_GetMany */
//  public Cell getTile(int index)
//  {
//    Cell aTile = tiles.get(index);
//    return aTile;
//  }
//
//  public Cell[] getTiles()
//  {
//    Cell[] newTiles = tiles.toArray(new Cell[tiles.size()]);
//    return newTiles;
//  }
//
//  public int numberOfTiles()
//  {
//    int number = tiles.size();
//    return number;
//  }
//
//  public boolean hasTiles()
//  {
//    boolean has = tiles.size() > 0;
//    return has;
//  }
//
//  public int indexOfTile(Cell aTile)
//  {
//    int index = tiles.indexOf(aTile);
//    return index;
//  }
//  /* Code from template association_GetOne */
//  public Game getGame()
//  {
//    return game;
//  }
//  /* Code from template association_GetMany */
//  public Cell getCell(int index)
//  {
//    Cell aCell = cells.get(index);
//    return aCell;
//  }
//
//  public List<Cell> getCells()
//  {
//    List<Cell> newCells = Collections.unmodifiableList(cells);
//    return newCells;
//  }
//
//  public int numberOfCells()
//  {
//    int number = cells.size();
//    return number;
//  }
//
//  public boolean hasCells()
//  {
//    boolean has = cells.size() > 0;
//    return has;
//  }
//
//  public int indexOfCell(Cell aCell)
//  {
//    int index = cells.indexOf(aCell);
//    return index;
//  }
//  /* Code from template association_IsNumberOfValidMethod */
//  public boolean isNumberOfCellsValid()
//  {
//    boolean isValid = numberOfCells() >= minimumNumberOfCells() && numberOfCells() <= maximumNumberOfCells();
//    return isValid;
//  }
//  /* Code from template association_RequiredNumberOfMethod */
//  public static int requiredNumberOfCells()
//  {
//    return 600;
//  }
//  /* Code from template association_MinimumNumberOfMethod */
//  public static int minimumNumberOfCells()
//  {
//    return 600;
//  }
//  /* Code from template association_MaximumNumberOfMethod */
//  public static int maximumNumberOfCells()
//  {
//    return 600;
//  }
//  /* Code from template association_AddMNToOnlyOne */
//  public Cell addCell(int aXValue, int aYValue, Room aRoom, Player aPlayer)
//  {
//    if (numberOfCells() >= maximumNumberOfCells())
//    {
//      return null;
//    }
//    else
//    {
//      return new Cell(aXValue, aYValue, aRoom, aPlayer, this);
//    }
//  }
//
//  public boolean addCell(Cell aCell)
//  {
//    boolean wasAdded = false;
//    if (cells.contains(aCell)) { return false; }
//    if (numberOfCells() >= maximumNumberOfCells())
//    {
//      return wasAdded;
//    }
//
//    Board existingBoard = aCell.getBoard();
//    boolean isNewBoard = existingBoard != null && !this.equals(existingBoard);
//
//    if (isNewBoard && existingBoard.numberOfCells() <= minimumNumberOfCells())
//    {
//      return wasAdded;
//    }
//
//    if (isNewBoard)
//    {
//      aCell.setBoard(this);
//    }
//    else
//    {
//      cells.add(aCell);
//    }
//    wasAdded = true;
//    return wasAdded;
//  }
//
//  public boolean removeCell(Cell aCell)
//  {
//    boolean wasRemoved = false;
//    //Unable to remove aCell, as it must always have a board
//    if (this.equals(aCell.getBoard()))
//    {
//      return wasRemoved;
//    }
//
//    //board already at minimum (600)
//    if (numberOfCells() <= minimumNumberOfCells())
//    {
//      return wasRemoved;
//    }
//    cells.remove(aCell);
//    wasRemoved = true;
//    return wasRemoved;
//  }
//
//  public void delete()
//  {
//    Game existingGame = game;
//    game = null;
//    if (existingGame != null)
//    {
//      existingGame.delete();
//    }
//    for(int i=cells.size(); i > 0; i--)
//    {
//      Cell aCell = cells.get(i - 1);
//      aCell.delete();
//    }
//  }
//
//
//  public String toString()
//  {
//    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
//            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null");
//  }
//}
