package dotsandboxes.board;

import gamesuite.board.BoardHandle;
import gamesuite.board.BoardManager;
import gamesuite.move.Move;

public class DotsAndBoxesBoardManager extends BoardManager {

    private dotsandboxes.board.BoardHandle board;

    public DotsAndBoxesBoardManager(Integer n, Integer m) {
        this.board =  new dotsandboxes.board.BoardHandle(n,m);
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
    public BoardHandle getBoard() {
        return board;
    }

    @Override
    public void reset() {
        board.reset();
    }
}
