import java.util.Scanner;

public class Game {
    private Board board;
    private Player player;
    private boolean gameWon, gameLost; // för att spåra spelets tillstånd.
    private int flags, attempts, remainingMines;  // flaggor, försök och återstående minor.
    private long startTime, endTime;  // spåra spelets tidslängd.
    private  Scanner sc = new Scanner(System.in);
    private  Menu menu = new Menu();

    public void start() {
        System.out.println("Välkommen till " + Color.CYAN + "\tMINRÖJ\t" + Color.RESET +"spelet!"); // Speltitel
        player = new Player();
        int difficulty = menu.displayMenu(); // Anropar displayMenu
        int[] sizes = menu.getGridSize(difficulty); // Få storlekarna som en int[]
        board = new Board(sizes); // Skapa nytt Board med storlek och Player.
        flags = 0;
        attempts = 0; // försök 0
        remainingMines = board.getMines(); // antalet återstående minor
        startTime = System.currentTimeMillis(); // Starta tidtagning
        play(); // börja spela
    }

    /**The game loop starts here.*/
    public void play(){
        board.initializeBoard();
        board.displayBoard();
        board.placeBombs();
        while(!gameOver){
        board.selectCell();
        board.displayBoard();
        }
        board.finalBoard();
    }

    public boolean checkDeath(int playerRow, int playerCol, String[][] board) {
        if (board[playerRow][playerCol].equals("o")) {
            System.out.println("Death");
            return true;
        }
        return false;
    }
}
