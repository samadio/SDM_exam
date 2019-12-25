package iomanagement;
import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;

import java.util.List;
import java.util.zip.DataFormatException;

public abstract class InputManager {

    protected Move currentMove;

    public abstract void readMove();

    public abstract Move getMove();

    public abstract Integer getPlayersNumber() throws DataFormatException;

    public abstract List<Integer> getGridDimensions() throws DataFormatException;

    public abstract boolean customPlayers() throws DataFormatException;

    public abstract String getPlayerName();

    public abstract void printInvalidMove(InvalidMoveException e);

}



