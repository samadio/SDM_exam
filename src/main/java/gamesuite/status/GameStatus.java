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
    private GameScore score;

    private Integer remainingMoves;


    public GameStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator) {

        PLAYERS = players;
        SCORER = new Scorer(bManager, mValidator);
        remainingMoves = 2*(bManager.columnsLength()-1)*(bManager.rowLength()-1) + bManager.rowLength() + bManager.columnsLength() - 2;
        currentPlayer = 0;
        score = new GameScore();

        for (Player p : PLAYERS)
            score.put(p, 0);
    }

    public Player currentPlayer() {
        return PLAYERS.get(currentPlayer);
    }

    public void update(Move lastMove) {

        if(isNotFinished()) {

            if (SCORER.isNotPoint(lastMove))
                currentPlayer = nextPlayer();
            else {

                Player currentP = PLAYERS.get(currentPlayer);
                score.replace(currentP, score.get(currentP) + 1);
            }

            remainingMoves--;
        }
    }

    private Integer nextPlayer() {
        return (currentPlayer + 1) % PLAYERS.size();
    }

    public boolean isFinished(){

        return remainingMoves <= 0;
    }
    public boolean isNotFinished(){

        return remainingMoves > 0;
    }

    public GameScore getScore() {

        return score;
    }
}
