package Java;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5092.1e2e91fc6 modeling language!*/



// line 34 "model.ump"
// line 113 "model.ump"
public class Cell
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cell Attributes
  private int xValue;
  private int yValue;
  private boolean isAccessible;
  private boolean isDoor;
  private Player player;

  //Cell Associations
  private Room room;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cell(int aXValue, int aYValue)
  {
    xValue = aXValue;
    yValue = aYValue;
    isAccessible = true;
    isDoor = false;
  }
  //------------------------
  // INTERFACE
  //------------------------
  public boolean setIsAccessible(boolean aIsAccessible)
  {
    boolean wasSet = false;
    isAccessible = aIsAccessible;
    wasSet = true;
    return wasSet;
  }

  public boolean isDoor() {
      return isDoor;
  }

  public void setDoor(boolean door) {
      isDoor = door;
  }
  public Player getPlayer() {
	  return player;
  }
  public void setPlayer(Player player) {
	  this.player = player;
  }
  public int getXValue()
  {
    return xValue;
  }

  public int getYValue()
  {
    return yValue;
  }

  public boolean getIsAccessible()
  {
    return isAccessible;
  }
  /* Code from template association_GetOne */
  public Room getRoom()
  {
    return room;
  }
  public void setRoom(Room room) {
	  this.room = room;
  }

  public String toString()
  {
    return super.toString() + "["+
            "xValue" + ":" + getXValue()+ "," +
            "yValue" + ":" + getYValue()+ "," +
            "isAccessible" + ":" + getIsAccessible()+ "," +
            System.getProperties().getProperty("line.separator") +
            "  " + "room = "+(getRoom()!=null?Integer.toHexString(System.identityHashCode(getRoom())):"null");
  }
}