package gamesuite;

public class BoardManager {
    private Integer rows;
    private Integer columns;
    private Board board;

    BoardManager(Integer n, Integer m) {
        this.rows = n;
        this.columns = m;
        this.board= new Board(n,m);
    }

    //needed by Federico
    public Integer rowLength() {return this.rows;}

    //needed by Federico
    public boolean moveDone(Move m) {
        if (this.board.getElement(new Indexes(m,this.rows))) return true;
        return false;
    }

    //needed by Simone
    public void updateBoard(Move m) throws MoveAlreadyDoneException {
        try {
            if (!moveDone(m)) this.board.setBoard(new Indexes(m, this.rows));
            else throw new Exception();

        } catch (IndexOutOfBoundsException ex) {
            throw new OutOfBoardException(m);

        } catch (Exception ex) {
            throw new MoveAlreadyDoneException(m);
        }
    }
}



