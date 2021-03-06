package gametests;

import dotsandboxes.board.DotsAndBoxesBoardManager;
import dotsandboxes.io.DotsAndBoxesInput;
import dotsandboxes.io.DotsAndBoxesOutput;
import dotsandboxes.status.DotsAndBoxesStatus;
import dotsandboxes.validation.DotsAndBoxesMoveValidator;
import gamesuite.board.BoardManager;
import gamesuite.game.Game;
import gamesuite.move.MoveValidator;
import gamesuite.players.NameAlreadyUsedException;
import gamesuite.players.Player;
import gamesuite.players.PlayersFactory;
import gamesuite.players.ReservedNameException;
import gamesuite.status.GameStatus;
import iomanagement.OutputManager;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private void setKeyboard(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }


    @Test
    void ManuallyEnded() {

        try {
            OutputManager oManager = new DotsAndBoxesOutput();
            DotsAndBoxesInput iManager = new DotsAndBoxesInput(oManager);
            setKeyboard("4 4");
            iManager.getGridDimensions();
            BoardManager bManager = new DotsAndBoxesBoardManager(4, 4);
            MoveValidator mValidator = new DotsAndBoxesMoveValidator(bManager);
            PlayersFactory factory = new PlayersFactory();
            List<Player> list = new ArrayList<>();
            Player p = factory.newPlayer("testPlayer");
            list.add(p);

            GameStatus gStatus = new DotsAndBoxesStatus(list, bManager, mValidator);

            Game dotsAndBoxes = new Game(iManager, oManager, bManager, mValidator, gStatus, list);

            assertFalse(dotsAndBoxes.endedManually());
            setKeyboard("  exit  ");
            dotsAndBoxes.play();
            assertTrue(dotsAndBoxes.endedManually());
        }catch (NameAlreadyUsedException|ReservedNameException e){
            fail();
        }
    }

}
