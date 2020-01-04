package dotsandboxes.status;

import gamesuite.board.BoardManager;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.status.GameStatus;
import gamesuite.status.Scorer;

import java.util.List;

public class DotsAndBoxesStatus extends GameStatus {

    private Integer remainingMoves;
    private Integer maximumMoves;

    public DotsAndBoxesStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator) {

        super(players, bManager, mValidator);
        setMaximumMoves(bManager.columnsLength(),bManager.rowLength());
        remainingMoves=maximumMoves;
    }

    private void setMaximumMoves(Integer rows, Integer cols){
        maximumMoves= 2*(rows-1)*(cols-1) + cols + rows - 2;
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
    public boolean isFinished() {

        return remainingMoves <= 0;
    }

    @Override
    public void reset() {
        super.reset();
        remainingMoves=maximumMoves;
    }
}
