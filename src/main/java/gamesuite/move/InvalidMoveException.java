package gamesuite.move;

public class InvalidMoveException extends Exception {
    Move invalid;

    public InvalidMoveException(Move m, String message) {
        super(message);
        invalid = m;
    }
    public InvalidMoveException(Move m){
        super();
        invalid = m;
    }

    public Move getInvalid() {
        return invalid;
    }
}
