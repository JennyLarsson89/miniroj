import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Player player = new Player("","X");

    /**
     * Menu for the game with the option to end and start.
     */
    public void runMenu() {
        while (true) {
            try {

                System.out.println("Welcome to minesweeper! Whats your name?");
                String playerName = sc.nextLine();
                player.setPlayerName(playerName);

                System.out.println("Hello, " + player.getName() + " press 1 to Play or 0 to Quit");

                int menuChoice = sc.nextInt();

                if (menuChoice == 1){
                    Game game = new Game();
                    game.play();
                } else if (menuChoice == 0){
                    System.exit(0);
                }


            } catch (Exception e){
                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
        }

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
                sc.nextLine();
            }
        }
    }


    }
