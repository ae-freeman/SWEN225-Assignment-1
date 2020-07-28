package Java;

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
	private Board gameBoard;
	private int numberOfPlayers = 0;
	private ArrayList listOfPlayers;
	private boolean gameOver;
	String[] roomList = { "Lounge", "Dining Room", "Kitchen", "Hall", "Conservatory", "Billiard Room", "Library",
			"Study", "Ballroom", "Hallway" };
	String[] characterList = { "Mrs. White", "Mr. Green", "Mrs . Peacock", "Prof. Plum", "Miss Scarlett",
	"Col. Mustard" };
	String[] weaponList = { "Pistol", "Rope", "Candlestick", "Wrench", "Leadpipe", "Dagger" };
	private ArrayList<WeaponCard> weapons;
	private ArrayList<CharacterCard> characters;
	private ArrayList<RoomCard> rooms;
	private ArrayList<? extends Card> deck;
	private Card[] murderDeck;
	private Scanner scanner;

	// Game State Machines
	public enum List {
		PISTOL, ROPE, CANDLESTICK, WRENCH, LEADPIPE, DAGGER
	}

	private List list;

	// Game Associations
	private ArrayList<Player> players;
	private ArrayList<Suggestion> suggestions;
	private Board board;
	private ArrayList<Card> cards;
	private ArrayList<Accusation> accusations;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public Game(Board aGameBoard, ArrayList aListOfPlayers, boolean aGameOver, ArrayList<WeaponCard> aWeapons,
			ArrayList<CharacterCard> aCharacters, ArrayList<RoomCard> aRooms, ArrayList aMurderDeck, Board aBoard) {
		gameBoard = aGameBoard;
		numberOPlayers = 0;
		listOfPlayers = aListOfPlayers;
		gameOver = aGameOver;
		weapons = aWeapons;
		characters = aCharacters;
		rooms = aRooms;
		murderDeck = aMurderDeck;
		scanner = new Scanner(System.in);
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Suggestion> suggestions = new ArrayList<Suggestion>();
		if (aBoard == null || aBoard.getGame() != null) {
			throw new RuntimeException(
					"Unable to create Game due to aBoard. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
		board = aBoard;
		cards = new ArrayList<Card>();
		accusations = new ArrayList<Accusation>();
		setList(List.PISTOL);
	}

	public Game(Board aGameBoard, ArrayList aListOfPlayers, boolean aGameOver, ArrayList<WeaponCard> aWeapons, ArrayList<CharacterCard> aCharacters, ArrayList<RoomCard> aRooms, ArrayList aMurderDeck)
	{
		gameBoard = aGameBoard;
		numberOPlayers = 0;
		listOfPlayers = aListOfPlayers;
		gameOver = aGameOver;
		roomList = "Lounge", "Dining Room", "Kitchen", "Hall", "Conservatory", "Billiard Room", "Library", "Study", "Ballroom", "Hallway";
		weapons = aWeapons;
		characters = aCharacters;
		rooms = aRooms;
		murderDeck = aMurderDeck;
		scanner = new Scanner(System.in);
		players = new ArrayList<Player>();
		suggestions = new ArrayList<Suggestion>();
		board = new Board(this);
		cards = new ArrayList<Card>();
		accusations = new ArrayList<Accusation>();
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	// line 27 "model.ump"
	public void gameSetup() {
		// Sets the number of players
		System.out.println("How many players?");
		while (true && (numberOfPlayers < 3 || numberOfPlayers > 6)) {
			System.out.println("Please enter a number between 3 and 6");
			try {
				numberOfPlayers = scanner.nextInt();
			} catch (InputMismatchException e) {
				throw new InputMismatchException("Please enter an integer");
			}
			scanner.next();
		}
		generatePlayers();
		listCreation();
		createDeck();
		murderDeck();
	}

	public ArrayList<Player> generatePlayers() {
		for (int i = 0; i < numberOfPlayers; i++) {
			Card character = (CharacterCard) chooseRandom(characters); //??????????????????????????????? Casting?
			Player player = new Player(character);
			listOfPlayers.add(player);
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
		
	}
	// line 50 "model.ump"
	public Card chooseRandom(ArrayList<? extends Card> list) {
		int rnd = new Random().nextInt(list.size());
		return list.get(rnd);
	}

	// line 52 "model.ump"
	public void listCreation(){
		for(int i = 0; i <= weaponList.length; i++){
			WeaponCard weapon = new WeaponCard(weaponList[i]));
			weapons.add(weapon);
		}
		for(int i = 0; i <= roomList.length; i++){
			RoomCard room = new RoomCard(roomList[i]);
			rooms.add(room);
		}
		for(int i = 0; i <= characterList.length; i++){
			CharacterCard character = new CharacterCard(roomList[i], startPosList[i]);
			//add in starting positions
			characters.add(character);
		}
	}

	public boolean setGameBoard(Board aGameBoard) {
		boolean wasSet = false;
		gameBoard = aGameBoard;
		wasSet = true;
		return wasSet;
	}

	public boolean setNumberOPlayers(int aNumberOPlayers) {
		boolean wasSet = false;
		numberOPlayers = aNumberOPlayers;
		wasSet = true;
		return wasSet;
	}

	public boolean setListOfPlayers(ArrayList aListOfPlayers) {
		boolean wasSet = false;
		listOfPlayers = aListOfPlayers;
		wasSet = true;
		return wasSet;
	}

	public boolean setGameOver(boolean aGameOver) {
		boolean wasSet = false;
		gameOver = aGameOver;
		wasSet = true;
		return wasSet;
	}

	public boolean setWeapons(ArrayList<WeaponCard> aWeapons) {
		boolean wasSet = false;
		weapons = aWeapons;
		wasSet = true;
		return wasSet;
	}

	public boolean setCharacters(ArrayList<CharacterCard> aCharacters) {
		boolean wasSet = false;
		characters = aCharacters;
		wasSet = true;
		return wasSet;
	}

	public boolean setRooms(ArrayList<RoomCard> aRooms) {
		boolean wasSet = false;
		rooms = aRooms;
		wasSet = true;
		return wasSet;
	}

	public boolean setMurderDeck(ArrayList aMurderDeck) {
		boolean wasSet = false;
		murderDeck = aMurderDeck;
		wasSet = true;
		return wasSet;
	}

	public boolean setScanner(Scanner aScanner) {
		boolean wasSet = false;
		scanner = aScanner;
		wasSet = true;
		return wasSet;
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public int getNumberOPlayers() {
		return numberOPlayers;
	}

	public ArrayList getListOfPlayers() {
		return listOfPlayers;
	}

	public boolean getGameOver() {
		return gameOver;
	}

	public ArrayList<String> getRoomList() {
		return rooms;
	}

	public ArrayList<WeaponCard> getWeapons() {
		return weapons;
	}

	public ArrayList<CharacterCard> getCharacters() {
		return characters;
	}

	public ArrayList<RoomCard> getRooms() {
		return rooms;
	}

	public ArrayList getMurderDeck() {
		return murderDeck;
	}

	public Scanner getScanner() {
		return scanner;
	}

	/* Code from template attribute_IsBoolean */
	public boolean isGameOver() {
		return gameOver;
	}

	public String getListFullName() {
		String answer = list.toString();
		return answer;
	}

	public List getList() {
		return list;
	}

	public boolean setList(List aList) {
		list = aList;
		return true;
	}

	/* Code from template association_GetMany */
	public Player getPlayer(int index) {
		Player aPlayer = players.get(index);
		return aPlayer;
	}

	public ArrayList<Player> getPlayers() {
		ArrayList<Player> newPlayers = (ArrayList<Player>) Collections.unmodifiableList(players);
		return newPlayers;
	}

	public int numberOfPlayers() {
		int number = players.size();
		return number;
	}

	public boolean hasPlayers() {
		boolean has = players.size() > 0;
		return has;
	}

	public int indexOfPlayer(Player aPlayer) {
		int index = players.indexOf(aPlayer);
		return index;
	}

	/* Code from template association_GetMany */
	public Suggestion getSuggestion(int index) {
		Suggestion aSuggestion = suggestions.get(index);
		return aSuggestion;
	}

	public ArrayList<Suggestion> getSuggestions() {
		ArrayList<Suggestion> newSuggestions = (ArrayList<Suggestion>) Collections.unmodifiableList(suggestions);
		return newSuggestions;
	}

	public int numberOfSuggestions() {
		int number = suggestions.size();
		return number;
	}

	public boolean hasSuggestions() {
		boolean has = suggestions.size() > 0;
		return has;
	}

	public int indexOfSuggestion(Suggestion aSuggestion) {
		int index = suggestions.indexOf(aSuggestion);
		return index;
	}

	/* Code from template association_GetOne */
	public Board getBoard() {
		return board;
	}

	/* Code from template association_GetMany */
	public Card getCard(int index) {
		Card aCard = cards.get(index);
		return aCard;
	}

	public List<Card> getCards() {
		List<Card> newCards = Collections.unmodifiableList(cards);
		return newCards;
	}

	public int numberOfCards() {
		int number = cards.size();
		return number;
	}

	public boolean hasCards() {
		boolean has = cards.size() > 0;
		return has;
	}

	public int indexOfCard(Card aCard) {
		int index = cards.indexOf(aCard);
		return index;
	}

	/* Code from template association_GetMany */
	public Accusation getAccusation(int index) {
		Accusation aAccusation = accusations.get(index);
		return aAccusation;
	}

	public List<Accusation> getAccusations() {
		List<Accusation> newAccusations = Collections.unmodifiableList(accusations);
		return newAccusations;
	}

	public int numberOfAccusations() {
		int number = accusations.size();
		return number;
	}

	public boolean hasAccusations() {
		boolean has = accusations.size() > 0;
		return has;
	}

	public int indexOfAccusation(Accusation aAccusation) {
		int index = accusations.indexOf(aAccusation);
		return index;
	}

	/* Code from template association_IsNumberOfValidMethod */
	public boolean isNumberOfPlayersValid() {
		boolean isValid = numberOfPlayers() >= minimumNumberOfPlayers()
				&& numberOfPlayers() <= maximumNumberOfPlayers();
		return isValid;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfPlayers() {
		return 3;
	}

	/* Code from template association_MaximumNumberOfMethod */
	public static int maximumNumberOfPlayers() {
		return 6;
	}

	/* Code from template association_AddMNToOnlyOne */
	public Player addPlayer(Character aAssignedCharacter, Cell aLocation, Hand aPlayerHand, boolean aPlayerStatus,
			Cell aCell, CharacterCard aCharacterCard) {
		if (numberOfPlayers() >= maximumNumberOfPlayers()) {
			return null;
		} else {
			return new Player(aAssignedCharacter, aLocation, aPlayerHand, aPlayerStatus, this, aCell, aCharacterCard);
		}
	}

	public boolean addPlayer(Player aPlayer) {
		boolean wasAdded = false;
		if (players.contains(aPlayer)) {
			return false;
		}
		if (numberOfPlayers() >= maximumNumberOfPlayers()) {
			return wasAdded;
		}

		Game existingGame = aPlayer.getGame();
		boolean isNewGame = existingGame != null && !this.equals(existingGame);

		if (isNewGame && existingGame.numberOfPlayers() <= minimumNumberOfPlayers()) {
			return wasAdded;
		}

		if (isNewGame) {
			aPlayer.setGame(this);
		} else {
			players.add(aPlayer);
		}
		wasAdded = true;
		return wasAdded;
	}

	public boolean removePlayer(Player aPlayer) {
		boolean wasRemoved = false;
		// Unable to remove aPlayer, as it must always have a game
		if (this.equals(aPlayer.getGame())) {
			return wasRemoved;
		}

		// game already at minimum (3)
		if (numberOfPlayers() <= minimumNumberOfPlayers()) {
			return wasRemoved;
		}
		players.remove(aPlayer);
		wasRemoved = true;
		return wasRemoved;
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
			players.remove(aPlayer);
			players.add(index, aPlayer);
			wasAdded = true;
		}
		return wasAdded;
	}

	public boolean addOrMovePlayerAt(Player aPlayer, int index) {
		boolean wasAdded = false;
		if (players.contains(aPlayer)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfPlayers()) {
				index = numberOfPlayers() - 1;
			}
			players.remove(aPlayer);
			players.add(index, aPlayer);
			wasAdded = true;
		} else {
			wasAdded = addPlayerAt(aPlayer, index);
		}
		return wasAdded;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfSuggestions() {
		return 0;
	}

	/* Code from template association_AddManyToOne */
	public Suggestion addSuggestion(ArrayList aSuggestion) {
		return new Suggestion(aSuggestion, this);
	}

	public boolean addSuggestion(Suggestion aSuggestion) {
		boolean wasAdded = false;
		if (suggestions.contains(aSuggestion)) {
			return false;
		}
		Game existingGame = aSuggestion.getGame();
		boolean isNewGame = existingGame != null && !this.equals(existingGame);
		if (isNewGame) {
			aSuggestion.setGame(this);
		} else {
			suggestions.add(aSuggestion);
		}
		wasAdded = true;
		return wasAdded;
	}

	public boolean removeSuggestion(Suggestion aSuggestion) {
		boolean wasRemoved = false;
		// Unable to remove aSuggestion, as it must always have a game
		if (!this.equals(aSuggestion.getGame())) {
			suggestions.remove(aSuggestion);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	public boolean addSuggestionAt(Suggestion aSuggestion, int index) {
		boolean wasAdded = false;
		if (addSuggestion(aSuggestion)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfSuggestions()) {
				index = numberOfSuggestions() - 1;
			}
			suggestions.remove(aSuggestion);
			suggestions.add(index, aSuggestion);
			wasAdded = true;
		}
		return wasAdded;
	}

	public boolean addOrMoveSuggestionAt(Suggestion aSuggestion, int index) {
		boolean wasAdded = false;
		if (suggestions.contains(aSuggestion)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfSuggestions()) {
				index = numberOfSuggestions() - 1;
			}
			suggestions.remove(aSuggestion);
			suggestions.add(index, aSuggestion);
			wasAdded = true;
		} else {
			wasAdded = addSuggestionAt(aSuggestion, index);
		}
		return wasAdded;
	}

	/* Code from template association_IsNumberOfValidMethod */
	public boolean isNumberOfCardsValid() {
		boolean isValid = numberOfCards() >= minimumNumberOfCards() && numberOfCards() <= maximumNumberOfCards();
		return isValid;
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

	/* Code from template association_AddMNToOnlyOne */
	public Card addCard(String aName) {
		if (numberOfCards() >= maximumNumberOfCards()) {
			return null;
		} else {
			return new Card(aName, this);
		}
	}

	public boolean addCard(Card aCard) {
		boolean wasAdded = false;
		if (cards.contains(aCard)) {
			return false;
		}
		if (numberOfCards() >= maximumNumberOfCards()) {
			return wasAdded;
		}

		Game existingGame = aCard.getGame();
		boolean isNewGame = existingGame != null && !this.equals(existingGame);

		if (isNewGame && existingGame.numberOfCards() <= minimumNumberOfCards()) {
			return wasAdded;
		}

		if (isNewGame) {
			aCard.setGame(this);
		} else {
			cards.add(aCard);
		}
		wasAdded = true;
		return wasAdded;
	}

	public boolean removeCard(Card aCard) {
		boolean wasRemoved = false;
		// Unable to remove aCard, as it must always have a game
		if (this.equals(aCard.getGame())) {
			return wasRemoved;
		}

		// game already at minimum (21)
		if (numberOfCards() <= minimumNumberOfCards()) {
			return wasRemoved;
		}
		cards.remove(aCard);
		wasRemoved = true;
		return wasRemoved;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfAccusations() {
		return 0;
	}

	/* Code from template association_AddManyToOne */
	public Accusation addAccusation(ArrayList aAccusation) {
		return new Accusation(aAccusation, this);
	}

	public boolean addAccusation(Accusation aAccusation) {
		boolean wasAdded = false;
		if (accusations.contains(aAccusation)) {
			return false;
		}
		Game existingGame = aAccusation.getGame();
		boolean isNewGame = existingGame != null && !this.equals(existingGame);
		if (isNewGame) {
			aAccusation.setGame(this);
		} else {
			accusations.add(aAccusation);
		}
		wasAdded = true;
		return wasAdded;
	}

	public boolean removeAccusation(Accusation aAccusation) {
		boolean wasRemoved = false;
		// Unable to remove aAccusation, as it must always have a game
		if (!this.equals(aAccusation.getGame())) {
			accusations.remove(aAccusation);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	public boolean addAccusationAt(Accusation aAccusation, int index) {
		boolean wasAdded = false;
		if (addAccusation(aAccusation)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfAccusations()) {
				index = numberOfAccusations() - 1;
			}
			accusations.remove(aAccusation);
			accusations.add(index, aAccusation);
			wasAdded = true;
		}
		return wasAdded;
	}

	public boolean addOrMoveAccusationAt(Accusation aAccusation, int index) {
		boolean wasAdded = false;
		if (accusations.contains(aAccusation)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfAccusations()) {
				index = numberOfAccusations() - 1;
			}
			accusations.remove(aAccusation);
			accusations.add(index, aAccusation);
			wasAdded = true;
		} else {
			wasAdded = addAccusationAt(aAccusation, index);
		}
		return wasAdded;
	}

	public void delete() {
		for (int i = players.size(); i > 0; i--) {
			Player aPlayer = players.get(i - 1);
			aPlayer.delete();
		}
		for (int i = suggestions.size(); i > 0; i--) {
			Suggestion aSuggestion = suggestions.get(i - 1);
			aSuggestion.delete();
		}
		Board existingBoard = board;
		board = null;
		if (existingBoard != null) {
			existingBoard.delete();
		}
		for (int i = cards.size(); i > 0; i--) {
			Card aCard = cards.get(i - 1);
			aCard.delete();
		}
		for (int i = accusations.size(); i > 0; i--) {
			Accusation aAccusation = accusations.get(i - 1);
			aAccusation.delete();
		}
	}

	// line 25 "model.ump"
	public void playGame() {

	}

	public String toString() {
		return super.toString() + "[" + "numberOPlayers" + ":" + getNumberOPlayers() + "," + "gameOver" + ":"
				+ getGameOver() + "]" + System.getProperties().getProperty("line.separator") + "  " + "gameBoard" + "="
				+ (getGameBoard() != null
				? !getGameBoard().equals(this) ? getGameBoard().toString().replaceAll("  ", "    ") : "this"
					: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "listOfPlayers" + "="
				+ (getListOfPlayers() != null
				? !getListOfPlayers().equals(this) ? getListOfPlayers().toString().replaceAll("  ", "    ")
						: "this"
							: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "roomList" + "="
				+ (getRoomList() != null
				? !getRoomList().equals(this) ? getRoomList().toString().replaceAll("  ", "    ") : "this"
					: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "weapons" + "="
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
				+ System.getProperties().getProperty("line.separator") + "  " + "murderDeck" + "="
				+ (getMurderDeck() != null
				? !getMurderDeck().equals(this) ? getMurderDeck().toString().replaceAll("  ", "    ") : "this"
					: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "scanner" + "="
				+ (getScanner() != null
				? !getScanner().equals(this) ? getScanner().toString().replaceAll("  ", "    ") : "this"
					: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "board = "
				+ (getBoard() != null ? Integer.toHexString(System.identityHashCode(getBoard())) : "null");
	}
	// ------------------------
	// DEVELOPER CODE - PROVIDED AS-IS
	// ------------------------

	// line 15 "model.ump"
	public enum CharacterList {
		MISS_SCARLETT, COLONEL_MUSTARD, PROFESSOR_PLUM, REVEREND_GREEN, MRS_PEACOCK, MRS_WHITE
	}

	// line 16 "model.ump"
	public enum RoomList {
		DINING_ROOM, BALLROOM, KITCHEN, CONSERVATORY, BILLIARD_ROOM, LIBRARY, STUDY, HALL, LOUNGE, HALLWAY
	}

}