import java.util.ArrayList;

public class Board {

    int cols = 6;
    int rows = 6;
    int numberOfBombs = 5;
    int cellValue = 0;
    int randomNum = 0;
    int bombLoop = 0;

    public Board() {
    }

    ArrayList<String> cells = new ArrayList<>();

    public void createBoard() {

    System.out.println("     a   b   c   d   e   f");

        for (int i = 0; i < (rows); i++) {
            System.out.print((i + 1) + "  |");

            for (int j = 0; j < (cols); j++) {
            cells.add(" ");
                System.out.print(" " + cells.get(cellValue) + " |");
                cellValue++;
            }
            System.out.println();
        }
    }

        public void placeBombs() {
            while (bombLoop < numberOfBombs) {
                randomNum = (int) Math.floor(Math.random() * (rows * cols)) + 1;
                cells.set(randomNum, "B");
                System.out.println(randomNum);
                bombLoop++;
            }
        }

    public void displayBoard() {
        cellValue = 0;
        System.out.println("     a   b   c   d   e   f");

        for (int i = 0; i < (rows); i++) {
            System.out.print((i + 1) + "  |");

            for (int j = 0; j < (cols); j++) {
                System.out.print(" " + cells.get(cellValue) + " |");
                cellValue++;
            }
            System.out.println();
        }
    }

}