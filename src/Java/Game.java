import java.util.*;

public class Game {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Game Attributes
	private int numberOfPlayers;
	private boolean gameOver;
	private String[] roomList = { "Lounge", "Dining Room", "Kitchen", "Hall", "Conservatory", "Billiard Room",
			"Library", "Study", "Ballroom", "Hallway" };
	private String[] characterList = { "Mrs. White", "Mr. Green", "Mrs . Peacock", "Prof. Plum", "Miss Scarlett",
			"Col. Mustard" };
	private String[] weaponList = { "Pistol", "Rope", "Candlestick", "Wrench", "Leadpipe", "Dagger" };
	private ArrayList<Card> weapons;
	private ArrayList<Card> characters;
	private ArrayList<Card> rooms;
	private ArrayList<Room> roomObjects;
	private Card[] murderDeck;
	private Card[] guess;
	private Scanner scanner;

	// Game Associations
	private ArrayList<Player> listOfPlayers;
	private Suggestion suggestion;
	private Board board;
	private ArrayList<Card> deck;
	private Accusation accusation;

	public static void main(String[] args) {
		Game game = new Game();
		game.gameSetup();
		game.round();
	}

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	public Game() {
		board = new Board();
		numberOfPlayers = 0;
		listOfPlayers = new ArrayList<Player>();
		gameOver = false;
		weapons = new ArrayList<Card>();
		characters = new ArrayList<Card>();
		rooms = new ArrayList<Card>();
		roomObjects = new ArrayList<Room>();
		deck = new ArrayList<Card>();
		murderDeck = new Card[3];
		scanner = new Scanner(System.in);
		guess = new Card[3];
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	public void gameSetup() {
		// Sets the number of players
		System.out.println(
				"####################################################\n" +
				"#                                                  #\n" +
				"#      ####  #      #   #  #####  ####    ###      #\n" +
				"#     #      #      #   #  #      #   #  #   #     #\n" +
				"#     #      #      #   #  ###    #   #  #   #     #\n" +
				"#     #      #      #   #  #      #   #  #   #     #\n" +
				"#      ####  #####  #####  #####  ####    ###      #\n" +
				"#                                                  #\n" +
				"####################################################");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("How many players?");

		do { // loop until we have correct input
			System.out.println("Please enter a number between 3 and 6");
			try {
				numberOfPlayers = scanner.nextInt(); // Blocks for user input
				if (numberOfPlayers > 2 && numberOfPlayers < 7) {
					break; // Got valid input, stop looping
				} else {
					System.out.println("Please enter a number between 3 and 6");
					scanner.next(); // discard non-integer input
					continue; // restart loop, didn't get an integer input
				}

			} catch (final InputMismatchException e) {
				System.out.println("You have entered an invalid input. Try again.");
				scanner.next(); // discard non-integer input
				continue; // restart loop, didn't get an integer input
			}
		} while (true);
		
		System.out.println("\n------------------   GENERATING GAME   ------------------");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		listCreation();
		murderDeck();
		createDeck();
		generatePlayers();
		//This prints out where the weapons are
		for(int i = 0; i < weapons.size(); i++) {
			WeaponCard weapon = (WeaponCard) weapons.get(i);
			System.out.println("The " + weapon.getName() +" is in the : " + (weapon.getRoom()));
		}
		//
		//System.out.println("List of Players\n");
		//for (int i = 0; i < numberOfPlayers; i++) {
		//	System.out.println(listOfPlayers.get(i).getCharacterCard().getName());
		//}
		//System.out.println("\n");
	}

	private ArrayList<Player> generatePlayers() {
		CharacterCard character = null;
		// Instantiate new players with randomly assigned character card
		for (int i = 0; i < numberOfPlayers; i++) {

			while (true) {
				character = (CharacterCard) chooseRandom(characters);

				if (preventDoubleUps(character, listOfPlayers)) {
					break;
				}
			}
			Player player = new Player(character);
			int x = player.getCharacterCard().getStartLocation().getXValue();
			int y = player.getCharacterCard().getStartLocation().getYValue();
			board.getBoard()[x][y].setPlayer(player);

			listOfPlayers.add(player);
		}

		// Randomize cards in deck
		Collections.shuffle(deck);

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
		
		System.out.println("\n------------------   PLAYERS   ------------------");
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Player " + (i+1) + ": " + listOfPlayers.get(i).getCharacterCard().getName());
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		

		return listOfPlayers;
	}

	private boolean preventDoubleUps(Card card, ArrayList<?> list) {
		boolean freeCharacter = true;
		if (list.size() == 0) {
			return freeCharacter;
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Player){
				Player player = (Player) list.get(i);
				if(player.getCharacterCard().getName().equals(card.getName())) {
					freeCharacter = false;
					break;
				}
			}
			if (list.get(i) instanceof Card){
				WeaponCard compare = (WeaponCard) list.get(i);
				if(compare.getRoom().equals(((WeaponCard)card).getRoom())) {
					freeCharacter = false;
					break;
				}
			}
		}

		return freeCharacter;
	}

