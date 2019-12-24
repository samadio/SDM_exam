package gametests.statustest;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveValidator;
import gamesuite.status.Scorer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScorerTest {



    @Test
    void horizontalMoveNoPoint() {

        Move refMove = new Move(Move.Which.HORIZONTAL, 1, 0);
        Map<Move, Boolean> movesDone = moveMap(refMove, Arrays.asList(true, true, false, true, false, true, true));
        Map<Move, Boolean> validMoves = moveMap(refMove, Arrays.asList(true, true, true, true, true, true, true));

        movesDone.get(refMove);
        Scorer scorer = new Scorer(new DummyBoardManager(movesDone), new DummyValidator(validMoves));

        assertFalse(scorer.isPoint(refMove));

    }

    @Test
    void verticalMoveNoPoint() {

        Move refMove = new Move(Move.Which.VERTICAL, 0, 0);
        Map<Move, Boolean> movesDone = moveMap(refMove, Arrays.asList(true, false, false, false, true, false, false));
        Map<Move, Boolean> validMoves = moveMap(refMove, Arrays.asList(true, false, false, false, true, true, true));

        movesDone.get(refMove);
        Scorer scorer = new Scorer(new DummyBoardManager(movesDone), new DummyValidator(validMoves));

        assertFalse(scorer.isPoint(refMove));
    }

    @Test
    void horizontalMovePoint() {

        Move refMove = new Move(Move.Which.HORIZONTAL, 0, 0);
        Map<Move, Boolean> movesDone = moveMap(refMove, Arrays.asList(true, false, false, false, true, true, true));
        Map<Move, Boolean> validMoves = moveMap(refMove, Arrays.asList(true, false, false, false, true, true, true));

        movesDone.get(refMove);
        Scorer scorer = new Scorer(new DummyBoardManager(movesDone), new DummyValidator(validMoves));

        assertTrue(scorer.isPoint(refMove));
    }

    @Test
    void verticalMovePoint() {

        Move refMove = new Move(Move.Which.VERTICAL, 0, 0);
        Map<Move, Boolean> movesDone = moveMap(refMove, Arrays.asList(true, false, true, true, true, true, true));
        Map<Move, Boolean> validMoves = moveMap(refMove, Arrays.asList(true, true, true, true, true, true, true));

        movesDone.get(refMove);
        Scorer scorer = new Scorer(new DummyBoardManager(movesDone), new DummyValidator(validMoves));

        assertTrue(scorer.isPoint(refMove));
    }

    private Map<Move, Boolean> moveMap(Move referenceMove, List<Boolean> values){

        Map<Move, Boolean> movesMap = new HashMap<>();
        Integer refRow = referenceMove.getRow();
        Integer refCol = referenceMove.getCol();

        movesMap.put(referenceMove, values.get(0));

        if (referenceMove.getLineKind() == Move.Which.HORIZONTAL) {

            movesMap.put(new Move(Move.Which.VERTICAL, refRow - 1, refCol), values.get(1));
            movesMap.put(new Move(Move.Which.HORIZONTAL, refRow - 1, refCol), values.get(2));
            movesMap.put(new Move(Move.Which.VERTICAL, refRow - 1, refCol + 1), values.get(3));
            movesMap.put(new Move(Move.Which.VERTICAL, refRow, refCol + 1), values.get(4));
            movesMap.put(new Move(Move.Which.HORIZONTAL, refRow + 1, refCol), values.get(5));
            movesMap.put(new Move(Move.Which.VERTICAL, refRow, refCol), values.get(6));
        }
        else{

            movesMap.put(new Move(Move.Which.HORIZONTAL, refRow + 1, refCol - 1), values.get(1));
            movesMap.put(new Move(Move.Which.VERTICAL, refRow, refCol - 1), values.get(2));
            movesMap.put(new Move(Move.Which.HORIZONTAL, refRow, refCol - 1), values.get(3));
            movesMap.put(new Move(Move.Which.HORIZONTAL, refRow, refCol), values.get(4));
            movesMap.put(new Move(Move.Which.VERTICAL, refRow, refCol + 1), values.get(5));
            movesMap.put(new Move(Move.Which.HORIZONTAL, refRow + 1, refCol), values.get(6));
        }

        return movesMap;
    }
}

class DummyBoardManager extends BoardManager {

    private final Map<Move, Boolean> MOVES_DONE;

    DummyBoardManager (Map<Move, Boolean> movesDone){
        super(3,3);

        MOVES_DONE = movesDone;
    }

    @Override
    public boolean moveDone(Move move){

        return MOVES_DONE.get(move);
    }
}

class DummyValidator extends MoveValidator {

    private final Map<Move, Boolean> MOVES_VALIDITY;
    DummyValidator( Map<Move, Boolean> movesValidity){

        MOVES_VALIDITY = movesValidity;
    }

    @Override
    public void validateMove(Move m) throws RuntimeException {}

    @Override
    public boolean outBoardLine(Move m) {
        return MOVES_VALIDITY.get(m);
    }
}

