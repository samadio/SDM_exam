package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.Line;
import dotsandboxes.gui.graphics.SetElements;
import dotsandboxes.gui.graphics.lists.LabelsList;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.move.Move;

import javax.swing.*;

public class GameFrame extends Frame{

    private JLabel currentPlayer;
    private Move currentMove;
    private boolean endGame;
    private boolean reset;
    private Integer boxesRows;
    private Integer boxesColumns;
    private boolean[][] boxes;

    public GameFrame(){
        super();
    }

    public void setFrame(BackgroundPanel backgroundPanel, LabelsList labels){
        endGame=false;
        reset=false;

        for (JLabel i : labels) backgroundPanel.add(i);

        JButton endGameButton=new JButton("End Game");
        endGameButton.setBounds(460, 290, 120, 30);

        endGameButton.addActionListener(x ->
        {
            endGame=true;
            inputGiven=true;

        });

        JButton resetGameButton=new JButton("Reset Game");
        resetGameButton.setBounds(460, 330, 120, 30);

        resetGameButton.addActionListener(x ->
        {
            reset=true;
            inputGiven=true;

        });

        backgroundPanel.add(endGameButton);
        backgroundPanel.add(resetGameButton);

        currentPlayer= new JLabel();
        currentPlayer.setBounds(230, 0, 200, 50);
        backgroundPanel.add(currentPlayer);

        ObjSpecifics hEmptySpec= new ObjSpecifics("images/line_empty.png","images/line_full.png",50, 20, 50);
        GridSpecifics heGridSpec=new GridSpecifics(6,5,50, 15, 155, 68 , 50);
        LinesList horizontalLines= SetElements.setGrid(hEmptySpec,heGridSpec,backgroundPanel);

        ObjSpecifics vEmptySpec= new ObjSpecifics("images/line_empty_vertical.png","images/line_full_vertical.png",20, 50, 50);
        GridSpecifics veGridSpec=new GridSpecifics(5,6,15, 50, 150, 75 , 50);
        LinesList verticalLines= SetElements.setGrid(vEmptySpec,veGridSpec,backgroundPanel);

        for(Line l:horizontalLines) {
            l.addActionListener(x ->
            {
                currentMove = new Move(Move.Which.HORIZONTAL,l.getRow(),l.getColumn());
                inputGiven=true;
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(),l.getLineH(),l.getLineHints()));
                l.setIcon(imageIcon);
            });
        }

        for(Line l:verticalLines) {
            l.addActionListener(x ->
            {
                currentMove = new Move(Move.Which.VERTICAL,l.getRow(),l.getColumn());
                inputGiven=true;
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(),l.getLineH(),l.getLineHints()));
                l.setIcon(imageIcon);
            });
        }

        ObjSpecifics dotSpec= new ObjSpecifics("images/dot.png","",10, 10, 50);
        GridSpecifics dotGridSpec=new GridSpecifics(6,6,50, 50, 130, 50 , 50);
        SetElements.setDots(dotSpec,dotGridSpec,backgroundPanel);





        backgroundPanel.revalidate();
        backgroundPanel.repaint();
    }
}
