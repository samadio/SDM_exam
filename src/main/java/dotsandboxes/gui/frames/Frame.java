package dotsandboxes.gui.frames;

import dotsandboxes.gui.components.BackgroundPanel;


public abstract class Frame {

    protected final BackgroundPanel BACKGROUND_PANEL;

    public Frame(BackgroundPanel bP) {

        BACKGROUND_PANEL = bP;
    }


    protected void updatePanel() {
        BACKGROUND_PANEL.revalidate();
        BACKGROUND_PANEL.repaint();
    }

    protected void clear(){
        BACKGROUND_PANEL.removeAll();
        BACKGROUND_PANEL.revalidate();
    }

    public abstract void setPanel();
}
