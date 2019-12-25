package gamesuite.move;

public class MoveAlreadyDoneException extends InvalidMoveException{

    public MoveAlreadyDoneException(Move m, String message) {
        super(m, message);
    }

    public MoveAlreadyDoneException(Move m) {
        super(m);
    }
}
