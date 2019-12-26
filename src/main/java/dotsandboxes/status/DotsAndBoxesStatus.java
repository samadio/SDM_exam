package dotsandboxes.status;

import gamesuite.board.BoardManager;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.status.GameStatus;
import gamesuite.status.Scorer;

import java.util.List;

public class DotsAndBoxesStatus extends GameStatus {

    private Integer remainingMoves;

    public DotsAndBoxesStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator) {

        super(players, bManager, mValidator);
        remainingMoves = 2*(bManager.columnsLength()-1)*(bManager.rowLength()-1) + bManager.rowLength() + bManager.columnsLength() - 2;
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


}
