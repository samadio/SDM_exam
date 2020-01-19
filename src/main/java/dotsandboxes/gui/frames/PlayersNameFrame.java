package dotsandboxes.gui.frames;


import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.DBTextField;
import java.util.ArrayList;
import java.util.List;

public class PlayersNameFrame extends InputFrame<String> {

    private String name;

    public PlayersNameFrame(BackgroundPanel bP){

        super(bP);
    }

    public void setPanel(){

        DBTextField playerName= new DBTextField(1,270, 100, 60, 30);
        DBLabel playerQuestion= new DBLabel("PLAYER'S NAME",200, 30, 200, 30);

        backgroundPanel.add(playerQuestion);
        backgroundPanel.add(playerName);


        playerName.addActionListener(x ->
        {
            name=playerName.getText();
            playerName.setText("");
            inputGiven=true;
        });

        updatePanel(backgroundPanel);
    }


    @Override
    public  String getInput() {

        waitInput();

        clear(backgroundPanel);

        return name;
    }
}
