/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/



// line 79 "model.ump"
// line 163 "model.ump"
public class Cell
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cell Attributes
  private int xValue;
  private int yValue;

  //Cell Associations
  private Room room;
  private Player player;
  private Board board;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cell(int aXValue, int aYValue, Room aRoom, Player aPlayer, Board aBoard)
  {
    xValue = aXValue;
    yValue = aYValue;
    boolean didAddRoom = setRoom(aRoom);
    if (!didAddRoom)
    {
      throw new RuntimeException("Unable to create cell due to room. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aPlayer == null || aPlayer.getCell() != null)
    {
      throw new RuntimeException("Unable to create Cell due to aPlayer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    player = aPlayer;
    boolean didAddBoard = setBoard(aBoard);
    if (!didAddBoard)
    {
      throw new RuntimeException("Unable to create cell due to board. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Cell(int aXValue, int aYValue, Room aRoom, Character aAssignedCharacterForPlayer, Cell aLocationForPlayer, Hand aPlayerHandForPlayer, boolean aPlayerStatusForPlayer, Game aGameForPlayer, CharacterCard aCharacterCardForPlayer, Board aBoard)
  {
    xValue = aXValue;
    yValue = aYValue;
    boolean didAddRoom = setRoom(aRoom);
    if (!didAddRoom)
    {
      throw new RuntimeException("Unable to create cell due to room. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    player = new Player(aAssignedCharacterForPlayer, aLocationForPlayer, aPlayerHandForPlayer, aPlayerStatusForPlayer, aGameForPlayer, this, aCharacterCardForPlayer);
    boolean didAddBoard = setBoard(aBoard);
    if (!didAddBoard)
    {
      throw new RuntimeException("Unable to create cell due to board. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setXValue(int aXValue)
  {
    boolean wasSet = false;
    xValue = aXValue;
    wasSet = true;
    return wasSet;
  }

  public boolean setYValue(int aYValue)
  {
    boolean wasSet = false;
    yValue = aYValue;
    wasSet = true;
    return wasSet;
  }

  public int getXValue()
  {
    return xValue;
  }

  public int getYValue()
  {
    return yValue;
  }
  /* Code from template association_GetOne */
  public Room getRoom()
  {
    return room;
  }
  /* Code from template association_GetOne */
  public Player getPlayer()
  {
    return player;
  }
  /* Code from template association_GetOne */
  public Board getBoard()
  {
    return board;
  }
  /* Code from template association_SetOneToMany */
  public boolean setRoom(Room aRoom)
  {
    boolean wasSet = false;
    if (aRoom == null)
    {
      return wasSet;
    }

    Room existingRoom = room;
    room = aRoom;
    if (existingRoom != null && !existingRoom.equals(aRoom))
    {
      existingRoom.removeCell(this);
    }
    room.addCell(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setBoard(Board aBoard)
  {
    boolean wasSet = false;
    //Must provide board to cell
    if (aBoard == null)
    {
      return wasSet;
    }

    //board already at maximum (600)
    if (aBoard.numberOfCells() >= Board.maximumNumberOfCells())
    {
      return wasSet;
    }
    
    Board existingBoard = board;
    board = aBoard;
    if (existingBoard != null && !existingBoard.equals(aBoard))
    {
      boolean didRemove = existingBoard.removeCell(this);
      if (!didRemove)
      {
        board = existingBoard;
        return wasSet;
      }
    }
    board.addCell(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Room placeholderRoom = room;
    this.room = null;
    if(placeholderRoom != null)
    {
      placeholderRoom.removeCell(this);
    }
    Player existingPlayer = player;
    player = null;
    if (existingPlayer != null)
    {
      existingPlayer.delete();
    }
    Board placeholderBoard = board;
    this.board = null;
    if(placeholderBoard != null)
    {
      placeholderBoard.removeCell(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "xValue" + ":" + getXValue()+ "," +
            "yValue" + ":" + getYValue()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "room = "+(getRoom()!=null?Integer.toHexString(System.identityHashCode(getRoom())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "board = "+(getBoard()!=null?Integer.toHexString(System.identityHashCode(getBoard())):"null");
  }
}