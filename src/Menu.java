import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);


    /**
     * Menu for the game with the option to end and start.
     */
    public void menu() {
        while (true) {
            try {

                System.out.println("Welcome to minesweeper! Whats your name?");
             //   System.out.println("Hello, " + playerName.getName + " press 1 to Play or 2 to Quit");
                String playerName = sc.nextLine();

                int menuChoice = sc.nextInt();

                if (menuChoice == 1){

                } else if (menuChoice == 2){
                    System.exit(2);
                }


            } catch (Exception e){
                System.out.println("Invalid input");

            }
        }
        }

    }
