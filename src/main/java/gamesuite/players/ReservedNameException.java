package gamesuite.players;

public class ReservedNameException extends PlayerNameException {

    public ReservedNameException() {
        super();
    }
    public ReservedNameException(String message) {
        super(message);
    }
}
