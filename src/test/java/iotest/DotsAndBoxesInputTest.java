package iotest;

import dotsandboxes.Converter;
import dotsandboxes.DotsAndBoxesInput;
import dotsandboxes.InputMove;
import gamesuite.board.BoardManager;
import dotsandboxes.DotsAndBoxesMoveValidator;
import gamesuite.move.Move;
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

    DotsAndBoxesInput itest = new DotsAndBoxesInput();

    @Test
    public void readInputTest() {
        setKeyboard("Mossa");
        assertEquals(itest.readInput(), "Mossa");
    }

    @Test
    public void readInputMoveParserTest() throws DataFormatException {
        setKeyboard("12 R");
        InputMove imove=itest.readInputMove();
        assertEquals(imove.getNode(),12);
        assertEquals(imove.getDirection(), InputMove.Direction.RIGHT);
    }

    @Test
    public void getGridTest() throws DataFormatException {
        setKeyboard("12 13");
        List<Integer> expected = Arrays.asList(12,13);
        assertEquals(itest.getGridDimensions(), expected);
    }

    @Test
    public void converterTest() throws DataFormatException {

        itest.setConverter(12);

        setKeyboard("26 R");
        itest.readMove();
        Move m = itest.getMove();

        assertTrue(m.getLineKind()==Move.Which.HORIZONTAL);
        assertTrue(m.getRow()==2); //first element of row2=Node 24,
        assertTrue(m.getCol()==2);
    }

    @Test
    public void getPlayersNumberTest() throws DataFormatException {
        setKeyboard("2");
        Integer i=itest.getPlayersNumber();
        assertTrue(i==2);
    }

    @Test
    public void customizePlayersTest() throws DataFormatException {
        setKeyboard("n");
        assertFalse(itest.customPlayers());
        setKeyboard("y");
        assertTrue(itest.customPlayers());
        //TRUE BUT IN THE FUTURE CAN BE MOVED, SO keep it commented

        //setKeyboard("anything else");
        //assertThrows(DataFormatException.class,()->itest.customizePlayers());
    }



}