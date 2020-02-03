package dotsandboxes.gui.DBlabels.labelSetters;

import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.DBlabels.DBLabel;
import dotsandboxes.gui.graphics.ObjSpecifics;
import gamesuite.game.Game;

public class CurrentPlayerLabel {

    public static void setPosition(BackgroundPanel backgroundPanel, DBLabel currentPlayerLabel) {
        currentPlayerLabel.setLabelProperties("",new ObjSpecifics(180, 10, 250, 30,80));
        backgroundPanel.add(currentPlayerLabel);
    }

    public static void setName(Game game, DBLabel currentPlayerLabel){
        currentPlayerLabel.setText("CURRENT PLAYER:  "+game.nextPlayer().getName());
    }

}
