package iomanagement;
import dotsandboxes.InputMove;
import gamesuite.move.Move;

import java.util.zip.DataFormatException;

public abstract class InputManager {

    protected InputMove currentMove;


    public abstract void readMove() throws DataFormatException;

    public InputMove getMove(){
        return currentMove;
    }
}



