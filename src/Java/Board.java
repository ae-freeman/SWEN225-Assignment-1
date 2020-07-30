/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.util.*;

// line 70 "model.ump"
// line 155 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Attributes
  private List<Cell> tiles;

  //Board Associations
  private Game game;
  private List<Cell> cells;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board()
  {
    tiles = new ArrayList<Cell>();
    cells = new ArrayList<Cell>();
  }

  public Board(Board aGameBoardForGame, ArrayList aListOfPlayersForGame, boolean aGameOverForGame, ArrayList<WeaponCard> aWeaponsForGame, ArrayList<CharacterCard> aCharactersForGame, ArrayList<RoomCard> aRoomsForGame, ArrayList aMurderDeckForGame)
  {
    tiles = new ArrayList<Cell>();
    game = new Game(aGameBoardForGame, aListOfPlayersForGame, aGameOverForGame, aWeaponsForGame, aCharactersForGame, aRoomsForGame, aMurderDeckForGame, this);
    cells = new ArrayList<Cell>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template attribute_SetMany */
  public boolean addTile(Cell aTile)
  {
    boolean wasAdded = false;
    wasAdded = tiles.add(aTile);
    return wasAdded;
  }

  public boolean removeTile(Cell aTile)
  {
    boolean wasRemoved = false;
    wasRemoved = tiles.remove(aTile);
    return wasRemoved;
  }
  /* Code from template attribute_GetMany */
  public Cell getTile(int index)
  {
    Cell aTile = tiles.get(index);
    return aTile;
  }

  public Cell[] getTiles()
  {
    Cell[] newTiles = tiles.toArray(new Cell[tiles.size()]);
    return newTiles;
  }

  public int numberOfTiles()
  {
    int number = tiles.size();
    return number;
  }

  public boolean hasTiles()
  {
    boolean has = tiles.size() > 0;
    return has;
  }

  public int indexOfTile(Cell aTile)
  {
    int index = tiles.indexOf(aTile);
    return index;
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_GetMany */
  public Cell getCell(int index)
  {
    Cell aCell = cells.get(index);
    return aCell;
  }

  public List<Cell> getCells()
  {
    List<Cell> newCells = Collections.unmodifiableList(cells);
    return newCells;
  }

  public int numberOfCells()
  {
    int number = cells.size();
    return number;
  }

  public boolean hasCells()
  {
    boolean has = cells.size() > 0;
    return has;
  }

  public int indexOfCell(Cell aCell)
  {
    int index = cells.indexOf(aCell);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfCellsValid()
  {
    boolean isValid = numberOfCells() >= minimumNumberOfCells() && numberOfCells() <= maximumNumberOfCells();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfCells()
  {
    return 600;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCells()
  {
    return 600;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfCells()
  {
    return 600;
  }
  /* Code from template association_AddMNToOnlyOne */
  public Cell addCell(int aXValue, int aYValue, Room aRoom, Player aPlayer)
  {
    if (numberOfCells() >= maximumNumberOfCells())
    {
      return null;
    }
    else
    {
      return new Cell(aXValue, aYValue, aRoom, aPlayer, this);
    }
  }

  public boolean addCell(Cell aCell)
  {
    boolean wasAdded = false;
    if (cells.contains(aCell)) { return false; }
    if (numberOfCells() >= maximumNumberOfCells())
    {
      return wasAdded;
    }

    Board existingBoard = aCell.getBoard();
    boolean isNewBoard = existingBoard != null && !this.equals(existingBoard);

    if (isNewBoard && existingBoard.numberOfCells() <= minimumNumberOfCells())
    {
      return wasAdded;
    }

    if (isNewBoard)
    {
      aCell.setBoard(this);
    }
    else
    {
      cells.add(aCell);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCell(Cell aCell)
  {
    boolean wasRemoved = false;
    //Unable to remove aCell, as it must always have a board
    if (this.equals(aCell.getBoard()))
    {
      return wasRemoved;
    }

    //board already at minimum (600)
    if (numberOfCells() <= minimumNumberOfCells())
    {
      return wasRemoved;
    }
    cells.remove(aCell);
    wasRemoved = true;
    return wasRemoved;
  }

  public void delete()
  {
    Game existingGame = game;
    game = null;
    if (existingGame != null)
    {
      existingGame.delete();
    }
    for(int i=cells.size(); i > 0; i--)
    {
      Cell aCell = cells.get(i - 1);
      aCell.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null");
  }
}