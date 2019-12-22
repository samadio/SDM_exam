package gamesuite.move;

import gamesuite.board.BoardManager;

public class MoveValidator {
    BoardManager bm;

    public MoveValidator(BoardManager desired){
        this.bm=desired;
    }

    public boolean lineOccupied(Move m) throws MoveAlreadyDoneException{
        if(bm.moveDone(m)) throw new MoveAlreadyDoneException(m);
        return false;
    }


}
