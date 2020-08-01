/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/



// line 99 "model.ump"
// line 210 "model.ump"
public class WeaponCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

	
  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WeaponCard(String cardName)
  {
	super(cardName);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }
  
  public String toString()
  {
    return getName();
  }

}