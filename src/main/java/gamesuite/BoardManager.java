package gamesuite;

public abstract class BoardManager {

    public abstract boolean moveDone(Move move);

    public abstract boolean isValidMove(Move move);

    public abstract Integer rowLength();
}
