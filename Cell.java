public class Cell {
    private boolean isBomb;
    private boolean isRevealed;
    private int adjacentBombs;

    public Cell(){
        this.isBomb = false;
        this.isRevealed = false;
        this.adjacentBombs = 0;
    }
}
