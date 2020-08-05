//package Java;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5092.1e2e91fc6 modeling language!*/


import java.util.*;

// line 88 "model.ump"
// line 148 "model.ump"
public class Suggestion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Suggestion Attributes
  private Card[] suggestion;
  private ArrayList<Player> listOfPlayers;
  private Scanner scanner;
  
  //Suggestion Associations
  private Player player;

  //------------------------
  // CONSTRUCTOR
  //------------------------

	public Suggestion(Card[] guess, Player currentPlayer, ArrayList<Player> listOfPlayers) {
		suggestion = guess;
		player = currentPlayer;
		this.listOfPlayers = listOfPlayers;
		scanner = new Scanner(System.in);
	}

  //------------------------
  // INTERFACE
  //------------------------
	public String compareCards() {

		Player nextPlayer = player.getNextPlayer(player, listOfPlayers);
		//compare the guess with the next player's hand
		ArrayList<Card> matchingCards = compare(nextPlayer);
		// save player as the next player

		while (nextPlayer.getCharacterCard().getName() != player.getCharacterCard().getName()) {
			//if there were matching cards
			if(matchingCards.size() > 0) {
				System.out.println("Player " + nextPlayer.getCharacterCard().getName() + " has " + matchingCards.size() + " matching cards.");

				for (int k = 0; k < matchingCards.size(); k++) {
					//print out each matching card
					System.out.println(k + "." + matchingCards.get(k).getName( )+ "\n");
				}

				//if there is more than one card ask player to select
				if (matchingCards.size() > 1) {
					System.out.println("Please select which card to display");

					do{					
						System.out.println("Enter a number between 1 and " + matchingCards.size() + " to select the card \n");
						while(!scanner.hasNextInt()){
							System.out.println("Please enter an integer between " + matchingCards.size() +"and 3 \n");
							scanner.hasNext();
						}
						int indexOfCardToDisplay = scanner.nextInt();
						return nextPlayer.getHand().get(indexOfCardToDisplay).getName();
					}while (scanner.nextInt() < 1 || scanner.nextInt() > 3);

				}

				//if there is one matching card, return it
				else if (matchingCards.size() == 1) {
					return matchingCards.get(0).getName();
				}
			}
			// If no match found with that player, get next player
			nextPlayer = nextPlayer.getNextPlayer(nextPlayer, listOfPlayers);
		}
		// If no match found with any player
		return "No matching cards found";
	}

	public ArrayList<Card> compare(Player nextPlayer) {
		ArrayList<Card> matches = new ArrayList<Card>();
		for (int i = 0; i < nextPlayer.numberOfCards(); i++) {
			for (int j = 0; j < 3; j++) {
				if (suggestion[j].getName() == nextPlayer.getHand().get(i).getName()) {
					// If match found, add to matching cards list
					matches.add(nextPlayer.getHand().get(i));
				}
			}
		}
		return matches;
	}
  
  public Card[] getSuggestion()
  {
    Card[] newSuggestion = suggestion;
    return newSuggestion;
  }

  public int numberOfSuggestion()
  {
    int number = suggestion.length;
    return number;
  }

  public boolean hasSuggestion()
  {
    boolean has = suggestion.length > 0;
    return has;
  }
  /* Code from template association_GetOne */
  public Player getPlayer()
  {
    return player;
  }

  public void delete()
  {
    player = null;
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null");
  }
}