package iomanagement;

import gamesuite.board.AbstractBoard;
import gamesuite.game.EndGameException;
import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;

public interface OutputManager {



     void startMatch(Game game);

      void printGame(Game game);

      void printInvalidMove(InvalidMoveException e);

      void outputPrintln(String message);

      void errorPrintln(String s);

      void outputPrint(String s);

     void resetMatch(Game game);

      void errorPrint(String s);

      void printWinner(Game game, boolean gameManuallyEnded);

      void printBoard(AbstractBoard board);

}
