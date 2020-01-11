package dotsandboxes.gui;


import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.frames.PlayersNameFrame;
import dotsandboxes.gui.frames.PlayersNumberFrame;
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

    private BackgroundPanel backgroundPanel = new BackgroundPanel();
    private GameFrame gameFrame;
    private List<String> playersNames;

    private Move currentMove;
    private boolean inputGiven;
    private LabelsList labels;

    private JLabel currentPlayer;
    private Integer numPlayers;
    private boolean endGame;
    private boolean reset;
    private Integer boxesRows;
    private Integer boxesColumns;
    private boolean[][] boxes;



    public DotsAndBoxesGui(){
        super();
        init();
    }

    private void init(){

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
        numPlayers=PNFrame.setFrame(backgroundPanel);

        return numPlayers;
    }


    @Override
    public List<Integer> getGridDimensions() {
        List<Integer> list= new ArrayList<Integer>(2);
        list.add(6);
        list.add(6);
        boxesRows=5;
        boxesColumns=5;
        return list;
    }

    @Override
    public boolean customPlayers() {
        return true;
    }

    @Override
    public List<String> getPlayersName(Integer nPlayers) {

        PlayersNameFrame PNFrame= new PlayersNameFrame();
        playersNames=PNFrame.setFrame(backgroundPanel,nPlayers);
       return  playersNames;
    }


    @Override
    public void startGame() {

        gameFrame= new GameFrame(backgroundPanel,playersNames,boxesRows,boxesColumns);

    }

    @Override
    public void printGame(Game game) {

        gameFrame.updateFrame(game,backgroundPanel);

    }

     @Override
     public void resetGame(Game game) {
        gameFrame.resetFrame(backgroundPanel);
        this.startGame();
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
/*
        List<Player> winners = game.getWinner();


        backgroundPanel.removeAll();
        backgroundPanel.revalidate();
        backgroundPanel.repaint();
        JLabel winMessage = new JLabel("",SwingConstants.CENTER);
        winMessage.setBounds(215, 30, 250, 50);
        List<JLabel> winnersLabels= new ArrayList<>();

        if (winners.size() == 1) winMessage.setText("The winner is");
        else winMessage.setText("<html>Game is a draw<br/>The following players have the same score:<html>");

        backgroundPanel.add(winMessage);
        Integer yOffset = 80;

        for (Player p : winners) {
            JLabel label= new JLabel(p.getName());
            label.setBounds(260, yOffset, 80, 30);

            yOffset+=30;
            backgroundPanel.add(label);
            winnersLabels.add(label);
        }
        backgroundPanel.revalidate();
        backgroundPanel.repaint();
*/
    }

    @Override
    public void printBoard(AbstractBoard board) {

    }
}
