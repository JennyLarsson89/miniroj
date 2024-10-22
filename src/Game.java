import java.util.Scanner;

public class Game {
    private Board board;
    private boolean gameOver;

    public Game() {
        board = new Board();
        gameOver = false;
    }

    public void start() {
        board.placeBombs();

        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            board.displayBoard();
            System.out.println("Enter your move (e.g., a1, b3, etc.):");

            String move = scanner.nextLine();

        }
    }
}

