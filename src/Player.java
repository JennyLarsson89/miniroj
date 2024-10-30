public class Player {
    private String name;
    private String playerSymbol;

    // Const
    public Player(String name, String playerSymbol) {
        this.name = name;
        this.playerSymbol = playerSymbol;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setPlayerSymbol(String playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public void setPlayerName(String name){
        this.name = name;
    }

    public String getPlayerSymbol() {return playerSymbol;}


}


