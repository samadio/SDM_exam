package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.BackgroundPanel;

public abstract  class InputFrame<V> extends Frame{

    public InputFrame(BackgroundPanel bP) {
        super(bP);
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

    public abstract V getInput();
}
