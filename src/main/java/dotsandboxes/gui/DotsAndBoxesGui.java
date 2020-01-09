package dotsandboxes.gui;

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
import java.util.ArrayList;
import java.util.List;

public class DotsAndBoxesGui extends JFrame implements InputManager, OutputManager {

    private Move currentMove;
    private boolean newMove;

    public DotsAndBoxesGui(){
        super();
        init();
    }

    private void init(){

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);
        this.setTitle("DOTS AND BOXES");
        this.setSize(600, 400);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(backgroundPanel);

        //Box.setBox(2, 2, backgroundPanel);
        //Box.setBox(0, 0, backgroundPanel);

        //Environment.setBackgroundElements(backgroundPanel);

        ObjSpecifics hEmptySpec= new ObjSpecifics("images/line_empty.png","images/line_full.png",50, 20, 50);
        GridSpecifics heGridSpec=new GridSpecifics(6,5,50, 15, 155, 68 , 50);
        LinesGrid horizontalLines= SetElements.setGrid(hEmptySpec,heGridSpec,backgroundPanel);

        for(Line l:horizontalLines) {
            l.addActionListener(x ->
                    {
                        newMove=true;
                        currentMove = new Move(Move.Which.HORIZONTAL,l.getRow(),l.getColumn());
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(),l.getLineH(),l.getLineHints()));
                        l.setIcon(imageIcon);
                    });
        }

        ObjSpecifics vEmptySpec= new ObjSpecifics("images/line_empty_vertical.png","images/line_full_vertical.png",20, 50, 50);
        GridSpecifics veGridSpec=new GridSpecifics(5,6,15, 50, 150, 75 , 50);
        LinesGrid verticalLines= SetElements.setGrid(vEmptySpec,veGridSpec,backgroundPanel);

        for(Line l:horizontalLines) {
            l.addActionListener(x ->
            {
                newMove=true;
                currentMove = new Move(Move.Which.VERTICAL,l.getRow(),l.getColumn());
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(),l.getLineH(),l.getLineHints()));
                l.setIcon(imageIcon);
            });
        }

        this.setVisible(true);
    }

    //      TODO
    //remove readInput from Interface
    @Override
    public String readInput() {return null;}

    @Override
    public void readMove() throws EndGameException, ResetGameException {
        while(!this.newMove){
            //Thread.wait();
        }
        this.newMove=false;
        //this.currentMove=m;
    }

    @Override
    public Move getMove() {
        return currentMove;
    }

    @Override
    public Integer getPlayersNumber() {
        return 2;
    }

    @Override
    public List<Integer> getGridDimensions() {
        List<Integer> list= new ArrayList<Integer>(2);
        list.add(5);
        list.add(5);
        return list;
    }

    @Override
    public boolean customPlayers() {
        return false;
    }

    @Override
    public String getPlayerName() {
        return null;
    }

    @Override
    public void printGame(Game game) {

    }

    @Override
    public void printInvalidMove(InvalidMoveException e) {

    }

    @Override
    public void outputPrintln(String message) {

    }

    @Override
    public void errorPrintln(String s) {

    }

    @Override
    public void outputPrint(String s) {

    }

    @Override
    public void errorPrint(String s) {

    }

    @Override
    public void printWinner(Game game) {

    }

    @Override
    public void printBoard(AbstractBoard board) {

    }


}
