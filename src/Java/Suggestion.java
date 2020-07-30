/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/



// line 138 "model.ump"
// line 205 "model.ump"
public class Suggestion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Suggestion Attributes
  private Card[] suggestion;
  private Player player;

  //Suggestion Associations
  private Game game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Suggestion(Card[] guess, Player currentPlayer){
    suggestion = guess;
    player = currentPlayer;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSuggestion(ArrayList aSuggestion)
  {
    boolean wasSet = false;
    suggestion = aSuggestion;
    wasSet = true;
    return wasSet;
  }

  public ArrayList getSuggestion()
  {
    return suggestion;
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
      existingGame.removeSuggestion(this);
    }
    game.addSuggestion(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Game placeholderGame = game;
    this.game = null;
    if(placeholderGame != null)
    {
      placeholderGame.removeSuggestion(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "suggestion" + "=" + (getSuggestion() != null ? !getSuggestion().equals(this)  ? getSuggestion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null");
  }
}