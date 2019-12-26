package dotsandboxes;

import dotsandboxes.io.DotsAndBoxesInput;
import dotsandboxes.io.DotsAndBoxesOutput;
import gamesuite.game.Game;
import gamesuite.game.GameSetter;
import iomanagement.OutputManager;

public class Main {

    public static void main(String[] args){

        OutputManager outputManager = new DotsAndBoxesOutput();
        GameSetter gSetter = new DotsAndBoxesSetter(new DotsAndBoxesInput(outputManager), outputManager);
        Game dotsAndBoxes = gSetter.newGame();
        dotsAndBoxes.play();
    }
}
