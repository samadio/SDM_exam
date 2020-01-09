package dotsandboxes.gui.io;

import dotsandboxes.gui.graphics.DotsAndBoxesFrame;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;
import iomanagement.OutputManager;

public class GuiOutput extends OutputManager {
    protected DotsAndBoxesFrame frame = new DotsAndBoxesFrame();

    @Override
    public void printGame(Game game) {}

    @Override
    public void printInvalidMove(InvalidMoveException e) {}

    @Override
    public void outputPrintln(String message) {

    }

    @Override
    public void errorPrintln(String s) {

    }

    @Override
    public void outputPrint(String s) {

    }

    @Override
    public void errorPrint(String s) {

    }

    @Override
    public void printWinner(Game game) {

    }

    @Override
    public void printBoard(AbstractBoard board) {

    }
}
