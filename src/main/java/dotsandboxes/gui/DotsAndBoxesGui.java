package dotsandboxes.gui;


import dotsandboxes.gui.frames.*;
import dotsandboxes.gui.graphics.*;
import gamesuite.board.AbstractBoard;
import gamesuite.game.EndGameException;
import gamesuite.game.Game;
import gamesuite.game.ResetGameException;
import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import javax.swing.*;
import java.util.List;


public class DotsAndBoxesGui extends JFrame implements InputManager, OutputManager {

    private BackgroundPanel backgroundPanel;
    private GameFrame gameFrame;



    public DotsAndBoxesGui(){
        super();
        backgroundPanelInit();
    }

    private void backgroundPanelInit(){

        backgroundPanel = new BackgroundPanel();
        this.setTitle("DOTS AND BOXES");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(backgroundPanel);
        this.setVisible(true);

    }


    @Override
    public Move getMove() throws EndGameException, ResetGameException{

        Move m = gameFrame.getInput();

        if(gameFrame.getEndGame()) throw new EndGameException();
        if(gameFrame.getReset()) throw new ResetGameException();

        return m;
    }

    @Override
    public Integer getPlayersNumber() {

        InputFrame<Integer> PNFrame = new PlayersNumberFrame(backgroundPanel);
        return PNFrame.getInput();
    }

    @Override
    public List<String> getPlayersName(Integer nPlayers) {

        InputFrame<List<String>> playersNameFrame= new PlayersNameFrame(backgroundPanel,nPlayers);
        return playersNameFrame.getInput();
    }

    @Override
    public List<Integer> getGridDimensions() {

        InputFrame<List<Integer>> gridFrame=new GridFrame(backgroundPanel);
        return gridFrame.getInput();
    }


    @Override
    public void startGame(Game game) {

        gameFrame= new GameFrame(backgroundPanel,game);

    }

    @Override
    public void printGame(Game game) {

        gameFrame.updateFrame(game);

    }

     @Override
     public void resetGame(Game game) {
        gameFrame.resetFrame(backgroundPanel);
        this.startGame(game);
        this.printGame(game);
     }

    @Override
    public void printWinner(Game game, boolean gameManuallyEnded) {
        EndFrame endFrame=new EndFrame(backgroundPanel);
        endFrame.printWinner(game);
    }


    @Override
    public boolean customPlayers() {
        return true;
    }

    @Override
    public void printInvalidMove(InvalidMoveException e) {}

    @Override
    public String readInput() {return null;}

    @Override
    public void outputPrintln(String message) {}

    @Override
    public void errorPrintln(String s) {}

    @Override
    public void outputPrint(String s) {}

    @Override
    public void errorPrint(String s) {}

    @Override
    public void printBoard(AbstractBoard board) {}
}
