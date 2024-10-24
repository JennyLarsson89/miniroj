public class Main {
    public static void main(String[] args) {

        Board myBoard = new Board(5,5,5);
        myBoard.createBoard();
        myBoard.placeBombs();
        myBoard.displayBoard();

    }
}
