public class Main {
    public static void main(String[] args) {

        Player player = new Player("","x");
        Game game = new Game(player,new Board());
        game.play();

    }
}
