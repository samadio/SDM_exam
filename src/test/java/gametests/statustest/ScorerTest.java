package gametests.statustest;

import gamesuite.BoardManager;
import gamesuite.Move;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScorerTest {
    @Test
    void horizontalMoveNoPoint() {
    }
}

class DummyBoardManager extends BoardManager {

    private final Map<Move, Boolean> MOVES_DONE;
    private final Map<Move, Boolean> MOVES_VALIDITY;

    DummyBoardManager (Map<Move, Boolean> movesDone, Map<Move, Boolean> movesValidity){

        MOVES_DONE = movesDone;
        MOVES_VALIDITY = movesValidity;
    }

    public boolean moveDone(Move move){

        Boolean done = MOVES_DONE.get(move);

        if (done == null)
            throw new NotValidMoveException();

        return done;
    }

    public boolean isValidMove(Move move){

        Boolean valid = MOVES_VALIDITY.get(move);
        if (valid == null)
            throw new NotValidMoveException();
        return valid;
    }

    public Integer rowLength(){

        return 3;
    }
}

class NotValidMoveException extends RuntimeException{}