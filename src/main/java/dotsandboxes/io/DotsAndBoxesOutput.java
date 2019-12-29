package dotsandboxes.io;

import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;
import gamesuite.players.Player;
import gamesuite.status.GameScore;
import iomanagement.OutputManager;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

import static gamesuite.move.Move.Which.HORIZONTAL;
import static gamesuite.move.Move.Which.VERTICAL;

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

        Move.Which type= HORIZONTAL;
        Integer i=0; //row u're looking at
        while(i!=rows-1 && type!=VERTICAL){   //stop condition: first invalid row
            for(Integer j=0;j<columnsOf(type,columns);j++){
                Boolean present= board.getElement(type,i,j);
                String s=convertToString(present,type);
                outputPrint(s);
            }
            if(type==VERTICAL) i+=1;
            type=other(type);
            outputPrint("\n");
        }
    }

    private Integer columnsOf(Move.Which lk,Integer cols){
        if((lk== HORIZONTAL)) return cols-1;
        return cols;
    }

    private Move.Which other(Move.Which lk){
        if(lk==HORIZONTAL) return VERTICAL;
        return HORIZONTAL;
    }

    private String convertToString(Boolean present, Move.Which type) {
        return null;
    }


}