	public void murderDeck() {

		Card murderer = chooseRandom(characters);
		Card murderRoom = chooseRandom(rooms);
		Card murderWeapon = chooseRandom(weapons);
		murderDeck[0] = murderer;
		murderDeck[1] = murderRoom;
		murderDeck[2] = murderWeapon;

	}

	public Card chooseRandom(ArrayList<Card> list) {
		int rnd = new Random().nextInt(list.size());

		return list.get(rnd);
	}

	public void listCreation() {
		for (int i = 0; i <= roomList.length - 1; i++) {
			if(!roomList[i].equals("Hallway")) {
			RoomCard room = new RoomCard(roomList[i]);
			rooms.add(room);
			}
				Room roomObject = new Room(roomList[i]);
				roomObjects.add(roomObject);

		}
		for (int i = 0; i <= weaponList.length - 1; i++) {
            WeaponCard weapon = new WeaponCard(weaponList[i], chooseRandom(rooms).getName());
            while(!preventDoubleUps(weapon, weapons)) {
            	weapon = new WeaponCard(weaponList[i], chooseRandom(rooms).getName());
            }
            weapons.add(weapon);
        }
		board.populateBoard(roomObjects);
		characters.add(new CharacterCard("Mrs. White", board.getBoard()[9][0]));
		characters.add(new CharacterCard("Mr. Green", board.getBoard()[14][0]));
		characters.add(new CharacterCard("Mrs. Peacock", board.getBoard()[23][6]));
		characters.add(new CharacterCard("Prof. Plum", board.getBoard()[23][19]));
		characters.add(new CharacterCard("Miss Scarlett", board.getBoard()[7][24]));
		characters.add(new CharacterCard("Col. Mustard", board.getBoard()[0][17]));

	}

