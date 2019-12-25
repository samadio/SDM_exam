package iotest;

import dotsandboxes.DotsAndBoxesInput;
import gamesuite.move.Move;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest{

    private void setKeyboard(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    DotsAndBoxesInput itest = new DotsAndBoxesInput();

    @Test
    public void converterTest() throws DataFormatException {

        itest.setConverter(12);

        setKeyboard("26 R");
        itest.readMove();
        Move m = itest.getMove();

        assertSame(m.getLineKind(), Move.Which.HORIZONTAL);
        assertEquals(2, (int) m.getRow()); //first element of row2=Node 24,
        assertEquals(2, (int) m.getCol());
    }
}
