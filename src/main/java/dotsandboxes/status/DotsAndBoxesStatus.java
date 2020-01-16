package dotsandboxes.status;

import gamesuite.board.BoardManager;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.status.GameStatus;
import gamesuite.status.Scorer;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DotsAndBoxesStatus extends GameStatus {

    private Integer remainingMoves;
    private final Integer MAXIMUM_MOVES;

    public DotsAndBoxesStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator) {

        super(players, bManager, mValidator);
        MAXIMUM_MOVES = maximumMoves(bManager.columnsLength(),bManager.rowLength());
        remainingMoves = MAXIMUM_MOVES;
    }

    private int maximumMoves(Integer rows, Integer cols){
        return 2*(rows-1)*(cols-1) + cols + rows - 2;
    }

    @Override
    protected Scorer setScorer(BoardManager bManager, MoveValidator mValidator) {
        return new DotsAndBoxesScorer(bManager, mValidator);
    }

    @Override
    protected void updateProgress() {
        remainingMoves--;
    }

    @Override
    public List<Player> getWinner() {
        Integer maxScore = score.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getValue();
        return score.entrySet().stream().filter(x -> x.getValue().equals(maxScore)).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    @Override
    public boolean isFinished() {

        return remainingMoves <= 0;
    }

    @Override
    public void reset() {
        super.reset();
        remainingMoves = MAXIMUM_MOVES;
    }
}
