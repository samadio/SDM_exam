package dotsandboxes.gui.frames;
import dotsandboxes.gui.components.BackgroundPanel;

public abstract  class InputFrame<V> extends Frame{

    protected boolean inputGiven;

    public InputFrame(BackgroundPanel bP) {
        super(bP);
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
