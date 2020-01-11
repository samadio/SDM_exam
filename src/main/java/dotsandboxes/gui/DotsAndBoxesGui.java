package dotsandboxes.gui;

import dotsandboxes.gui.graphics.*;
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

    private Move currentMove;
    private boolean inputGiven;
    private LabelsList labels;
    private JLabel currentPlayer;
    private Integer numPlayers;
    private String name;
    private boolean endGame=false;
    BackgroundPanel backgroundPanel = new BackgroundPanel();


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
        waitInput();
        if(endGame==true) throw new EndGameException();
    }

    @Override
    public Move getMove() {
        return currentMove;
    }

    @Override
    public Integer getPlayersNumber() {

        this.setVisible(true);
        JLabel playerQuestion= new JLabel();
        playerQuestion.setText("Number of players");
        playerQuestion.setBounds(215, 30, 200, 30);

        backgroundPanel.add(playerQuestion);

        List<NumButton> buttons= new ArrayList<>(3);
        Integer yOffset = 70;

        for (int i=2; i<5; i++) {
            NumButton button=new NumButton(i);
            button.setBounds(260, yOffset, 80, 30);
            button.addActionListener(x ->
            {
                numPlayers=button.number;
                inputGiven=true;
            });
            yOffset+=40;
            backgroundPanel.add(button);
            buttons.add(button);
        }

        //for (int i=0 ; i<3; i++) backgroundPanel.add(buttons.get(i));

        backgroundPanel.revalidate();
        backgroundPanel.repaint();

        waitInput();

        this.inputGiven=false;
        backgroundPanel.remove(playerQuestion);
        for(JButton i : buttons) backgroundPanel.remove(i);
        backgroundPanel.revalidate();
        backgroundPanel.repaint();


        return numPlayers;
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



        JTextField playerName= new JTextField(1);
        JLabel playerQuestion= new JLabel();
        playerQuestion.setText("Player's names");
        playerQuestion.setBounds(70, 30, 200, 30);
        playerName.setBounds(70, 100, 60, 30);

        //playerName.setBorder(null);
        //playerName.setOpaque(false);

        List<String> playerList= new ArrayList<>(nPlayers);
        backgroundPanel.add(playerQuestion);
        backgroundPanel.add(playerName);

        

        playerName.addActionListener(x ->
        {
            name=playerName.getText();
            playerName.setText("");
            inputGiven=true;
        });

        backgroundPanel.revalidate();
        backgroundPanel.repaint();

        Integer yOffset=0;
        labels= new LabelsList();
        
        for (int i=0; i<nPlayers; i++) {

            waitInput();
            playerList.add(i,name);
            JLabel label= new JLabel("Test");
            label.setText("Score    "+playerName);
            label.setBounds(10, yOffset, 200, 50);
            labels.add(label);
            yOffset+=20;
        }

        backgroundPanel.remove(playerName);
        backgroundPanel.remove(playerQuestion);
        backgroundPanel.revalidate();
        backgroundPanel.repaint();

        backgroundPanel.updateUI();

        return playerList;
    }


    @Override
    public void startGame() {

        for (JLabel i : labels) backgroundPanel.add(i);

        JButton endGameButton=new JButton("End Game");
        endGameButton.setBounds(460, 330, 120, 30);

        endGameButton.addActionListener(x ->
        {
            endGame=true;
            inputGiven=true;

        });

        backgroundPanel.add(endGameButton);

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

    @Override
    public void printGame(Game game) {

        outputPrintln("\n");
        //printBoard(game.getBoard());
        outputPrintln("\n Players score:");

        currentPlayer.setText("Current Player:  "+game.nextPlayer().getName());

        backgroundPanel.revalidate();
        backgroundPanel.repaint();

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

    }

    @Override
    public void printBoard(AbstractBoard board) {

    }

    public void waitInput(){
        while (!this.inputGiven) {

            try {
                Thread.sleep(150);
            }
            catch (InterruptedException e) {
            }
        }

        this.inputGiven = false;
    }


}
