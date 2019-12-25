package dotsandboxes;

import gamesuite.game.Game;
import gamesuite.game.GameSetter;

import java.util.zip.DataFormatException;

public class Main {

    public static void main(String[] args){

        GameSetter gSetter = new DotsAndBoxesSetter(new DotsAndBoxesInput(), new DotsAndBoxesOutput());
        Game dotsAndBoxes = gSetter.newGame();
    }
}
