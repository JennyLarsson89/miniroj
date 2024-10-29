import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Player player = new Player("","x");



    public void runMenu() {

        System.out.println("Welcome to minesweeper! Whats your name?");
        String playerName = sc.nextLine();
        System.out.println("Hello, " +player.setPlayerName(playerName)+ " press 1 to Play or 0 to Quit");

        while (true) {
            try {

                int menuChoice = sc.nextInt();

                if (menuChoice == 1){
                    Game game = new Game();
                    game.play();
                } else if (menuChoice == 0){
                    System.out.println("Goodbye!");
                    System.exit(0);
                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid input 1:Play 0:Quit");
                sc.nextLine();

            }
        }
        }

    public void runMenuAgain() {
        System.out.println("Press 1 to Play or 0 to Quit");
        int menuChoice = sc.nextInt();

        while (true) {
            try {

                if (menuChoice == 1){
                    Game game = new Game();
                    game.play();
                } else if (menuChoice == 0){
                    System.exit(0);
                }


            } catch (Exception e){
                System.out.println("Invalid input");

            }
        }
    }


    }
