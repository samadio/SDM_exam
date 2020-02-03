package dotsandboxes.gui.DBlabels.labelSetters;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.DBlabels.DBLabel;
import dotsandboxes.gui.graphics.ObjSpecifics;
import gamesuite.players.Player;

import java.util.List;

public class PlayersLabelSetter {

    public static void setLabels(GameFrame gameFrame, List<Player> players, BackgroundPanel backgroundPanel){

        Integer yOffset=40;

        DBLabel score= new DBLabel("SCORE",new ObjSpecifics(10, yOffset, 100, 30,80));
        backgroundPanel.add(score);


        for (Player player : players) {
            yOffset += 40;
            DBLabel label = new DBLabel(player.getName(), new ObjSpecifics(10, yOffset, 100, 30, 80));
            gameFrame.getLabels().add(label);
            backgroundPanel.add(label);
        }
    }
}
