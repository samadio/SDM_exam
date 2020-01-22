package iotest;

import dotsandboxes.board.DotsAndBoxesBoardManager;
import dotsandboxes.io.DotsAndBoxesInput;
import dotsandboxes.io.DotsAndBoxesOutput;
import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import iomanagement.OutputManager;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class DotsAndBoxesOutputTest {

    private void setKeyboard(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    DotsAndBoxesOutput otest = new DotsAndBoxesOutput();
    DotsAndBoxesInput itest = new DotsAndBoxesInput(new DotsAndBoxesOutput());
    BoardManager bm = new DotsAndBoxesBoardManager(4, 4);

/*
    @Test
    public void seeOutputTest(){
        Move currentMove = new Move(Move.Which.HORIZONTAL, 0,0);
        bm.updateBoard(currentMove);
        bm.updateBoard(new Move(Move.Which.VERTICAL,2,2));
        bm.updateBoard(new Move(Move.Which.HORIZONTAL,2,2));
        otest.printBoard(bm.getBoard());
    }
    
 */


}
