import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);


    /**
     * Menu for the game with the option to end and start.
     */
    public void runMenu() {
        while (true) {
            try {

                System.out.println("Welcome to minesweeper! Whats your name?");
                String playerName = sc.nextLine();
                System.out.println("Hello, " + playerName + " press 1 to Play or 2 to Quit");


                int menuChoice = sc.nextInt();

                if (menuChoice == 1){
                    Game game = new Game();
                    game.play();
                } else if (menuChoice == 2){
                    System.exit(2);
                }


            } catch (Exception e){
                System.out.println("Invalid input");

            }



