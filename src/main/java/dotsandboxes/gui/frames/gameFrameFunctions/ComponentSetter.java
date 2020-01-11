package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.Line;
import dotsandboxes.gui.graphics.SetElements;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.game.Game;
import gamesuite.move.Move;

import javax.swing.*;
import java.util.List;

public class ComponentSetter{
    public void playersLabels(GameFrame gameFrame, List<String> playersName, BackgroundPanel backgroundPanel){
        Integer yOffset=0;

        for (int i=0; i<playersName.size(); i++) {

            JLabel label= new JLabel("Test");
            label.setText("Score    "+playersName.get(i));
            label.setBounds(10, yOffset, 200, 50);
            gameFrame.getLabels().add(label);
            backgroundPanel.add(label);
            yOffset+=20;
        }
    }



    public void endResetButtons(GameFrame gameFrame, BackgroundPanel backgroundPanel){
        JButton endGameButton = new JButton("End Game");
        endGameButton.setBounds(460, 290, 120, 30);

        endGameButton.addActionListener(x ->
        {
            gameFrame.endGame= true;
            gameFrame.inputGiven = true;

        });

        JButton resetGameButton = new JButton("Reset Game");
        resetGameButton.setBounds(460, 330, 120, 30);

        resetGameButton.addActionListener(x ->
        {
            gameFrame.reset = true;
            gameFrame.inputGiven = true;

        });

        backgroundPanel.add(endGameButton);
        backgroundPanel.add(resetGameButton);
    }



    public static void lines(GameFrame gameFrame, BackgroundPanel backgroundPanel){

        ObjSpecifics hEmptySpec = new ObjSpecifics("images/line_empty.png", "images/line_full.png", 50, 20, 50);
        GridSpecifics heGridSpec = new GridSpecifics(6, 5, 50, 15, 155, 68, 50);
        LinesList horizontalLines = SetElements.setGrid(hEmptySpec, heGridSpec, backgroundPanel);

        ObjSpecifics vEmptySpec = new ObjSpecifics("images/line_empty_vertical.png", "images/line_full_vertical.png", 20, 50, 50);
        GridSpecifics veGridSpec = new GridSpecifics(5, 6, 15, 50, 150, 75, 50);
        LinesList verticalLines = SetElements.setGrid(vEmptySpec, veGridSpec, backgroundPanel);

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

}
