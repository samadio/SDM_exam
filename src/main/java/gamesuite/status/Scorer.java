package gamesuite.status;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveValidator;

import java.util.*;
import java.util.function.Predicate;

public abstract class Scorer {

    protected final BoardManager BOARD_MANAGER;
    protected final MoveValidator MOVE_VALIDATOR;

    public Scorer(BoardManager bManager, MoveValidator mValidator) {

        BOARD_MANAGER = bManager;
        MOVE_VALIDATOR = mValidator;
    }

    public abstract boolean isPoint(Move refMove);

    public boolean isNotPoint(Move refMove){

        return !isPoint(refMove);
    }

}
