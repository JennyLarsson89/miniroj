import java.util.Scanner;

public class Board {
    private int ROWS, COLUMNS, MINES, remainingCells; // Håller dimensioner och antalet minor.
    private final Cell[][] grid; // En tvådimensionell array
    private final boolean[][] revealed; // Spåra vilka celler som har avslöjats

    // Const
    public Board(int[] sizes) {
        this.ROWS = sizes[0];
        this.COLUMNS = sizes[1];
        this.MINES = sizes[2];
        grid = new Cell[ROWS][COLUMNS]; // en ny cell-array
        revealed = new boolean[ROWS][COLUMNS]; // en boolean-array för avslöjade celler.
    }

    // Metod initializeGrid initierar och beräknar minorna
    public void initializeGrid() { // Initiera spelbrädet med tomma celler.
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = new Cell();
            }
        }
        remainingCells = ROWS * COLUMNS - MINES; // Beräkna antalet återstående celler att avslöja.
    }

    // Metod placeMines placerar minor
    public void placeMines(int firstRow, int firstCol) {
        int minesPlaced = 0;
        while (minesPlaced < MINES) { // Placera minor slumpmässigt på brädet
            int row = (int) (Math.random() * ROWS);
            int col = (int) (Math.random() * COLUMNS);
            if (grid[row][col].isMine() || (row == firstRow && col == firstCol)) {
                continue;
            }
            grid[row][col].setMine(true);
            minesPlaced++;
        }
    }

    // Metod beräkna intilliggande minor
    public void calculateAdjacentMines() {  // Beräkna antalet intilliggande minor för varje cell
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (!grid[i][j].isMine()) { // kontroll om den aktuella cellen är en mina
                    int count = 0;
                    for (int x = -1; x <= 1; x++) { // Inre loopar för att gå igenom närliggande celler:
                        for (int y = -1; y <= 1; y++) { // x och y varierar mellan -1 och 1, vilket täcker alla möjliga 8 grannpositioner
                            if ((x != 0 || y != 0) && isValidCell(i + x, j + y) && grid[i + x][j + y].isMine()) { //  en kombination av två villkor som används för att kontrollera om en närliggande cell innehåller en mina och är inom gränserna för spelbrädet.
                                /* 1 (x != 0 || y != 0) kontroll att (x, y) inte är (0, 0), den aktuella cellens position
                                   2 isValidCell(i + x, j + y) kontroll om koordinaterna (i + x, j + y) ligger inom spelbrädets gränser
                                   3 grid[i + x][j + y].isMine() Om den närliggande cellen finns inom gränserna */
                                count++;
                            }
                        }
                    }
                    // Anropa setAdjacentMines(count) för att tilldela count som antalet intilliggande minor
                    grid[i][j].setAdjacentMines(count);
                }
            }
        }
    }

    // Kontrollera cellens giltighet om en given cell är inom brädets gränser.
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLUMNS;
    }

    //  Skriva ut brädet
    public void printGrid() {
        System.out.print("\t ");
        for (int j = 1; j <= COLUMNS; j++) {
            System.out.printf("\t"+ Color.YELLOW + "%7s", (j) + Color.RESET);
        }
        // Skriv ut koordinatnummer överst
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.print("\t ");

            for (int j = 0; j < COLUMNS; j++) {
                if (grid[i][j].isFlagged()) {
                    System.out.print(" |⛳");
                } else if (revealed[i][j]) {
                    if (grid[i][j].isMine()) {
                        System.out.print("\t|" + Color.RED +"\uD83D\uDCA3"+Color.RESET);
                    } else if (grid[i][j].getAdjacentMines() == 0) {
                        System.out.print("\t| 0");
                    } else {
                        String color = switch (grid[i][j].getAdjacentMines()) {
                            case 1 -> Color.BRT_GREEN;
                            case 2 -> Color.BRT_BLUE;
                            case 3 -> Color.BRT_MAGENTA;
                            case 4 -> Color.BRT_CYAN;
                            case 5 -> Color.BRT_RED;
                            case 6 -> Color.BRT_PURPLE;
                            default -> Color.BRT_WHITE;
                        };
                        System.out.print("\t| " + color + grid[i][j].getAdjacentMines() + Color.RESET);
                    }
                } else {
                    System.out.print("\t| *");
                }
            }
            // Skriv ut koordinatnummer till höger
            System.out.print(" | "+Color.YELLOW +(i + 1)+ Color.RESET);
            System.out.println(); // Skriv ut brädet
        }
    }

    // revealCell rekursivt metod avslöjar celler
    public void revealCell(int row, int col) {
        if (!isValidCell(row, col) || revealed[row][col] || grid[row][col].isFlagged()) {
            return;
        }
        revealed[row][col] = true;
        remainingCells--;
        if (grid[row][col].getAdjacentMines() == 0) {
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    revealCell(row + x, col + y);
                }
            }
        }
    }

    // Avslöja alla celler när är BOOM!
    public void revealAllCells() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                revealed[i][j] = true;
            }
        }
    }

    // Metod kontrollera vinst
    public boolean checkWin() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (!grid[i][j].isMine() && !revealed[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Kontroll om det finns en mina
    public boolean isMine(int row, int col) {
        return grid[row][col].isMine();
    }

    // Kontroll om det är flaggad
    public boolean isFlagged(int row, int col) {
        return grid[row][col].isFlagged();
    }
    // Ändra flaggstatusen
    public void toggleFlag(int row, int col) {
        if (isValidCell(row, col) && !revealed[row][col]) {
            grid[row][col].setFlagged(!grid[row][col].isFlagged());
        }
    }


}