package gamesuite.status;

import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class GameStatus {


    private final Scorer SCORER;
    private final List<Player> PLAYERS;
    private Integer currentPlayer;
    protected GameScore score;

    public GameStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator) {

        PLAYERS = players;
        SCORER = setScorer(bManager, mValidator);
        currentPlayer = 0;
        score = new GameScore();

        PLAYERS.forEach( p -> score.put(p,0) );
    }

    protected abstract Scorer setScorer(BoardManager bManager, MoveValidator mValidator);
    protected abstract void updateProgress();
    public abstract List<Player> getWinner();

    public Player currentPlayer() {
        return PLAYERS.get(currentPlayer);
    }

    public void update(Move lastMove) {

        if(isNotFinished()) {

            if (SCORER.isNotPoint(lastMove))
                currentPlayer = nextPlayer();
            else {

                Player currentP = PLAYERS.get(currentPlayer);
                score.replace(currentP, updateScore(score.get(currentP)));
            }

            updateProgress();
        }
    }


    private Integer nextPlayer() {
        return (currentPlayer + 1) % PLAYERS.size();
    }

    public abstract boolean isFinished();
    
    public boolean isNotFinished(){

        return !isFinished();
    }

    public GameScore getScore() {

        return score;
    }

    public void reset(){
        score.reset();
        currentPlayer = 0;
    }

    protected abstract int updateScore(int score);

}
