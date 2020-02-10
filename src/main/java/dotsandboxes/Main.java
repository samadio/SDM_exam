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
//le funzioni sotto l'exception reset e sotto this.reset andrebbero spostate nel reset

//ora funziona anche chiamare il game.reset() game.play() in guiMain()

//le exceptions secondo me andrebbero in un package (più ordinato)
//questo vale per game move players ecc

// in generale passare direttamente i messaggi non mi piace
////in particolare gamesetter line 59 non ha senso, cosa stampare dovrebbe essere un problema dell io


//mi piace ancora meno il fatto che il validator scelga il messaggio, lui lancia l'eccezzione appropriata,
//cosa si stampi, è per lui irrilevante


//game status line 59. Lo status (astratto) non solo aggionrna lo score che dovrebbe essere fatto dallo score,
//ma decide pure il valore di un punto


//per la gui paradossalmente i termini specifici di DB sono in gameFrame updateFrame()