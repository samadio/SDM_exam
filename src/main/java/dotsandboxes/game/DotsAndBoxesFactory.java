package dotsandboxes.game;

import dotsandboxes.board.DotsAndBoxesBoardManager;
import dotsandboxes.status.DotsAndBoxesStatus;
import dotsandboxes.validation.DotsAndBoxesMoveValidator;
import gamesuite.board.BoardManager;
import gamesuite.game.GameFactory;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.status.GameStatus;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import java.util.List;

public class DotsAndBoxesFactory extends GameFactory {

    public DotsAndBoxesFactory(InputManager iManager, OutputManager oManager) {
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
