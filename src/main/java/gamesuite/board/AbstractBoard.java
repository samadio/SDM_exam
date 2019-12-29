package gamesuite.board;

import gamesuite.move.Move;

public abstract class AbstractBoard {
    public abstract Boolean getElement(Move.Which w, Integer i, Integer j);
    public abstract Integer getRows();
    public abstract Integer getColumns();

}
