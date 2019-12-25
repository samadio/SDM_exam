package gamesuite.move;

public class MoveOutOfBoardException extends InvalidMoveException{
    public MoveOutOfBoardException(Move m, String message) {
        super(m, message);
    }

    public MoveOutOfBoardException(Move m) {
        super(m);
    }
}
