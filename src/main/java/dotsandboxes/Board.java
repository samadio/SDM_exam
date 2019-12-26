package dotsandboxes;

import gamesuite.move.Move;

public class Board {



    public boolean[][] horizontalLines;
    private boolean[][] verticalLines;

    public Board(Integer n, Integer m){
        this.horizontalLines= new boolean[n][m-1];
        this.verticalLines=  new boolean[n-1][m];
    }

    public Boolean getElement(Move.Which w, Integer i, Integer j) {
        if (w== Move.Which.HORIZONTAL)
            return this.horizontalLines[i][j];
        else
            return this.verticalLines[i][j];
    }

    public void setBoard(Move.Which w, Integer i, Integer j){
        if (w== Move.Which.HORIZONTAL)
            this.horizontalLines[i][j]=true;
        else
            this.verticalLines[i][j]=true;
    }
}
