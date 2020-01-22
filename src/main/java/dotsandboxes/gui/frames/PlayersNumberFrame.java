package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.NumButton;
import dotsandboxes.gui.graphics.BackgroundPanel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayersNumberFrame extends InputFrame<Integer>{

    private Integer numPlayers;
    private List<NumButton> buttons;


    public PlayersNumberFrame(BackgroundPanel bP, File imageDir, File fontDir) {

        super(bP, imageDir, fontDir);
    }

    @Override
    public void setPanel() {

        DBLabel playerQuestion= new DBLabel("NUMBER OF PLAYERS",200, 30, 200, 30);

        BACKGROUND_PANEL.add(playerQuestion);

        setButtons(new ArrayList<>(3));
        int yOffset = 100;

        for (int i=2; i<5; i++) {
            NumButton button=new NumButton(i,260, yOffset, 80, 30);
            button.addActionListener(x ->
            {
                setNumPlayers(button.number);
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

    private List<NumButton> getButtons() {
        return buttons;
    }

    private void setButtons(List<NumButton> buttons) {
        this.buttons = buttons;
    }
}


