import java.util.Scanner;

public class Game {
    private Player player;
    private Board board;


    public Game(Player player, Board board) {
        this.player = player;
        this.board = board;
    }


    /**
     * The game loop starts here.
     */

    public void play(){
        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;

        System.out.println("Welcome to the game of TicTacToe! 1:PLAY 2:Quit");
        String playerMove = sc.nextLine();
        while (true){
            try {
                while (!gameOver){

                    if (playerMove.equals("2")){
                        System.out.println("Thanks for playing, bye!!");
                        System.exit(2);

                    }else if (playerMove.equals("1")){
                        board.DisplayBoard();
                        board.checkForValidMoves(sc, board.getBoard(), player);




                    }


                }


            }catch (Exception e){
                System.out.println("Try again");
                sc.nextLine();
            }

        }

    }



}
