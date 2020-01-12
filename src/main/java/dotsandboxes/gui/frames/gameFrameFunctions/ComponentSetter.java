package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBButton;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.Line;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.move.Move;
import gamesuite.players.Player;

import javax.swing.*;
import java.util.List;

public class ComponentSetter{

    ObjSpecifics horizontalLinesSpec;
    ObjSpecifics verticalLinesSpec;
    ObjSpecifics dotsSpec;
    GridSpecifics horizontalGridSpec;
    GridSpecifics verticalGridSpec;
    GridSpecifics dotsGridSpec;


    public ComponentSetter(Integer rows, Integer cols){

        Integer x_limit=120;

        horizontalLinesSpec = new ObjSpecifics("images/line_empty.png", "images/line_full.png", 50, 20, 50);
        horizontalGridSpec = new GridSpecifics(rows+1, cols, 50, 15, x_limit, 68, 50);

        verticalLinesSpec = new ObjSpecifics("images/line_empty_vertical.png", "images/line_full_vertical.png", 20, 50, 50);
        verticalGridSpec = new GridSpecifics(rows, cols+1, 15, 50, x_limit, 75, 50);

        dotsSpec = new ObjSpecifics("images/dot.png", "", 15, 15, 50);
        dotsGridSpec = new GridSpecifics(rows+1, cols+1, 50, 50, x_limit, 50, 50);

        /*
        horizontalLinesSpec = new ObjSpecifics("images/line_empty.png", "images/line_full.png", 50, 20, 50);
        horizontalGridSpec = new GridSpecifics(rows+1, cols, 50, 15, 155, 68, 50);

        verticalLinesSpec = new ObjSpecifics("images/line_empty_vertical.png", "images/line_full_vertical.png", 20, 50, 50);
        verticalGridSpec = new GridSpecifics(rows, cols+1, 15, 50, 150, 75, 50);

        dotsSpec = new ObjSpecifics("images/dot.png", "", 10, 10, 50);
        dotsGridSpec = new GridSpecifics(rows+1, cols+1, 50, 50, 130, 50, 50);
        */



    }

    public void playersLabels(GameFrame gameFrame,List<Player>  players, BackgroundPanel backgroundPanel){


        DBLabel score= new DBLabel("SCORE",10, 5, 100, 30);
        backgroundPanel.add(score);

        Integer yOffset=40;
        for (int i=0; i<players.size(); i++) {

            DBLabel label= new DBLabel(players.get(i).getName(),10, yOffset, 100, 30);
            gameFrame.getLabels().add(label);
            backgroundPanel.add(label);
            yOffset+=40;
        }
    }



    public void endResetButtons(GameFrame gameFrame, BackgroundPanel backgroundPanel){
        DBButton endGameButton = new DBButton("END GAME",470, 290, 120, 30);

        endGameButton.addActionListener(x ->
        {
            gameFrame.endGame= true;
            gameFrame.inputGiven = true;

        });

        DBButton resetGameButton = new DBButton("RESET GAME",470, 330, 120, 30);

        resetGameButton.addActionListener(x ->
        {
            gameFrame.reset = true;
            gameFrame.inputGiven = true;

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

}
