package gamesuite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardManagerTest {

    @Test
    void moveDoneTest(){
        BoardManager BM=new BoardManager(4,6);

        Move m= new Move(4, Move.Direction.UP);

        assertEquals(BM.moveDone(m),false);
    }
}