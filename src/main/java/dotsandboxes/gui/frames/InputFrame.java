package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;

import java.io.File;

public abstract  class InputFrame<V> extends Frame{

    protected boolean inputGiven;

    public InputFrame(BackgroundPanel bP, File imageDir, File fontsDir) {
        super(bP, imageDir, fontsDir);
        inputGiven = false;

    }

    protected   void waitInput() {
        while (!inputGiven) {

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {

                throw new RuntimeException("Error: thread was interrupted unexpectedly");
            }
        }

        inputGiven = false;
    }

    public void setInputGiven(boolean inputGiven) {
        this.inputGiven = inputGiven;
    }


    public abstract V getInput();
}
