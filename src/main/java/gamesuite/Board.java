package gamesuite;

public class Board {
    private Boolean[][] board;

    Board(Integer n, Integer m){
        this.board= new Boolean[n][m];
    }

    public Boolean getElement(Indexes indexes) {
        return this.board[indexes.row()][indexes.column()];
    }

    public void setBoard(Indexes indexes){
        this.board[indexes.row()][indexes.column()]=true;
    }
}
