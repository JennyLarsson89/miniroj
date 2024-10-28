import java.util.Scanner;

public class Board {
private String[][] board;
private int playerRow;
private int playerCol;

    public String[][] getBoard() {
        return board;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public Board(int row, int col) {
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
            System.out.println("xxx");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("o")) {
                    System.out.print(" |");
                } else {
                    System.out.print(board[i][j] + "|");
                }
            }
            System.out.println();
        }
    }

    public void finalBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }




    public void placeBombs() {
        for (int i = 0; i < board[0].length; i++) {
            int r = (int) Math.floor(Math.random() * board.length);
            int c = (int) Math.floor(Math.random() * board[0].length);
//            if (board[r][c] == board[0][0]) {
                board[r][c] = "o";
            //}
        }
    }

    public void selectCell() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the row number");
        playerRow = sc.nextInt();
        System.out.println("Please enter the column number");
        playerCol = sc.nextInt();
        if (playerRow < 1 || playerRow > 6 || playerCol < 1 || playerCol > 6) {
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





    /**
     * Custom placement for the board with number and letter.
     */
    public void customPlacementBoard() {}






}