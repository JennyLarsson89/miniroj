public class Cell {
    private boolean isMine;
    private boolean isFlagged;
    private int adjacentMines;  // antalet miner i angränsande celler.

    // Const
    public Cell() {
        this.isMine = false;
        this.isFlagged = false;
        this.adjacentMines = 0;
    }

    public boolean isMine() {
        return isMine; // om cellen är en mina.
    }

    public void setMine(boolean isMine) {
        this.isMine = isMine; // Sätter cellen som en mina eller inte beroende på det angivna värdet.
    }

    public boolean isFlagged() {
        return isFlagged; // om cellen är flaggad.
    }

    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged; // Sätter cellens flaggstatus.
    }

    public int getAdjacentMines() {
        return adjacentMines; // antalet angränsande minor.
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines; // antalet angränsande minor för cellen.
    }
}

