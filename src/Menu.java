import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);

    // Meny svårighetsgrad
    public int displayMenu() {
        System.out.println("\t" + Color.BG_GREEN + "\tMENY\t" + Color.RESET);
        System.out.println(Color.YELLOW + " 1. Lätt    (6x8)" + Color.RESET);
        System.out.println(Color.CYAN + " 2. Medium (8x12)" + Color.RESET);
        System.out.println(Color.PURPLE + " 3. Svår  (10x20)" + Color.RESET);
        System.out.println(Color.BLUE + " 4. Anpassad:" + Color.RESET);
        System.out.println(Color.RED + " 0. Avsluta" + Color.RESET);

        int choice = 0;
        boolean validInput = false;

        // Kontroll mata in ett giltigt heltal
        while (!validInput) {
            System.out.print("Välj svårighetsgrad: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                validInput = true; // Inmatningen är ett heltal
            } else {
                System.out.println("Ogiltig inmatning. Ange ett heltal.");
                sc.next();
            }
        }
        return choice;
    }

    // Metod getGridSize svårighetsgraden.
    public int[] getGridSize(int sizes) {
        while (true) {
            switch (sizes) {
                case 0:
                    System.out.println("Programmet avslutas.");
                    System.exit(0);
                case 1:
                    return new int[]{6, 8, 10};
                case 2:
                    return new int[]{8, 12, 20};
                case 3:
                    return new int[]{10, 20, 60};
                case 4:
                    return getCustomGridSize();
                default:
                    System.out.println("Ogiltigt val, försök igen: (0-4)");
                    sizes = getIntInput("Välj svårighetsgrad: "); // Använd getIntInput för att få ny inmatning
            }
        }
    }

    // Metod getCustomGridSize reda på rad, kol, och minor
    private int[] getCustomGridSize() {
        System.out.println("Ange antal rader, kolumner och minor (t.ex. 20 30 60):");

        int rows = getIntInput("Rader: ");
        int cols = getIntInput("Kolumner: ");
        int mines = getIntInput("Minor: ");

        // Kontrollera att antalet minor är rimligt i förhållande till rader och kolumner
        if (mines >= rows * cols) {
            System.out.println("Antalet minor är större än det totala antalet rutor. Försök igen.");
            return getCustomGridSize(); // Fråga igen
        }

        return new int[]{rows, cols, mines};
    }

    // Metod getIntInput
    private int getIntInput(String prompt) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                validInput = true;
            } else {
                System.out.println("Ogiltig inmatning. Ange ett heltal.");
                sc.next(); // Rensa
            }
        }
        return value;
    }
}
