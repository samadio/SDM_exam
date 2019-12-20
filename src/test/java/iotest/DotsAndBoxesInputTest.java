package iotest;


import dotsandboxes.DotsAndBoxesInput;
import gamesuite.Move;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DotsAndBoxesInputTest {

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
    public void ParserTest(){
        DotsAndBoxesInput itest=new DotsAndBoxesInput();
        setKeyboard("12 R");
        itest.readMove();
        Move currentMove= itest.getMove();
        assertEquals(currentMove.getNode(),12);
        assertEquals(currentMove.getDirection(), Move.Direction.RIGHT);
    }


}