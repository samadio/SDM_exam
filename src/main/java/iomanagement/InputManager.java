package iomanagement;

import gamesuite.move.Move;

import java.util.zip.DataFormatException;

public abstract class InputManager {

    protected Move currentMove;


    public abstract void readMove() throws DataFormatException;

    public Move getMove(){
        return currentMove;
    }
}



