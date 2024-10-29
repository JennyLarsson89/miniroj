public class Player {
    private final String playerName;
    private char playerSymbol;

    // Const
    public Player(String playerName, char playerSymbol) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }

    public String setPlayerName(String playerName) {return playerName;}


    /**
     *
     * @return Return the player name.
     */
    public String getPlayerName() {
        return playerName;
    }


    /**
     *
     * @return Sets the player symbol.
     */
    public char setPlayerSymbol() {return playerSymbol;}


    /**
     *
     * @return Return the player char symbol
     */
    public char getPlayerSymbol() {return playerSymbol;}




}


