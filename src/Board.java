import java.awt.*;
import java.util.Scanner;

public class Board {
    private String[][] board;
    private int playerRow;
    private int playerCol;

    public Board(int playerRow, int playerCol) {
        this.playerRow = playerRow;
        this.playerCol = playerCol;
        board = new String[6][6];
    }

    Player player = new Player("","X");


    Menu menu = new Menu();
    BoardColor boardColor = new BoardColor();

    /**
     * Makes the board empty
     */
    public void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = " ";
            }
        }
    }

    /**
     * Prints out the board with empty space
     */
    public void displayBoard() {
        System.out.println(boardColor.ANSI_PURPLE+ "  1 2 3 4 5 6"+ boardColor.ANSI_RESET);
        for (int i = 0; i < board.length; i++) {
            System.out.print(boardColor.ANSI_YELLOW + (i + 1) + " "+boardColor.ANSI_RESET );
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("o")) {
                    System.out.print(boardColor.ANSI_BLUE + " |" + boardColor.ANSI_RESET );
                } else {
                    System.out.print(boardColor.ANSI_BLUE + board[i][j] + "|" + boardColor.ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    public void finalBoard() {
        System.out.println(boardColor.ANSI_YELLOW + "  1 2 3 4 5 6" + boardColor.ANSI_RESET);
        for (int i = 0; i < board.length; i++) {
            System.out.print(boardColor.ANSI_PURPLE + (i + 1) + " " + boardColor.ANSI_RESET);
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(boardColor.ANSI_BLUE + board[i][j] + "|" + boardColor.ANSI_RESET);
            }
            System.out.println();
        }
    }

    public void placeBombs() {
         for (int i = 0; i < board[0].length; i++) {
            int r = (int) Math.floor(Math.random() * board.length);
            int c = (int) Math.floor(Math.random() * board[0].length);
            board[r][c] = "o";
        }
    }

    public void selectCell() {
        Scanner sc = new Scanner(System.in);

        try {

            boolean rowChoice = false;
            while (!rowChoice) {


                System.out.println("Please enter the row number. (0 to quit)");
                playerRow = sc.nextInt();
                if (playerRow == 0) {
                    System.out.println("Thank you! Bye");
                    System.exit(0);
                }

                if (playerRow < 1 || playerRow > 6) {
                    System.out.println("Invalid choice, try again!");
                } else {
                    rowChoice = true;
                }
            }

            boolean colChoice = false;
            while (!colChoice) {
                System.out.println("Please enter the column number. (0 to quit)");
                playerCol = sc.nextInt();
                if (playerCol == 0) {
                    System.out.println("Thank you! Bye");
                    System.exit(0);
                }

                if (playerCol < 1 || playerCol > 6) {
                    System.out.println("Invalid choice, try again!");
                } else {
                    colChoice = true;
                }
            }

            if (board[playerRow - 1][playerCol - 1].equals("o")) {
                finalBoard();
                System.out.println("KABOOOM!");
                menu.runMenuAgain();
            } else if (!board[playerRow - 1][playerCol - 1].equals(" ")) {
                System.out.println("Cell already chosen! Select another one.");
            } else {
                board[playerRow - 1][playerCol - 1] = player.getPlayerSymbol();  // Markerar vald ruta med 'X'

                // Kontrollera om spelaren har vunnit
                if (checkWinCondition()) {
                    System.out.println("Congratulations! You've uncovered all safe cells and won the game!");
                    menu.runMenuAgain();
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            sc.nextLine();
        }
    }

    /**
     * Kontrollera om alla säkra rutor har markerats med "X".
     */
    private boolean checkWinCondition() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // Om en säker ruta (utan bomb) inte är markerad som "X", har spelaren inte vunnit än.
                if (!board[i][j].equals("o") && !board[i][j].equals("X")) {
                    return false;
                }
            }
        }
        return true;
    }
}
