package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.DBTextField;


public class PlayersNameFrame extends InputFrame<String> {

    private String name;
    private boolean panelSet;
    private DBLabel playerMessage;
    private DBLabel playerToType;
    private Integer playerNumber;
    private boolean error;

    public PlayersNameFrame(BackgroundPanel bP){

        super(bP);
        playerNumber=0;
    }

    public void setPanel(){

        if(!panelSet) {
            playerNumber=1;
            error=false;
            DBTextField playerName = new DBTextField(1, 265, 100, 70, 30);
            DBLabel playerQuestion = new DBLabel("INSERT NAMES", 200, 30, 200, 30);
            playerToType =  new DBLabel("PLAYER  "+Integer.toString(playerNumber), 180, 100, 70, 30);

            backgroundPanel.add(playerQuestion);
            backgroundPanel.add(playerName);
            backgroundPanel.add(playerToType);


            playerName.addActionListener(x ->
            {
                name = playerName.getText();
                playerName.setText("");
                inputGiven = true;
            });

            updatePanel(backgroundPanel);

            panelSet=true;
        }

        else {
            if(!error) playerNumber+=1;
            playerToType.setText("PLAYER  "+Integer.toString(playerNumber));
            error=false;
            updatePanel(backgroundPanel);
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
        error=true;

    }

}