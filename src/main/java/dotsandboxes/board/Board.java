package dotsandboxes.board;

import gamesuite.board.AbstractBoard;
import gamesuite.move.Move;

import java.util.stream.IntStream;

public class Board extends AbstractBoard {

    private Integer rows;
    private Integer columns;
    public boolean[][] horizontalLines;
    private boolean[][] verticalLines;

    public Board(Integer n, Integer m){
        this.rows=n;
        this.columns=m;
        this.horizontalLines= new boolean[n][m-1];
        this.verticalLines=  new boolean[n-1][m];
    }

    @Override
    public Boolean getElement(Move.Which w, Integer i, Integer j) {
        if (w== Move.Which.HORIZONTAL)
            return this.horizontalLines[i][j];
        else
            return this.verticalLines[i][j];
    }

    @Override
    public Integer getRows() {return rows;}

    @Override
    public Integer getColumns() {return columns;}

    public void setBoard(Move.Which w, Integer i, Integer j){
        if (w== Move.Which.HORIZONTAL)
            this.horizontalLines[i][j]=true;
        else
            this.verticalLines[i][j]=true;
    }


    public void reset() {

        IntStream.range(0, horizontalLines.length).forEach((x -> IntStream.range(0, horizontalLines[x].length).forEach(y -> horizontalLines[x][y] = false)));
        IntStream.range(0, verticalLines.length).forEach((x -> IntStream.range(0, verticalLines[x].length).forEach(y -> verticalLines[x][y] = false)));
    }
}
