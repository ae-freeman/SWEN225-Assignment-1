//package Java;

/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/

import java.util.*;

/**
 * Unable to update umple code due to error at null Unable to update umple code
 * due to error at null Unable to update umple code due to error at null Unable
 * to update umple code due to error at null Unable to update umple code due to
 * error at null Unable to update umple code due to error at null
 */
// line 8 "model.ump"
// line 148 "model.ump"
public class Game {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Game Attributes
	private Board board;
	private int numberOfPlayers = 0;
	private ArrayList<Player> listOfPlayers;
	private boolean gameOver;
	private String[] roomList = { "Lounge", "Dining Room", "Kitchen", "Hall", "Conservatory", "Billiard Room",
			"Library", "Study", "Ballroom" };
	private String[] characterList = { "Mrs. White", "Mr. Green", "Mrs . Peacock", "Prof. Plum", "Miss Scarlett",
			"Col. Mustard" };
	private String[] weaponList = { "Pistol", "Rope", "Candlestick", "Wrench", "Leadpipe", "Dagger" };
	private ArrayList<Card> weapons;
	private ArrayList<Card> characters;
	private ArrayList<Card> rooms;
	private ArrayList<Card> deck;
	private Card[] murderDeck;
	private Card[] guess;
	private Scanner scanner;

	// Game State Machines
	public enum List {
		PISTOL, ROPE, CANDLESTICK, WRENCH, LEADPIPE, DAGGER
	}

	private List list;

	// Game Associations
	private ArrayList<Player> players;
	private ArrayList<Suggestion> suggestions;
	private Board gameBoard;
	private ArrayList<Card> cards;
	private ArrayList<Accusation> accusations;

	public static void main(String[] args) { // use the "..." syntax!
		Game game = new Game();
		game.gameSetup();
	}

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

//	public Game(Board aGameBoard, ArrayList aListOfPlayers, boolean aGameOver, ArrayList<WeaponCard> aWeapons,
//				ArrayList<CharacterCard> aCharacters, ArrayList<RoomCard> aRooms, ArrayList aMurderDeck, Board aBoard) {
//		gameBoard = aGameBoard;
//		numberOPlayers = 0;
//		listOfPlayers = aListOfPlayers;
//		gameOver = aGameOver;
//		weapons = aWeapons;
//		characters = aCharacters;
//		rooms = aRooms;
//		murderDeck = aMurderDeck;
//		scanner = new Scanner(System.in);
//		ArrayList<Player> players = new ArrayList<Player>();
//		ArrayList<Suggestion> suggestions = new ArrayList<Suggestion>();
//		if (aBoard == null || aBoard.getGame() != null) {
//			throw new RuntimeException(
//					"Unable to create Game due to aBoard. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
//		}
//		board = aBoard;
//		cards = new ArrayList<Card>();
//		accusations = new ArrayList<Accusation>();
//		setList(List.PISTOL);
//	}

	public Game() {
		board = new Board();
		numberOfPlayers = 0;
		listOfPlayers = new ArrayList<Player>();
		gameOver = false;
		weapons = new ArrayList<Card>(); // ? WeaponCard
		characters = new ArrayList<Card>(); // ? CharacterCard;
		rooms = new ArrayList<Card>(); // RoomCard;
		deck = new ArrayList<Card>();
		murderDeck = new Card[3]; // <? extends Card>
		scanner = new Scanner(System.in);
		suggestions = new ArrayList<Suggestion>();
		guess = new Card[3];
		cards = new ArrayList<Card>();
		accusations = new ArrayList<Accusation>();
	}

	/* Oliver's code begins */

