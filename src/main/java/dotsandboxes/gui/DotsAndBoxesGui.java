package dotsandboxes.gui;


import dotsandboxes.gui.frames.*;
import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.Box;
import dotsandboxes.gui.graphics.lists.LabelsList;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.board.AbstractBoard;
import gamesuite.game.EndGameException;
import gamesuite.game.Game;
import gamesuite.game.ResetGameException;
import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;
import gamesuite.players.Player;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class DotsAndBoxesGui extends JFrame implements InputManager, OutputManager {

    private BackgroundPanel backgroundPanel;
    private GameFrame gameFrame;



    public DotsAndBoxesGui(){
        super();
        backgroundPanellInit();
    }

    private void backgroundPanellInit(){

        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);
        this.setTitle("DOTS AND BOXES");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(backgroundPanel);

    }


    @Override
    public String readInput() {return null;}


    @Override
    public void readMove() throws EndGameException, ResetGameException {
        gameFrame.readMove();
    }


    @Override
    public Move getMove() {
        return gameFrame.getMove();
    }



    @Override
    public Integer getPlayersNumber() {

        this.setVisible(true);

        PlayersNumberFrame PNFrame=new PlayersNumberFrame();
        Integer numPlayers=PNFrame.setFrame(backgroundPanel);

        return numPlayers;
    }


    @Override
    public List<Integer> getGridDimensions() {

        GridFrame gridFrame=new GridFrame();
        List<Integer> gridDimensions= gridFrame.setFrame(backgroundPanel);
        return gridDimensions;
    }

    @Override
    public boolean customPlayers() {
        return true;
    }

    @Override
    public List<String> getPlayersName(Integer nPlayers) {

        PlayersNameFrame playersNameFrame= new PlayersNameFrame();
        List<String> playersNames=playersNameFrame.setFrame(backgroundPanel,nPlayers);
        return  playersNames;
    }


    @Override
    public void startGame(Game game) {

        gameFrame= new GameFrame(backgroundPanel,game);

    }

    @Override
    public void printGame(Game game) {

        gameFrame.updateFrame(backgroundPanel,game);

    }

     @Override
     public void resetGame(Game game) {
        gameFrame.resetFrame(backgroundPanel);
        this.startGame(game);
        this.printGame(game);
     }


    @Override
    public void printInvalidMove(InvalidMoveException e) {

    }

    @Override
    public void outputPrintln(String message) {
        System.out.println(message);
    }

    @Override
    public void errorPrintln(String s) {

    }

    @Override
    public void outputPrint(String s) {
        System.out.print(s);
    }

    @Override
    public void errorPrint(String s) {

    }

    @Override
    public void printWinner(Game game, boolean gameManuallyEnded) {
        EndFrame endFrame=new EndFrame();
        endFrame.printWinner(backgroundPanel, game);
    }

    @Override
    public void printBoard(AbstractBoard board) {

    }
}
