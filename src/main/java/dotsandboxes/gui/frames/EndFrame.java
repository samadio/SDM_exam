package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;
import gamesuite.game.Game;
import gamesuite.players.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EndFrame extends Frame{
    public EndFrame(){
        super();
    }

    public void printWinner( BackgroundPanel backgroundPanel, Game game){


        List<Player> winners = game.getWinner();
        backgroundPanel.removeAll();
        backgroundPanel.revalidate();
        backgroundPanel.repaint();
        JLabel winMessage = new JLabel("",SwingConstants.CENTER);
        winMessage.setBounds(215, 30, 250, 50);
        List<JLabel> winnersLabels= new ArrayList<>();

        if (winners.size() == 1) winMessage.setText("The winner is");
        else winMessage.setText("<html>Game is a draw<br/>The following players have the same score:<html>");

        backgroundPanel.add(winMessage);
        Integer yOffset = 80;

        for (Player p : winners) {
            JLabel label= new JLabel(p.getName());
            label.setBounds(260, yOffset, 80, 30);

            yOffset+=30;
            backgroundPanel.add(label);
            winnersLabels.add(label);
        }
        updatePanel(backgroundPanel);
    }
}
