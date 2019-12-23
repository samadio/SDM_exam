package gamesuite.move;

import gamesuite.board.BoardManager;

public class DotsAndBoxesMoveValidator extends MoveValidator{
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
        if(m.getLineKind()== Move.Which.HORIZONTAL) return (m.getCol()>bm.columnsLength()-1) | (m.getRow()>bm.rowLength()) ;
        //VERTICAL case
        return (m.getCol()>bm.columnsLength())|(m.getRow()>bm.rowLength()-1);
    }

    @Override
    public void validateMove(Move m) throws RuntimeException {
        if(outBoardLine(m)) throw new MoveOutOfBoardException(m);
        if(moveAlreadyDone(m)) throw new MoveAlreadyDoneException(m);
    }

}