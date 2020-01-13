package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;

public class Frame {

    protected BackgroundPanel backgroundPanel;
    public boolean inputGiven;

    public Frame(BackgroundPanel bP) {
        backgroundPanel=bP;
    }


    protected   void waitInput() {
        while (!inputGiven) {

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
            }
        }

        inputGiven = false;
    }
    protected void updatePanel(BackgroundPanel backgroundPanel) {
        backgroundPanel.revalidate();
        backgroundPanel.repaint();
    }

    protected void clear(BackgroundPanel backgroundPanel){
        backgroundPanel.removeAll();
        updatePanel(backgroundPanel);
    }
}
