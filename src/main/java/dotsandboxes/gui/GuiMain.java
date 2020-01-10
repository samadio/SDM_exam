package dotsandboxes.gui;

import dotsandboxes.game.DotsAndBoxesSetter;
import gamesuite.game.Game;

public class GuiMain {
    public static void main(String[] args) {


        DotsAndBoxesGui dbGui = new DotsAndBoxesGui();
        Game game = (new DotsAndBoxesSetter(dbGui, dbGui)).newGame();
        game.play();
    }
}