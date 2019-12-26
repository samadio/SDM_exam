package iomanagement;
import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;

import java.util.List;
import java.util.zip.DataFormatException;

public abstract class InputManager {

    protected Move currentMove;
    protected final OutputManager OUTPUT;

    protected InputManager(OutputManager oManager){

        OUTPUT = oManager;
    }

    public abstract void readMove();

    public abstract Move getMove();

    public abstract Integer getPlayersNumber();

    public abstract List<Integer> getGridDimensions();

    public abstract boolean customPlayers();

    public abstract String getPlayerName();

}



