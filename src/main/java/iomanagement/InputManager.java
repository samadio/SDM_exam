package iomanagement;
import gamesuite.game.EndGameException;
import gamesuite.move.Move;

import java.util.List;

public abstract class InputManager {

    protected Move currentMove;
    protected final OutputManager OUTPUT;

    protected InputManager(OutputManager oManager){

        OUTPUT = oManager;
    }

    public abstract String readInput();

    public abstract void readMove() throws EndGameException;

    public abstract Move getMove();

    public abstract Integer getPlayersNumber();

    public abstract List<Integer> getGridDimensions();

    public abstract boolean customPlayers();

    public abstract String getPlayerName();

}



