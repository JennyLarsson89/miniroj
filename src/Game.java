
public class Game {

    Board board = new Board(6, 6);
    boolean gameOver = false;

    /**The game loop starts here.*/
    public void play() {
        board.initializeBoard();
        board.placeBombs();

        while(!gameOver) {
            board.selectCell();
            gameOver = true;
        }
    }
}
