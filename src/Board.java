

public class Board {
private String[][] board;


public Board() {
    board = new String[6][6];
    inizializeBoard();
}


    /**
     * Makes the board empty
     */
    public void inizializeBoard() {
    for (int i = 0; i <6 ; i++) {
        for (int j = 0; j <6 ; j++) {
            board[i][j] = " ";
        }
    }
}


    /**
     * Prints out the board with empty space
     */
    public void DisplayBoard() {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            System.out.print(board[i][j] + "-");
        }

        System.out.println();
    }
}


    /**
     * Custom placement for the board with number and letter.
     */
    public void customPlacementBoard() {}






}