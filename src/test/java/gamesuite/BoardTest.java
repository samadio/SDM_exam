package gamesuite;

import dotsandboxes.board.Board;
import dotsandboxes.io.Converter;
import dotsandboxes.io.InputMove;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    public void getElementTest() {
        Board board= new Board(4,6);
        InputMove inputMove= new InputMove(10, InputMove.Direction.UP);
        Converter converter= new Converter(6);
        Move m=converter.convert(inputMove);
        assertEquals(board.getElement(m.getLineKind(),m.getRow(),m.getCol()),false);
    }


    @Test
    public void setElementTest(){
        Board board= new Board(4,6);
        InputMove inputMove= new InputMove(10, InputMove.Direction.UP);
        Converter converter= new Converter(6);
        Move m=converter.convert(inputMove);
        board.setBoard(m.getLineKind(),m.getRow(),m.getCol());
        assertEquals(board.getElement(m.getLineKind(),m.getRow(),m.getCol()),true);
    }


}