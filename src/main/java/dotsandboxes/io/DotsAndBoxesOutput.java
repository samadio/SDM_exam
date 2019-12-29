package dotsandboxes.io;

import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;
import gamesuite.players.Player;
import gamesuite.status.GameScore;
import iomanagement.OutputManager;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class DotsAndBoxesOutput extends OutputManager {

    @Override
    public void printGame(Game game) {

        System.out.println("Hello, world!");
    }

    @Override
    public void printInvalidMove(InvalidMoveException e) {

        System.err.println(e.getMessage());
    }

    @Override
    public void outputPrintln(String message) {
        System.out.println(message);
    }

    @Override
    public void errorPrintln(String s) {
        System.err.println(s);
    }

    @Override
    public void outputPrint(String s) {
        System.out.print(s);
    }

    @Override
    public void errorPrint(String s) {
        System.err.print(s);
    }

    @Override
    public void printWinner(Game game) {

        GameScore score = game.getScore();

        Optional<Map.Entry<Player, Integer>> winner = score.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("The winner is " + winner.get().getKey());
    }

    @Override
    public void printBoard(AbstractBoard board) {
        Integer rows=board.getRows();
        Integer columns=board.getColumns();
    }
}
