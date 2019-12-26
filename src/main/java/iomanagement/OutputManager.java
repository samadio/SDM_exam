package iomanagement;

import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;

public abstract class OutputManager {

    public abstract void printGame(Game game);
    public abstract void printInvalidMove(InvalidMoveException e);

    public abstract void outputPrintln(String message);

    public abstract void errorPrintln(String s);

    public abstract void outputPrint(String s);

    public abstract void errorPrint(String s);
}
