package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.DBTextField;

import java.io.File;


public class PlayersNameFrame extends InputFrame<String> {

    private String name;
    private boolean panelSet;
    private DBLabel playerMessage;
    private DBLabel playerToType;
    private Integer playerNumber;
    private boolean error;

    public PlayersNameFrame(BackgroundPanel bP, File imageDir, File fontDir) {

        super(bP, imageDir, fontDir);
        playerNumber=0;
    }

    public void setPanel(){

        if(!panelSet) {
            playerNumber=1;
            error=false;
            DBTextField playerName = new DBTextField(1, 265, 100, 70, 30);
            DBLabel playerQuestion = new DBLabel("INSERT NAMES", 200, 30, 200, 30);
            playerToType =  new DBLabel("PLAYER  "+ playerNumber, 180, 100, 70, 30);

            BACKGROUND_PANEL.add(playerQuestion);
            BACKGROUND_PANEL.add(playerName);
            BACKGROUND_PANEL.add(playerToType);


            playerName.addActionListener(x ->
            {
                name = playerName.getText();
                playerName.setText("");
                inputGiven = true;
            });

            updatePanel();

            panelSet=true;
        }

        else {
            if(!error) playerNumber+=1;
            playerToType.setText("PLAYER  "+ playerNumber);
            error=false;
            updatePanel();
        }

    }


    @Override
    public  String getInput() {

        waitInput();

        if(playerMessage!=null) {
            BACKGROUND_PANEL.remove(playerMessage);
            updatePanel();

        }

        return name;
    }



    public void showMessage(String s) {

        playerMessage = new DBLabel(s, 50, 160, 500, 30);
        BACKGROUND_PANEL.add(playerMessage);
        updatePanel();
        error=true;

    }

}