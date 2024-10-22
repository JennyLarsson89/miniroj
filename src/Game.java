public class Game {
    private Board board;
    private Player player;

    // Konstruktor
    public Game(int rows, int columns, int numberOfBombs, String playerName) {
        board = new Board(rows, columns, numberOfBombs); // Skapar en ny spelplan
        player = new Player(playerName); // Skapar en ny spelare
    }

    // Metod för att starta spelet
    public void start() {
        board.placeBombs(); // Slumpar och placerar bomber på spelplanen
        boolean gameOn = true;

        while (gameOn) {
            board.displayBoard(); // Visar spelplanens nuvarande status
            System.out.println(player.getName() + ", välj en ruta (ange rad och kolumn):");

            // Exempel på spelarens inmatning
            int row = getInput("Ange rad: ");
            int column = getInput("Ange kolumn: ");

            // Kolla om spelaren valde en ruta med en bomb
            if (board.revealCell(row, column)) {
                System.out.println("Oj, du valde en bomb! Du förlorade.");
                gameOn = false;
            } else if (isWin()) {
                System.out.println("Grattis! Du har undersökt alla säkra rutor och vunnit spelet!");
                gameOn = false;
            }
        }
    }

    // Metod som kontrollerar om alla säkra rutor är undersökta
    public boolean isWin() {
        return board.allCellsRevealed(); // Kollar om alla säkra rutor har öppnats
    }

    // Metod som kontrollerar om spelaren har förlorat (om en bomb valdes)
    public boolean isLoss() {
        return board.hasBombExploded(); // Returnerar om en bomb har valts
    }

    // Hjälpmetod för att hantera användarinmatning
    private int getInput(String message) {
        System.out.print(message);
        // Använder Scanner för att läsa spelarens val
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextInt();
    }
}
