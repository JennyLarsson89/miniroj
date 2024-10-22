import java.util.ArrayList;
import java.util.List;

public class Board {

    int cols = 10;
    int rows = 4;
    int numberOfBombs = 3;
    int cellValue = 0;
    int randomNum = 0;
    int bombLoop = 0;

    public Board() {
    }

    ArrayList<String> cells = new ArrayList<>();

    public void createBoard() {


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

        int length = cols;
        List<Character> alphabetList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            alphabetList.add((char)('a' + i));
        }
        System.out.print("     ");
        for (Character c : alphabetList) {
        System.out.print(c + "   ");
        }
        System.out.println();

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