	/**
	 * Takes player through suggestion / accusation phase of the turn
	 */
//	public void makeSuggestion() {
//
//		// Need to set current player
//
//		String input;
//		RoomCard suggestedRoom;
//		CharacterCard suggestedCharacter;
//		WeaponCard suggestedWeapon;
//		Boolean validInput = false;
//		while (true) {
//			System.out.println("Enter 's' to make a suggestion, or 'a' to make an accusation:");
//			input = scanner.nextLine();
//			if (input.equals("s") || input.equals("a")) {
//				// Ask player for Weapon, Room and Character
//				while (true) {
//					System.out.println("Suggested Weapon: ");
//					input = scanner.nextLine();
//					if (Arrays.stream(weaponList).anyMatch(input :: equals)) {
//						suggestedWeapon = new WeaponCard(input);
//						break;
//					}
//				}
//
//				while (true) {
//					System.out.println("Suggested Room: ");
//					input = scanner.nextLine();
//					if (Arrays.stream(roomList).anyMatch(input :: equals)) {
//						suggestedRoom = new RoomCard(input);
//						break;
//					}
//				}
//
//				while (true) {
//					System.out.println("Suggested Character: ");
//					input = scanner.nextLine();
//					if (Arrays.stream(characterList).anyMatch(input :: equals)){
//						suggestedCharacter = new CharacterCard(input);
//						break;
//					}
//				}
//
//
//				// Check if other players have any of those cards
//				int numMatches = 0;
//				ArrayList<Card> suggestionList = new ArrayList<Card>();
//				suggestionList.add(suggestedWeapon);
//				suggestionList.add(suggestedRoom);
//				suggestionList.add(suggestedCharacter);
//
//				if (input.equals("s")) {
//					showMatchingCards(suggestionList);
//				} else if (input.equals("a")) {
//					makeAccusation(suggestionList);
//				}
//
//
//				// Current player presses button to end turn
//				break;
//			}
//			scanner.next();
//		}
//	}
//
//	/**
//	 * Returns and arrayList of matching cards from a player's hand
//	 * @param suggestions the cards being suggested
//	 * @param playerHand the hand being checked
//	 * @return all matching cards
//	 */
//	public ArrayList<Card> getMatchingCards(ArrayList<Card> suggestions, ArrayList<Card> playerHand) {
//		ArrayList<Card> matchedCards = new ArrayList<Card>();
//		// Check if weapon
//		for (int i = 0; i < playerHand.size(); i++) {
//			if (playerHand.get(i).equals(suggestions.get(0))) {
//				matchedCards.add(card[0]);
//			}
//		}
//
//		// Check if room
//		for (int i = 0; i < playerHand.size(); i++) {
//			if (playerHand.get(i).equals(suggestions.get(1))) {
//				matchedCards.add(card[1]);
//			}
//		}
//
//		// Check if character
//		for (int i = 0; i < playerHand.size(); i++) {
//			if (playerHand.get(i).equals(suggestions.get(2))) {
//				matchedCards.add(card[0]);
//			}
//		}
//
//		return matchedCards;
//	}
//
//	/**
//	 * Executes part of game where a matching card is revealed to the suggestor
//	 * @param suggestionList list of cards being suggested
//	 */
//	public void showMatchingCards(ArrayList<Card> suggestionList) {
//		ArrayList<Card> matchedCards = new ArrayList<Card>();
//		String playerWithMatch = "";
//		for (int i = 0; i < listOfPlayers.size() && numMatches == 0; i++) {
//			if (matchedCards.size() == 0) {
//				matchedCards.addAll(getMatchingCards(
//						suggestionList, listOfPlayers.get(i).getHand));
//				if (matchedCards.size() > 0) {
//					playerWithMatch = listOfPlayers.get(i).getName();
//					if (matchedCards.size() > 1) {
//						System.out.println("Your hand contains the following cards from the suggestion: ");
//						matchedCards.stream().forEach(Card -> System.out.println(Card.getName()));
//						System.out.println("Type the number of the card you wish to show: ");
//						// Display the card
//
//					} else {
//						// Display card
//					}
//				} else {
//					System.out.println("No player has your suggested cards in their hand");
//				}
//			}
//		}
//	}
//
//	/**
//	 * Executes final part of accusation
//	 * @param suggestionList list of cards in the accusation
//	 */
//	public void makeAccusation(ArrayList<Card> suggestionList) {
//		ArrayList<Card> matchedCards = new ArrayList<Card>();
//		Card[] accusation = {suggestionList.get(0), suggestionList.get(1), suggestionList.get(2)};
//		Arrays.sort(accusation);
//		Arrays.sort(murderDeck);
//		if (accusation.equals(murderDeck)) {
//			// End game, player wins
//		} else {
//			// Player is 'out', end of turn
//		}
//
//	}
	/* Oliver's code ends */

//	Jude's Code Begins

	public void turn() {
		while (!gameOver) {
			for (Player player : listOfPlayers) {
				int active = 0; // amount of active players
				if (player.getPlayerStatus()) {
					active++;
				}
				if (active == 1) {
					gameOver = true;
					break;
				}
				if (!player.getPlayerStatus()) {
					System.out.println("It's " + player.getCharacterName() + "'s turn");
					int roll = rollDice();
					System.out.println(player.getCharacterName() + " rolled a " + roll);
					
					
					player.movePlayer(roll, player, board);
//					while (roll > 0) {
//						
//						 // move method return roll? so if they reach a room they can end loop
//					}
					int action = action();
					if (action == 1 || action == 2) {
						guess[0] = characters.get(guess(characters));
						guess[1] = rooms.get(guess(rooms));
						guess[2] = weapons.get(guess(weapons));
						if (action == 1) {
							Suggestion suggestion = new Suggestion(guess, player, listOfPlayers);
							// Call compare method inside suggestion class
							String matchResult = suggestion.compareCards();
							System.out.println("Match result: " + matchResult);
						}
						if (action == 2) {
							Accusation accusation = new Accusation(guess, murderDeck);
							boolean accusationResult = accusation.checkAccusation();
							System.out.println("Accusation result: " + accusationResult);
							if (accusationResult) {
								gameOver = true;
								System.out.println("Player " + player.getCharacterName() + " wins!");
							} else {
								player.setPlayerStatus();
								System.out.println("Player " + player.getCharacterName() + " is out!");
							}
						}
					}
				}
			}
		}

	}

