package dotsandboxes;

import dotsandboxes.game.DotsAndBoxesFactory;
import dotsandboxes.io.DotsAndBoxesInput;
import dotsandboxes.io.DotsAndBoxesOutput;
import dotsandboxes.io.ExhaustedInputException;
import gamesuite.game.Game;
import gamesuite.game.GameFactory;
import iomanagement.OutputManager;

public class Main {

    public static void main(String[] args){
        OutputManager outputManager = new DotsAndBoxesOutput();
        try{
            GameFactory gSetter = new DotsAndBoxesFactory(new DotsAndBoxesInput(outputManager), outputManager);
            Game dotsAndBoxes = gSetter.newGame();
            dotsAndBoxes.play();
            //dotsAndBoxes.reset();
            //dotsAndBoxes.play();
        }catch (ExhaustedInputException e){
            //System.out.println("Ctrl+D ending");
            System.exit(1);
        }
    }
}   