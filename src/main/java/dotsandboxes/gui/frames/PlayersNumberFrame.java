package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.DBNumButton;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayersNumberFrame extends InputFrame<Integer>{

    private Integer numPlayers;
    private List<DBNumButton> buttons;


    public PlayersNumberFrame(BackgroundPanel bP, File imageDir, File fontDir) {

        super(bP, imageDir, fontDir);
    }

    @Override
    public void setPanel() {

        DBLabel playerQuestion= new DBLabel("NUMBER OF PLAYERS",new ObjSpecifics(200, 30, 200, 30,80));

        BACKGROUND_PANEL.add(playerQuestion);

        setButtons(new ArrayList<>(3));
        int yOffset = 100;

        for (int i=2; i<5; i++) {
            DBNumButton button=new DBNumButton(i, new ObjSpecifics(260,yOffset, 80, 30,80) );
            button.addActionListener(x ->
            {
                setNumPlayers(button.getNumber());
                button.setDark();
                inputGiven=true;
            });
            yOffset+=40;
            BACKGROUND_PANEL.add(button);
            getButtons().add(button);
        }

        updatePanel();
    }


    @Override
    public Integer getInput(){


        waitInput();

        clear();

        return numPlayers;
    }

    private void setNumPlayers(Integer numPlayers) {
        this.numPlayers = numPlayers;
    }

    private List<DBNumButton> getButtons() {
        return buttons;
    }

    private void setButtons(List<DBNumButton> buttons) {
        this.buttons = buttons;
    }
}


