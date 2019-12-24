package gamesuite.status;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;

import java.util.List;

public class GameStatus {


    private final Scorer SCORER;
    private final List<Player> PLAYERS;
    private Integer currentPlayer;

    public GameStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator) {

        PLAYERS = players;
        SCORER = new Scorer(bManager, mValidator);
        currentPlayer = 0;
    }

    public Player currentPlayer() {
        return PLAYERS.get(currentPlayer);
    }

    public void update(Move lastMove) {

        if(SCORER.isPoint(lastMove))
            currentPlayer = nextPlayer();
    }

    private Integer nextPlayer() {
        return (currentPlayer + 1) % PLAYERS.size();
    }
}
