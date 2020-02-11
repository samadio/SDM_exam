package gametests.boardtest;

import dotsandboxes.board.BoardHandle;
import dotsandboxes.io.Converter;
import dotsandboxes.io.InputMove;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static gamesuite.move.Move.Orientation.HORIZONTAL;
import static gamesuite.move.Move.Orientation.VERTICAL;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BoardTest {

    @Test
    public void getElementTest() {
        BoardHandle board = new BoardHandle(4,6);
        InputMove inputMove = new InputMove(10, InputMove.Direction.UP);
        Converter converter = new Converter(6);
        Move m=converter.convert(inputMove);
        assertEquals(board.getElement(m.getLineKind(),m.getRow(),m.getCol()),false);
    }

    @Test
    public void setElementTest(){
        BoardHandle board = new BoardHandle(4,6);
        InputMove inputMove = new InputMove(10, InputMove.Direction.UP);
        Converter converter = new Converter(6);
        Move m = converter.convert(inputMove);
        board.setBoard(m.getLineKind(),m.getRow(),m.getCol());
        assertEquals(board.getElement(m.getLineKind(),m.getRow(),m.getCol()),true);
    }


    @Test
    void resetTest() {
        BoardHandle board = new BoardHandle(3,3);

        Integer rows = board.getRows();
        Integer columns = board.getColumns();

        Move.Orientation type = HORIZONTAL;
        int i = 0;
        while(i != rows - 1 | type != VERTICAL){
            for(int j = 0; j < columnsOf(type,columns); j += 1){
                board.setBoard(type,i,j);
            }
            if(type == VERTICAL) i += 1;
            type = other(type);
        }
        board.reset();
        type = HORIZONTAL;
        i = 0;
        while(i != rows-1 | type != VERTICAL){
            for(int j = 0; j < columnsOf(type,columns); j += 1){
                assertFalse(board.getElement(type,i,j));
            }
            if(type==VERTICAL) i += 1;
            type=other(type);
        }
    }


    private Integer columnsOf(Move.Orientation lk, Integer cols){
        if((lk ==  HORIZONTAL)) return cols - 1;
        return cols;
    }

    private Move.Orientation other(Move.Orientation lk){
        if(lk == HORIZONTAL) return VERTICAL;
        return HORIZONTAL;
    }
}