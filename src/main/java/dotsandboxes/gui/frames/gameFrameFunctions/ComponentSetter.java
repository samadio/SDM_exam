package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBButton;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.Line;
import dotsandboxes.gui.graphics.lists.LabelsList;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.Move;
import gamesuite.players.Player;

import javax.swing.*;
import java.util.List;

public class ComponentSetter{

    private ObjSpecifics horizontalLinesSpec;
    private ObjSpecifics verticalLinesSpec;
    private ObjSpecifics dotsSpec;
    private GridSpecifics horizontalGridSpec;
    private GridSpecifics verticalGridSpec;
    private GridSpecifics dotsGridSpec;

    private Integer xOffset;
    private Integer yOffset;
    private Integer dimOne;
    private Integer dimTwo;


    public ComponentSetter(Integer rows, Integer cols){

        dimOne=45;
        dimTwo=15;
        xOffset=120+(340-(dimOne+dimTwo)*cols)/2;
        yOffset=50+(300-(dimOne+dimTwo)*rows)/2;


        horizontalLinesSpec = new ObjSpecifics("images/horizontal_empty.png", "images/horizontal_full.png", dimOne, dimTwo, 50);
        horizontalGridSpec = new GridSpecifics(rows+1, cols, dimOne, dimTwo, xOffset+dimTwo, yOffset, dimOne+dimTwo);

        verticalLinesSpec = new ObjSpecifics("images/vertical_empty.png", "images/vertical_full.png", dimTwo, dimOne, 50);
        verticalGridSpec = new GridSpecifics(rows, cols+1, dimTwo, dimOne, xOffset, yOffset+dimTwo, dimOne+dimTwo);

        dotsSpec = new ObjSpecifics("images/dot.png", "", 10, 10, 50);
        dotsGridSpec = new GridSpecifics(rows+1, cols+1, dimTwo, dimTwo, xOffset, yOffset, dimOne+dimTwo);

    }


    public Integer getXOffset(){return  xOffset;}
    public Integer getYOffset(){return  yOffset;}
    public Integer getDimOne() {return  dimOne;}
    public Integer getDimTwo() {return  dimTwo;}


    public void playersLabels(GameFrame gameFrame,List<Player>  players, BackgroundPanel backgroundPanel){

        Integer yOffset=40;

        DBLabel score= new DBLabel("SCORE",10, yOffset, 100, 30);
        backgroundPanel.add(score);


        for (int i=0; i<players.size(); i++) {
            yOffset+=40;
            DBLabel label= new DBLabel(players.get(i).getName(),10, yOffset, 100, 30);
            gameFrame.getLabels().add(label);
            backgroundPanel.add(label);
        }
    }


    public void currentPlayerLabel(BackgroundPanel backgroundPanel,DBLabel currentPlayerLabel) {
        currentPlayerLabel.setLabelProperties("",180, 10, 250, 30);
        backgroundPanel.add(currentPlayerLabel);
    }



    public void endResetButtons(GameFrame gameFrame, BackgroundPanel backgroundPanel){
        DBButton endGameButton = new DBButton("END GAME",470, 290, 120, 30);

        endGameButton.addActionListener(x ->
        {
            gameFrame.endGame= true;
            gameFrame.inputGiven = true;
            endGameButton.setDark();

        });

        DBButton resetGameButton = new DBButton("RESET GAME",470, 330, 120, 30);

        resetGameButton.addActionListener(x ->
        {
            gameFrame.reset = true;
            gameFrame.inputGiven = true;
            resetGameButton.setDark();
        });

        backgroundPanel.add(endGameButton);
        backgroundPanel.add(resetGameButton);
    }





    public void lines(GameFrame gameFrame, BackgroundPanel backgroundPanel){


        LinesList horizontalLines = SetElementsInGrid.setGrid(horizontalLinesSpec, horizontalGridSpec, backgroundPanel);
        LinesList verticalLines = SetElementsInGrid.setGrid(verticalLinesSpec, verticalGridSpec, backgroundPanel);

        for (Line l : horizontalLines) {
            l.addActionListener(x ->
            {
                gameFrame.currentMove = new Move(Move.Which.HORIZONTAL, l.getRow(), l.getColumn());
                gameFrame.inputGiven = true;
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(), l.getLineH(), l.getLineHints()));
                l.setIcon(imageIcon);
            });
        }

        for (Line l : verticalLines) {
            l.addActionListener(x ->
            {
                gameFrame.currentMove = new Move(Move.Which.VERTICAL, l.getRow(), l.getColumn());
                gameFrame.inputGiven = true;
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(), l.getLineH(), l.getLineHints()));
                l.setIcon(imageIcon);
            });
        }
    }


    public void dots(BackgroundPanel backgroundPanel) {

        SetElementsInGrid.setDots(dotsSpec, dotsGridSpec, backgroundPanel);

    }


    public void setScores(Game game, LabelsList labels) {
        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setText(game.getPlayers().get(i).getName() + "   " + game.getScore().get(game.getPlayers().get(i)));
        }
    }


    public  void addBox(Game game, GameFrame gameFrame,  BackgroundPanel backgroundPanel) {
        AbstractBoard board = game.getBoard();

        for (int i = 0; i < gameFrame.getBoxesRows(); i++) {
            for (int j = 0; j < gameFrame.getBoxesColumns(); j++) {

                if (board.getElement(Move.Which.HORIZONTAL, i, j) && board.getElement(Move.Which.HORIZONTAL, i + 1, j)
                        && board.getElement(Move.Which.VERTICAL, i, j) && board.getElement(Move.Which.VERTICAL, i, j + 1)) {

                    if (gameFrame.getBoxes()[i][j] == false) {
                        SetElementsInGrid.setBox(i, j,this, backgroundPanel);
                        gameFrame.getBoxes()[i][j] = true;
                    }
                }
            }
        }
    }

}
