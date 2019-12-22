package gamesuite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getElementTest() {
        Board board= new Board(4,6);
        Move m= new Move(4, Move.Direction.UP);
        Indexes indexes=new Indexes(m,4);
        assertEquals(board.getElement(indexes),false);

    }

    @Test
    void setElementTest(){
        Board board= new Board(4,6);
        Move m= new Move(4, Move.Direction.UP);
        Indexes indexes=new Indexes(m,4);
        board.setBoard(indexes);
        assertEquals(board.getElement(indexes),true);
    }


}