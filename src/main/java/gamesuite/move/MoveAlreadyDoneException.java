package gamesuite.move;

public class MoveAlreadyDoneException extends InvalidMoveException{
    Move invalid;
    public MoveAlreadyDoneException(Move m){
        invalid=m;
    }

    public Move getInvalid() {
        return invalid;
    }
}
