public class Player {
    private String name;
    private String playerSymbol;

    // Const
    public Player(String name, String playerSymbol) {
        this.name = name;
        this.playerSymbol = playerSymbol;
    }


    /**
     *
     * @return Return the player name.
     */
    public String getName() {
        return name;
    }


    /**
     *
     * @return Sets the player symbol.
     */
    public void setPlayerSymbol(String playerSymbol) {

        this.playerSymbol = playerSymbol;

    }

    public void setPlayerName(String name){
        this.name = name;
    }


    /**
     *
     * @return Return the player char symbol
     */
    public String getPlayerSymbol() {return playerSymbol;}




}


