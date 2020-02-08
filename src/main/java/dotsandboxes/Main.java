package dotsandboxes;

import dotsandboxes.game.DotsAndBoxesSetter;
import dotsandboxes.io.DotsAndBoxesInput;
import dotsandboxes.io.DotsAndBoxesOutput;
import dotsandboxes.io.ExhaustedInputException;
import gamesuite.game.Game;
import gamesuite.game.GameSetter;
import gamesuite.players.NameAlreadyUsedException;
import gamesuite.players.ReservedNameException;
import iomanagement.OutputManager;

public class Main {

    public static void main(String[] args){
        OutputManager outputManager = new DotsAndBoxesOutput();
        try{
            GameSetter gSetter = new DotsAndBoxesSetter(new DotsAndBoxesInput(outputManager), outputManager);
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