import java.util.Scanner;

public class Game {


    Scanner sc = new Scanner(System.in);
    Board board = new Board();
    Player player1 = new Player("", 0, 'x');


    boolean gameOver = false;


    public void play() {
        while (true) {
            System.out.println("\uD83D\uDCA3 Welcome to MineSweep\uD83D\uDCA3   1:Play 0:Quit!");
            int choice = sc.nextInt();

            while (!gameOver) {
                try {
                    if (choice == 0) {
                        System.out.println("Thank you for playing!,Bye!!");
                        System.exit(0);
                    } else if (choice == 1) {


                    }
                    board.displayBoard();
                    BoardMovement(board.getBoard(), sc, player1);


                } catch (Exception e) {
                    System.out.println("Invalid input, please try again.");
                    sc.nextLine();
                }
            }

        }




    }













        public void BoardMovement(char[][] board,Scanner sc,Player player1) {

                boolean gameOver = false;
            boolean validMove = false;

            while (!validMove) {
                try {
                    System.out.println("Enter your move Player 1" + player1.getSymbol());
                    int move = sc.nextInt();
                    int row = (move - 1) / 6;
                    int col = (move - 1) % 6;

                    if (move == 0) {
                        System.out.println("Thanks for playing!, bye!!");
                        System.exit(0);

                    }
                    if (row < 0 && row > 5) {
                        System.out.println("Invalid input, please try again. row 1-6 & col 1-6");


                    }
                    if (board[row][col] == '0') {
                        System.out.println("kaamboom!!!");
                        gameOver = true;
                    } else {
                        board[row][col] = player1.getSymbol();
                        validMove = true;

                    }

                }catch (Exception e) {
                    System.out.println("Invalid input, please try again.");
                    sc.nextLine();
                }
            }

        }



}















