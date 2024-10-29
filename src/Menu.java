import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);


    //Start the game with an option to play or quit.
    public void runMenu() {
        while (true) {
            try {

                System.out.println("Welcome to minesweeper! Whats your name?");
                String playerName = sc.nextLine();
                System.out.println("Hello, " + playerName + " press 1 to Play or 0 to Quit");

                int menuChoice = sc.nextInt();

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

    //Option to restart the game.
    public void runMenuAgain() {
        while (true) {
            try {

                System.out.println("Press 1 to Play or 0 to Quit");

                int menuChoice = sc.nextInt();

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
