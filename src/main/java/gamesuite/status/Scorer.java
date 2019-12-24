package gamesuite.status;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveValidator;

import java.util.*;
import java.util.function.Predicate;

public class Scorer {
    private final BoardManager BOARD_MANAGER;
    private final MoveValidator MOVE_VALIDATOR;

    public Scorer(BoardManager bManager, MoveValidator mValidator) {

        BOARD_MANAGER = bManager;
        MOVE_VALIDATOR = mValidator;
    }

    public boolean isPoint(Move refMove) {

        List<Move> upperNeighbors = upperNeighbors(refMove);
        List<Move> lowerNeighbors = lowerNeighbors(refMove);

        Predicate<Boolean> isTrue = x -> x;

        Boolean upperPoint = upperNeighbors.stream().map(MOVE_VALIDATOR::outBoardLine).allMatch(isTrue) && upperNeighbors.stream().map(BOARD_MANAGER::moveDone).allMatch(isTrue);
        Boolean lowerPoint = lowerNeighbors.stream().map(MOVE_VALIDATOR::outBoardLine).allMatch(isTrue) && lowerNeighbors.stream().map(BOARD_MANAGER::moveDone).allMatch(isTrue);

        return upperPoint || lowerPoint;
    }

    public boolean isNotPoint(Move refMove){

        return !isPoint(refMove);
    }

    private List<Move> lowerNeighbors(Move refMove) {

        Integer refRow = refMove.getRow();
        Integer refCol = refMove.getCol();

        if (refMove.getLineKind() == Move.Which.HORIZONTAL) {

            return Arrays.asList(new Move(Move.Which.VERTICAL, refRow, refCol + 1),
                                 new Move(Move.Which.HORIZONTAL, refRow + 1, refCol),
                                 new Move(Move.Which.VERTICAL, refRow, refCol));
        }
        else{

            return Arrays.asList(new Move(Move.Which.HORIZONTAL, refRow, refCol),
                                 new Move(Move.Which.VERTICAL, refRow, refCol + 1),
                                 new Move(Move.Which.HORIZONTAL, refRow + 1, refCol));
        }
    }

    private List<Move> upperNeighbors(Move refMove) {

        Integer refRow = refMove.getRow();
        Integer refCol = refMove.getCol();

        if (refMove.getLineKind() == Move.Which.HORIZONTAL) {

            return Arrays.asList(new Move(Move.Which.VERTICAL, refRow - 1, refCol),
                                 new Move(Move.Which.HORIZONTAL, refRow - 1, refCol),
                                 new Move(Move.Which.VERTICAL, refRow - 1, refCol + 1));
        }
        else{

            return Arrays.asList(new Move(Move.Which.HORIZONTAL, refRow + 1, refCol - 1),
                                 new Move(Move.Which.VERTICAL, refRow, refCol - 1),
                                 new Move(Move.Which.HORIZONTAL, refRow, refCol - 1));
        }
    }
}
