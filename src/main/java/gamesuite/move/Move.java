package gamesuite.move;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return row == move.row &&
                column == move.column &&
                lineKind == move.lineKind;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineKind, row, column);
    }
}


