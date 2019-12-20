package iotest;


import dotsandboxes.DotsAndBoxesInput;
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
}