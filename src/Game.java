import java.util.Scanner;

public class Game {
    private Player player;
    private Board board;
    private boolean isGameOver;
    private Scanner sc;

    //Konstroktur
    public Game(){
        //Skapa en spelare och en spelplan
        this.sc = new Scanner(System.in);
        this.player = new Player("Spelare 1", 'X');
        this.board = new Board();
        this.isGameOver = false;
    }


    //Spel-loop
    public void play(){
        System.out.println("Välkommen till miniröj!");
        board.DisplayBoard(); //Visa tom spelplan

        //Loopa tills spelet är över
        while (!isGameOver){
            System.out.println(player.getName() + ", välj en ruta (t.ex a1, c3): ");
            String move = sc.nextLine(); //Läs spelarens val

            if(validateMoveFormat(move)){ //Validera spelarens inmatning
                int[] coordinates = parseMove(move); //Omvandla input till koordinater
                checkForValidMoves(coordinates[0], coordinates[1]); //Kontrollera draget

            } else{
                System.out.println("Ogiltigt drag, försök igen!");
            }

            board.DisplayBoard(); //Visa spelplanen efter varje drag
        }


    }

    //Metoden validerar inmatningen
    private boolean validateMoveFormat(String move){
        //kollar om inmatningen matchar formatet a1-f6
        return move.matches("[a-f][1-6]");
    }

    //Omvandla spelarens drag till koordinater
    private int[] parseMove(String move){
        int row = move.charAt(0) - 'a'; //Omvandla bokstav till radnummer (a = 0, b = 1)
        int col = move.charAt(1) - '1'; //Omvandla siffra till kolumnnummer (1 = 0, 2 = 1)
        return new int[]{row, col};
    }


    //Kontrollera om det är en bomb eller säker ruta
    public void checkForValidMoves(int row, int col){
        if(board.isBomb(row, col)){
            System.out.println("Du träffade en bomb! Game over.");
            isGameOver = true;
        } else{
            System.out.println("Ingen bomb här, fortsätt spela.");
        }
    }

}
