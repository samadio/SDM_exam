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
        outputPrintln("\n");
        printBoard(game.getBoard());
        outputPrintln("\n Players score:");
        for(Player i: game.getPlayers()){
            outputPrint(i.getName()+": ");
            outputPrint(game.getScore().get(i) + "        ");
        }
        outputPrintln("\n");
        printCurrentPlayer(game);
        outputPrintln("\n");

    }

    private void printCurrentPlayer(Game game) {

        outputPrintln("Next player: " + game.nextPlayer());
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

        Optional<Map.Entry<Player, Integer>> winner = score.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("The winner is " + winner.get().getKey());
    }

    @Override
    public void printBoard(AbstractBoard board) {
        Integer rows=board.getRows();
        Integer columns=board.getColumns();
        Integer maxLength=String.valueOf(rows*columns-1).length();

        Move.Which type= HORIZONTAL;
        int i=0; //row u're looking at
        while(i!=rows-1 | type!=VERTICAL){   //stop condition: first invalid row
            for(int j = 0; j<columnsOf(type,columns); j += 1){
                Boolean present= board.getElement(type,i,j);
                Integer currNode= i*columns+j;
                String s=convertToString(present,type,currNode, maxLength);
                outputPrint(s);
            }
            //after finishing a column
            if(type==VERTICAL) i+=1;
            if(type==VERTICAL)outputPrint("\n");
            if(type==HORIZONTAL)outputPrint(indent(String.valueOf(i*columns+columns-1),maxLength)+"\n");
            type=other(type);
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

    private String indent(String nodeString, Integer maxLength){
        return "0".repeat(maxLength-nodeString.length())+nodeString;
    }

    private String convertToString(Boolean present, Move.Which type, Integer currNode,Integer maxLength) {
        String nodeString=String.valueOf(currNode);
        String indented=indent(nodeString,maxLength);
        if(present){
            if(type==VERTICAL)  return " ".repeat(maxLength/2)+"| "+ " ".repeat((maxLength+1)/2);
            if(type==HORIZONTAL)return indented+"——";
        }
        if(type==VERTICAL)return " ".repeat(maxLength+2);
        return  indented+"  ";
    }


}
