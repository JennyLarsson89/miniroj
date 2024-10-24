public class Player {
    private final String playerName;
    private String playerSymbol;

    // Const
    public Player(String name, String playerSymbol) {
        this.playerName = name;
        this.playerSymbol = playerSymbol;
    }


    /**
     *
     * @return Return the player name.
     */
    public String getPlayerName() {
        return playerName;
    }
public String setPlayerName(String playerName) {
        return playerName;
}

    /**
     *
     * @return Sets the player symbol.
     */
    public String setPlayerSymbol() {return playerSymbol;}


    /**
     * @return Return the player char symbol
     */
    public String getPlayerSymbol() {return playerSymbol;}




}


