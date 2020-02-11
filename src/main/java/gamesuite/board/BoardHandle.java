package gamesuite.board;

import gamesuite.move.Move;

public abstract class BoardHandle {
    public abstract Boolean getElement(Move.Orientation w, Integer i, Integer j);
    public abstract Integer getRows();
    public abstract Integer getColumns();

}
