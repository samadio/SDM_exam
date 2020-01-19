package dotsandboxes.board;

import gamesuite.board.AbstractBoard;
import gamesuite.move.Move;

import java.util.stream.IntStream;

public class Board extends AbstractBoard {

    private final BoardDimensions DIMS;
    private final LinesGrid HORIZONTAL_LINES;
    private final LinesGrid VERTICAL_LINES;

    public Board(Integer n, Integer m){

        this.DIMS = new BoardDimensions(n,m);
        this.HORIZONTAL_LINES = new LinesGrid(n,m-1);
        this.VERTICAL_LINES = new LinesGrid(n-1, m);
    }


    @Override
    public Boolean getElement(Move.Which w, Integer i, Integer j) {

        return getGrid(w).getLine(i,j);
        /*
        if (w== Move.Which.HORIZONTAL)
            return this.HORIZONTAL_LINES.getLine(i,j);
        else
            return this.VERTICAL_LINES.getLine(i,j);

         */
    }

    private LinesGrid getGrid(Move.Which lineType){

        return (lineType == Move.Which.HORIZONTAL) ? HORIZONTAL_LINES : VERTICAL_LINES;
    }

    @Override
    public Integer getRows() {return DIMS.getRows();}

    @Override
    public Integer getColumns() {return DIMS.getColumns();}

    public void setBoard(Move.Which w, Integer i, Integer j){

        getGrid(w).setLine(i,j,true);
        /*
        if (w== Move.Which.HORIZONTAL)
            this.HORIZONTAL_LINES.setLine(i, j, true);
        else
            this.VERTICAL_LINES.setLine(i, j, true);

         */
    }


    public void reset() {

        HORIZONTAL_LINES.reset();
        VERTICAL_LINES.reset();
    }
}

class BoardDimensions{

    private final Integer N_ROWS;
    private final Integer N_COLS;

    BoardDimensions(Integer rows, Integer cols){

        N_ROWS = rows;
        N_COLS = cols;
    }

    Integer getRows(){
        return N_ROWS;
    }

    Integer getColumns(){
        return N_COLS;
    }
}

class LinesGrid {

    private boolean[][] lineGrid;

    LinesGrid(Integer nRows, Integer nCols){

        lineGrid = new boolean[nRows][nCols];
    }

    void setLine(Integer row, Integer col, Boolean value){

        lineGrid[row][col] = value;
    }

    Boolean getLine(Integer row, Integer col){

        return lineGrid[row][col];
    }

    Integer numRows(){

        return lineGrid.length;
    }

    Integer numColumns(){

        return lineGrid[0].length;
    }

    void reset(){

        IntStream.range(0, numRows()).forEach(x -> IntStream.range(0, numColumns()).forEach(y -> setLine(x, y,false)));
    }
}
