package dotsandboxes.gui.frames;

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

import javax.swing.*;
import java.util.List;

public class GameFrame extends Frame {

    private JLabel currentPlayer;
    private Move currentMove;
    private LabelsList labels;
    private boolean endGame;
    private boolean reset;
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
        Integer yOffset=0;

        for (int i=0; i<playersName.size(); i++) {

            JLabel label= new JLabel("Test");
            label.setText("Score    "+playersName.get(i));
            label.setBounds(10, yOffset, 200, 50);
            labels.add(label);
            yOffset+=20;
        }

        for (JLabel i : labels) backgroundPanel.add(i);

        JButton endGameButton = new JButton("End Game");
        endGameButton.setBounds(460, 290, 120, 30);

        endGameButton.addActionListener(x ->
        {
            endGame = true;
            inputGiven = true;

        });

        JButton resetGameButton = new JButton("Reset Game");
        resetGameButton.setBounds(460, 330, 120, 30);

        resetGameButton.addActionListener(x ->
        {
            reset = true;
            inputGiven = true;

        });

        backgroundPanel.add(endGameButton);
        backgroundPanel.add(resetGameButton);

        currentPlayer = new JLabel();
        currentPlayer.setBounds(230, 0, 200, 50);
        backgroundPanel.add(currentPlayer);

        ObjSpecifics hEmptySpec = new ObjSpecifics("images/line_empty.png", "images/line_full.png", 50, 20, 50);
        GridSpecifics heGridSpec = new GridSpecifics(6, 5, 50, 15, 155, 68, 50);
        LinesList horizontalLines = SetElements.setGrid(hEmptySpec, heGridSpec, backgroundPanel);

        ObjSpecifics vEmptySpec = new ObjSpecifics("images/line_empty_vertical.png", "images/line_full_vertical.png", 20, 50, 50);
        GridSpecifics veGridSpec = new GridSpecifics(5, 6, 15, 50, 150, 75, 50);
        LinesList verticalLines = SetElements.setGrid(vEmptySpec, veGridSpec, backgroundPanel);

        for (Line l : horizontalLines) {
            l.addActionListener(x ->
            {
                currentMove = new Move(Move.Which.HORIZONTAL, l.getRow(), l.getColumn());
                inputGiven = true;
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(), l.getLineH(), l.getLineHints()));
                l.setIcon(imageIcon);
            });
        }

        for (Line l : verticalLines) {
            l.addActionListener(x ->
            {
                currentMove = new Move(Move.Which.VERTICAL, l.getRow(), l.getColumn());
                inputGiven = true;
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(), l.getLineH(), l.getLineHints()));
                l.setIcon(imageIcon);
            });
        }

        ObjSpecifics dotSpec = new ObjSpecifics("images/dot.png", "", 10, 10, 50);
        GridSpecifics dotGridSpec = new GridSpecifics(6, 6, 50, 50, 130, 50, 50);
        SetElements.setDots(dotSpec, dotGridSpec, backgroundPanel);


        backgroundPanel.revalidate();
        backgroundPanel.repaint();
    }

    public void readMove() throws EndGameException, ResetGameException {
        waitInput();
        if(endGame==true) throw new EndGameException();
        if(reset==true) throw new ResetGameException();
    }

    public Move getMove() {return currentMove;}


    public void updateFrame(Game game, BackgroundPanel backgroundPanel) {
        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setText("Score " + game.getPlayers().get(i).getName() + "   " + game.getScore().get(game.getPlayers().get(i)));
        }

        printBox(game,backgroundPanel);
        backgroundPanel.revalidate();
        backgroundPanel.repaint();
    }


    public void printBox(Game game, BackgroundPanel backgroundPanel) {
        AbstractBoard board = game.getBoard();

        for (int i = 0; i < boxesRows; i++) {
            for (int j = 0; j < boxesColumns; j++) {

                if (board.getElement(Move.Which.HORIZONTAL, i, j) && board.getElement(Move.Which.HORIZONTAL, i + 1, j)
                        && board.getElement(Move.Which.VERTICAL, i, j) && board.getElement(Move.Which.VERTICAL, i, j + 1)) {

                    if (boxes[i][j] == false) {
                        Box.setBox(i, j, backgroundPanel);
                        boxes[i][j] = true;
                    }
                }
            }
        }
        backgroundPanel.revalidate();
        backgroundPanel.repaint();

    }

    public void resetFrame(BackgroundPanel backgroundPanel) {
        boxes=new boolean[boxesRows][boxesColumns];
        backgroundPanel.removeAll();
        backgroundPanel.revalidate();
        backgroundPanel.repaint();
    }
}
