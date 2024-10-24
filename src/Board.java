import java.util.Scanner;

public class Board {
private String[][] board;
private BoardColor boardColor;


public Board() {
    board = new String[6][6];
    boardColor = new BoardColor();
    inizializeBoard();
}


    public String[][] getBoard() {
        return board;
    }

    /**
     * Makes the board empty
     */
    public void inizializeBoard() {
    for (int i = 0; i <6 ; i++) {
        for (int j = 0; j <6 ; j++) {
            board[i][j] = "-";
        }
    }
}



    /**
     * Prints out the board with empty space & color.
     */
    public void DisplayBoard() {

        System.out.println(boardColor.ANSI_YELLOW+"  1 2 3 4 5 6"+boardColor.ANSI_RESET);
        System.out.println(boardColor.ANSI_YELLOW+"a"+ boardColor.ANSI_YELLOW+ "|"+board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|" + board[0][3] + "|"+board[0][4] +"|"+board[0][5]+"|"+ boardColor.ANSI_RESET);
        System.out.println(boardColor.ANSI_BLUE+"b"+boardColor.ANSI_BLUE+ "|"+board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|" + board[1][3] + "|"+board[1][4] +"|"+board[1][5]+"|"+ boardColor.ANSI_RESET);
        System.out.println(boardColor.ANSI_GREEN+"c"+boardColor.ANSI_GREEN+"|"+board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|" + board[2][3] + "|"+board[2][4] +"|"+board[2][5]+"|"+ boardColor.ANSI_RESET);
        System.out.println(boardColor.ANSI_RED+"d"+boardColor.ANSI_RED+ "|"+board[3][0] + "|" + board[3][1] + "|" + board[3][2] + "|" + board[3][3] + "|"+board[3][4] +"|"+board[3][5]+"|"+ boardColor.ANSI_RESET);
        System.out.println(boardColor.ANSI_YELLOW+"e"+boardColor.ANSI_YELLOW+ "|"+board[4][0] + "|" + board[4][1] + "|" + board[4][2] + "|" + board[4][3] + "|"+board[4][4] +"|"+board[4][5]+"|"+ boardColor.ANSI_RESET);
        System.out.println("f"+ "|"+board[5][0] + "|" + board[5][1] + "|" + board[5][2] + "|" + board[5][3] + "|"+board[5][4] +"|"+board[5][5]+"|");
    }


    /**
     *
     * @param sc Scanner for taking in input from players move
     * @param board Board to check for valid input on row and column.
     * @param player To get the playerSymbol and use It as a marker on the board
     */
    public void checkForValidMoves(Scanner sc, String[][] board, Player player) {
        boolean validMove = false;

        while (!validMove) {
            System.out.print("Enter your move: (Only accepts 2 input (a1)");
            String playerMove = sc.nextLine().toLowerCase();

            /**
             * The first Invalid check.
             * Checks if the input has 2 value. If it deducts only 1 value, It will print out "Invalid input"
             */
            if (playerMove.length() < 2){
                System.out.println("Invalid move. plz enter both letter & number!");
                continue;
            }

            /**
             * Converts the number to letter for the row & col.
             */
            char rowLetter = playerMove.charAt(0);
            char colNumber = playerMove.charAt(1);
            int row = rowLetter - 'a';
            int col = colNumber - '1';


            /**
             * Checks for input value for row, if row input is under 0 and more the boards length. In this case the board length is 5.
             */
            if (row < 0 || row >= board.length){
                System.out.println("Invalid move,plz try again00!");
                continue;
            }

            /**
             * Checks for input value for columns, if columns input is under 0 and more the boards length. In this case the board length is 5.
             */
            if (col < 0 || col >= board[0].length){
                System.out.println("Invalid move,plz try again11!");
                continue;
            }

            /**
             * Checks for empty spot on the board. If it finds a spot a player picked and its empty the move gets approved.
             */
            if (board[row][col].equals("-")){
                board[row][col] = player.getPlayerSymbol();
                validMove = true;
            }else {
                System.out.println("Invalid move,plz try again!");
            }



        }

    }
    }









