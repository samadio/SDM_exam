package dotsandboxes.gui.frames;


import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.DBTextField;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlayersNameFrame extends InputFrame<String> {

    private String name;
    private boolean panelSet;
    private DBLabel playerMessage;

    public PlayersNameFrame(BackgroundPanel bP){

        super(bP);
    }

    public void setPanel(){

        if(!panelSet) {

            DBTextField playerName = new DBTextField(1, 270, 100, 60, 30);
            DBLabel playerQuestion = new DBLabel("PLAYER'S NAME", 200, 30, 200, 30);

            backgroundPanel.add(playerQuestion);
            backgroundPanel.add(playerName);


            playerName.addActionListener(x ->
            {
                name = playerName.getText();
                playerName.setText("");
                inputGiven = true;
            });

            updatePanel(backgroundPanel);

            panelSet=true;
        }



    }


    @Override
    public  String getInput() {

        waitInput();

        if(playerMessage!=null) {
            backgroundPanel.remove(playerMessage);
            updatePanel(backgroundPanel);

        }

        return name;
    }



    public void showMessage(String s) {

        playerMessage = new DBLabel(s, 50, 160, 500, 30);
        backgroundPanel.add(playerMessage);
        updatePanel(backgroundPanel);

    }

}