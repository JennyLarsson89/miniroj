import java.util.Scanner;

public class Game {


Scanner sc = new Scanner(System.in);
Player player = new Player("",'x');
Board board = new Board(6, 6);

    /**
     * The game loop starts here.
     */
    public void play(){
        Board board = new Board(6, 6);

        board.DisplayBoard();
        board.placeBombs();
        board.selectCell();

    }






    /**
     * Checks for valid moves and If you picked a bomb spot.
     */
    public void checkForValidMoves(){}









}
