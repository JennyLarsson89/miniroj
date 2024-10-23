import java.util.ArrayList;
import java.util.List;

public class Board {

    int cols;
    int rows;
    int numberOfBombs;
    int cellValue;
    int randomNum;
    int bombLoop;

    public Board(int cols, int rows, int numberOfBombs) {
    this.cols = cols;
    this.rows = rows;
    this.numberOfBombs = numberOfBombs;
    this.cellValue = 0;
    this.randomNum = 0;
    this.bombLoop = 0;
    }

    ArrayList<String> cells = new ArrayList<>();

    public void createBoard() {         // Skapa ett tomt spelbräde

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

        public void placeBombs() {          // Slumpa bombernas placering
            while (bombLoop < numberOfBombs) {
                randomNum = (int) Math.floor(Math.random() * (rows * cols)) + 1;
                cells.set(randomNum, "B");
                System.out.println(randomNum);
                bombLoop++;
            }
        }

    public void displayBoard() {            // Visa spelplanen
        cellValue = 0;

        int length = cols;
        List<Character> alphabetList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            alphabetList.add((char)('a' + i));
        }
        System.out.print("      ");
        for (Character c : alphabetList) {
        System.out.print(c + "   ");
        }
        System.out.println();

        for (int i = 0; i < (rows); i++) {

            String space = "";      // Knuffar tvåsiffriga tal ett steg åt höger
            if (i < 9){             //
                space = " ";        //
            }

            System.out.print(space + (i + 1) + "  |");

            for (int j = 0; j < (cols); j++) {
                System.out.print(" " + cells.get(cellValue) + " |");
                cellValue++;
            }

            System.out.println();
        }
    }

}