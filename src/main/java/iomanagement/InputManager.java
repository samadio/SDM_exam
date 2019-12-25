package iomanagement;
import gamesuite.move.Move;

import java.util.List;
import java.util.zip.DataFormatException;

public abstract class InputManager {

    protected Move currentMove;

    public abstract void readMove() throws DataFormatException;

    public abstract Move getMove();

    public abstract Integer[] getGrid() throws DataFormatException;

    public abstract Integer getPlayersNumber() throws DataFormatException;

    public abstract List<Integer> getGridDimensions();

    public abstract boolean customPlayers() throws DataFormatException;

    public abstract String getPlayerName();
}



