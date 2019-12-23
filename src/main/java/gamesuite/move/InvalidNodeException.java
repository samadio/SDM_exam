package gamesuite.move;

public class InvalidNodeException extends Throwable {
    Move invalid;
    public InvalidNodeException(Move m) {
        this.invalid=m;
    }

    public Move getInvalid() {
        return invalid;
    }
}
