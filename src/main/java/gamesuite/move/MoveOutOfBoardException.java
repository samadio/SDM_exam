package gamesuite.move;

public class MoveOutOfBoardException extends InvalidMoveException{
    Move invalid;
    public MoveOutOfBoardException(Move m){
        invalid=m;
    }

    public Move getInvalid() {return this.invalid;}
}
