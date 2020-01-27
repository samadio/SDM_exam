package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.DBButtons.DBNumButton;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayersNumberFrame extends InputFrame<Integer>{

    private Integer numPlayers;


    public PlayersNumberFrame(BackgroundPanel bP) {

        super(bP);
    }

    @Override
    public void setPanel() {

        DBLabel playerQuestion= new DBLabel("NUMBER OF PLAYERS",new ObjSpecifics(200, 30, 200, 30,80));
        BACKGROUND_PANEL.add(playerQuestion);

        final int yOffset = 100;
        final int minPlayers = 2;
        final int maxPlayers = 5;
        final int yOffsetGap = 40;

        List<DBNumButton> buttonsList = IntStream.range(minPlayers,maxPlayers)
                .mapToObj(i -> new DBNumButton(i, new ObjSpecifics(260, yOffset + (i-minPlayers)*yOffsetGap, 80, 30,80)))
                .collect(Collectors.toList());
        buttonsList.stream().forEach(button -> {

            button.addActionListener(x ->
            {
                setNumPlayers(button.getNumber());
                button.setDark();
                inputGiven=true;
            });
        });
        buttonsList.stream().forEach(BACKGROUND_PANEL::add);

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

}


