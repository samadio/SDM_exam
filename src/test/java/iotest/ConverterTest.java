package iotest;

import dotsandboxes.io.DotsAndBoxesInput;
import dotsandboxes.io.DotsAndBoxesOutput;
import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest{

    private void setKeyboard(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());

    @Test
    public void converterTest() throws EndGameException, ResetGameException {
        setKeyboard("12 12");
        itest.getGridDimensions();
        setKeyboard("26 R");
        Move m = itest.getMove();

        assertSame(m.getLineKind(), Move.Which.HORIZONTAL);
        assertEquals(2, (int) m.getRow()); //first element of row2=Node 24,
        assertEquals(2, (int) m.getCol());
    }
}
