package dotsandboxes.gui.frames;

import dotsandboxes.gui.frames.gameFrameFunctions.AddBox;
import dotsandboxes.gui.frames.gameFrameFunctions.ComponentSetter;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.Box;
import dotsandboxes.gui.graphics.Line;
import dotsandboxes.gui.graphics.SetElements;
import dotsandboxes.gui.graphics.lists.LabelsList;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.board.AbstractBoard;
import gamesuite.game.EndGameException;
import gamesuite.game.Game;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;
import gamesuite.players.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends Frame {

    private JLabel currentPlayer;
    public Move currentMove;
    private LabelsList labels;
    public boolean endGame;
    public boolean reset;
    private Integer boxesRows;
    private Integer boxesColumns;
    private boolean[][] boxes;

    public GameFrame(BackgroundPanel backgroundPanel, List<String> playersName,Integer bRows,Integer bColumns) {

        super();
        boxesRows=bRows;
        boxesColumns=bColumns;
        boxes=new boolean[boxesRows][boxesColumns];
        endGame = false;
        reset = false;
        labels= new LabelsList();

        ComponentSetter componentSetter= new ComponentSetter();

        componentSetter.playersLabels(this, playersName, backgroundPanel);
        componentSetter.endResetButtons(this,backgroundPanel);

        currentPlayer = new JLabel();
        currentPlayer.setBounds(230, 0, 200, 50);
        backgroundPanel.add(currentPlayer);

        componentSetter.lines(this, backgroundPanel);

        ObjSpecifics dotSpec = new ObjSpecifics("images/dot.png", "", 10, 10, 50);
        GridSpecifics dotGridSpec = new GridSpecifics(6, 6, 50, 50, 130, 50, 50);
        SetElements.setDots(dotSpec, dotGridSpec, backgroundPanel);

        updatePanel(backgroundPanel);
    }


    public Integer getBoxesRows() {return boxesRows;}
    public Integer getBoxesColumns() {return boxesColumns;}
    public boolean[][] getBoxes() {return boxes;}
    public LabelsList getLabels() {return labels;}
    public boolean getReset() {return reset;}
    public Move getMove() {return currentMove;}


    public void readMove() throws EndGameException, ResetGameException {
        waitInput();
        if(endGame==true) throw new EndGameException();
        if(reset==true) throw new ResetGameException();
    }


    public void updateFrame(Game game, BackgroundPanel backgroundPanel) {

        currentPlayer.setText("Current Player:  "+game.nextPlayer().getName());

        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setText("Score " + game.getPlayers().get(i).getName() + "   " + game.getScore().get(game.getPlayers().get(i)));
        }

        AddBox.add(game,this,backgroundPanel);
        updatePanel(backgroundPanel);
    }


    public void resetFrame(BackgroundPanel backgroundPanel) {

        boxes=new boolean[boxesRows][boxesColumns];
        clear(backgroundPanel);

    }

}



