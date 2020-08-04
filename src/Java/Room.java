//package Java;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5092.1e2e91fc6 modeling language!*/

// line 76 "model.ump"
// line 137 "model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private String name;

  //Room Associations
  private Cell[] cells;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String aName)
  {
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetMany */
  public Cell getCell(int index)
  {
    Cell aCell = cells[index];
    return aCell;
  }

  public Cell[] getCells()
  {
    Cell[] newCells = cells;
    return newCells;
  }

  public int numberOfCells()
  {
    int number = cells.length;
    return number;
  }

  public boolean hasCells()
  {
    boolean has = cells.length > 0;
    return has;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCells()
  {
    return 0;
  }
  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}