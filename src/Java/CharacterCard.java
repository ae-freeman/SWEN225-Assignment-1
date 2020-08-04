//package Java;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5092.1e2e91fc6 modeling language!*/



// line 56 "model.ump"
// line 126 "model.ump"
public class CharacterCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CharacterCard Attributes
  private Cell startLocation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CharacterCard(String aName, Cell aStartLocation)
  {
    super(aName);
    startLocation = aStartLocation;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartLocation(Cell aStartLocation)
  {
    boolean wasSet = false;
    startLocation = aStartLocation;
    wasSet = true;
    return wasSet;
  }

  public Cell getStartLocation()
  {
    return startLocation;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startLocation" + "=" + (getStartLocation() != null ? !getStartLocation().equals(this)  ? getStartLocation().toString().replaceAll("  ","    ") : "this" : "null");
  }
}