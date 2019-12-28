package dotsandboxes.board;

import gamesuite.move.Move;

public abstract class AbstractBoard {
    public abstract Boolean getElement(Move.Which w, Integer i, Integer j);
}