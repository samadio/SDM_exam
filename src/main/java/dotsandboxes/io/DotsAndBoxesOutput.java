package dotsandboxes.io;

import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;
import gamesuite.players.Player;
import gamesuite.status.GameScore;
import iomanagement.OutputManager;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static gamesuite.move.Move.Which.HORIZONTAL;
import static gamesuite.move.Move.Which.VERTICAL;

public class DotsAndBoxesOutput extends OutputManager {

    @Override
    public void printGame(Game game) {
        outputPrintln("\n");
        printBoard(game.getBoard());
        outputPrintln("\n Players score:");
        for (Player i : game.getPlayers()) {
            outputPrint(i.getName() + ": ");
            outputPrint(game.getScore().get(i) + "        ");
        }
        outputPrintln("\n");
        printCurrentPlayer(game);
        outputPrintln("\n");

    }

    private void printCurrentPlayer(Game game) { outputPrintln("Next player: " + game.nextPlayer()); }

    @Override
    public void printInvalidMove(InvalidMoveException e) { System.err.println(e.getMessage());}

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

        List<Player> winners = game.getWinner();

        if (winners.size() == 1)
            System.out.println("The winner is " + winners.get(0));
        else {
            System.out.println("Game is a draw, the following players have the same score:");
            for (Player p : winners)
                System.out.println(p);
        }
    }

    @Override
    public void printBoard(AbstractBoard board) {
        Integer rows = board.getRows();
        Integer columns = board.getColumns();

        //maximum number of digits to be used
        Integer maxLength = String.valueOf(rows * columns - 1).length();

        Move.Which type = HORIZONTAL;
        int i = 0; //row u're looking at
        while (i != rows - 1 | type != VERTICAL) {   //stop condition: first invalid row
            for (int j = 0; j < AuxiliaryPrintBoard.columnsOf(type, columns); j++) {
                Boolean present = board.getElement(type, i, j);
                Integer currNode = i * columns + j;
                String s = AuxiliaryPrintBoard.convertToString(present, type, currNode, maxLength);
                outputPrint(s);
            }
            //after finishing a column
            if (type == VERTICAL) {
                i += 1;
                outputPrint("\n");
            }
            if (type == HORIZONTAL)
                outputPrint(AuxiliaryPrintBoard.indent(String.valueOf(i * columns + columns - 1), maxLength) + "\n");
            type = AuxiliaryPrintBoard.other(type);
        }
    }

}

class AuxiliaryPrintBoard{
    static Integer columnsOf(Move.Which lk,Integer cols){
        if((lk== HORIZONTAL)) return cols-1;
        return cols;
    }

    static Move.Which other(Move.Which lk){
        if(lk==HORIZONTAL) return VERTICAL;
        return HORIZONTAL;
    }

    static String convertToString(Boolean present, Move.Which type, Integer currNode,Integer maxLength) {
        String nodeString=String.valueOf(currNode);
        String indented=indent(nodeString,maxLength);
        if(present){
            if(type==VERTICAL)  return " ".repeat(maxLength/2)+"| "+ " ".repeat((maxLength+1)/2);
            if(type==HORIZONTAL)return indented+"——";
        }
        if(type==VERTICAL)return " ".repeat(maxLength+2);
        return  indented+"  ";
    }

    static String indent(String nodeString, Integer maxLength){
        return "0".repeat(maxLength-nodeString.length())+nodeString;
    }


}