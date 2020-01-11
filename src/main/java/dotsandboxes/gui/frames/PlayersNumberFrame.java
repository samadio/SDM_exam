package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.NumButton;
import dotsandboxes.gui.graphics.BackgroundPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlayersNumberFrame extends Frame{


    public PlayersNumberFrame(){
        super();
    }

    public Integer setFrame(BackgroundPanel backgroundPanel){

        PlayersNumberFrame frame= new PlayersNumberFrame();
        JLabel playerQuestion= new JLabel();
        playerQuestion.setText("Number of players");
        playerQuestion.setBounds(215, 30, 200, 30);

        backgroundPanel.add(playerQuestion);

        List<NumButton> buttons= new ArrayList<>(3);
        Integer yOffset = 70;

        for (int i=2; i<5; i++) {
            NumButton button=new NumButton(i);
            button.setBounds(260, yOffset, 80, 30);
            button.addActionListener(x ->
            {
                numPlayers=button.number;
                inputGiven=true;
            });
            yOffset+=40;
            backgroundPanel.add(button);
            buttons.add(button);
        }


        backgroundPanel.revalidate();
        backgroundPanel.repaint();


        waitInput();

        this.inputGiven=false;
        backgroundPanel.remove(playerQuestion);
        for(JButton i : buttons) backgroundPanel.remove(i);
        backgroundPanel.revalidate();
        backgroundPanel.repaint();

        return numPlayers;
    }



}


