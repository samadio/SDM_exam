package gamesuite;
import gamesuite.board.Indexes;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexesTest {


    @Test
    public void toBoardRowIndexTest(){
        Move m= new Move(4, Move.Direction.UP);
        Indexes indexes=new Indexes(m,4);
        assertEquals(indexes.toBoardRowIndex(m,3),
                0);
    }

    @Test
    public void toBoardColIndexTest(){
        Move m= new Move(4, Move.Direction.UP);
        Indexes indexes=new Indexes(m,4);
        assertEquals(indexes.toBoardColIndex(m,3),
                1);
    }


}