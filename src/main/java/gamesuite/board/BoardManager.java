package gamesuite.board;

import gamesuite.move.Move;
import gamesuite.move.MoveAlreadyDoneException;
import gamesuite.move.MoveOutOfBoardException;

public class BoardManager {
    private Integer rows;
    private Integer columns;
    private Board board;

    public BoardManager(Integer n, Integer m) {
        this.rows = n;
        this.columns = m;
        this.board= new Board(n,m);
    }

    //needed by Federico
    public Integer rowLength() {return this.columns;}
    public Integer columnsLength() {return this.rows;}

    //needed by Federico
    public boolean moveDone(Move m) {
        return (this.board.getElement(new Indexes(m,this.rows)));
    }

    //needed by Simone
    public void updateBoard(Move m) { this.board.setBoard(new Indexes(m, this.rows));}

}



