package gamesuite;

public class Board {

    public enum Which{HORIZONTAL,VERTICAL};

    private Boolean[][] horizontalLines;
    private Boolean[][] verticalLines;

    Board(Integer n, Integer m){
        this.horizontalLines= new Boolean[n][m-1];
        this.verticalLines=  new Boolean[n-1][m];
    }

    public Boolean getElement(Indexes indexes) {
        if (indexes.which()==Which.HORIZONTAL)
            return this.horizontalLines[indexes.row()][indexes.column()];
        else
            return this.verticalLines[indexes.row()][indexes.column()];
    }

    public void setBoard(Indexes indexes){
        if (indexes.which()==Which.HORIZONTAL)
            this.horizontalLines[indexes.row()][indexes.column()]=true;
        else
            this.verticalLines[indexes.row()][indexes.column()]=true;
    }
}
