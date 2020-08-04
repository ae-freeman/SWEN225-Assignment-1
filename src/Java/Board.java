package Java;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5092.1e2e91fc6 modeling language!*/



// line 27 "model.ump"
// line 105 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Associations
    private Cell[][] board;
    private int LENGTH = 25;
    private int WIDTH = 24;
    private String boardString =
            "_________ ____ _________" +
            "KKKKK|_   |BB|_   |CCCCC" +
            "KKKKK|  __|BB|__  |CCCCC" +
            "KKKKK|  |BBBBBB|  |CCCCC" +
            "KKKKK|  |BBBBBB|  CCCCCC" +
            "KKKKK|  BBBBBBBB   |____" +
            "_|__K|  |BBBBBB|        " +
            "        |B____B|       |" +
            "_                 _____" +
            "|____             IIIIII" +
            "DDDD|___  AAAAA   |IIIII" +
            "DDDDDDD|  AAAAA   |IIIII" +
            "DDDDDDDD  AAAAA   |___I_" +
            "DDDDDDD|  AAAAA        |" +
            "DDDDDDD|  AAAAA   __L__|" +
            "______D|  AAAAA  _|LLLLL" +
            "|         AAAAA  LLLLLLL" +
            "                 |_LLLLL" +
            "_        __HH__   |____|" +
            "|_____O  |HHHH|         " +
            "OOOOOO|  |HHHHH        _" +
            "OOOOOO|  |HHHH|  S_____|" +
            "OOOOOO|  |HHHH|  |SSSSSS" +
            "OOOOOO|  |HHHH|  |SSSSSS" +
            "OOOOOO| |HHHHHH| |SSSSSS";
  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board(Cell... allCells)
  {
	  board = new Cell[LENGTH][WIDTH];
	  populateBoard();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /**
   * Prints the board on the console
   */
  public void printBoard() {
      String out = "";
      for (int row = 0; row < 24; row++) {
          for (int col = 0; col < 23; col++) {
              char currentChar = boardString.charAt((row * 24) + col);
              out = out.concat(" " + currentChar + " ");
          }
          System.out.println();
          out = out.concat("\n");
      }
      System.out.print(out);
  }

  /**
   * Prints the board on the console, current player as X and other players as .
   */
  public void printBoardWithCurrentPlayer(Player player) {
      String out = "";
      for (int row = 0; row < 24; row++) {
          for (int col = 0; col < 23; col++) {
              char currentChar = boardString.charAt((row * 24) + col);
              try {
                  Player playerOnBoard = board[row][col].getPlayer();
                  if (playerOnBoard.equals(player)) {
                      out = out.concat(" " + 'X' + " ");
                  } else {
                      out = out.concat(" " + '0' + " ");
                  }
              } catch (Exception ex) {
                  out = out.concat(" " + currentChar + " ");
              }
          }
          System.out.println();
          out = out.concat("\n");
      }
      System.out.print(out);
  }
  
  private void populateBoard() {
      for (int row = 0; row < 24; row++) {
          for (int col = 0; col < 23; col++) {
              char currentChar = boardString.charAt((row * 24) + col);
              Cell currentCell = new Cell(row, col);
              board[row][col] = currentCell;
              switch (currentChar) {
                  case 'K':
                      currentCell.setRoom(new Room("Kitchen"));
                      break;
                  case 'B':
                      currentCell.setRoom(new Room("Ballroom"));
						break;
                  case 'C':
                      currentCell.setRoom(new Room("Conservatory"));
						break;
                  case 'D':
                      currentCell.setRoom(new Room("Dining room"));
						break;
                  case 'I':
                      currentCell.setRoom(new Room("Billiard Room"));
						break;
                  case 'L':
                      currentCell.setRoom(new Room("Library"));
						break;
                  case 'O':
                      currentCell.setRoom(new Room("Lounge"));
						break;
                  case 'H':
                      currentCell.setRoom(new Room("Hall"));
						break;
                  case 'S':
                      currentCell.setRoom(new Room("Study"));
						break;
                  case ' ':
                      currentCell.setRoom(new Room("Hallway"));
						break;
                  case '|':
                  case '-':
                      currentCell.setRoom(new Room("Wall"));
                      currentCell.setIsAccessible(false);
                    case 'A':
                      currentCell.setRoom(new Room("Cellar"));
                      currentCell.setIsAccessible(false);
						break;
					default:
						currentCell.setRoom(new Room("Default"));
						break;
              }
          }
      }
  }
  public Cell[][] getBoard(){
	  return board;
  }

  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfCells()
  {
    return 600;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCells()
  {
    return 600;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfCells()
  {
    return 600;
  }

  public void delete()
  {
    board = null;
  }

}