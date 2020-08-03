/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/

//
//import java.util.*;

import java.util.ArrayList;

// line 70 "model.ump"
// line 155 "model.ump"
public class Board {

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    private Cell[][] board;
    private int length = 25;
    private int width = 24;
    private ArrayList<Cell> kitchenCells;
    private ArrayList<Cell> ballRoomCells;
    private ArrayList<Cell> conservatoryCells;
    private ArrayList<Cell> diningRoomCells;
    private ArrayList<Cell> billiardRoomCells;
    private ArrayList<Cell> loungeCells;
    private ArrayList<Cell> hallCells;
    private ArrayList<Cell> libraryCells;
    private ArrayList<Cell> studyCells;
    private ArrayList<Cell> cellarCells;
    private ArrayList<Cell> wallCells;
    private ArrayList<Cell> hallwayCells;
    private ArrayList<Cell> outofboardCells;
    private String boardString =
                    "_________ ____ _________" +
                    "KKKKK|_   |BB|_   |CCCCC" +
                    "KKKKK|  __|BB|__  |CCCCC" +
                    "KKKKK|  |BBBBBB|  |CCCCC" +
                    "KKKKK|  |BBBBBB|  CCCCCC" +
                    "KKKKK|  BBBBBBBB   |____" +
                    "_|__K|  |BBBBBB|        " +
                    "        |B____B|       |" +
                    "_                 _____" +
                    "|____             IIIIII" +
                    "DDDD|___  AAAAA   |IIIII" +
                    "DDDDDDD|  AAAAA   |IIIII" +
                    "DDDDDDDD  AAAAA   |___I_" +
                    "DDDDDDD|  AAAAA        |" +
                    "DDDDDDD|  AAAAA   __L__|" +
                    "______D|  AAAAA  _|LLLLL" +
                    "|         AAAAA  LLLLLLL" +
                    "                 |_LLLLL" +
                    "_        __HH__   |____|" +
                    "|_____O  |HHHH|         " +
                    "OOOOOO|  |HHHHH        _" +
                    "OOOOOO|  |HHHH|  S_____|" +
                    "OOOOOO|  |HHHH|  |SSSSSS" +
                    "OOOOOO|  |HHHH|  |SSSSSS" +
                    "OOOOOO| |HHHHHH| |SSSSSS";

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Board() {
        board = new Cell[length][width];
        kitchenCells = new ArrayList<>();
        ballRoomCells = new ArrayList<>();
        conservatoryCells = new ArrayList<>();
        diningRoomCells = new ArrayList<>();
        billiardRoomCells = new ArrayList<>();
        loungeCells = new ArrayList<>();
        hallCells = new ArrayList<>();
        libraryCells = new ArrayList<>();
        studyCells = new ArrayList<>();
        wallCells = new ArrayList<>();
        cellarCells = new ArrayList<>();
        hallwayCells = new ArrayList<>();
        outofboardCells = new ArrayList<>();
        populateBoard();
    }


    /**
     * Prints the board on the console
     */
    public void printBoard() {
        String out = "";
        for (int row = 0; row < 24; row++) {
            for (int col = 0; col < 23; col++) {
                char currentChar = boardString.charAt((row * 24) + col);
                out = out.concat(" " + currentChar + " ");
            }
            System.out.println();
            out = out.concat("\n");
        }
        System.out.print(out);
    }

    /**
     * Prints the board on the console, current player as X and other players as .
     */
    public void printBoardWithCurrentPlayer(Player player) {
        String out = "";
        for (int row = 0; row < 24; row++) {
            for (int col = 0; col < 23; col++) {
                char currentChar = boardString.charAt((row * 24) + col);
                try {
                    Player playerOnBoard = board[row][col].getPlayer();
                    if (playerOnBoard.equals(player)) {
                        out = out.concat(" " + 'X' + " ");
                    } else {
                        out = out.concat(" " + '-' + " ");
                    }
                } catch (Exception ex) {
                    out = out.concat(" " + currentChar + " ");
                }
            }
            System.out.println();
            out = out.concat("\n");
        }
        System.out.print(out);
    }

