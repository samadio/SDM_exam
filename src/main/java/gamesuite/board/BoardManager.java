package gamesuite.board;

import gamesuite.move.Move;
import gamesuite.move.MoveAlreadyDoneException;
import gamesuite.move.MoveOutOfBoardException;

public abstract class BoardManager {

    public abstract Integer rowLength();
    public abstract Integer columnsLength();
    public abstract boolean moveDone(Move m);
    public abstract void updateBoard(Move m);
    public abstract AbstractBoard getBoard();

    public abstract void reset();
}



