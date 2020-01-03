package gamesuite;

import dotsandboxes.board.DotsAndBoxesBoardManager;
import dotsandboxes.io.Converter;
import dotsandboxes.io.InputMove;
import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardManagerTest {


    @Test
    void rowAndColLengthTest(){
        BoardManager BM=new DotsAndBoxesBoardManager(4,6);

        assertEquals(BM.rowLength(),6);
        assertEquals(BM.columnsLength(), 4);
    }

    @Test
    void moveDoneTest(){
        BoardManager BM=new DotsAndBoxesBoardManager(4,6);

        InputMove m= new InputMove(10, InputMove.Direction.UP);

        assertFalse(BM.moveDone(new Converter(6).convert(m)));
    }



}