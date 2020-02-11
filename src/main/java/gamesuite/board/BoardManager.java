package gamesuite.board;

import gamesuite.move.Move;

public abstract class BoardManager {

    public abstract Integer rowLength();
    public abstract Integer columnsLength();
    public abstract boolean moveDone(Move m);
    public abstract void updateBoard(Move m);
    public abstract BoardHandle getBoard();

    public abstract void reset();
}



