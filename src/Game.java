import java.util.Scanner;

public class Game {
    private Board board;
    private Player player;
    private boolean gameWon, gameLost; // för att spåra spelets tillstånd.
    private int flags, attempts, remainingMines;  // flaggor, försök och återstående minor.
    private long startTime, endTime;  // spåra spelets tidslängd.
    private  Scanner sc = new Scanner(System.in);
    private  Menu menu = new Menu();

    public void start() {
        boolean playAgain;

        do { // kör så länge playAgain är true

            if (player == null || player.getName() == null) { // Skapa spelare om den inte redan finns
                System.out.println("Välkommen till " + Color.REVERSED + "\tMINRÖJ\t" + Color.RESET + " spelet!"); // Speltitel
                player = new Player();
            } else {
                System.out.println("\nSpelar igen som: " + player.getName());
            }

            int difficulty = menu.displayMenu(); // Anropar displayMenu
            int[] sizes = menu.getGridSize(difficulty); // Få storlekarna som en int[]
            board = new Board(sizes); // Skapa nytt Board med storlek och Player.
            flags = 0;
            attempts = 0; // försök 0
            remainingMines = board.getMines(); // antalet återstående minor
            startTime = System.currentTimeMillis(); // Starta tidtagning
            play(); // börja spela
            System.out.print("Vill du spela igen? (j/n): ");
            playAgain = sc.next().equals("j");
        } while (playAgain);

        System.out.println("Tack för att du spelade!");
        sc.close();
    }

    // Play-metoden
    public void play() {
        board.initializeGrid(); // förbereda spelbrädet
        board.printGrid(); // Visa
        int[] move = getPlayerMove(board.getRows(), board.getColumns()); // Hämtar spelarens första drag.
        int row = move[0];
        int col = move[1];
        System.out.println("Spelarens drag - Rad: " + row + ", Kolumn: " + col);
        board.placeMines(row, col); // Placera minor efter första draget
        board.calculateAdjacentMines();
        while (!gameWon && !gameLost) {
            attempts++; // Öka antalet försök
            if (board.isMine(row, col)) { // Kontrollera om spelaren trampade på en mina
                gameLost = true;
                board.revealAllCells();
                board.printGrid();
                endTime = System.currentTimeMillis(); // Stoppa tidtagning
                displayResults();
                break;
            } else {
                board.revealCell(row, col);
                player.increaseScore(); // Uppdatera poängen för varje avslöjad cell
                board.printGrid();
                displayStatus();

                // Kontroll om spelaren har rensat alla icke-minceller
                if (board.checkWin()) {
                    gameWon = true;
                    endTime = System.currentTimeMillis();
                    displayResults();
                    break;
                }
                move = getPlayerMove(board.getRows(), board.getColumns());
                row = move[0];
                col = move[1];
            }
        }
    }

    public void displayResults() {
        if (gameWon) {
            System.out.println("\n🎉 Grattis! Du har vunnit spelet! 🎉");
        } else if (gameLost) {
            System.out.println("\n💥 Du trampade på en mina. Spelet är över. 💥");
        }
        System.out.println("\n\t\t<<== SLUTRESULTAT ==>>");
        System.out.println("\t\t\t\uD83D\uDC64 Spelare: " + player.getName());
        System.out.println("\t\t\t⏱️ Tid: " + formatTime(endTime - startTime));
        System.out.printf("\t\t\t🔄 Försök: %d", attempts);
        System.out.println("\n\t\t\t⛳ Flaggor: " + flags);
        System.out.println("\t\t\t💣 Minor: " + remainingMines);
        System.out.println("\t\t\t🏆 Poäng: " + player.getScore());
    }

    private void displayStatus() {
        System.out.print("\t\t-----------------------------------\n");
        System.out.print("\t\t🔄 Försök: " + attempts);
        System.out.print(". ⛳ Flaggor: " + flags);
        System.out.print(". 💣 Minor: " + remainingMines);
        System.out.print(". \uD83C\uDF96 Poäng: " + player.getScore());
    }

    //  Metod för att hämta spelarens drag
    private int[] getPlayerMove(int maxRows, int maxCols) {
        int[] move = new int[2]; // Array för att lagra rad och kolumn
        System.out.print("\nVill du flagga ⛳ en cell? ( Tryck: 'j' för ja ):");
        String flagInput = sc.nextLine().trim().toLowerCase();
        /* sc.nextLine() läser hela raden, extra mellanslag eller tecken.
           trim() tar bort alla omgivande mellanslag runt.
           toLowerCase() konverterar inmatningen till gemener*/
        boolean flagCell = flagInput.equals("j"); /* kontroll om inmatninggen är exakt "j" sätts till true; annars false.*/

        // Fråga efter radnummer
        do {
            System.out.print("Ange radnummer (1-" + maxRows + "): ");
            while (!sc.hasNextInt()) {
                System.out.println("Ogiltig inmatning. Ange ett heltal.");
                sc.next(); // Rensa den ogiltiga inmatningen
            }
            move[0] = sc.nextInt() - 1; // Justera för att matcha arrayindex
            sc.nextLine(); // Rensa ny rad efter heltalsinmatning
        } while (move[0] < 0 || move[0] >= maxRows);

        // Fråga efter kolumnnummer
        do {
            System.out.print("Ange kolumnnummer (1-" + maxCols + "): ");
            while (!sc.hasNextInt()) {
                System.out.println("Ogiltig inmatning. Ange ett heltal.");
                sc.next();
            }
            move[1] = sc.nextInt() - 1;
            sc.nextLine();
        } while (move[1] < 0 || move[1] >= maxCols);

        // Hantera flaggning och avflagning
        if (flagCell) {
            board.toggleFlag(move[0], move[1]);
            if (board.isFlagged(move[0], move[1])) {
                flags++; // Öka antalet flaggor
                remainingMines--; // Minska antalet återstående minor
            } else {
                flags--; // Minska antalet flaggor
                remainingMines++; // Öka antalet återstående minor
            }
            board.printGrid();
            System.out.print("\t\tFlaggor: ⛳ " + flags + ", Minor: \uD83D\uDCA3 " + remainingMines);
            return getPlayerMove(maxRows, maxCols); // Be om ett nytt drag efter flaggning
        }

        return move;  // Returnera spelarens drag
    }

    // getTime Metod för att formatera tid format
    private String formatTime(long milliseconds) {
        long seconds = (milliseconds / 1000) % 60;
        long minutes = (milliseconds / (1000 * 60)) % 60;
        long hours = (milliseconds / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        /*
          Link -> https://www.geeksforgeeks.org/java-lang-system-currenttimemillis-method-with-examples/
          %: Markerar början av en formatted specifikation.
          0: Anger att om siffran är kortare än två tecken, ska den fyllas med en nolla (0) till vänster.
          2: Anger att siffran ska ta upp exakt två positioner.
          d: Anger att värdet är ett heltal (integer) */
    }

}
