package dotsandboxes;

import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;
import iomanagement.OutputManager;

public class DotsAndBoxesOutput extends OutputManager {

    @Override
    public void printGame(Game game) {

        System.out.println("Hello, world!");
    }

    @Override
    public void printInvalidMove(InvalidMoveException e) {

        System.err.println(e.getMessage());
    }

    @Override
    public void outputPrintln(String message) {
        System.out.println(message);
    }

    @Override
    public void errorPrintln(String s) {
        System.err.println(s);
    }

    @Override
    public void outputPrint(String s) {
        System.out.print(s);
    }

    @Override
    public void errorPrint(String s) {
        System.err.print(s);
    }
}
