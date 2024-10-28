public class Player {
    private final String name;
    private char playerSymbol;

    // Const
    public Player(String name, char playerSymbol) {
        this.name = name;
        this.playerSymbol = playerSymbol;
    }

    /**@return Return the player name.*/
    public String getName() {
        return name;
    }

    /**@return Sets the player symbol.*/
    public char setPlayerSymbol() {return playerSymbol;}


    /**@return Return the player char symbol*/
    public char getPlayerSymbol() {return playerSymbol;}

}


