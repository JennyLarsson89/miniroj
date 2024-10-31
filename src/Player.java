import java.util.Scanner;

public class Player {
    private final String name;
    private int score;

    // Const
    public Player() {
        System.out.print("Ange ditt namn: ");
        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine();
        this.score = 0;
    }

    public String getName(String jonas) {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score++;
    }

    @Override
    public String toString() {
        return "Spelare: " + name + ", Poäng: " + score;
    }
}
