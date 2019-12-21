package gamesuite;

public class Indexes{

    private Board.Which whichBoard;
    private Integer rowIndex;
    private Integer columnIndex;

    Indexes(Move m, Integer rows){
        whichBoard=toBoardWhich(m);
        rowIndex=toBoardRowIndex(m, rows);
        columnIndex=toBoardColIndex(m, rows);
    }

    public Board.Which which() {return  whichBoard;}
    public Integer row(){ return rowIndex;}
    public Integer column(){ return columnIndex;}


    public Board.Which toBoardWhich(Move m){
        if (m.getDirection()== Move.Direction.LEFT || m.getDirection()==Move.Direction.RIGHT)
            return Board.Which.HORIZONTAL;
        else
            return Board.Which.VERTICAL;
    }

    public Integer  toBoardRowIndex(Move m, Integer rows) {
        if(m.getDirection()== Move.Direction.UP)
            return m.getNode()/rows-1;
        else
            return m.getNode()/rows;
    }

    public Integer  toBoardColIndex(Move m, Integer rows) {
        if(m.getDirection()== Move.Direction.LEFT)
            return m.getNode()%rows -1;
        else
            return m.getNode()%rows;
    }

}