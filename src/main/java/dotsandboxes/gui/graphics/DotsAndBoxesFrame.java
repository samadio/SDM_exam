package dotsandboxes.gui.graphics;

import javax.swing.*;

public class DotsAndBoxesFrame extends JFrame {

    public DotsAndBoxesFrame() {
        super();
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);
        this.setTitle("DOTS AND BOXES");
        this.setSize(600, 400);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(backgroundPanel);

        //Box.setBox(2, 2, backgroundPanel);
        //Box.setBox(0, 0, backgroundPanel);

        Environment.setBackgroundElements(backgroundPanel);
        this.setVisible(true);

    }

}