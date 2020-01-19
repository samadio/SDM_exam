package iomanagement;
import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;

import java.util.ArrayList;
import java.util.List;


public interface InputManager {

    public abstract String readInput();

    public abstract Move getMove() throws EndGameException, ResetGameException;

    public abstract Integer getPlayersNumber();

    public abstract List<Integer> getGridDimensions();

    public abstract boolean customPlayers();

    public abstract List<String> getPlayersName(Integer nPlayers);

}



