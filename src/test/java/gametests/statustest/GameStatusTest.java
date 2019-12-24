package gametests.statustest;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.players.PlayersFactory;
import gamesuite.status.GameScore;
import gamesuite.status.GameStatus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameStatusTest {

    @Test
    void playerChangesAfterNoPoint() {

        Move lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);

        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));
        BoardManager bManager = new DummyBoardManager(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, false, true)));
        MoveValidator mValidator = new DummyValidator(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        GameStatus gStatus = new GameStatus(players, bManager, mValidator);

        assertEquals(players.get(0), gStatus.currentPlayer());
        gStatus.update(lastMove);
        assertEquals(players.get(1), gStatus.currentPlayer());
    }

    @Test
    void playerNotChangedAfterPoint() {

        Move lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);

        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));
        BoardManager bManager = new DummyBoardManager(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        MoveValidator mValidator = new DummyValidator(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        GameStatus gStatus = new GameStatus(players, bManager, mValidator);

        assertEquals(players.get(0), gStatus.currentPlayer());
        gStatus.update(lastMove);
        assertEquals(players.get(0), gStatus.currentPlayer());
    }

    @Test
    void initialPlayerAfterTwoNoPoints() {

        Move lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);

        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));
        BoardManager bManager = new DummyBoardManager(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, false, true)));
        MoveValidator mValidator = new DummyValidator(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        GameStatus gStatus = new GameStatus(players, bManager, mValidator);

        assertEquals(players.get(0), gStatus.currentPlayer());
        gStatus.update(lastMove);
        assertEquals(players.get(1), gStatus.currentPlayer());
        gStatus.update(lastMove);
        assertEquals(players.get(0), gStatus.currentPlayer());

    }

    @Test
    void pointAssigned() {

        Move lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);

        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));
        BoardManager bManager = new DummyBoardManager(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        MoveValidator mValidator = new DummyValidator(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        GameStatus gStatus = new GameStatus(players, bManager, mValidator);

        GameScore score = gStatus.getScore();
        assertEquals(0, score.get(players.get(0)));
        assertEquals(0, score.get(players.get(1)));
        gStatus.update(lastMove);
        assertEquals(1, score.get(players.get(0)));
        assertEquals(0, score.get(players.get(1)));
    }
}