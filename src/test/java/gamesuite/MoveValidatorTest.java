package gamesuite;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveAlreadyDoneException;
import gamesuite.move.MoveValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class MoveValidatorTest {


    @Test
    public void correctInputTest() {
        Move currentMove = new Move(3, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        MoveValidator testMoveValidator = new MoveValidator(currentBM);
        assertFalse(testMoveValidator.lineOccupied(currentMove));
    }

    @Test
    public void moveAlreadyDoneExceptionTest() {
        Move currentMove = new Move(3, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        MoveValidator testMoveValidator = new MoveValidator(currentBM);

        currentBM.updateBoard(currentMove);

        assertThrows(MoveAlreadyDoneException.class, () -> testMoveValidator.lineOccupied(currentMove));
    }



}
