import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean playAgain;

        do {
            Game game = new Game();
            game.start();

            System.out.print("Vill du spela igen? (j/n): ");
            playAgain = sc.next().equals("j");

        } while (playAgain);

        System.out.println("Tack för att du spelade!");
        sc.close();
    }
}