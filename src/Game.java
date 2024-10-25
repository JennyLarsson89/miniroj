import java.util.Scanner;

public class Game {


    Scanner sc = new Scanner(System.in);
    Board board = new Board(6, 6);
    boolean gameOver = false;


    /**
     * The game loop starts here.
     */
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
