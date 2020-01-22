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

    private final BackgroundPanel BACKGROUND_PANEL;
    private GameFrame gameFrame;
    private final PlayersNameFrame PLAYER_NAME_FRAME;



    public DotsAndBoxesGui(){
        super();
        BACKGROUND_PANEL = new BackgroundPanel();
        PLAYER_NAME_FRAME = new PlayersNameFrame(BACKGROUND_PANEL);
        setFrameOptions();
    }

    private void setFrameOptions(){

        this.setTitle("DOTS AND BOXES");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(BACKGROUND_PANEL);
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

        InputFrame<Integer> PNFrame = new PlayersNumberFrame(BACKGROUND_PANEL);
        PNFrame.setPanel();
        return PNFrame.getInput();
    }

    @Override
    public String getPlayerName() {

        PLAYER_NAME_FRAME.setPanel();
        return PLAYER_NAME_FRAME.getInput();
    }

    @Override
    public List<Integer> getGridDimensions() {

        InputFrame<List<Integer>> gridFrame = new GridDimensionFrame(BACKGROUND_PANEL);
        gridFrame.setPanel();
        return gridFrame.getInput();
    }


    @Override
    public void startMatch(Game game) {

        gameFrame= new GameFrame(BACKGROUND_PANEL,game);
        gameFrame.setPanel();

    }

    @Override
    public void printGame(Game game) {

        gameFrame.updateFrame(game);

    }

     @Override
     public void resetMatch(Game game) {
        gameFrame.resetFrame(BACKGROUND_PANEL);
        this.startMatch(game);
        this.printGame(game);
     }

    @Override
    public void printWinner(Game game, boolean manuallyEnded) {
        EndFrame endFrame=new EndFrame(BACKGROUND_PANEL);
        endFrame.printWinner(game);
    }


    @Override
    public boolean customPlayers() {
        return true;
    }

    @Override
    public void printInvalidMove(InvalidMoveException e) {}

    @Override
    public void outputPrintln(String message) {}

    @Override
    public void errorPrintln(String s) {
        PLAYER_NAME_FRAME.showMessage(s);
        //JOptionPane.showMessageDialog(this, s);
    }

    @Override
    public void outputPrint(String s) {}

    @Override
    public void errorPrint(String s) {}

    @Override
    public void printBoard(AbstractBoard board) {}
}
