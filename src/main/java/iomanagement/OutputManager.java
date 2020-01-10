package iomanagement;

import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;

public interface OutputManager {

    public void startGame();

    public  void printGame(Game game);

    public  void printInvalidMove(InvalidMoveException e);

    public  void outputPrintln(String message);

    public  void errorPrintln(String s);

    public  void outputPrint(String s);

    public  void errorPrint(String s);

    public  void printWinner(Game game);

    public  void printBoard(AbstractBoard board);

}
