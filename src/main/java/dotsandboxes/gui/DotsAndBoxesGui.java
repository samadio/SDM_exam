package dotsandboxes.gui;

import dotsandboxes.gui.graphics.DotsAndBoxesFrame;
import gamesuite.board.AbstractBoard;
import gamesuite.game.EndGameException;
import gamesuite.game.Game;
import gamesuite.game.ResetGameException;
import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import java.util.List;

public class DotsAndBoxesGui extends DotsAndBoxesFrame implements InputManager, OutputManager {

    private Move currentMove;
    private boolean newMove;

    //      TODO
    //remove readInput from Interface
    @Override
    public String readInput() {return null;}

    @Override
    public void readMove() throws EndGameException, ResetGameException {
        while(!this.newMove){
            //Thread.wait();
        }
        this.newMove=false;
        //this.currentMove=m;
    }

    @Override
    public Move getMove() {
        return null;
    }

    @Override
    public Integer getPlayersNumber() {
        return null;
    }

    @Override
    public List<Integer> getGridDimensions() {
        return null;
    }

    @Override
    public boolean customPlayers() {
        return false;
    }

    @Override
    public String getPlayerName() {
        return null;
    }

    @Override
    public void printGame(Game game) {

    }

    @Override
    public void printInvalidMove(InvalidMoveException e) {

    }

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
