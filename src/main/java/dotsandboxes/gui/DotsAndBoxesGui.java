package dotsandboxes.gui;

import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.lists.LabelsList;
import dotsandboxes.gui.graphics.lists.LinesList;
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
import java.util.Scanner;

public class DotsAndBoxesGui extends JFrame implements InputManager, OutputManager {

    private Move currentMove;
    private boolean newMove;
    private LabelsList labels;
    private JLabel currentPlayer;
    BackgroundPanel startPanel= new BackgroundPanel();
    BackgroundPanel backgroundPanel = new BackgroundPanel();
    private Integer yOffset=0;

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


        //Box.setBox(2, 2, backgroundPanel);



    }



    //      TODO
    //remove readInput from Interface
    @Override
    public String readInput() {return null;}

    @Override
    public void readMove() throws EndGameException, ResetGameException {
        while(!this.newMove)
        {

            try {
                Thread.sleep(150);
            }
            catch(InterruptedException e) {}
        }
        this.newMove=false;
    }

    @Override
    public Move getMove() {
        return currentMove;
    }

    @Override
    public Integer getPlayersNumber() {

        labels= new LabelsList();
        currentPlayer= new JLabel();
        currentPlayer.setBounds(230, 0, 200, 50);
        backgroundPanel.add(currentPlayer);
        return 2;
    }

    private void printCurrentPlayer(Game game) { outputPrintln("Next player: " + game.nextPlayer()); }

    @Override
    public List<Integer> getGridDimensions() {
        List<Integer> list= new ArrayList<Integer>(2);
        list.add(6);
        list.add(6);
        return list;
    }

    @Override
    public boolean customPlayers() {
        return true;
    }

    @Override
    public List<String> getPlayersName(Integer nPlayers) {
        List<String> playerList= new ArrayList<>(nPlayers);
        System.out.print("cicciociccio");
        System.out.println(nPlayers);
        System.out.println(playerList.size());
        for (int i=0; i<nPlayers; i++) playerList.add(i,getPlayerName());
        return playerList;
    }

    @Override
    public String getPlayerName() {
        String playerNameMessage = "Insert next player's name: ";

        outputPrintln(playerNameMessage);
        Scanner myObj = new Scanner(System.in);
        String playerName;

        // Enter username and press Enter
        playerName = myObj.nextLine();
        JLabel label= new JLabel("Test");
        label.setText("Score    "+playerName);
        label.setBounds(10, yOffset, 200, 50);
        backgroundPanel.add(label);
        labels.add(label);
        yOffset+=20;


        return playerName;
    }

    @Override
    public void startGame() {

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
                newMove=true;
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(),l.getLineH(),l.getLineHints()));
                l.setIcon(imageIcon);
            });
        }

        for(Line l:verticalLines) {
            l.addActionListener(x ->
            {
                currentMove = new Move(Move.Which.VERTICAL,l.getRow(),l.getColumn());
                newMove=true;
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(l.newFileName()).getImage().getScaledInstance(l.getLineW(),l.getLineH(),l.getLineHints()));
                l.setIcon(imageIcon);
            });
        }

        ObjSpecifics dotSpec= new ObjSpecifics("images/dot.png","",10, 10, 50);
        GridSpecifics dotGridSpec=new GridSpecifics(6,6,50, 50, 130, 50 , 50);
        SetElements.setDots(dotSpec,dotGridSpec,backgroundPanel);
        this.setVisible(true);
    }

    @Override
    public void printGame(Game game) {

        outputPrintln("\n");
        //printBoard(game.getBoard());
        outputPrintln("\n Players score:");

        currentPlayer.setText("Current Player:  "+game.nextPlayer().getName());

        for (int i=0; i<labels.size(); i++){
            labels.get(i).setText("Score "+game.getPlayers().get(i).getName()+"   "+game.getScore().get(game.getPlayers().get(i)));
        }

        for (Player i : game.getPlayers()) {
            outputPrint(i.getName() + ": ");
            outputPrint(game.getScore().get(i) + "        ");
        }

        outputPrintln("\n");
        printCurrentPlayer(game);
        outputPrintln("\n");
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
    public void printWinner(Game game) {

    }

    @Override
    public void printBoard(AbstractBoard board) {

    }


}
