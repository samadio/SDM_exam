package dotsandboxes.gui;

import dotsandboxes.game.DotsAndBoxesFactory;
import gamesuite.game.Game;

public class GuiMain {
    public static void main(String[] args) {


        DotsAndBoxesGui dbGui = new DotsAndBoxesGui();
        Game game = (new DotsAndBoxesFactory(dbGui, dbGui)).newGame();
        game.play();
    }
}