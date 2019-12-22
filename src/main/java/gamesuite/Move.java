package gamesuite;


public class Move {
    public enum Direction{RIGHT,DOWN,UP,LEFT};

    private Integer node;
    private Direction direction;

    public Move(Integer i,Direction d){
        this.node=i;
        this.direction=d;
    }

    public Integer getNode(){ return this.node;}

    public Direction getDirection(){return this.direction;}

}



class MoveAlreadyDoneException extends RuntimeException{
    Move invalid;
    MoveAlreadyDoneException(Move m){
        invalid=m;
    }
}


class OutOfBoardException extends RuntimeException{
    Move invalid;
    OutOfBoardException(Move m){
        invalid=m;
    }
}
