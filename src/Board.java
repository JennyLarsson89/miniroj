import java.util.InputMismatchException;
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

    Menu menu = new Menu();
    BoardColor boardColor = new BoardColor();
    Player player = new Player("","x");


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

            System.out.println("Please enter the row number. (0 to quit)");
            playerRow = sc.nextInt();

            while (!rowChoice) {


                displayBoard();
                if (playerRow == 0) {
                    System.out.println("Thank you! Bye");
                    System.exit(0);
                }

                if (playerRow == 0) {
                    System.out.println("Thanks for playing, bye!!");
                    System.exit(0);
                }

                if (playerRow < 1 || playerRow > 6) {
                    System.out.println("Invalid choice, 1-6 valid inputs");
                } else {
                    rowChoice = true;
                }

            }

            boolean colChoice = false;

            System.out.println("Please enter the column number. (0 to quit)");
            playerCol = sc.nextInt();
            while (!colChoice) {
                try {

                    displayBoard();
                    if (playerCol < 1 || playerCol > 6) {
                        System.out.println("Invalid choice, 1-6 valid inputs");
                    } else {
                        colChoice = true;
                    }


                    if (board[playerRow - 1][playerCol - 1].equals("o")) {
                        finalBoard();
                        System.out.println("KABOOOM!");
                        menu.runMenuAgain();

                    } else if (!board[playerRow - 1][playerCol - 1].equals(" ")) {
                        System.out.println("Cell already chosen! Select another one.");
                    } else {
                        board[playerRow - 1][playerCol - 1] = player.getPlayerSymbol();  // Markerar vald ruta med 'X'
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid choice, 1-6 valid input");
                    sc.nextLine();
                }
            }


        }catch (InputMismatchException e) {
            System.out.println("Invalid choice, 1-6 valid input");
            sc.nextLine();

        }
    }
    }