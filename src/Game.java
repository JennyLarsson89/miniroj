import java.util.Scanner;

public class Game {

Board board = new Board(6, 6);

boolean gameOver = false;
    /**
     * The game loop starts here.
     */
    public void play(){
        board.initializeBoard();
        board.placeBombs();
        board.displayBoard();
        while(!gameOver){
            board.selectCell();
            board.displayBoard();
        }
    }















}