	public int rollDice() {
		int die = new Random().nextInt(6);
		int die2 = new Random().nextInt(6);
		return die + die2;
	}

	public int action() {
		System.out.println(
				"Press 1 to make a suggestion;/n" + "Press 2 to make an accusation/n" + "Press 3 to do nothing/n");
		do {
			System.out.println("Please enter your action");
			while (!scanner.hasNextInt()) {
				System.out.println("Please enter an integer between 1 and 3");
				scanner.hasNext();
			}
			return scanner.nextInt();
		} while (scanner.nextInt() < 1 || scanner.nextInt() > 3);
	}

	public int guess(ArrayList<? extends Card> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Press " + i + "for: " + list.get(i) + "/n");
		}
		do {
			System.out.println("Please enter your selection");
			while (!scanner.hasNextInt()) {
				System.out.println("Please enter an integer between 0 and " + list.size());
				scanner.hasNext();
			}
			return scanner.nextInt();
		} while (scanner.nextInt() < 0 || scanner.nextInt() > list.size());
	}
// Jude's code ends

	// ------------------------
	// INTERFACE
	// ------------------------
	// line 27 "model.ump"
	public void gameSetup() {
		System.out.println("Welcome to Cluedo!");
		// Sets the number of players
		System.out.println("How many players?");
		while (true && (numberOfPlayers < 3 || numberOfPlayers > 6)) {
			System.out.println("Please enter a number between 3 and 6");
			try {
				numberOfPlayers = scanner.nextInt();

			} catch (InputMismatchException e) {
				throw new InputMismatchException("Please enter an integer");
			}
//			scanner.next();
		}

		
		listCreation();
		murderDeck();
		createDeck();
		generatePlayers();
		System.out.println("List of Players\n");
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println(listOfPlayers.get(i).getCharacterName());
		}
		
		turn();
//		while (!gameOver) {	
//			for (Player p : generatePlayers()){
//				
//			doMove(scanner, listOfPlayers);
//		}

