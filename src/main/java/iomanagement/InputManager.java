package iomanagement;

import gamesuite.Move;

public abstract class InputManager {

    protected Move currentMove;


    public abstract void readMove();

    public Move getMove(){
        return currentMove;
    }
}



