package dotsandboxes.board;

import gamesuite.board.AbstractBoard;
import gamesuite.board.BoardManager;
import gamesuite.move.Move;

public class DotsAndBoxesBoardManager extends BoardManager {

    private Board board;

    public DotsAndBoxesBoardManager(Integer n, Integer m) {
        this.board= new Board(n,m);
    }

    @Override
    public Integer rowLength() {return this.board.getColumns();}
    @Override
    public Integer columnsLength() {return this.board.getRows();}

    @Override
    public boolean moveDone(Move m) {
        return this.board.getElement(m.getLineKind(), m.getRow(),m.getCol());
    }

    @Override
    public void updateBoard(Move m) { this.board.setBoard(m.getLineKind(), m.getRow(), m.getCol());}

    @Override
    public AbstractBoard getBoard() {
        return board;
    }

    @Override
    public void reset() {
        board.reset();
    }
}
