/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/



// line 132 "model.ump"
// line 199 "model.ump"
public class Accusation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Accusation Attributes
	  private Card[] accusation;
	  private Card[] murder;

  //Accusation Associations
  private Game game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Accusation(Card[] guess, Card[] murderDeck){
    accusation = guess;
    murder = murderDeck;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccusation(ArrayList aAccusation)
  {
    boolean wasSet = false;
    accusation = aAccusation;
    wasSet = true;
    return wasSet;
  }

  public ArrayList getAccusation()
  {
    return accusation;
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGame(Game aGame)
  {
    boolean wasSet = false;
    if (aGame == null)
    {
      return wasSet;
    }

    Game existingGame = game;
    game = aGame;
    if (existingGame != null && !existingGame.equals(aGame))
    {
      existingGame.removeAccusation(this);
    }
    game.addAccusation(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Game placeholderGame = game;
    this.game = null;
    if(placeholderGame != null)
    {
      placeholderGame.removeAccusation(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "accusation" + "=" + (getAccusation() != null ? !getAccusation().equals(this)  ? getAccusation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null");
  }
}