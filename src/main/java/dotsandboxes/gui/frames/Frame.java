package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Frame {
    protected BackgroundPanel backgroundPanel;
    protected boolean inputGiven;

    public Frame(BackgroundPanel bP) {

        backgroundPanel = bP;
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

    public boolean getInputGiven(){
        return inputGiven;
    }

    public void setInputGiven(boolean inputGiven) {
        this.inputGiven = inputGiven;
    }

    public abstract void setPanel();
}
