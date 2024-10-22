import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    public char[][] board;

    public Board() {
        board = new char[6][6];
    }



    public char[][] getBoard() {
        return board;
    }


    public void initializeboard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = ' ';
            }
        }
    }



    public void displayBoard() {
        System.out.println("1 2 3 4 5 6" );

        System.out.println("1"+board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|" + board[0][3] + "|" + board[0][4]+ "|" + board[0][5]);
        System.out.println("2"+board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|" + board[1][3] + "|" + board[1][4]+ "|" + board[1][5]);
        System.out.println("3"+board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|" + board[2][3] + "|" + board[2][4]+ "|" + board[2][5]);
        System.out.println("4"+board[3][0] + "|" + board[3][1] + "|" + board[3][2] + "|" + board[3][3] + "|" + board[3][4]+ "|" + board[3][5]);
        System.out.println("5"+board[4][0] + "|" + board[4][1] + "|" + board[4][2] + "|" + board[4][3] + "|" + board[4][4]+ "|" + board[4][5]);
        System.out.println("6"+board[5][0] + "|" + board[5][1] + "|" + board[5][2] + "|" + board[5][3] + "|" + board[5][4]+ "|" + board[5][5]);

    }





    public void placeBombs() {
        String bombChar = "";
    }




    public void BoardMovement(char[][] board, Scanner sc, Player player1) {

        boolean validMove = false;

        while (!validMove) {
            boolean gameOver = false;
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





