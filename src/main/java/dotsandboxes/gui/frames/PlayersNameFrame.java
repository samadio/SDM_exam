package dotsandboxes.gui.frames;

import dotsandboxes.gui.frames.Frame;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.DBTextField;
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

        DBTextField playerName= new DBTextField(1,270, 100, 60, 30);
        DBLabel playerQuestion= new DBLabel("PLAYER'S NAME",200, 30, 200, 30);

        backgroundPanel.add(playerQuestion);
        backgroundPanel.add(playerName);

        List<String> playerList= new ArrayList<>(nPlayers);

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