	// COMBINE CARD LISTS
	public void createDeck() {

		// combine weapons, rooms, characters
		deck.addAll(weapons);
		deck.addAll(characters);
		deck.addAll(rooms);

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

	// Main play method

	public void round() {
		// Check game is not over
		int inActive = 0; // amount of inactive players
		while (!gameOver) {
			
			// Check that there is more than one player in the game
			for (int i = 0; i < listOfPlayers.size(); i++) {
				if (gameOver){
					break;
				}
				Player player = listOfPlayers.get(i);
				if(player.getPlayerStatus()) {
					inActive += 1;
				}
				// Check player is still active (i.e. hasn't made an incorrect accusation)
				// If there is only one player
				if (inActive == listOfPlayers.size() - 1) {
					gameOver = true;
					System.out.println("Game Over!");
					break;
				}
				//if the player isn't out
				if (!player.getPlayerStatus()) {
					System.out.println("Press ENTER to continue");
					try {
						System.in.read();
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("It is " + player.getCharacterCard().getName() + "'s turn!\n");
					System.out.println("\n------------------   "+ player.getCharacterCard().getName() + "'s hand:   ------------------\n");
					for (int j = 0; j < player.getHand().size(); j++) {
						System.out.println(player.getHand().get(j).getName());
					}
					System.out.println();
					//run and print out roll
					int roll = rollDice();
					System.out.println("You rolled a " + roll + "!\n");
					//run the move method for a player
					player.movePlayer(roll, board);
					//if after a player has finished moving and they are in a room
					if (!player.getCell().getRoom().getName().equals("Hallway")) {
						//allow them to make a suggestion or an accusation
						int action = action();
						// If they make a suggestion
						if (action == 1) {
							// Print out player's hand
							player.printHand();
							//Collate the user's guess
							if (suggestion(player)){
								int actionChoice;
								System.out.println(
										"Press 1 to make an accusation\n" + "Press 2 to do nothing\n");

								do { // loop until we have correct input
									System.out.println("Please enter 1 or 2");
									try {
										actionChoice = scanner.nextInt(); // Blocks for user input
										if (actionChoice > 0 && actionChoice < 3) {
											break; // Got valid input, stop looping
										} else {
											System.out.println("Please enter 1 or 2");
											scanner.next(); // discard non-integer input
											continue; // restart loop, didn't get an integer input
										}

									} catch (final InputMismatchException e) {
										System.out.println("You have entered an invalid input. Try again.");
										scanner.next(); // discard non-integer input
										continue; // restart loop, didn't get an integer input
									}
								} while (true);
								if (actionChoice == 1){
									if (accusation(player)){
										gameOver = true;
										break;
									}
								}
								else {
									break;
								}
							}
						}
						// if they make an accusation run the accusation method
						if (action == 2) {
							if (accusation(player)){
								gameOver = true;
								break;
							}
						}
					} else {
						System.out.println("Turn over");
					}

				}

			}

		}

	}

	public boolean accusation(Player player) {
		guess[0] = characters.get(guess(characters));
		guess[1] = rooms.get(guess(rooms));
		guess[2] = weapons.get(guess(weapons));
		Accusation accusation = new Accusation(guess, murderDeck);
		boolean accusationResult = accusation.checkAccusation(player);
		System.out.println("Accusation result: " + accusationResult);
		if (accusationResult) {
			board.getBoard()[player.getCell().getXValue()][player.getCell().getYValue()].setIsAccessible(true);
			return true;

		} 
		player.setPlayerStatus(false);
		return false;
	}
	
	public boolean suggestion(Player player) {
		guess[0] = characters.get(guess(characters));
		guess[1] = weapons.get(guess(weapons));
		String roomGuess = player.getRoom();
		int j = 0;
		while (rooms.get(j).getName() != roomGuess) {
			j++;
		}
		guess[2] = rooms.get(j);
		//create a suggestion and compare the cards
		Suggestion suggestion = new Suggestion(guess, player, listOfPlayers);


		if (!suggestion.runSuggestion()){
			return true;
		}
		return false;

	}

	public int rollDice() {
		int die1 = (int) (Math.random() * 5 + 1);
		int die2 = (int) (Math.random() * 5 + 1);

		return die1 + die2;
	}

	public int action() {
		int actionChoice;
		System.out.println(
				"Press 1 to make a suggestion\n" + "Press 2 to make an accusation\n" + "Press 3 to do nothing\n");

		do { // loop until we have correct input
			System.out.println("Please enter 1, 2 or 3");
			try {
				actionChoice = scanner.nextInt(); // Blocks for user input
				if (actionChoice > 0 && actionChoice < 4) {
					break; // Got valid input, stop looping
				} else {
					System.out.println("Please enter 1, 2 or 3");
					scanner.next(); // discard non-integer input
					continue; // restart loop, didn't get an integer input
				}

			} catch (final InputMismatchException e) {
				System.out.println("You have entered an invalid input. Try again.");
				scanner.next(); // discard non-integer input
				continue; // restart loop, didn't get an integer input
			}
		} while (true);

		return actionChoice;

	}

	public int guess(ArrayList<Card> list) {
		System.out.println("---------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Press " + i + " for: " + list.get(i).getName() + "\n");
		}
		do {
			System.out.println("Please enter your selection");
			while (!scanner.hasNextInt() && scanner.nextInt() >= list.size()) {
				System.out.println("Please enter an integer between 0 and " + list.size());
				scanner.hasNext();
			}
			return scanner.nextInt();
		} while (scanner.nextInt() < 0 || scanner.nextInt() > list.size());
	}

	public boolean setNumberOPlayers(int aNumberOPlayers) {
		boolean wasSet = false;
		numberOfPlayers = aNumberOPlayers;
		wasSet = true;
		return wasSet;
	}

	public boolean setGameOver(boolean aGameOver) {
		boolean wasSet = false;
		gameOver = aGameOver;
		wasSet = true;
		return wasSet;
	}

	public boolean setScanner(Scanner aScanner) {
		boolean wasSet = false;
		scanner = aScanner;
		wasSet = true;
		return wasSet;
	}

	public int getNumberOPlayers() {
		return numberOfPlayers;
	}

	public boolean getGameOver() {
		return gameOver;
	}

	public ArrayList<Card> getWeapons() {
		return weapons;
	}

	public ArrayList<Card> getCharacters() {
		return characters;
	}

	public ArrayList<Card> getRooms() {
		return rooms;
	}

	public Scanner getScanner() {
		return scanner;
	}

	/* Code from template attribute_IsBoolean */
	public boolean isGameOver() {
		return gameOver;
	}

	/* Code from template association_GetMany */
	public Player getPlayer(int index) {
		Player aPlayer = listOfPlayers.get(index);
		return aPlayer;
	}

	public List<Player> getPlayers() {
		List<Player> newPlayers = Collections.unmodifiableList(listOfPlayers);
		return newPlayers;
	}

	public int numberOfPlayers() {
		int number = listOfPlayers.size();
		return number;
	}

	public boolean hasPlayers() {
		boolean has = listOfPlayers.size() > 0;
		return has;
	}

	public int indexOfPlayer(Player aPlayer) {
		int index = listOfPlayers.indexOf(aPlayer);
		return index;
	}

	/* Code from template association_GetOne */
	public Suggestion getSuggestion() {
		return suggestion;
	}

	public boolean hasSuggestion() {
		boolean has = suggestion != null;
		return has;
	}

	/* Code from template association_GetOne */
	public Board getBoard() {
		return board;
	}

	/* Code from template association_GetOne */
	public Accusation getAccusation() {
		return accusation;
	}

	public boolean hasAccusation() {
		boolean has = accusation != null;
		return has;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfPlayers() {
		return 3;
	}

	/* Code from template association_MaximumNumberOfMethod */
	public static int maximumNumberOfPlayers() {
		return 6;
	}

	/* Code from template association_AddUnidirectionalMN */
	public boolean addPlayer(Player aPlayer) {
		boolean wasAdded = false;
		if (listOfPlayers.contains(aPlayer)) {
			return false;
		}
		if (numberOfPlayers() < maximumNumberOfPlayers()) {
			listOfPlayers.add(aPlayer);
			wasAdded = true;
		}
		return wasAdded;
	}

	public boolean removePlayer(Player aPlayer) {
		boolean wasRemoved = false;
		if (!listOfPlayers.contains(aPlayer)) {
			return wasRemoved;
		}

		if (numberOfPlayers() <= minimumNumberOfPlayers()) {
			return wasRemoved;
		}

		listOfPlayers.remove(aPlayer);
		wasRemoved = true;
		return wasRemoved;
	}

	/* Code from template association_SetUnidirectionalMN */
	public boolean setPlayers(Player... newPlayers) {
		boolean wasSet = false;
		ArrayList<Player> verifiedPlayers = new ArrayList<Player>();
		for (Player aPlayer : newPlayers) {
			if (verifiedPlayers.contains(aPlayer)) {
				continue;
			}
			verifiedPlayers.add(aPlayer);
		}

		if (verifiedPlayers.size() != newPlayers.length || verifiedPlayers.size() < minimumNumberOfPlayers()
				|| verifiedPlayers.size() > maximumNumberOfPlayers()) {
			return wasSet;
		}

		listOfPlayers.clear();
		listOfPlayers.addAll(verifiedPlayers);
		wasSet = true;
		return wasSet;
	}

	/* Code from template association_AddIndexControlFunctions */
	public boolean addPlayerAt(Player aPlayer, int index) {
		boolean wasAdded = false;
		if (addPlayer(aPlayer)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfPlayers()) {
				index = numberOfPlayers() - 1;
			}
			listOfPlayers.remove(aPlayer);
			listOfPlayers.add(index, aPlayer);
			wasAdded = true;
		}
		return wasAdded;
	}

	public boolean addOrMovePlayerAt(Player aPlayer, int index) {
		boolean wasAdded = false;
		if (listOfPlayers.contains(aPlayer)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfPlayers()) {
				index = numberOfPlayers() - 1;
			}
			listOfPlayers.remove(aPlayer);
			listOfPlayers.add(index, aPlayer);
			wasAdded = true;
		} else {
			wasAdded = addPlayerAt(aPlayer, index);
		}
		return wasAdded;
	}

