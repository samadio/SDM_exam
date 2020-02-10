package dotsandboxes.status;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveValidator;
import gamesuite.status.Scorer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DotsAndBoxesScorer extends Scorer {
    public DotsAndBoxesScorer(BoardManager bManager, MoveValidator mValidator) {
        super(bManager, mValidator);
    }

    @Override
    public boolean isPoint(Move refMove) {

        List<Move> upperNeighbors = upperNeighbors(refMove);
        List<Move> lowerNeighbors = lowerNeighbors(refMove);

        Predicate<Boolean> isTrue = x -> x;
        Predicate<Boolean> isFalse = x -> !x;

        Boolean upperSquareCompleted = upperNeighbors.stream().map(MOVE_VALIDATOR::outOfBoardLine).allMatch(isFalse) && upperNeighbors.stream().map(BOARD_MANAGER::moveDone).allMatch(isTrue);
        Boolean lowerSquareCompleted = lowerNeighbors.stream().map(MOVE_VALIDATOR::outOfBoardLine).allMatch(isFalse) && lowerNeighbors.stream().map(BOARD_MANAGER::moveDone).allMatch(isTrue);

        return upperSquareCompleted || lowerSquareCompleted;
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
