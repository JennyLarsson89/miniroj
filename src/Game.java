import java.util.Scanner;

public class Game {
    private Board board;
    private Player player;
    private boolean gameWon, gameLost; // för att spåra spelets tillstånd.
    private int flags, attempts, remainingMines;  // flaggor, försök och återstående minor.
    private long startTime, endTime;  // spåra spelets tidslängd.
    private  Scanner sc = new Scanner(System.in);
    private  Menu menu = new Menu();

    Scanner sc = new Scanner(System.in);
    Board board = new Board(6, 6);
    boolean gameOver = false;

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
