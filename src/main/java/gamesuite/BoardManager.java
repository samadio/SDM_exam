package gamesuite;

public class BoardManager {
    private Integer rows;
    private Integer columns;
    private Board board;

    BoardManager(Integer n, Integer m) {
        this.rows = n;
        this.columns = m;
    }


    public Integer rowLength() {return this.rows;}


    public boolean moveDone(Move m) {
        if (this.board.getElement(new Indexes(m,this.rows))) return true;
        return false;
    }


    public void updateBoard(Move m) throws InvalidMove {
        try {
            if (!moveDone(m)) this.board.setBoard(new Indexes(m, this.rows));
            else throw new Exception();

        } catch (IndexOutOfBoundsException ex) {
            throw new InvalidMove(m);

        } catch (Exception ex) {
            throw new InvalidMove(m);
        }
    }
}



