package gamesuite.move;

public class MoveAlreadyDoneException extends RuntimeException{
    Move invalid;
    public MoveAlreadyDoneException(Move m){
        invalid=m;
    }
}
