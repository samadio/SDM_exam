package gamesuite.status;

import gamesuite.board.BoardManager;
import gamesuite.move.MoveValidator;

public class Scorer {
    private final BoardManager BOARD_MANAGER;
    private final MoveValidator MOVE_VALIDATOR;

    public Scorer(BoardManager bManager, MoveValidator mValidator) {

        BOARD_MANAGER = bManager;
        MOVE_VALIDATOR = mValidator;
    }
}
