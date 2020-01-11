package dotsandboxes.gui.frames;

import dotsandboxes.gui.frames.Frame;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.lists.LabelsList;
import gamesuite.players.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlayersNameFrame extends Frame {

    private String name;

    public PlayersNameFrame(){
        super();
    }

    public  List<String> setFrame(BackgroundPanel backgroundPanel,Integer nPlayers) {

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

        updatePanel(backgroundPanel);


        for (int i=0; i<nPlayers; i++) {

            waitInput();
            playerList.add(i,name);

        }

        clear(backgroundPanel);

        return playerList;
    }
}
