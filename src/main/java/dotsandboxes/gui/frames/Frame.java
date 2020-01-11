package dotsandboxes.gui.frames;

public class Frame {
    protected Integer numPlayers;
    protected boolean inputGiven;

    public Frame() {}


    protected   void waitInput() {
        while (!inputGiven) {

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
            }
        }

        inputGiven = false;
    }
}
