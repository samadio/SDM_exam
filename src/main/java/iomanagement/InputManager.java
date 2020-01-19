package iomanagement;
import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;

import java.util.ArrayList;
import java.util.List;


public interface InputManager {

     Move getMove() throws EndGameException, ResetGameException;

     Integer getPlayersNumber();

     List<Integer> getGridDimensions();

     boolean customPlayers();

     String getPlayerName();

}



