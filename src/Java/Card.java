/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/



// line 119 "model.ump"
// line 186 "model.ump"
public abstract class Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Card Attributes
  private String name;
  private Cell startLocation;

  //Card Associations
//  private Game game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Card(String aName)
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
  /* Code from template association_GetOne */
//  public Game getGame()
//  {
//    return game;
//  }
//  /* Code from template association_SetOneToAtMostN */
//  public boolean setGame(Game aGame)
//  {
//    boolean wasSet = false;
//    //Must provide game to card
//    if (aGame == null)
//    {
//      return wasSet;
//    }
//
//    //game already at maximum (21)
//    if (aGame.numberOfCards() >= Game.maximumNumberOfCards())
//    {
//      return wasSet;
//    }
//    
//    Game existingGame = game;
//    game = aGame;
//    if (existingGame != null && !existingGame.equals(aGame))
//    {
//      boolean didRemove = existingGame.removeCard(this);
//      if (!didRemove)
//      {
//        game = existingGame;
//        return wasSet;
//      }
//    }
//    game.addCard(this);
//    wasSet = true;
//    return wasSet;
//  }

//  public void delete()
//  {
//    Game placeholderGame = game;
//    this.game = null;
//    if(placeholderGame != null)
//    {
//      placeholderGame.removeCard(this);
//    }
//  }


  public String toString()
  {
    return "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator");
  }

public Cell getStartLocation() {
	return startLocation;
}
}