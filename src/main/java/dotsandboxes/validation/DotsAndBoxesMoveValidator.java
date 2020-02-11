package dotsandboxes.validation;

import gamesuite.board.BoardManager;
import gamesuite.move.*;

public class DotsAndBoxesMoveValidator extends MoveValidator {

    private BoardManager bm;

    public DotsAndBoxesMoveValidator(BoardManager bm){
        this.bm = bm;
    }

    private boolean moveAlreadyDone(Move m){
        return bm.moveDone(m);
    }

    @Override
    public boolean outOfBoardLine(Move m){
        if((m.getRow() < 0) | (m.getCol() < 0)) return true;
        if(m.getLineKind() == Move.Orientation.HORIZONTAL) return (m.getCol() > bm.rowLength() - 2) | (m.getRow() > bm.columnsLength() - 1) ;
        //VERTICAL case
        return (m.getCol() > bm.rowLength() - 1)|(m.getRow() > bm.columnsLength() - 2);
    }

    @Override
    public void validateMove(Move m) throws InvalidMoveException {

        if(outOfBoardLine(m)) throw new MoveOutOfBoardException(m, "Error: move is out of board!");
        if(moveAlreadyDone(m)) throw new MoveAlreadyDoneException(m, "Error: move already done!");
    }

}