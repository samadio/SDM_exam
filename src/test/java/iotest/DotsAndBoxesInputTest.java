package iotest;

import dotsandboxes.io.DotsAndBoxesInput;
import dotsandboxes.io.DotsAndBoxesOutput;
import dotsandboxes.io.InputMove;
import dotsandboxes.io.InvalidStateException;
import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

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
        assertEquals(12,imove.getNode());
        assertEquals(InputMove.Direction.RIGHT, imove.getDirection());
    }

    @Test
    public void readMoveTest() throws EndGameException, ResetGameException {
        itest.setConverter(10);
        setKeyboard("12 L");
        assertDoesNotThrow(()->itest.getMove());
        setKeyboard("12 L");
        Move current=itest.getMove();
        assertEquals(1,current.getRow());
        assertEquals(1,current.getCol());
        assertEquals(Move.Which.HORIZONTAL,current.getLineKind());
    }

    @Test
    public void getGridTest(){
        setKeyboard("12 13");
        List<Integer> expected = Arrays.asList(12,13);
        assertEquals(itest.getGridDimensions(), expected);
    }



    @Test
    public void getPlayersNumberTest(){
        setKeyboard("5 ");
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

    @Test
    public void EndGameExceptionTest(){
        itest.setConverter(8);
        setKeyboard("1 2 quit");
        assertThrows(EndGameException.class,()->itest.getMove());
        setKeyboard("exit");
        assertThrows(EndGameException.class,()->itest.getMove());
    }

    @Test
    public void ResetGameExceptionTest(){
        itest.setConverter(8);
        setKeyboard("1 2 reset");
        assertThrows(ResetGameException.class,()->itest.getMove());
        setKeyboard("reset");
        assertThrows(ResetGameException.class,()->itest.getMove());
    }


    @Test
    public void settedConverterExceptionTest() {
        try {
            setKeyboard("1 R");
            itest.getMove();
            fail();
        } catch (InvalidStateException e) {assertEquals(e.getMessage(),"Convert not set");}
        catch(EndGameException | ResetGameException end){fail();}

        itest.setConverter(10);
        setKeyboard("1 R");
        assertDoesNotThrow(()->itest.getMove());
    }

    @Test
    public void DataFormatExceptionTest() {
        setKeyboard("1 l");
        DataFormatException e = assertThrows(DataFormatException.class, () -> itest.readInputMove());
        assertEquals(e.getMessage(), "Invalid move, please use the following format: [NodeNumber] [U|D|L|R]");
    }

}