//		
//		testSuggestion();
	}

	public void testSuggestion() {
		System.out.println("Next player:\n");
		System.out.println(listOfPlayers.get(1).getNextPlayer(listOfPlayers.get(1), listOfPlayers));

		guess[0] = characters.get(0);
		guess[1] = rooms.get(0);
		guess[2] = weapons.get(0);

		System.out.println("Suggestion");
		for (int i = 0; i < 3; i++) {
			System.out.println(guess[i].getName());
		}

		Suggestion suggestion = new Suggestion(guess, listOfPlayers.get(0), listOfPlayers);
		// Call compare method inside suggestion class
		String matchResult = suggestion.compareCards();
		System.out.println("Match result: " + matchResult);

		Accusation accusation = new Accusation(guess, murderDeck);
		boolean accusationResult = accusation.checkAccusation();
		System.out.println("Accusation result: " + accusationResult);

	}

	private ArrayList<Player> generatePlayers() {
//		ArrayList<Card> playerHand;
//		ArrayList<ArrayList<Card>> listOfHands = new ArrayList<ArrayList<Card>>();

		// Instantiate new players with randomly assigned character card
		for (int i = 0; i < numberOfPlayers; i++) {
			CharacterCard character = (CharacterCard) chooseRandom(characters);
			Player player = new Player(character);
			listOfPlayers.add(player);
		}

		// Randomise cards in deck
		Collections.shuffle(deck);
//		CHECK:
//		System.out.println("Shuffled deck: " + deck);

		// Assign player hand from shuffled deck
		int currentCardIndex = 0;
		int currentPlayerIndex = 0;

		while (currentCardIndex < 18) {

			listOfPlayers.get(currentPlayerIndex).addToHand(deck.get(currentCardIndex));

			currentCardIndex++;

			if (currentPlayerIndex == numberOfPlayers - 1) {
				currentPlayerIndex = 0;
			} else {
				currentPlayerIndex++;
			}
		}

		// Print out each player's hand
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println(listOfPlayers.get(i).getCharacterName() + "'s hand:\n");
			System.out.println(listOfPlayers.get(i).getPlayerHand());
		}

		return listOfPlayers;
	}

	public void murderDeck() {
		Card murderer = chooseRandom(characters);
		Card murderRoom = chooseRandom(rooms);
		Card murderWeapon = chooseRandom(weapons);
		murderDeck[0] = murderer;
		murderDeck[1] = murderRoom;
		murderDeck[2] = murderWeapon;

		///// FOR TESTING: /////

//		murderDeck[0] = characters.get(0);
//		murderDeck[1] = rooms.get(0);
//		murderDeck[2] = weapons.get(0);

	}

	// line 50 "model.ump"
	public Card chooseRandom(ArrayList<? extends Card> list) {
		int rnd = new Random().nextInt(list.size());
		return list.get(rnd);
	}

	// line 52 "model.ump"
	public void listCreation() {
		for (int i = 0; i <= weaponList.length - 1; i++) {
			WeaponCard weapon = new WeaponCard(weaponList[i]);
			weapons.add(weapon);
		}
		for (int i = 0; i <= roomList.length - 1; i++) {
			RoomCard room = new RoomCard(roomList[i]);
			rooms.add(room);
		}
		for (int i = 0; i <= characterList.length - 1; i++) {
			int x = 0;
			int y = 0;
			CharacterCard character = new CharacterCard(characterList[i], new Cell(x, y));
			// add in starting positions
			characters.add(character);
		}
	}

	// COMBINE CARD LISTS
	public void createDeck() {

		// combine weapons, rooms, characters
		deck.addAll(weapons);
		deck.addAll(characters);
		deck.addAll(rooms);

		// CHECK:
//		System.out.println(deck);

		int totalCards = 21;

		// REMOVE MURDER DECK CARDS
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < totalCards; j++) {
				if (deck.get(j).getName().equals(murderDeck[i].getName())) {
					deck.remove(j);
					totalCards -= 1;
					break;
				}
			}

		}

	}

