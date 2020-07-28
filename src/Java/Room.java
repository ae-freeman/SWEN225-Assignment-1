/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.util.*;

// line 125 "model.ump"
// line 194 "model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private List<Cell> roomTiles;
  private List<Cell> doorCell;
  private String name;

  //Room Associations
  private List<Cell> cells;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String aName)
  {
    roomTiles = new ArrayList<Cell>();
    doorCell = new ArrayList<Cell>();
    name = aName;
    cells = new ArrayList<Cell>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template attribute_SetMany */
  public boolean addRoomTile(Cell aRoomTile)
  {
    boolean wasAdded = false;
    wasAdded = roomTiles.add(aRoomTile);
    return wasAdded;
  }

  public boolean removeRoomTile(Cell aRoomTile)
  {
    boolean wasRemoved = false;
    wasRemoved = roomTiles.remove(aRoomTile);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addDoorCell(Cell aDoorCell)
  {
    boolean wasAdded = false;
    wasAdded = doorCell.add(aDoorCell);
    return wasAdded;
  }

  public boolean removeDoorCell(Cell aDoorCell)
  {
    boolean wasRemoved = false;
    wasRemoved = doorCell.remove(aDoorCell);
    return wasRemoved;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_GetMany */
  public Cell getRoomTile(int index)
  {
    Cell aRoomTile = roomTiles.get(index);
    return aRoomTile;
  }

  public Cell[] getRoomTiles()
  {
    Cell[] newRoomTiles = roomTiles.toArray(new Cell[roomTiles.size()]);
    return newRoomTiles;
  }

  public int numberOfRoomTiles()
  {
    int number = roomTiles.size();
    return number;
  }

  public boolean hasRoomTiles()
  {
    boolean has = roomTiles.size() > 0;
    return has;
  }

  public int indexOfRoomTile(Cell aRoomTile)
  {
    int index = roomTiles.indexOf(aRoomTile);
    return index;
  }
  /* Code from template attribute_GetMany */
  public Cell getDoorCell(int index)
  {
    Cell aDoorCell = doorCell.get(index);
    return aDoorCell;
  }

  public Cell[] getDoorCell()
  {
    Cell[] newDoorCell = doorCell.toArray(new Cell[doorCell.size()]);
    return newDoorCell;
  }

  public int numberOfDoorCell()
  {
    int number = doorCell.size();
    return number;
  }

  public boolean hasDoorCell()
  {
    boolean has = doorCell.size() > 0;
    return has;
  }

  public int indexOfDoorCell(Cell aDoorCell)
  {
    int index = doorCell.indexOf(aDoorCell);
    return index;
  }

  public String getName()
  {
    return name;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCells()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Cell addCell(int aXValue, int aYValue, Player aPlayer, Board aBoard)
  {
    return new Cell(aXValue, aYValue, this, aPlayer, aBoard);
  }

  public boolean addCell(Cell aCell)
  {
    boolean wasAdded = false;
    if (cells.contains(aCell)) { return false; }
    Room existingRoom = aCell.getRoom();
    boolean isNewRoom = existingRoom != null && !this.equals(existingRoom);
    if (isNewRoom)
    {
      aCell.setRoom(this);
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
    //Unable to remove aCell, as it must always have a room
    if (!this.equals(aCell.getRoom()))
    {
      cells.remove(aCell);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCellAt(Cell aCell, int index)
  {  
    boolean wasAdded = false;
    if(addCell(aCell))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCells()) { index = numberOfCells() - 1; }
      cells.remove(aCell);
      cells.add(index, aCell);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCellAt(Cell aCell, int index)
  {
    boolean wasAdded = false;
    if(cells.contains(aCell))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCells()) { index = numberOfCells() - 1; }
      cells.remove(aCell);
      cells.add(index, aCell);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCellAt(aCell, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=cells.size(); i > 0; i--)
    {
      Cell aCell = cells.get(i - 1);
      aCell.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}