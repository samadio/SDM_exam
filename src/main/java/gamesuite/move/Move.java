package gamesuite.move;


import java.util.Objects;

public class Move {

    public enum Orientation {HORIZONTAL,VERTICAL}


    private final Orientation LINE_KIND;
    private final MoveCoordinates COORDINATES;

    public Move(Orientation lineKind, Integer row, Integer column){
        this.LINE_KIND = lineKind;
        this.COORDINATES = new MoveCoordinates(row, column);
    }

    public Orientation getLineKind(){ return this.LINE_KIND;}
    public Integer getRow(){ return this.COORDINATES.getRow();}
    public Integer getCol() { return this.COORDINATES.getColumn();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return getRow().equals(move.getRow()) &&
                getCol().equals(move.getCol()) &&
                getLineKind() == move.getLineKind();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLineKind(), getRow(), getCol());
    }
}


class MoveCoordinates{

    private final int ROW;
    private final int COL;

    MoveCoordinates(int row, int col){

        this.ROW = row;
        this.COL = col;
    }

    Integer getRow(){ return ROW;}
    Integer getColumn(){ return COL;}
}

