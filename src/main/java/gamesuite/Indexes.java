package gamesuite;

public class Indexes{


    private Integer rowIndex;
    private Integer columnIndex;

    Indexes(Move m){
        rowIndex=toBoardRowIndex(m);
        columnIndex=toBoardColIndex(m);
    }

    public Integer row(){ return rowIndex;}
    public Integer column(){ return columnIndex;}

    public Integer  toBoardRowIndex(Move m) {
        return 0;
    }

    public Integer  toBoardColIndex(Move m) {
        return 0;
    }

}