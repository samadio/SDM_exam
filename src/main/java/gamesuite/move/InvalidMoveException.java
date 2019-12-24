package gamesuite.move;

public abstract class InvalidMoveException extends Exception {
    Move invalid;

    public Move getInvalid() {
        return invalid;
    }
}
