public class Main {
    public static void main(String[] args) {

        Board myBoard = new Board(10,10,15);
        myBoard.createBoard();
        myBoard.placeBombs();
        myBoard.displayBoard();

    }
}
