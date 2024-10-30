import java.util.Scanner;

public class Game {

Board board = new Board(6, 6);

boolean gameOver = false;

    // Running and looping game methods

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
