package dotsandboxes.gui.frames;


import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.DBTextField;
import java.util.ArrayList;
import java.util.List;

public class PlayersNameFrame extends Frame {

    private String name;
    Integer nPlayers;
    List<String> playerList;

    public PlayersNameFrame(BackgroundPanel bP, Integer nP){

        super(bP);
        nPlayers= nP;
        playerList= new ArrayList<>(nPlayers);

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



    public  List<String> getInput() {

        for (int i=0; i<nPlayers; i++) {

            waitInput();
            playerList.add(i,name);

        }

        clear(backgroundPanel);

        return playerList;
    }
}
