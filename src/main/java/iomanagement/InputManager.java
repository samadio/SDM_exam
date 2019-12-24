package iomanagement;
import gamesuite.move.Move;

import java.util.zip.DataFormatException;

public abstract class InputManager {

    protected Move currentMove;

    public abstract void readMove() throws DataFormatException;

    public abstract Move getMove();

    public abstract Integer[] getGrid() throws DataFormatException;

    public abstract Integer getPlayersNumber() throws DataFormatException;

    public abstract boolean customizePlayers() throws DataFormatException;
}



