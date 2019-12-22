package gamesuite;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveAlreadyDoneException;
import gamesuite.move.MoveValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveValidatorTest {


    @Test
    public void NewMoveTest() {
        Move currentMove = new Move(3, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        MoveValidator testMoveValidator = new MoveValidator(currentBM);
        assertFalse(testMoveValidator.moveAlreadyDone(currentMove));
    }

    @Test
    public void AlreadyDoneMoveTest() {
        Move currentMove = new Move(3, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        MoveValidator testMoveValidator = new MoveValidator(currentBM);

        currentBM.updateBoard(currentMove);

        assertTrue(testMoveValidator.moveAlreadyDone(currentMove));
    }


    @Test
    public void inBoardMoveTest() {
        Move currentMove = new Move(3, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        MoveValidator testMoveValidator = new MoveValidator(currentBM);

        assertFalse(testMoveValidator.outBoardLine(currentMove));
    }

    @Test
    public void outBoardMoveTests() {
        BoardManager currentBM = new BoardManager(4, 4);
        MoveValidator testMoveValidator = new MoveValidator(currentBM);

        assertTrue(testMoveValidator.outBoardLine(new Move(15, Move.Direction.DOWN)));
        assertTrue(testMoveValidator.outBoardLine(new Move(16, Move.Direction.RIGHT)));
        assertTrue(testMoveValidator.outBoardLine(new Move(1, Move.Direction.UP)));
        assertTrue(testMoveValidator.outBoardLine(new Move(5, Move.Direction.LEFT)));
        assertTrue(testMoveValidator.outBoardLine(new Move(5, Move.Direction.LEFT)));

    }

    @Test
    public void invalidNodeTest() {
        BoardManager currentBM = new BoardManager(4, 4);
        MoveValidator testMoveValidator = new MoveValidator(currentBM);

        assertTrue(testMoveValidator.invalidNode(17));
        assertTrue(testMoveValidator.invalidNode(0));
        assertTrue(testMoveValidator.invalidNode(-10));
        assertFalse(testMoveValidator.invalidNode(15));
    }

    @Test
    public void validateMoveAlreadyDoneException() {
        Move currentMove = new Move(12, Move.Direction.LEFT);
        BoardManager currentBM = new BoardManager(4, 4);
        MoveValidator testMoveValidator = new MoveValidator(currentBM);

        testMoveValidator.validate(currentMove);
        currentBM.updateBoard(currentMove);

        assertThrows(MoveAlreadyDoneException.class, () -> testMoveValidator.validate(currentMove));
    }





}
