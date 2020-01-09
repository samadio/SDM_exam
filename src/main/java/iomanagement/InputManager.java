package iomanagement;
import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;

import java.util.List;


public interface InputManager {


    public abstract String readInput();

    public abstract void readMove() throws EndGameException, ResetGameException;

    public abstract Move getMove();

    public abstract Integer getPlayersNumber();

    public abstract List<Integer> getGridDimensions();

    public abstract boolean customPlayers();

    public abstract String getPlayerName();

}



