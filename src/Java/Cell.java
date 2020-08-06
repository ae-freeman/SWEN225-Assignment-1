import java.util.ArrayList;

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
  private Room room;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cell(int aXValue, int aYValue)
  {
    xValue = aXValue;
    yValue = aYValue;
    isAccessible = true;

  }
  //------------------------
  // INTERFACE
  //------------------------
  public void addCellToRoom(String name, ArrayList<Room> rooms) {
      for(Room room : rooms) {
    	  if(room.getName().equals(name)) {
    		  room.addCell(this);
    	  }
      }
  }
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