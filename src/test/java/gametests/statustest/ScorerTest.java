package gametests.statustest;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ScorerTest {
    @Test
    void horizontalMoveNoPoint() {
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

class DummyValidator extends MoveValidator{

    private final Map<Move, Boolean> MOVES_VALIDITY;
    DummyValidator( Map<Move, Boolean> movesValidity){

        MOVES_VALIDITY = movesValidity;
    }

    public boolean isValidMove(Move m){

        return MOVES_VALIDITY.get(m);
    }

}

