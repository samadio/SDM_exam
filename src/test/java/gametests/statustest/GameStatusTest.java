package gametests.statustest;

import dotsandboxes.board.DotsAndBoxesBoardManager;
import dotsandboxes.status.DotsAndBoxesStatus;
import gamesuite.board.BoardManager;
import dotsandboxes.validation.DotsAndBoxesMoveValidator;
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
        GameStatus gStatus = new DotsAndBoxesStatus(players, bManager, mValidator);

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
        GameStatus gStatus = new DotsAndBoxesStatus(players, bManager, mValidator);

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
        GameStatus gStatus = new DotsAndBoxesStatus(players, bManager, mValidator);

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
        GameStatus gStatus = new DotsAndBoxesStatus(players, bManager, mValidator);

        GameScore score = gStatus.getScore();
        assertScore(players, score ,0 , 0);
        gStatus.update(lastMove);
        assertScore(players, score ,1 , 0);
    }

    @Test
    void pointNotAssigned() {

        Move lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);

        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));
        BoardManager bManager = new DummyBoardManager(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, false, true)));
        MoveValidator mValidator = new DummyValidator(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        GameStatus gStatus = new DotsAndBoxesStatus(players, bManager, mValidator);

        GameScore score = gStatus.getScore();
        assertScore(players, score, 0, 0);
        gStatus.update(lastMove);
        assertScore(players, score, 0, 0);
    }

    @Test
    void notFinishedAtStart() {

        Move lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);

        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));
        BoardManager bManager = new DummyBoardManager(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        MoveValidator mValidator = new DummyValidator(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        GameStatus gStatus = new DotsAndBoxesStatus(players, bManager, mValidator);

        assertFalse(gStatus.isFinished());
    }

    @Test
    void notFinishedAfterOneMove() {

        Move lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);

        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));
        BoardManager bManager = new DummyBoardManager(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        MoveValidator mValidator = new DummyValidator(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        GameStatus gStatus = new DotsAndBoxesStatus(players, bManager, mValidator);

        assertFalse(gStatus.isFinished());
        gStatus.update(lastMove);
        assertFalse(gStatus.isFinished());
    }

    @Test
    void finishedAtEnd() {

        Move lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);

        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));
        BoardManager bManager = new DummyBoardManager(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        MoveValidator mValidator = new DummyValidator(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        GameStatus gStatus = new DotsAndBoxesStatus(players, bManager, mValidator);

        int nMoves = 12;

        assertFalse(gStatus.isFinished());
        for(int i = 0; i < nMoves; i++)
            gStatus.update(lastMove);
        assertTrue(gStatus.isFinished());
    }

    @Test
    void gameTest() {
        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));

        BoardManager boardManager = new DotsAndBoxesBoardManager(3,3);
        GameStatus gStatus = new DotsAndBoxesStatus(players, boardManager, new DotsAndBoxesMoveValidator(boardManager));

        assertScore(players, gStatus.getScore(), 0, 0);

        Move lastMove = new Move(Move.Which.HORIZONTAL, 1, 0);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 0, 0);

        lastMove = new Move(Move.Which.VERTICAL, 0, 1);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 0, 0);

        lastMove = new Move(Move.Which.HORIZONTAL, 0, 1);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 0, 0);

        lastMove = new Move(Move.Which.VERTICAL, 1, 1);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 0, 0);

        lastMove = new Move(Move.Which.HORIZONTAL, 2, 1);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 0, 0);

        lastMove = new Move(Move.Which.VERTICAL, 0, 0);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 0, 0);

        lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 1, 0);
        assertEquals(players.get(0), gStatus.currentPlayer());

        lastMove = new Move(Move.Which.VERTICAL, 0, 2);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 1, 0);

        lastMove = new Move(Move.Which.HORIZONTAL, 1, 1);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 1, 1);
        assertEquals(players.get(1), gStatus.currentPlayer());

        lastMove = new Move(Move.Which.VERTICAL, 1, 2);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 1, 2);
        assertEquals(players.get(1), gStatus.currentPlayer());

        lastMove = new Move(Move.Which.HORIZONTAL, 2, 0);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 1, 2);

        lastMove = new Move(Move.Which.VERTICAL, 1, 0);
        boardManager.updateBoard(lastMove);
        gStatus.update(lastMove);
        assertScore(players, gStatus.getScore(), 2, 2);
        assertEquals(players.get(0), gStatus.currentPlayer());

        assertTrue(gStatus.isFinished());
    }

    @Test
    void resetTest() {

        Move lastMove = new Move(Move.Which.HORIZONTAL, 0, 0);

        PlayersFactory pFactory = new PlayersFactory();
        List<Player> players = Arrays.asList(pFactory.newPlayer("Pippo"), pFactory.newPlayer("Pluto"));
        BoardManager bManager = new DummyBoardManager(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        MoveValidator mValidator = new DummyValidator(ScorerTest.moveMap(lastMove, Arrays.asList(true, false, false, false, true, true, true)));
        GameStatus gStatus = new DotsAndBoxesStatus(players, bManager, mValidator);

        gStatus.update(lastMove);
        GameScore score = gStatus.getScore();
        assertScore(players, score, 1, 0);
        gStatus.reset();
        assertScore(players, score, 0, 0);
    }

    private void assertScore(List<Player> players, GameScore score, Integer... points ){

        for(int i = 0; i < players.size(); i++)
            assertEquals(points[i],score.get(players.get(i)));
    }
}