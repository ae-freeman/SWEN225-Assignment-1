import java.util.ArrayList;
import java.util.Scanner;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/

// line 138 "model.ump"
// line 205 "model.ump"
public class Suggestion {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Suggestion Attributes
	private Card[] suggestion;
	private Player player;
	private ArrayList<Player> listOfPlayers;
	private Scanner scanner;

	// Suggestion Associations
	private Game game;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public Suggestion(Card[] guess, Player currentPlayer, ArrayList<Player> listOfPlayers) {
		suggestion = guess;
		player = currentPlayer;
		this.listOfPlayers = listOfPlayers;
		scanner = new Scanner(System.in);
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public String compareCards() {

		ArrayList<Card> matchingCards = new ArrayList<Card>();

		// while loop/other loop
		while (true) {
			// call next player on the current player
			// save player as the next player
			Player nextPlayer = player.getNextPlayer(player, listOfPlayers);
			for (int i = 0; i < nextPlayer.getHandLength(); i++) {
				for (int j = 0; j < 3; j++) {
					if (suggestion[j].getName() == nextPlayer.getPlayerHand().get(i).getName()) {
						// If match found, add to matching cards list
						matchingCards.add(nextPlayer.getPlayerHand().get(i));
					}
				}

			}

			// After that player's cards have all been considered, check if there are
			// multiple matching cards
			if (matchingCards.size() > 1) {
				System.out.println(
						"Player " + nextPlayer.getCharacterName() + " has " + matchingCards.size() + " matching cards.");
				for (int k = 0; k < matchingCards.size(); k++) {
					System.out.println(matchingCards.get(k).getName());
				}
				if (matchingCards.size() == 2) {
					System.out.println("Press 1 or 2 to select card to display\n");
				} else {
					System.out.println("Press 1 or 2 or 3 to select card to display\n");
				}
				int indexOfCardToDisplay = scanner.nextInt();
				return nextPlayer.getPlayerHand().get(indexOfCardToDisplay).getName();

				// Return the one matching card name
			} else if (matchingCards.size() == 1) {
				return matchingCards.get(0).getName();
			}

			// If no match found with that player, get next player
			nextPlayer = nextPlayer.getNextPlayer(nextPlayer, listOfPlayers);
			// If next player has arrived back to the original player, then break the loop
			if (nextPlayer.getCharacterName() == player.getCharacterName()) {
				break;
			}
		}

		// If no match found with any player
		return "No matching cards found";

	}

	public boolean setSuggestion(ArrayList aSuggestion) {
		boolean wasSet = false;
		suggestion = aSuggestion;
		wasSet = true;
		return wasSet;
	}

	public ArrayList getSuggestion() {
		return suggestion;
	}

	/* Code from template association_GetOne */
	public Game getGame() {
		return game;
	}

	/* Code from template association_SetOneToMany */
	public boolean setGame(Game aGame) {
		boolean wasSet = false;
		if (aGame == null) {
			return wasSet;
		}

		Game existingGame = game;
		game = aGame;
		if (existingGame != null && !existingGame.equals(aGame)) {
			existingGame.removeSuggestion(this);
		}
		game.addSuggestion(this);
		wasSet = true;
		return wasSet;
	}

	public void delete() {
		Game placeholderGame = game;
		this.game = null;
		if (placeholderGame != null) {
			placeholderGame.removeSuggestion(this);
		}
	}

	public String toString() {
		return super.toString() + "[" + "]" + System.getProperties().getProperty("line.separator") + "  " + "suggestion"
				+ "="
				+ (getSuggestion() != null
						? !getSuggestion().equals(this) ? getSuggestion().toString().replaceAll("  ", "    ") : "this"
						: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "game = "
				+ (getGame() != null ? Integer.toHexString(System.identityHashCode(getGame())) : "null");
	}
}