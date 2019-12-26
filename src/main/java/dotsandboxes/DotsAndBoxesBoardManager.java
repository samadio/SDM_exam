package dotsandboxes;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;

public class DotsAndBoxesBoardManager extends BoardManager {

    private Integer rows;
    private Integer columns;
    private Board board;

    public DotsAndBoxesBoardManager(Integer n, Integer m) {
        this.rows = n;
        this.columns = m;
        this.board= new Board(n,m);
    }

    @Override
    public Integer rowLength() {return this.columns;}
    @Override
    public Integer columnsLength() {return this.rows;}

    @Override
    public boolean moveDone(Move m) {
        return this.board.getElement(m.getLineKind(), m.getRow(),m.getCol());
    }

    @Override
    public void updateBoard(Move m) { this.board.setBoard(m.getLineKind(), m.getRow(), m.getCol());}

}
