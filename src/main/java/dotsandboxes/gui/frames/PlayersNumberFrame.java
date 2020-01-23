package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.DBNumButton;
import dotsandboxes.gui.graphics.BackgroundPanel;

import javax.swing.*;
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

        DBLabel playerQuestion= new DBLabel("NUMBER OF PLAYERS",200, 30, 200, 30);

        BACKGROUND_PANEL.add(playerQuestion);

        setButtons(new ArrayList<>(3));
        int yOffset = 100;

        Rectangle dimensions = new Rectangle( 80, 30);
        Point position = new Point(260,yOffset);

        ImageIcon image = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTable.png").getImage().getScaledInstance((int) dimensions.getWidth(), (int) dimensions.getHeight(), 80));
        ImageIcon darkImage = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTableDark.png").getImage().getScaledInstance(dimensions.width, dimensions.height, 80));

        for (int i=2; i<5; i++) {
            DBNumButton button=new DBNumButton(i, image,position,dimensions);
            button.addActionListener(x ->
            {
                setNumPlayers(button.getNumber());
                button.setIcon(darkImage);
                inputGiven=true;
            });
            position.setLocation(position.getX(), position.getY() + 40);
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


