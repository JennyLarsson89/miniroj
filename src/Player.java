import javax.lang.model.element.Name;

public class Player {
    private  String name;
    private int score;
    private char Symbol;

    // Const
    public Player(String name,int score,char symbol) {
        this.name = name;
        this.score = score;
        this.Symbol = symbol;

    }

    public char getSymbol() {
        return Symbol;
    }
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score++;
    }
}
