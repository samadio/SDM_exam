package dotsandboxes.gui;

import dotsandboxes.game.DotsAndBoxesSetter;
import gamesuite.game.Game;
import gamesuite.players.NameAlreadyUsedException;
import gamesuite.players.ReservedNameException;

public class GuiMain {
    public static void main(String[] args) throws NameAlreadyUsedException, ReservedNameException {


        DotsAndBoxesGui dbGui = new DotsAndBoxesGui();
        Game game = (new DotsAndBoxesSetter(dbGui, dbGui)).newGame();
        game.play();
    }
}