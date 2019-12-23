package gamesuite.move;


public class Move {

    public enum Which{HORIZONTAL,VERTICAL}


    private Which lineKind;
    private int row;
    private int column;

    public Move(Which lk, Integer i,Integer j){
        this.lineKind= lk;
        this.row=i;
        this.column=j;
    }

    public Which getLineKind(){return this.lineKind;}
    public Integer getRow(){ return this.row;}
    public Integer getCol() {return this.column;}



}