    /**
     * Creates board, setting each cell to a specific Room
     */
    private void populateBoard() {
        for (int row = 0; row < 24; row++) {
            for (int col = 0; col < 23; col++) {
                char currentChar = boardString.charAt((row * 24) + col);
                Cell currentCell = new Cell(row, col);
                board[row][col] = currentCell;
                switch (currentChar) {
                    case 'K':
                        currentCell.setRoom(new Room("Kitchen"));
                        currentCell.setAccessible(true);
                        kitchenCells.add(currentCell);
                        break;
                    case 'B':
                        currentCell.setRoom(new Room("Ballroom"));
                        currentCell.setAccessible(true);
                        ballRoomCells.add(currentCell);
						break;
                    case 'C':
                        currentCell.setRoom(new Room("Conservatory"));
                        currentCell.setAccessible(true);
                        conservatoryCells.add(currentCell);
						break;
                    case 'D':
                        currentCell.setRoom(new Room("Dining room"));
                        currentCell.setAccessible(true);
                        diningRoomCells.add(currentCell);
						break;
                    case 'I':
                        currentCell.setRoom(new Room("Billiard Room"));
                        currentCell.setAccessible(true);
                        billiardRoomCells.add(currentCell);
						break;
                    case 'L':
                        currentCell.setRoom(new Room("Library"));
                        currentCell.setAccessible(true);
                        libraryCells.add(currentCell);
						break;
                    case 'O':
                        currentCell.setRoom(new Room("Lounge"));
                        currentCell.setAccessible(true);
                        loungeCells.add(currentCell);
						break;
                    case 'H':
                        currentCell.setRoom(new Room("Hall"));
                        board[row][col].setAccessible(true);
                        hallCells.add(currentCell);
						break;
                    case 'S':
                        currentCell.setRoom(new Room("Study"));
                        currentCell.setAccessible(true);
                        studyCells.add(currentCell);
						break;
                    case ' ':
                        currentCell.setRoom(new Room("Hallway"));
                        board[row][col].setAccessible(true);
                        hallwayCells.add(currentCell);
						break;
                    case '|':
                    case '_':
                        currentCell.setRoom(new Room("Wall"));
                        currentCell.setAccessible(false);
                        wallCells.add(currentCell);
						break;
                    case '0':
                        currentCell.setRoom(new Room("Out of Board"));
                        currentCell.setAccessible(false);
                        outofboardCells.add(currentCell);
						break;
                    case 'A':
                        currentCell.setRoom(new Room("Cellar"));
                        currentCell.setAccessible(false);
                        cellarCells.add(currentCell);
						break;
					default:
						currentCell.setRoom(new Room("Default"));
						currentCell.setAccessible(true);
						break;
                }
            }
        }

        ArrayList<Cell> doorCells = new ArrayList<>();
        doorCells.add(new Cell(4, 6));
        doorCells.add(new Cell(7, 13));
        doorCells.add(new Cell(6, 16));
        doorCells.add(new Cell(6, 20));
        doorCells.add(new Cell(8, 5));
        doorCells.add(new Cell(9, 7));
        doorCells.add(new Cell(14, 7));
        doorCells.add(new Cell(15, 5));
        doorCells.add(new Cell(18, 4));
        doorCells.add(new Cell(18, 9));
        doorCells.add(new Cell(22, 13));
        doorCells.add(new Cell(20, 15));
        doorCells.add(new Cell(17, 17));
        doorCells.add(new Cell(11, 19));
        doorCells.add(new Cell(12, 19));
        doorCells.add(new Cell(14, 21));
        doorCells.add(new Cell(17, 22));

        doorCells.forEach(doorCell -> getBoard()[doorCell.getxValue()][doorCell.getyValue()].setDoor(true));

    }


    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public ArrayList<Cell> getKitchenCells() {
        return kitchenCells;
    }

    public void setKitchenCells(ArrayList<Cell> kitchenCells) {
        this.kitchenCells = kitchenCells;
    }

    public ArrayList<Cell> getBallRoomCells() {
        return ballRoomCells;
    }

    public void setBallRoomCells(ArrayList<Cell> ballRoomCells) {
        this.ballRoomCells = ballRoomCells;
    }

    public ArrayList<Cell> getConservatoryCells() {
        return conservatoryCells;
    }

    public void setConservatoryCells(ArrayList<Cell> conservatoryCells) {
        this.conservatoryCells = conservatoryCells;
    }

    public ArrayList<Cell> getDiningRoomCells() {
        return diningRoomCells;
    }

    public void setDiningRoomCells(ArrayList<Cell> diningRoomCells) {
        this.diningRoomCells = diningRoomCells;
    }

    public ArrayList<Cell> getBilliardRoomCells() {
        return billiardRoomCells;
    }

    public void setBilliardRoomCells(ArrayList<Cell> billiardRoomCells) {
        this.billiardRoomCells = billiardRoomCells;
    }

    public ArrayList<Cell> getLoungeCells() {
        return loungeCells;
    }

    public void setLoungeCells(ArrayList<Cell> loungeCells) {
        this.loungeCells = loungeCells;
    }

    public ArrayList<Cell> getHallCells() {
        return hallCells;
    }

    public void setHallCells(ArrayList<Cell> hallCells) {
        this.hallCells = hallCells;
    }

    public ArrayList<Cell> getLibraryCells() {
        return libraryCells;
    }

    public void setLibraryCells(ArrayList<Cell> libraryCells) {
        this.libraryCells = libraryCells;
    }

    public ArrayList<Cell> getStudyCells() {
        return studyCells;
    }

    public void setStudyCells(ArrayList<Cell> studyCells) {
        this.studyCells = studyCells;
    }

    public ArrayList<Cell> getCellarCells() {
        return cellarCells;
    }

    public void setCellarCells(ArrayList<Cell> cellarCells) {
        this.cellarCells = cellarCells;
    }

    public ArrayList<Cell> getHallwayCells() {
        return hallwayCells;
    }

    public void setHallwayCells(ArrayList<Cell> hallwayCells) {
        this.hallwayCells = hallwayCells;
    }

    public ArrayList<Cell> getOutofboardCells() {
        return outofboardCells;
    }

    public void setOutofboardCells(ArrayList<Cell> outofboardCells) {
        this.outofboardCells = outofboardCells;
    }

    public ArrayList<Cell> getWallCells() {
        return wallCells;
    }

    public void setWallCells(ArrayList<Cell> wallCells) {
        this.wallCells = wallCells;
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
