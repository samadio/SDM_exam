package gamesuite.move;

import gamesuite.board.Board;
import gamesuite.board.BoardManager;

public abstract class MoveValidator {
    public abstract void validateMove(Move m) throws Throwable;
}
