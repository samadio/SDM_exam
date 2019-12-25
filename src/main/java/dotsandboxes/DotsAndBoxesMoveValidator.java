package dotsandboxes;

import gamesuite.board.BoardManager;
import gamesuite.move.*;

public class DotsAndBoxesMoveValidator extends MoveValidator {
    BoardManager bm;

    public DotsAndBoxesMoveValidator(BoardManager desired){
        this.bm=desired;
    }

    public boolean moveAlreadyDone(Move m){
        return bm.moveDone(m);
    }

    @Override
    public boolean outBoardLine(Move m){
        if((m.getRow()<0) | (m.getCol()<0)) return true;
        if(m.getLineKind()== Move.Which.HORIZONTAL) return (m.getCol()>bm.columnsLength()-2) | (m.getRow()>bm.rowLength() - 1) ;
        //VERTICAL case
        return (m.getCol()>bm.columnsLength() - 1)|(m.getRow()>bm.rowLength()-2);
    }

    @Override
    public void validateMove(Move m) throws InvalidMoveException {

        if(outBoardLine(m)) throw new MoveOutOfBoardException(m, "Error: move is out of board!");
        if(moveAlreadyDone(m)) throw new MoveAlreadyDoneException(m, "Error: move already done!");
    }

}