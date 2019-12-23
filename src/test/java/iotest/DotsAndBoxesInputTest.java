package iotest;


import dotsandboxes.DotsAndBoxesInput;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DotsAndBoxesInputTest {
/*
    private void setKeyboard(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    public void printInput(){
        DotsAndBoxesInput itest=new DotsAndBoxesInput();
        setKeyboard("Mossa");
        assertEquals(itest.readInput(),"Mossa");
    }


    @Test
    public void regularParserTest(){
        DotsAndBoxesInput itest=new DotsAndBoxesInput();
        setKeyboard("12 R");
        try{
            itest.readMove();
            Move currentMove= itest.getMove();
            assertEquals(currentMove.getNode(),12);
            assertEquals(currentMove.getDirection(), Move.Direction.RIGHT);
        } catch (DataFormatException e) {
            assertEquals("This should not have been executed",e.getMessage());
        }
    }

    @Test
    public void exceptionParserTest(){
        DotsAndBoxesInput itest=new DotsAndBoxesInput();
        setKeyboard("12 RU");

        DataFormatException exception = assertThrows(DataFormatException.class, itest::readMove);
        assertEquals("Format not recognized",exception.getMessage());
    }


 */

}