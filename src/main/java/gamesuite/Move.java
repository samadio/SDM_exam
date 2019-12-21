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



class InvalidMove extends Exception {
    Move invalid;
    InvalidMove(Move m){
        invalid=m;
    }
}
