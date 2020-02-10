package iotest;

import dotsandboxes.io.*;
import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DotsAndBoxesInputTest {

    private void setKeyboard(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    public void ExhaustedInputTest(){
        DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());
        //in order to setConverter
        setKeyboard("10 10");
        itest.getGridDimensions();
        setKeyboard("    12   L  ");
        assertDoesNotThrow(itest::getMove);
        setKeyboard("12 2");
        ExhaustedInputException e=assertThrows(ExhaustedInputException.class, itest::getMove);
        setKeyboard("    12.2 L  ");
        assertThrows(ExhaustedInputException.class, itest::getMove);
        assertThrows(ExhaustedInputException.class, itest::getMove);

    }


    @Test
    public void readInputMoveParserTest(){
        DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());
        //in order to setConverter
        setKeyboard("10 10");
        itest.getGridDimensions();
        setKeyboard("12 R");
        try{
            Move move = itest.getMove();
            assertEquals(Move.Which.HORIZONTAL,move.getLineKind());
            assertEquals(1,move.getRow());
            assertEquals(2,move.getCol());

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getGridTest(){
        DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());
        setKeyboard("  12   13 ");
        List<Integer> expected = Arrays.asList(12,13);
        assertEquals(itest.getGridDimensions(), expected);
    }


    @Test
    public void getPlayersNumberTest(){
        DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());
        setKeyboard("   5 ");
        Integer i = itest.getPlayersNumber();
        assertEquals(5, i);
    }

    @Test
    public void customizePlayersTest(){
        DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());
        setKeyboard("n\n");
        assertFalse(itest.customPlayers());
        setKeyboard(" Y \n");
        assertTrue(itest.customPlayers());
    }

    @Test
    public void EndGameExceptionTest(){
        DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());
        setKeyboard("10 10");
        itest.getGridDimensions();
        setKeyboard("1 2 quit");
        assertThrows(EndGameException.class, itest::getMove);
        setKeyboard("parliamo della brexit?");
        assertThrows(EndGameException.class, itest::getMove);
    }

    @Test
    public void ResetGameExceptionTest(){
        DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());
        setKeyboard("10 10");
        itest.getGridDimensions();
        setKeyboard("1 2 reset");
        assertThrows(ResetGameException.class, itest::getMove);
        setKeyboard("reset");
        assertThrows(ResetGameException.class, itest::getMove);
    }


    @Test
    public void settedConverterExceptionTest() {
        DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());
        try {
            setKeyboard("1 R");
            itest.getMove();
            fail();
        } catch (InvalidStateException e) {assertEquals(e.getMessage(),"Convert not set");}
        catch(EndGameException | ResetGameException end){fail();}

        setKeyboard("10 10");
        itest.getGridDimensions();
        setKeyboard("1 R");
        assertDoesNotThrow(itest::getMove);
    }

}