//	public void doMove(Scanner scanner, ArrayList<Player> players){
//
//		boolean isTurn = false;
//		Player currentPlayer;
//
//		for (Player p : players){
//			if (players.get(p).getAssignedCharacter().getName().equals("Miss Scarlett")){
//				currentPlayer = p;
//			}
//
//			System.out.println("" + p.assignedCharacter.getName() + "'s turn");
//			if (p.getPlayerStatus()){
//				isTurn = true;
//
//				// generate dice roll
//				System.out.println("Rolling dice...");
//				int die1 = (int)(Math.random()*6) + 1;
//				int die2 = (int)(Math.random()*6) + 1;
//				int diceNum = die1+die2;
//
//				System.out.println("You have rolled a: " + diceNum);
//				//num of player moves
//				while (diceNum > 0){
//					System.out.println("Enter direction 'N,E,S,W' to move: ");
//					String input = scanner.nextLine();
//
//					if (input.equalsIgnoreCase("N")){
//						p.move(0, -1);
//					}
//					else if (input.equalsIgnoreCase("E")){
//						p.move(1, 0);
//					}
//					else if (input.equalsIgnoreCase("S")){
//						p.move(0, 1);
//					}
//					else if (input.equalsIgnoreCase("W")){
//						p.move(-1, 0);
//					}
//					else {
//						System.out.println("Error...");
//					}
//					diceNum--;
//				}
//
//				//Suggestion method
//
//
//				//Accusation method
//
//				//Ask user to confirm end of turn
//
//			}
//			else{
//				//endTurn
//			}
//		}
//	}
//	public boolean setGameBoard(Board aGameBoard) {
//		boolean wasSet = false;
//		gameBoard = aGameBoard;
//		wasSet = true;
//		return wasSet;
//	}
//
//	public boolean setNumberOPlayers(int aNumberOPlayers) {
//		boolean wasSet = false;
//		numberOPlayers = aNumberOPlayers;
//		wasSet = true;
//		return wasSet;
//	}
//
//	public boolean setListOfPlayers(ArrayList aListOfPlayers) {
//		boolean wasSet = false;
//		listOfPlayers = aListOfPlayers;
//		wasSet = true;
//		return wasSet;
//	}
//
//	public boolean setGameOver(boolean aGameOver) {
//		boolean wasSet = false;
//		gameOver = aGameOver;
//		wasSet = true;
//		return wasSet;
//	}
//
//	public boolean setWeapons(ArrayList<WeaponCard> aWeapons) {
//		boolean wasSet = false;
//		weapons = aWeapons;
//		wasSet = true;
//		return wasSet;
//	}
//
//	public boolean setCharacters(ArrayList<CharacterCard> aCharacters) {
//		boolean wasSet = false;
//		characters = aCharacters;
//		wasSet = true;
//		return wasSet;
//	}
//
//	public boolean setRooms(ArrayList<RoomCard> aRooms) {
//		boolean wasSet = false;
//		rooms = aRooms;
//		wasSet = true;
//		return wasSet;
//	}
//
//	public boolean setMurderDeck(ArrayList aMurderDeck) {
//		boolean wasSet = false;
//		murderDeck = aMurderDeck;
//		wasSet = true;
//		return wasSet;
//	}
//
//	public boolean setScanner(Scanner aScanner) {
//		boolean wasSet = false;
//		scanner = aScanner;
//		wasSet = true;
//		return wasSet;
//	}
//
//	public Board getGameBoard() {
//		return gameBoard;
//	}
//
//	public int getNumberOPlayers() {
//		return numberOPlayers;
//	}
//
//	public ArrayList getListOfPlayers() {
//		return listOfPlayers;
//	}
//
//	public boolean getGameOver() {
//		return gameOver;
//	}
//
//	public ArrayList<String> getRoomList() {
//		return rooms;
//	}
//
//	public ArrayList<WeaponCard> getWeapons() {
//		return weapons;
//	}
//
//	public ArrayList<CharacterCard> getCharacters() {
//		return characters;
//	}
//
//	public ArrayList<RoomCard> getRooms() {
//		return rooms;
//	}
//
//	public ArrayList getMurderDeck() {
//		return murderDeck;
//	}
//
//	public Scanner getScanner() {
//		return scanner;
//	}
//
//	/* Code from template attribute_IsBoolean */
//	public boolean isGameOver() {
//		return gameOver;
//	}
//
//	public String getListFullName() {
//		String answer = list.toString();
//		return answer;
//	}
//
//	public List getList() {
//		return list;
//	}
//
//	public boolean setList(List aList) {
//		list = aList;
//		return true;
//	}
//
//	/* Code from template association_GetMany */
//	public Player getPlayer(int index) {
//		Player aPlayer = players.get(index);
//		return aPlayer;
//	}
//
//	public ArrayList<Player> getPlayers() {
//		ArrayList<Player> newPlayers = (ArrayList<Player>) Collections.unmodifiableList(players);
//		return newPlayers;
//	}
//
//	public int numberOfPlayers() {
//		int number = players.size();
//		return number;
//	}
//
//	public boolean hasPlayers() {
//		boolean has = players.size() > 0;
//		return has;
//	}
//
//	public int indexOfPlayer(Player aPlayer) {
//		int index = players.indexOf(aPlayer);
//		return index;
//	}
//
//	/* Code from template association_GetMany */
//	public Suggestion getSuggestion(int index) {
//		Suggestion aSuggestion = suggestions.get(index);
//		return aSuggestion;
//	}
//
//	public ArrayList<Suggestion> getSuggestions() {
//		ArrayList<Suggestion> newSuggestions = (ArrayList<Suggestion>) Collections.unmodifiableList(suggestions);
//		return newSuggestions;
//	}
//
//	public int numberOfSuggestions() {
//		int number = suggestions.size();
//		return number;
//	}
//
//	public boolean hasSuggestions() {
//		boolean has = suggestions.size() > 0;
//		return has;
//	}
//
//	public int indexOfSuggestion(Suggestion aSuggestion) {
//		int index = suggestions.indexOf(aSuggestion);
//		return index;
//	}
//
//	/* Code from template association_GetOne */
//	public Board getBoard() {
//		return board;
//	}
//
//	/* Code from template association_GetMany */
//	public Card getCard(int index) {
//		Card aCard = cards.get(index);
//		return aCard;
//	}
//
//	public List<Card> getCards() {
//		List<Card> newCards = Collections.unmodifiableList(cards);
//		return newCards;
//	}
//
//	public int numberOfCards() {
//		int number = cards.size();
//		return number;
//	}
//
//	public boolean hasCards() {
//		boolean has = cards.size() > 0;
//		return has;
//	}
//
//	public int indexOfCard(Card aCard) {
//		int index = cards.indexOf(aCard);
//		return index;
//	}
//
//	/* Code from template association_GetMany */
//	public Accusation getAccusation(int index) {
//		Accusation aAccusation = accusations.get(index);
//		return aAccusation;
//	}
//
//	public List<Accusation> getAccusations() {
//		List<Accusation> newAccusations = Collections.unmodifiableList(accusations);
//		return newAccusations;
//	}
//
//	public int numberOfAccusations() {
//		int number = accusations.size();
//		return number;
//	}
//
//	public boolean hasAccusations() {
//		boolean has = accusations.size() > 0;
//		return has;
//	}
//
//	public int indexOfAccusation(Accusation aAccusation) {
//		int index = accusations.indexOf(aAccusation);
//		return index;
//	}
//
//	/* Code from template association_IsNumberOfValidMethod */
//	public boolean isNumberOfPlayersValid() {
//		boolean isValid = numberOfPlayers() >= minimumNumberOfPlayers()
//				&& numberOfPlayers() <= maximumNumberOfPlayers();
//		return isValid;
//	}
//
//	/* Code from template association_MinimumNumberOfMethod */
//	public static int minimumNumberOfPlayers() {
//		return 3;
//	}
//
//	/* Code from template association_MaximumNumberOfMethod */
//	public static int maximumNumberOfPlayers() {
//		return 6;
//	}
//
//	/* Code from template association_AddMNToOnlyOne */
//	public Player addPlayer(Character aAssignedCharacter, Cell aLocation, Hand aPlayerHand, boolean aPlayerStatus,
//							Cell aCell, CharacterCard aCharacterCard) {
//		if (numberOfPlayers() >= maximumNumberOfPlayers()) {
//			return null;
//		} else {
//			return new Player(aAssignedCharacter, aLocation, aPlayerHand, aPlayerStatus, this, aCell, aCharacterCard);
//		}
//	}
//
//	public boolean addPlayer(Player aPlayer) {
//		boolean wasAdded = false;
//		if (players.contains(aPlayer)) {
//			return false;
//		}
//		if (numberOfPlayers() >= maximumNumberOfPlayers()) {
//			return wasAdded;
//		}
//
//		Game existingGame = aPlayer.getGame();
//		boolean isNewGame = existingGame != null && !this.equals(existingGame);
//
//		if (isNewGame && existingGame.numberOfPlayers() <= minimumNumberOfPlayers()) {
//			return wasAdded;
//		}
//
//		if (isNewGame) {
//			aPlayer.setGame(this);
//		} else {
//			players.add(aPlayer);
//		}
//		wasAdded = true;
//		return wasAdded;
//	}
//
//	public boolean removePlayer(Player aPlayer) {
//		boolean wasRemoved = false;
//		// Unable to remove aPlayer, as it must always have a game
//		if (this.equals(aPlayer.getGame())) {
//			return wasRemoved;
//		}
//
//		// game already at minimum (3)
//		if (numberOfPlayers() <= minimumNumberOfPlayers()) {
//			return wasRemoved;
//		}
//		players.remove(aPlayer);
//		wasRemoved = true;
//		return wasRemoved;
//	}
//
//	/* Code from template association_AddIndexControlFunctions */
//	public boolean addPlayerAt(Player aPlayer, int index) {
//		boolean wasAdded = false;
//		if (addPlayer(aPlayer)) {
//			if (index < 0) {
//				index = 0;
//			}
//			if (index > numberOfPlayers()) {
//				index = numberOfPlayers() - 1;
//			}
//			players.remove(aPlayer);
//			players.add(index, aPlayer);
//			wasAdded = true;
//		}
//		return wasAdded;
//	}
//
//	public boolean addOrMovePlayerAt(Player aPlayer, int index) {
//		boolean wasAdded = false;
//		if (players.contains(aPlayer)) {
//			if (index < 0) {
//				index = 0;
//			}
//			if (index > numberOfPlayers()) {
//				index = numberOfPlayers() - 1;
//			}
//			players.remove(aPlayer);
//			players.add(index, aPlayer);
//			wasAdded = true;
//		} else {
//			wasAdded = addPlayerAt(aPlayer, index);
//		}
//		return wasAdded;
//	}
//
//	/* Code from template association_MinimumNumberOfMethod */
//	public static int minimumNumberOfSuggestions() {
//		return 0;
//	}
//
//	/* Code from template association_AddManyToOne */
//	public Suggestion addSuggestion(ArrayList aSuggestion) {
//		return new Suggestion(aSuggestion, this);
//	}
//
//	public boolean addSuggestion(Suggestion aSuggestion) {
//		boolean wasAdded = false;
//		if (suggestions.contains(aSuggestion)) {
//			return false;
//		}
//		Game existingGame = aSuggestion.getGame();
//		boolean isNewGame = existingGame != null && !this.equals(existingGame);
//		if (isNewGame) {
//			aSuggestion.setGame(this);
//		} else {
//			suggestions.add(aSuggestion);
//		}
//		wasAdded = true;
//		return wasAdded;
//	}
//
//	public boolean removeSuggestion(Suggestion aSuggestion) {
//		boolean wasRemoved = false;
//		// Unable to remove aSuggestion, as it must always have a game
//		if (!this.equals(aSuggestion.getGame())) {
//			suggestions.remove(aSuggestion);
//			wasRemoved = true;
//		}
//		return wasRemoved;
//	}
//
//	/* Code from template association_AddIndexControlFunctions */
//	public boolean addSuggestionAt(Suggestion aSuggestion, int index) {
//		boolean wasAdded = false;
//		if (addSuggestion(aSuggestion)) {
//			if (index < 0) {
//				index = 0;
//			}
//			if (index > numberOfSuggestions()) {
//				index = numberOfSuggestions() - 1;
//			}
//			suggestions.remove(aSuggestion);
//			suggestions.add(index, aSuggestion);
//			wasAdded = true;
//		}
//		return wasAdded;
//	}
//
//	public boolean addOrMoveSuggestionAt(Suggestion aSuggestion, int index) {
//		boolean wasAdded = false;
//		if (suggestions.contains(aSuggestion)) {
//			if (index < 0) {
//				index = 0;
//			}
//			if (index > numberOfSuggestions()) {
//				index = numberOfSuggestions() - 1;
//			}
//			suggestions.remove(aSuggestion);
//			suggestions.add(index, aSuggestion);
//			wasAdded = true;
//		} else {
//			wasAdded = addSuggestionAt(aSuggestion, index);
//		}
//		return wasAdded;
//	}
//
//	/* Code from template association_IsNumberOfValidMethod */
//	public boolean isNumberOfCardsValid() {
//		boolean isValid = numberOfCards() >= minimumNumberOfCards() && numberOfCards() <= maximumNumberOfCards();
//		return isValid;
//	}
//
//	/* Code from template association_RequiredNumberOfMethod */
//	public static int requiredNumberOfCards() {
//		return 21;
//	}
//
//	/* Code from template association_MinimumNumberOfMethod */
//	public static int minimumNumberOfCards() {
//		return 21;
//	}
//
//	/* Code from template association_MaximumNumberOfMethod */
//	public static int maximumNumberOfCards() {
//		return 21;
//	}
//
//	/* Code from template association_AddMNToOnlyOne */
//	public Card addCard(String aName) {
//		if (numberOfCards() >= maximumNumberOfCards()) {
//			return null;
//		} else {
//			return new Card(aName, this);
//		}
//	}
//
//	public boolean addCard(Card aCard) {
//		boolean wasAdded = false;
//		if (cards.contains(aCard)) {
//			return false;
//		}
//		if (numberOfCards() >= maximumNumberOfCards()) {
//			return wasAdded;
//		}
//
//		Game existingGame = aCard.getGame();
//		boolean isNewGame = existingGame != null && !this.equals(existingGame);
//
//		if (isNewGame && existingGame.numberOfCards() <= minimumNumberOfCards()) {
//			return wasAdded;
//		}
//
//		if (isNewGame) {
//			aCard.setGame(this);
//		} else {
//			cards.add(aCard);
//		}
//		wasAdded = true;
//		return wasAdded;
//	}
//
//	public boolean removeCard(Card aCard) {
//		boolean wasRemoved = false;
//		// Unable to remove aCard, as it must always have a game
//		if (this.equals(aCard.getGame())) {
//			return wasRemoved;
//		}
//
//		// game already at minimum (21)
//		if (numberOfCards() <= minimumNumberOfCards()) {
//			return wasRemoved;
//		}
//		cards.remove(aCard);
//		wasRemoved = true;
//		return wasRemoved;
//	}
//
//	/* Code from template association_MinimumNumberOfMethod */
//	public static int minimumNumberOfAccusations() {
//		return 0;
//	}
//
//	/* Code from template association_AddManyToOne */
//	public Accusation addAccusation(ArrayList aAccusation) {
//		return new Accusation(aAccusation, this);
//	}
//
//	public boolean addAccusation(Accusation aAccusation) {
//		boolean wasAdded = false;
//		if (accusations.contains(aAccusation)) {
//			return false;
//		}
//		Game existingGame = aAccusation.getGame();
//		boolean isNewGame = existingGame != null && !this.equals(existingGame);
//		if (isNewGame) {
//			aAccusation.setGame(this);
//		} else {
//			accusations.add(aAccusation);
//		}
//		wasAdded = true;
//		return wasAdded;
//	}
//
//	public boolean removeAccusation(Accusation aAccusation) {
//		boolean wasRemoved = false;
//		// Unable to remove aAccusation, as it must always have a game
//		if (!this.equals(aAccusation.getGame())) {
//			accusations.remove(aAccusation);
//			wasRemoved = true;
//		}
//		return wasRemoved;
//	}
//
//	/* Code from template association_AddIndexControlFunctions */
//	public boolean addAccusationAt(Accusation aAccusation, int index) {
//		boolean wasAdded = false;
//		if (addAccusation(aAccusation)) {
//			if (index < 0) {
//				index = 0;
//			}
//			if (index > numberOfAccusations()) {
//				index = numberOfAccusations() - 1;
//			}
//			accusations.remove(aAccusation);
//			accusations.add(index, aAccusation);
//			wasAdded = true;
//		}
//		return wasAdded;
//	}
//
//	public boolean addOrMoveAccusationAt(Accusation aAccusation, int index) {
//		boolean wasAdded = false;
//		if (accusations.contains(aAccusation)) {
//			if (index < 0) {
//				index = 0;
//			}
//			if (index > numberOfAccusations()) {
//				index = numberOfAccusations() - 1;
//			}
//			accusations.remove(aAccusation);
//			accusations.add(index, aAccusation);
//			wasAdded = true;
//		} else {
//			wasAdded = addAccusationAt(aAccusation, index);
//		}
//		return wasAdded;
//	}
//
//	public void delete() {
//		for (int i = players.size(); i > 0; i--) {
//			Player aPlayer = players.get(i - 1);
//			aPlayer.delete();
//		}
//		for (int i = suggestions.size(); i > 0; i--) {
//			Suggestion aSuggestion = suggestions.get(i - 1);
//			aSuggestion.delete();
//		}
//		Board existingBoard = board;
//		board = null;
//		if (existingBoard != null) {
//			existingBoard.delete();
//		}
//		for (int i = cards.size(); i > 0; i--) {
//			Card aCard = cards.get(i - 1);
//			aCard.delete();
//		}
//		for (int i = accusations.size(); i > 0; i--) {
//			Accusation aAccusation = accusations.get(i - 1);
//			aAccusation.delete();
//		}
//	}
//
//	// line 25 "model.ump"
//	public void playGame() {
//
//	}
//
//	public String toString() {
//		return super.toString() + "[" + "numberOPlayers" + ":" + getNumberOPlayers() + "," + "gameOver" + ":"
//				+ getGameOver() + "]" + System.getProperties().getProperty("line.separator") + "  " + "gameBoard" + "="
//				+ (getGameBoard() != null
//				? !getGameBoard().equals(this) ? getGameBoard().toString().replaceAll("  ", "    ") : "this"
//				: "null")
//				+ System.getProperties().getProperty("line.separator") + "  " + "listOfPlayers" + "="
//				+ (getListOfPlayers() != null
//				? !getListOfPlayers().equals(this) ? getListOfPlayers().toString().replaceAll("  ", "    ")
//				: "this"
//				: "null")
//				+ System.getProperties().getProperty("line.separator") + "  " + "roomList" + "="
//				+ (getRoomList() != null
//				? !getRoomList().equals(this) ? getRoomList().toString().replaceAll("  ", "    ") : "this"
//				: "null")
//				+ System.getProperties().getProperty("line.separator") + "  " + "weapons" + "="
//				+ (getWeapons() != null
//				? !getWeapons().equals(this) ? getWeapons().toString().replaceAll("  ", "    ") : "this"
//				: "null")
//				+ System.getProperties().getProperty("line.separator") + "  " + "characters" + "="
//				+ (getCharacters() != null
//				? !getCharacters().equals(this) ? getCharacters().toString().replaceAll("  ", "    ") : "this"
//				: "null")
//				+ System.getProperties().getProperty("line.separator") + "  " + "rooms" + "="
//				+ (getRooms() != null
//				? !getRooms().equals(this) ? getRooms().toString().replaceAll("  ", "    ") : "this"
//				: "null")
//				+ System.getProperties().getProperty("line.separator") + "  " + "murderDeck" + "="
//				+ (getMurderDeck() != null
//				? !getMurderDeck().equals(this) ? getMurderDeck().toString().replaceAll("  ", "    ") : "this"
//				: "null")
//				+ System.getProperties().getProperty("line.separator") + "  " + "scanner" + "="
//				+ (getScanner() != null
//				? !getScanner().equals(this) ? getScanner().toString().replaceAll("  ", "    ") : "this"
//				: "null")
//				+ System.getProperties().getProperty("line.separator") + "  " + "board = "
//				+ (getBoard() != null ? Integer.toHexString(System.identityHashCode(getBoard())) : "null");
//	}
	// ------------------------
	// DEVELOPER CODE - PROVIDED AS-IS
	// ------------------------

}
