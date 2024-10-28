import java.util.Scanner;

public class Board {
private String[][] board;
private int playerRow;
private int playerCol;

    /**
     *
     * @return Getter for the board to use in different class.
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     *
     * @return Getter for the playerRow.
     */
    public int getPlayerRow() {
        return playerRow;
    }


    /**
     *
     * @return Getter for the playerCol.
     */
    public int getPlayerCol() {
        return playerCol;
    }


    /**
     *
     * @param playerRow Movement for the board row
     * @param playerCol Movement for the board col
     */
    public Board(int playerRow, int playerCol) {
    this.playerRow = playerRow;
    this.playerCol = playerCol;
    board = new String[6][6];
}


    /**
     * Makes the board empty
     */
    public void initializeBoard() {
    for (int i = 0; i <6 ; i++) {
        for (int j = 0; j <6 ; j++) {
            board[i][j] = " ";
        }
    }
}


    /**
     * Prints out the board with empty space
     */
    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("o")) { // Om "o" är din bomb-symbol
                    System.out.print(" |"); // Visa något annat istället
                } else {
                    System.out.print(board[i][j] + "|");
                }
            }
            System.out.println();
        }
    }


    /**
     * Method for Printing out the board with the bomb placement.
     */
    public void finalBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }



    /**
     * Method for placing bombs on the board.
     */
    public void placeBombs() {
        for (int i = 0; i < board[0].length; i++) {
            int r = (int) Math.floor(Math.random() * board.length);
            int c = (int) Math.floor(Math.random() * board[0].length);
            board[r][c] = "o";

        }
    }




    /**
     * Method for selecting a positions on the board.
     */
    public void selectCell() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the row number 0:Quit");

        playerRow = sc.nextInt();

         //Quits the game with 0
        if (playerRow == 0) {
            System.out.println("Thanks for playing, bye!!");
            System.exit(0);
        }

        System.out.println("Please enter the column number 0:Quit");

        //Quits the game with 0
        if (playerCol == 0) {
            System.out.println("Thanks for playing, bye!!");
            System.exit(0);
        }

        playerCol = sc.nextInt();


        if (playerRow < 1 || playerRow > board.length || playerCol < 1 || playerCol > board.length) {
            System.out.println("Invalid choice, try again!");
        } else if (board[playerRow - 1][playerCol - 1].equals("o")) {
            System.out.println("KABOOOM!");
             System.exit(2);
        } else if (!board[playerRow - 1][playerCol - 1].equals(" ")) {
            System.out.println("Cell already chosen! Select another one.");
        } else {
            board[playerRow - 1][playerCol - 1] = "X";  // Markerar vald ruta med 'X'
        }


    }




}