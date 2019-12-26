package dotsandboxes;

import gamesuite.board.BoardManager;
import gamesuite.game.GameSetter;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.status.GameStatus;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import java.util.List;

public class DotsAndBoxesSetter extends GameSetter {

    public DotsAndBoxesSetter(InputManager iManager, OutputManager oManager) {
        super(iManager, oManager);
    }

    @Override
    protected GameStatus setStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator) {
       return new DotsAndBoxesStatus(players, bManager, mValidator);
    }

    @Override
    protected MoveValidator setValidator(BoardManager bManager) {
        return new DotsAndBoxesMoveValidator(bManager);
    }

    @Override
    protected BoardManager setBoard(Integer rows, Integer cols) {
        return new DotsAndBoxesBoardManager(rows, cols);
    }
}
