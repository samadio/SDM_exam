package dotsandboxes;

import gamesuite.game.Game;
import gamesuite.game.GameSetter;
import iomanagement.OutputManager;

import java.util.zip.DataFormatException;

public class Main {

    public static void main(String[] args){

        OutputManager outputManager = new DotsAndBoxesOutput();
        GameSetter gSetter = new DotsAndBoxesSetter(new DotsAndBoxesInput(outputManager), outputManager);
        Game dotsAndBoxes = gSetter.newGame();
        dotsAndBoxes.play();
    }
}
