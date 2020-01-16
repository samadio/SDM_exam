package gamesuite.move;

public abstract class MoveValidator {

    public abstract void validateMove(Move m) throws InvalidMoveException;
    public abstract boolean outOfBoardLine(Move m);
}
