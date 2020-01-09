package dotsandboxes.gui;

import dotsandboxes.game.DotsAndBoxesSetter;
import gamesuite.game.Game;

public class GuiMain {
    String word="";
    public static void main(String[] args) {


        DotsAndBoxesGui dbGui = new DotsAndBoxesGui();
        System.out.println("ciao ciao");
        Game game = (new DotsAndBoxesSetter(dbGui, dbGui)).newGame();
        game.play();
    }
}