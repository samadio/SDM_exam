package iomanagement;

import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;

public interface OutputManager {



     void startMatch(Game game);

      void printGame(Game game);

      void printInvalidMove(InvalidMoveException e);

      void outputMessage(String message);

      void errorMessage(String s);

      void printWinner(Game game);

      void initialMessage();

}
