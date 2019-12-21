package gamesuite;

public class Board {

    public enum Which{HORIZONTAL,VERTICAL};

    public boolean[][] horizontalLines;
    private boolean[][] verticalLines;

    Board(Integer n, Integer m){
        this.horizontalLines= new boolean[n][m-1];
        this.verticalLines=  new boolean[n-1][m];
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