	/* Code from template association_SetUnidirectionalOptionalOne */
	public boolean setSuggestion(Suggestion aNewSuggestion) {
		boolean wasSet = false;
		suggestion = aNewSuggestion;
		wasSet = true;
		return wasSet;
	}

	/* Code from template association_SetUnidirectionalOne */
	public boolean setBoard(Board aNewBoard) {
		boolean wasSet = false;
		if (aNewBoard != null) {
			board = aNewBoard;
			wasSet = true;
		}
		return wasSet;
	}

	/* Code from template association_RequiredNumberOfMethod */
	public static int requiredNumberOfCards() {
		return 21;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfCards() {
		return 21;
	}

	/* Code from template association_MaximumNumberOfMethod */
	public static int maximumNumberOfCards() {
		return 21;
	}

	/* Code from template association_SetUnidirectionalOptionalOne */
	public boolean setAccusation(Accusation aNewAccusation) {
		boolean wasSet = false;
		accusation = aNewAccusation;
		wasSet = true;
		return wasSet;
	}

	public void delete() {
		listOfPlayers.clear();
		suggestion = null;
		board = null;
		deck = null;
		accusation = null;
	}

	public String toString() {
		return super.toString() + "[" + "numberOPlayers" + ":" + getNumberOPlayers() + "," + "gameOver" + ":"
				+ getGameOver() + "]" + System.getProperties().getProperty("line.separator") + "  " + "weapons" + "="
				+ (getWeapons() != null
						? !getWeapons().equals(this) ? getWeapons().toString().replaceAll("  ", "    ") : "this"
						: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "characters" + "="
				+ (getCharacters() != null
						? !getCharacters().equals(this) ? getCharacters().toString().replaceAll("  ", "    ") : "this"
						: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "rooms" + "="
				+ (getRooms() != null
						? !getRooms().equals(this) ? getRooms().toString().replaceAll("  ", "    ") : "this"
						: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "scanner" + "="
				+ (getScanner() != null
						? !getScanner().equals(this) ? getScanner().toString().replaceAll("  ", "    ") : "this"
						: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "suggestion = "
				+ (getSuggestion() != null ? Integer.toHexString(System.identityHashCode(getSuggestion())) : "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "board = "
				+ (getBoard() != null ? Integer.toHexString(System.identityHashCode(getBoard())) : "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "accusation = "
				+ (getAccusation() != null ? Integer.toHexString(System.identityHashCode(getAccusation())) : "null");
	}
}
