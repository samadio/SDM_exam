package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBButtons.DBTextButton;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

public class ButtonInserter {

    public static void addEndButton(GameFrame gameFrame, BackgroundPanel backgroundPanel) {
        DBTextButton endGameButton = new DBTextButton("END GAME", new ObjSpecifics(470, 290, 120, 30, 80));

        endGameButton.addActionListener(x ->
        {
            gameFrame.setEndGame(true);
            gameFrame.setInputGiven(true);
            endGameButton.setDark();

        });
        backgroundPanel.add(endGameButton);
    }

    public static void addResetButton(GameFrame gameFrame, BackgroundPanel backgroundPanel) {

        DBTextButton resetGameButton = new DBTextButton("RESET GAME",new ObjSpecifics(470, 330, 120, 30,80));

        resetGameButton.addActionListener(x ->
        {
            gameFrame.setReset(true);
            gameFrame.setInputGiven(true);
            resetGameButton.setDark();
        });

        backgroundPanel.add(resetGameButton);
    }

}
