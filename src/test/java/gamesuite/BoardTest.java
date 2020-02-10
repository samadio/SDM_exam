package gamesuite;

import dotsandboxes.board.Board;
import dotsandboxes.io.Converter;
import dotsandboxes.io.InputMove;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dotsandboxes.board.Board;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import static gamesuite.move.Move.Which.HORIZONTAL;
import static gamesuite.move.Move.Which.VERTICAL;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BoardTest {

    @Test
    public void getElementTest() {
        Board board = new Board(4,6);
        InputMove inputMove = new InputMove(10, InputMove.Direction.UP);
        Converter converter = new Converter(6);
        Move m=converter.convert(inputMove);
        assertEquals(board.getElement(m.getLineKind(),m.getRow(),m.getCol()),false);
    }

    @Test
    public void setElementTest(){
        Board board = new Board(4,6);
        InputMove inputMove = new InputMove(10, InputMove.Direction.UP);
        Converter converter = new Converter(6);
        Move m = converter.convert(inputMove);
        board.setBoard(m.getLineKind(),m.getRow(),m.getCol());
        assertEquals(board.getElement(m.getLineKind(),m.getRow(),m.getCol()),true);
    }


    @Test
    void resetTest() {
        Board board = new Board(3,3);

        Integer rows = board.getRows();
        Integer columns = board.getColumns();

        Move.Which type = HORIZONTAL;
        int i = 0; //row u're looking at
        while(i != rows - 1 | type != VERTICAL){   //stop condition: first invalid row
            for(int j = 0; j < columnsOf(type,columns); j += 1){
                board.setBoard(type,i,j);
            }
            //after finishing a column
            if(type == VERTICAL) i += 1;
            type = other(type);
        }
        board.reset();
        type = HORIZONTAL;
        i = 0; //row u're looking at
        while(i != rows-1 | type != VERTICAL){   //stop condition: first invalid row
            for(int j = 0; j < columnsOf(type,columns); j += 1){
                assertFalse(board.getElement(type,i,j));
            }
            //after finishing a column
            if(type==VERTICAL) i += 1;
            type=other(type);
        }
    }


    private Integer columnsOf(Move.Which lk,Integer cols){
        if((lk ==  HORIZONTAL)) return cols - 1;
        return cols;
    }

    private Move.Which other(Move.Which lk){
        if(lk == HORIZONTAL) return VERTICAL;
        return HORIZONTAL;
    }
}