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

    /**Makes the board empty*/
    public void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " ";
            }
        }
    }

    /**Prints out the board with empty space*/
    public void displayBoard() {
        System.out.print(" ");
        for (int i = 1; i <= board.length; i++) {
            System.out.printf(Color.PURPLE + " ", (i) + Color.RESET);
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(Color.YELLOW + (i + 1) + " " + Color.RESET );
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("o")) { // Om "o" är din bomb-symbol
                    System.out.print(Color.BLUE + " |" + Color.RESET); // Visa något annat istället
                } else {
                    System.out.print(Color.BLUE + board[i][j] + "|" + Color.RESET);
                }
            }
            System.out.println();
        }
    }

    /**Method for Printing out the board with the bomb placement.*/
    public void finalBoard() {
        System.out.print(" ");
        for (int i = 1; i <= board.length; i++) {
            System.out.print(Color.PURPLE + " " + (i) + Color.RESET);
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(Color.PURPLE + (i + 1) + " " + Color.RESET);
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(Color.BLUE + board[i][j] + "|" + Color.RESET);
            }
            System.out.println();
        }
    }

    /** Method for placing bombs on the board.*/
    public void placeBombs() {
        for (int i = 0; i < board[0].length; i++) {
            int r = (int) Math.floor(Math.random() * board.length);
            int c = (int) Math.floor(Math.random() * board[0].length);
            board[r][c] = "o";
        }
    }

    /** Method for selecting a positions on the board.*/
    public void selectCell() {
        while (true) {
            displayBoard();
            System.out.println("1 - Select cell");
            System.out.println("2 - Flag cell or remove");
            System.out.println("0 - End the game");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Välj cell
                    boolean rowChoice = false;
                    while (!rowChoice) {
                        System.out.println("Please enter the row number (1-6).");
                        playerRow = sc.nextInt();

                        if (playerRow == 0) {
                            System.out.println("Thanks for playing! Bye!");
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
                        System.out.println("Please enter the column number (1-6).");
                        playerCol = sc.nextInt();

                        if (playerCol < 1 || playerCol > 6) {
                            System.out.println("Invalid choice, try again!");
                        } else {
                            colChoice = true;
                        }
                    }

                    // Kontrollera om cellen innehåller en bomb
                    if (board[playerRow - 1][playerCol - 1].equals("o")) { // ?
                        finalBoard(); // Visa hela brädet om det är en bomb
                        Menu.boom = true;
                        System.out.println("KABOOOM!");
                        return; // Avsluta spelet
                    } else if (!board[playerRow - 1][playerCol - 1].equals(" ")) {
                        System.out.println("Cell already chosen! Select another one.");
                    } else {
                        board[playerRow - 1][playerCol - 1] = "X"; // Markera vald cell med 'X'
                    }
                    break;

                case 2: // Flagga cell
                    flagCell();
                    break;

                case 0: // Avsluta spelet
                    System.out.println("Thanks for playing! Bye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, try again!"); // Hantera ogiltiga val
            }

        }

    }

    /** Method to flag or remove a position on the board.*/
    public void flagCell() {
        boolean rowChoice = false;
        while (!rowChoice) {
            System.out.println("Enter row number to flag cell (1-6).");
            Scanner sc = new Scanner(System.in);
            playerRow = sc.nextInt();

            if (playerRow == 0) {
                System.out.println("Thanks for playing, bye!");
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
            System.out.println("Enter column number to flag cell (1-6).");
            Scanner sc = new Scanner(System.in);
            playerCol = sc.nextInt();

            if (playerCol < 1 || playerCol > 6) {
                System.out.println("Invalid choice, try again!");
            } else {
                colChoice = true;
            }
        }

        /** Check if the cell is already flagged or selected */
        if (board[playerRow - 1][playerCol - 1].equals("X")) {
            System.out.println("Cell already chosen! Select another one.");
        } else if (board[playerRow - 1][playerCol - 1].equals("F")) {
            // Om cellen redan är flaggad, ta bort flaggan
            board[playerRow - 1][playerCol - 1] = " "; // Ta bort flaggan
            System.out.println("The flag has been removed from the cell (" + playerRow + ", " + playerCol + ").");
        } else {
            // Om cellen är ledig, sätt flaggan
            board[playerRow - 1][playerCol - 1] = "F"; // Markera vald ruta med 'F' för flagga
            System.out.println("Flag placed on the cell (" + playerRow + ", " + playerCol + ").");
        }
    }
}