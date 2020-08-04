//package Java;



import java.util.*;

public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Attributes
  private int numberOfPlayers;
  private boolean gameOver;
  private String[] roomList = { "Lounge", "Dining Room", "Kitchen", "Hall", "Conservatory", "Billiard Room", "Library",
		  "Study", "Ballroom", "Hallway" };
  private String[] characterList = { "Mrs. White", "Mr. Green", "Mrs . Peacock", "Prof. Plum", "Miss Scarlett",
  "Col. Mustard" };
  private String[] weaponList = { "Pistol", "Rope", "Candlestick", "Wrench", "Leadpipe", "Dagger" };
  private ArrayList<Card> weapons;
  private ArrayList<Card> characters;
  private ArrayList<Card> rooms;
  private Card[] murderDeck;
  private Card[] guess;
  private Scanner scanner;
  private int[] characterStartLoc = { 0, 9, 0, 14, 6, 23, 19, 23, 24, 7, 17, 0};
  //Game Associations
  private ArrayList<Player> listOfPlayers;
  private Suggestion suggestion;
  private Board board;
  private ArrayList<Card> deck;
  private Accusation accusation;

  
  
  
  public static void main(String[] args) { // use the "..." syntax!
      Game game = new Game();
      game.gameSetup();
//      game.round();
  }

  //------------------------
  // CONSTRUCTOR
  //------------------------
	public Game() {
		board = new Board();
		numberOfPlayers = 0;
		listOfPlayers = new ArrayList<Player>();
		gameOver = false;
		weapons = new ArrayList<Card>(); //? WeaponCard
		characters =new ArrayList<Card>(); //? CharacterCard;
		rooms = new ArrayList<Card>(); //RoomCard;
		
		deck = new ArrayList<Card>();
		murderDeck = new Card[3]; //<? extends Card>
		scanner = new Scanner(System.in);
		guess = new Card[3];
	}

  //------------------------
  // INTERFACE
  //------------------------
	public void gameSetup() {
		// Sets the number of players
		System.out.println("Welcome to Cluedo!");
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
			System.out.println(listOfPlayers.get(i).getCharacterCard());
		}
	}
	
	
	
	private ArrayList<Player> generatePlayers() {
		
		// Instantiate new players with randomly assigned character card
		for (int i = 0; i < numberOfPlayers; i++) {
			
			CharacterCard character = (CharacterCard) chooseRandom(characters);
			Player player = new Player(character);
			listOfPlayers.add(player);
		}

		// Randomise cards in deck
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

		// Print out each player's hand
//		for (int i = 0; i < numberOfPlayers; i++) {
//			System.out.println(listOfPlayers.get(i).getCharacterCard() + "'s hand:\n");
//			System.out.println(listOfPlayers.get(i).getHand());
//		}

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
	public Card chooseRandom(ArrayList<Card> list) {
		int rnd = new Random().nextInt(list.size());
		
		
		return list.get(rnd);
	}
	
//	public Card chooseRandom(ArrayList<Card> list) {
//		Set<Integer> numGenerated = new HashSet<>();
//	      int rnd = 0;
//	      while (numGenerated.contains(rnd)){
//	          rnd = new Random().nextInt(list.size());
//
//	          numGenerated.add(rnd);
//	      }
//	        return list.get(rnd);
//	    }
	
	// line 52 "model.ump"
	public void listCreation(){
		for(int i = 0; i <= weaponList.length-1; i++){
			WeaponCard weapon = new WeaponCard(weaponList[i]);
			weapons.add(weapon);
		}
		for(int i = 0; i <= roomList.length-1; i++){
			RoomCard room = new RoomCard(roomList[i]);
			rooms.add(room);
		}
//		for (int i = 0; i <= characterList.length - 1; i++) {
//			Cell startLoc = board.getBoard()[characterStartLoc[i*2]][characterStartLoc[(i*2)+1]];
//			CharacterCard character = new CharacterCard(characterList[i], startLoc );
//			// add in starting positions
//			characters.add(character);
//	    }

		characters.add(new CharacterCard("Mrs. White", board.getBoard()[9][0]));
        characters.add(new CharacterCard("Mr. Green", board.getBoard()[14][0]));
        characters.add(new CharacterCard("Mrs. Peacock", board.getBoard()[22][6]));
        characters.add(new CharacterCard("Prof. Plum", board.getBoard()[22][19]));
        characters.add(new CharacterCard("Miss Scarlett", board.getBoard()[7][24]));
        characters.add(new CharacterCard("Col. Mustard", board.getBoard()[0][17]));
        
	}
	
	// COMBINE CARD LISTS
	public void createDeck(){
	
		//combine weapons, rooms, characters
		deck.addAll(weapons);
		deck.addAll(characters);
		deck.addAll(rooms);
	
		// had to change the type at the top to be Card for all three types and the deck itself so it would combine them
		// is that alright?
		//CHECK:
	//		System.out.println(deck);
		
	
	
		int totalCards = 21;
	
		// REMOVE MURDER DECK CARDS
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < totalCards; j++){
				if(deck.get(j).getName().equals(murderDeck[i].getName())){
					deck.remove(j);
					totalCards -= 1;
					break;
				}
			}
	
		}
	
	
	}
	
	public void round() {
		while(!gameOver) {
			for(int i = 0; i < listOfPlayers.size(); i++ ) {
				Player player = listOfPlayers.get(i);
				int active = 0; //amount of active players
				if (player.getPlayerStatus()){
					active++;
				}
				if (active == 1){
					gameOver = true;
					break;
				}
				if(!player.getPlayerStatus()) {
					int roll = rollDice();
					player.movePlayer(roll, board); //move method return roll? so if they reach a room they can end loop
					int action = action();
					if(action == 1 || action == 2) {
						guess[0] = characters.get(guess(characters));
						guess[1] = weapons.get(guess(weapons));
						String roomGuess = player.getRoom();
						 int j = 0;
						  while (rooms.get(i).getName() != roomGuess) {
							  i++;
						  }
						  // return
						 Card roomCard = rooms.get(j);
						guess[2] = roomCard;
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
								System.out.println("Player " + player.getCharacterCard() + " wins!");
								gameOver = true;
							} else {
								player.setPlayerStatus(false);
								System.out.println("Player " + player.getCharacterCard() + " is out!");
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
		System.out.println("Press 1 to make a suggestion;/n" + "Press 2 to make an accusation/n" + "Press 3 to do nothing/n");
		do{
			System.out.println("Please enter your action");
			while(!scanner.hasNextInt()) {
				System.out.println("Please enter an integer between 1 and 3");
				scanner.hasNext();
			}
			return scanner.nextInt();
		}while (scanner.nextInt() < 1 || scanner.nextInt() > 3);
	}
	
	public int guess(ArrayList<Card> list){
		for(int i = 0; i < list.size(); i++) {
			System.out.println("Press " + i + "for: " + list.get(i) + "/n");
		}
		do {
			System.out.println("Please enter your selection");
			while(!scanner.hasNextInt()) {
				System.out.println("Please enter an integer between 0 and " + list.size());
				scanner.hasNext();
			}
			return scanner.nextInt();
		}while (scanner.nextInt() < 0 || scanner.nextInt() > list.size());
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
	
  public boolean setNumberOPlayers(int aNumberOPlayers)
  {
    boolean wasSet = false;
    numberOfPlayers = aNumberOPlayers;
    wasSet = true;
    return wasSet;
  }

  public boolean setGameOver(boolean aGameOver)
  {
    boolean wasSet = false;
    gameOver = aGameOver;
    wasSet = true;
    return wasSet;
  }

  public boolean setScanner(Scanner aScanner)
  {
    boolean wasSet = false;
    scanner = aScanner;
    wasSet = true;
    return wasSet;
  }

  public int getNumberOPlayers()
  {
    return numberOfPlayers;
  }

  public boolean getGameOver()
  {
    return gameOver;
  }
  
  public ArrayList<Card> getWeapons()
  {
    return weapons;
  }

  public ArrayList<Card> getCharacters()
  {
    return characters;
  }

  public ArrayList<Card> getRooms()
  {
    return rooms;
  }
  
  public Scanner getScanner()
  {
    return scanner;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isGameOver()
  {
    return gameOver;
  }
  /* Code from template association_GetMany */
  public Player getPlayer(int index)
  {
    Player aPlayer = listOfPlayers.get(index);
    return aPlayer;
  }

  public List<Player> getPlayers()
  {
    List<Player> newPlayers = Collections.unmodifiableList(listOfPlayers);
    return newPlayers;
  }

  public int numberOfPlayers()
  {
    int number = listOfPlayers.size();
    return number;
  }

  public boolean hasPlayers()
  {
    boolean has = listOfPlayers.size() > 0;
    return has;
  }

  public int indexOfPlayer(Player aPlayer)
  {
    int index = listOfPlayers.indexOf(aPlayer);
    return index;
  }
  /* Code from template association_GetOne */
  public Suggestion getSuggestion()
  {
    return suggestion;
  }

  public boolean hasSuggestion()
  {
    boolean has = suggestion != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Board getBoard()
  {
    return board;
  }
  /* Code from template association_GetOne */
  public Accusation getAccusation()
  {
    return accusation;
  }

  public boolean hasAccusation()
  {
    boolean has = accusation != null;
    return has;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPlayers()
  {
    return 3;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfPlayers()
  {
    return 6;
  }
  /* Code from template association_AddUnidirectionalMN */
  public boolean addPlayer(Player aPlayer)
  {
    boolean wasAdded = false;
    if (listOfPlayers.contains(aPlayer)) { return false; }
    if (numberOfPlayers() < maximumNumberOfPlayers())
    {
      listOfPlayers.add(aPlayer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removePlayer(Player aPlayer)
  {
    boolean wasRemoved = false;
    if (!listOfPlayers.contains(aPlayer))
    {
      return wasRemoved;
    }

    if (numberOfPlayers() <= minimumNumberOfPlayers())
    {
      return wasRemoved;
    }

    listOfPlayers.remove(aPlayer);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalMN */
  public boolean setPlayers(Player... newPlayers)
  {
    boolean wasSet = false;
    ArrayList<Player> verifiedPlayers = new ArrayList<Player>();
    for (Player aPlayer : newPlayers)
    {
      if (verifiedPlayers.contains(aPlayer))
      {
        continue;
      }
      verifiedPlayers.add(aPlayer);
    }

    if (verifiedPlayers.size() != newPlayers.length || verifiedPlayers.size() < minimumNumberOfPlayers() || verifiedPlayers.size() > maximumNumberOfPlayers())
    {
      return wasSet;
    }

    listOfPlayers.clear();
    listOfPlayers.addAll(verifiedPlayers);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPlayerAt(Player aPlayer, int index)
  {  
    boolean wasAdded = false;
    if(addPlayer(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      listOfPlayers.remove(aPlayer);
      listOfPlayers.add(index, aPlayer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlayerAt(Player aPlayer, int index)
  {
    boolean wasAdded = false;
    if(listOfPlayers.contains(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      listOfPlayers.remove(aPlayer);
      listOfPlayers.add(index, aPlayer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlayerAt(aPlayer, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setSuggestion(Suggestion aNewSuggestion)
  {
    boolean wasSet = false;
    suggestion = aNewSuggestion;
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setBoard(Board aNewBoard)
  {
    boolean wasSet = false;
    if (aNewBoard != null)
    {
      board = aNewBoard;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfCards()
  {
    return 21;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCards()
  {
    return 21;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfCards()
  {
    return 21;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setAccusation(Accusation aNewAccusation)
  {
    boolean wasSet = false;
    accusation = aNewAccusation;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    listOfPlayers.clear();
    suggestion = null;
    board = null;
    deck = null;
    accusation = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "numberOPlayers" + ":" + getNumberOPlayers()+ "," +
            "gameOver" + ":" + getGameOver()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "weapons" + "=" + (getWeapons() != null ? !getWeapons().equals(this)  ? getWeapons().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "characters" + "=" + (getCharacters() != null ? !getCharacters().equals(this)  ? getCharacters().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "rooms" + "=" + (getRooms() != null ? !getRooms().equals(this)  ? getRooms().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "scanner" + "=" + (getScanner() != null ? !getScanner().equals(this)  ? getScanner().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "suggestion = "+(getSuggestion()!=null?Integer.toHexString(System.identityHashCode(getSuggestion())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "board = "+(getBoard()!=null?Integer.toHexString(System.identityHashCode(getBoard())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "accusation = "+(getAccusation()!=null?Integer.toHexString(System.identityHashCode(getAccusation())):"null");
  }
}