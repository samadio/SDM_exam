package iotest;

import dotsandboxes.io.DotsAndBoxesInput;
import dotsandboxes.io.DotsAndBoxesOutput;
import dotsandboxes.io.InputMove;
import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DotsAndBoxesInputTest {

    private void setKeyboard(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());

    @Test
    public void readInputTest() {
        setKeyboard("Mossa");
        assertEquals(itest.readInput(), "Mossa");
    }

    @Test
    public void readInputMoveParserTest() throws DataFormatException, EndGameException, ResetGameException {
        setKeyboard("12 R");
        InputMove imove=itest.readInputMove();
        assertEquals(imove.getNode(),12);
        assertEquals(imove.getDirection(), InputMove.Direction.RIGHT);
    }

    @Test
    public void getGridTest(){
        setKeyboard("12 13");
        List<Integer> expected = Arrays.asList(12,13);
        assertEquals(itest.getGridDimensions(), expected);
    }



    @Test
    public void getPlayersNumberTest(){
        setKeyboard(" 5 ");
        Integer i=itest.getPlayersNumber();
        assertEquals(5, i);
    }

    @Test
    public void customizePlayersTest(){
        setKeyboard("n\n");
        assertFalse(itest.customPlayers());
        setKeyboard(" Y \n");
        assertTrue(itest.customPlayers());

    }

}