package iotest;


import dotsandboxes.DotsAndBoxesInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DotsAndBoxesInputTest {

    @Test
    public void printInput(){
        DotsAndBoxesInput itest=new DotsAndBoxesInput();
        assertEquals(itest.readInput(),"Mossa");
    }
}