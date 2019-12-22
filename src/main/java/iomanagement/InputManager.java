package iomanagement;

import gamesuite.move.Move;

public abstract class InputManager {

    protected Move currentMove;


    public abstract void readMove();

    public Move getMove(){
        return currentMove;
    }
}



