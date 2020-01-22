package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;

import java.io.File;


public abstract class Frame {

    protected final BackgroundPanel BACKGROUND_PANEL;
    protected final File IMAGE_DIR;
    protected final File FONT_DIR;

    public Frame(BackgroundPanel bP, File imagesDir, File fontsDir) {

        BACKGROUND_PANEL = bP;
        IMAGE_DIR = imagesDir;
        FONT_DIR = fontsDir;
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
