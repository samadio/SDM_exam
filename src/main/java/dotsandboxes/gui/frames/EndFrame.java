package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import gamesuite.game.Game;
import gamesuite.players.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EndFrame extends Frame{
    public EndFrame(BackgroundPanel bP){

        super(bP);
    }

    public void printWinner(Game game){


        List<Player> winners = game.getWinner();
        clear(backgroundPanel);
        DBLabel winMessage = new DBLabel("",175, 30, 250, 50);

        List<JLabel> winnersLabels= new ArrayList<>();

        if (winners.size() == 1) winMessage.setText("The winner is");
        else winMessage.setText("<html><body style='text-align: center'>Game is a draw<br/>The following players have the same score:<html>");

        backgroundPanel.add(winMessage);
        Integer yOffset = 90;

        for (Player p : winners) {
            DBLabel label= new DBLabel(p.getName(),260, yOffset, 80, 30);

            yOffset+=30;
            backgroundPanel.add(label);
            winnersLabels.add(label);
        }
        updatePanel(backgroundPanel);
    }
}
