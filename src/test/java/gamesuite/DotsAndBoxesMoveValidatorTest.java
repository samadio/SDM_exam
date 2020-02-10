package gamesuite;

import dotsandboxes.board.DotsAndBoxesBoardManager;
import gamesuite.board.BoardManager;
import dotsandboxes.validation.DotsAndBoxesMoveValidator;
import gamesuite.move.Move;
import gamesuite.move.MoveAlreadyDoneException;
import gamesuite.move.MoveOutOfBoardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DotsAndBoxesMoveValidatorTest {

    @Test
    public void NewMoveTest() {
        Move currentMove = new Move(Move.Which.HORIZONTAL, 0,0);
        BoardManager currentBM = new DotsAndBoxesBoardManager(4, 4);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);
        assertDoesNotThrow(()->testMoveValidator.validateMove(currentMove));
    }


    @Test
    public void inBoardMoveTest() {
        Move currentMove = new Move(Move.Which.HORIZONTAL,4,4);
        BoardManager currentBM = new DotsAndBoxesBoardManager(8, 8);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        assertFalse(testMoveValidator.outOfBoardLine(currentMove));
    }

    @Test
    public void outBoardMoveTests() {
        BoardManager currentBM = new DotsAndBoxesBoardManager(10, 10);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        assertTrue(testMoveValidator.outOfBoardLine(new Move(Move.Which.HORIZONTAL,10,11)));
        assertTrue(testMoveValidator.outOfBoardLine(new Move(Move.Which.VERTICAL, 10,11)));
        assertTrue(testMoveValidator.outOfBoardLine(new Move(Move.Which.HORIZONTAL,-1,0)));
        assertTrue(testMoveValidator.outOfBoardLine(new Move(Move.Which.HORIZONTAL,3,11)));
        assertTrue(testMoveValidator.outOfBoardLine(new Move(Move.Which.VERTICAL, 11,2)));
    }

    @Test
    public void validateNoExceptionTest(){
        Move currentMove= new Move(Move.Which.HORIZONTAL, 10,0);
        BoardManager currentBM = new DotsAndBoxesBoardManager(11, 11);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        assertDoesNotThrow(()->testMoveValidator.validateMove(currentMove));
    }

    @Test
    public void validateMoveAlreadyDoneException(){
        Move currentMove = new Move(Move.Which.HORIZONTAL, 10,0);
        BoardManager currentBM = new DotsAndBoxesBoardManager(11, 11);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        currentBM.updateBoard(currentMove);

        MoveAlreadyDoneException exception=assertThrows(MoveAlreadyDoneException.class, () -> testMoveValidator.validateMove(currentMove));
        assertEquals(currentMove,exception.getInvalid());
    }


    @Test
    public void validateMoveOutOfBoardException() {
        BoardManager currentBM = new DotsAndBoxesBoardManager(10, 10);
        DotsAndBoxesMoveValidator testMoveValidator = new DotsAndBoxesMoveValidator(currentBM);

        //outBoardLine should cause exception
        Move move1=new Move(Move.Which.HORIZONTAL,10,10);
        MoveOutOfBoardException exception= assertThrows(MoveOutOfBoardException.class, () -> testMoveValidator.validateMove(move1));
        assertEquals(move1,exception.getInvalid());
    }



}