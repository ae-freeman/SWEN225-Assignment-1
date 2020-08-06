//package Java;




public class Accusation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Accusation Attributes
  private Card[] accusation;
  private Card[] murder;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Accusation(Card[] guess, Card[] murderDeck)
  {
    accusation = guess;
    murder = murderDeck;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean checkAccusation(Player player) {
	  for (int i = 0; i < 3; i++) {
		  if(accusation[i].getName() != murder[i].getName()) {
			  player.setPlayerStatus(false);
			  System.out.println("Player " + player.getCharacterCard().getName() + " is out!");
			  return false;
		  }
	  }
	  System.out.println("Player " + player.getCharacterCard().getName() + " wins!");

	  return true;
  }
  			
}