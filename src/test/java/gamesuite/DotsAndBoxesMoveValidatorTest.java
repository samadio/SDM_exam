package gamesuite;

import gamesuite.board.BoardManager;
import gamesuite.move.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DotsAndBoxesMoveValidatorTest {


    @Test
    public void NewMoveTest() {
        Move currentMove = new Move(3, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);
        assertFalse(testMoveValidator.moveAlreadyDone(currentMove));
    }

    @Test
    public void AlreadyDoneMoveTest() {
        Move currentMove = new Move(3, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        currentBM.updateBoard(currentMove);

        assertTrue(testMoveValidator.moveAlreadyDone(currentMove));
    }


    @Test
    public void inBoardMoveTest() {
        Move currentMove = new Move(3, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        assertFalse(testMoveValidator.outBoardLine(currentMove));
    }

    @Test
    public void outBoardMoveTests() {
        BoardManager currentBM = new BoardManager(4, 4);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        assertTrue(testMoveValidator.outBoardLine(new Move(14, Move.Direction.DOWN)));
        assertTrue(testMoveValidator.outBoardLine(new Move(15, Move.Direction.RIGHT)));
        assertTrue(testMoveValidator.outBoardLine(new Move(1, Move.Direction.UP)));
        assertTrue(testMoveValidator.outBoardLine(new Move(4, Move.Direction.LEFT)));

    }

    @Test
    public void invalidNodeTest() {
        BoardManager currentBM = new BoardManager(4, 4);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        assertTrue(testMoveValidator.invalidNode(16));
        assertTrue(testMoveValidator.invalidNode(103));
        assertTrue(testMoveValidator.invalidNode(-10));
        assertFalse(testMoveValidator.invalidNode(8));
    }

    @Test
    public void validateNoExceptionTest(){
        Move currentMove= new Move(10, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        assertDoesNotThrow(()->testMoveValidator.validateMove(currentMove));
    }

    @Test
    public void validateMoveAlreadyDoneException(){
        Move currentMove = new Move(10, Move.Direction.DOWN);
        BoardManager currentBM = new BoardManager(4, 4);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        currentBM.updateBoard(currentMove);

        MoveAlreadyDoneException exception=assertThrows(MoveAlreadyDoneException.class, () -> testMoveValidator.validateMove(currentMove));
        assertEquals(currentMove,exception.getInvalid());
    }


    @Test
    public void validateMoveOutOfBoardException() {
        BoardManager currentBM = new BoardManager(1, 10);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        //outBoardLine should cause exception
        Move move1=new Move(1, Move.Direction.DOWN);
        MoveOutOfBoardException exception= assertThrows(MoveOutOfBoardException.class, () -> testMoveValidator.validateMove(move1));
        assertEquals(move1,exception.getInvalid());
    }

    @Test
    public void validateInvalidNodeException() {
        BoardManager currentBM = new BoardManager(10, 7);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        //invalidNode should cause an exception
        Move currentMove = new Move(101, Move.Direction.UP);
        InvalidNodeException exception = assertThrows(InvalidNodeException.class, () -> testMoveValidator.validateMove(currentMove));
        assertEquals(currentMove, exception.getInvalid());
    }



}
