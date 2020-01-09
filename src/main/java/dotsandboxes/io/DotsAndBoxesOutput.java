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
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import static gamesuite.move.Move.Which.HORIZONTAL;
import static gamesuite.move.Move.Which.VERTICAL;

public class DotsAndBoxesOutput implements OutputManager {

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

        outputPrintln(BoardDrawer.boardToString(board));
    }

}

class BoardDrawer{

    public static String boardToString(AbstractBoard board) {
        Integer rows = board.getRows();
        Integer columns = board.getColumns();

        //maximum number of digits needed
        Integer maxLength = String.valueOf(rows * columns - 1).length();

        IntFunction<String> lastRowNumber = row -> String.valueOf(row * columns + columns - 1);

        StringBuilder boardString = new StringBuilder();
        Move.Which type = HORIZONTAL;
        int currentRow = 0; //row u're looking at
        while (currentRow != rows - 1 | type != VERTICAL) {   //stop condition: first invalid row

            Move.Which finalType = type;
            int finalRow = currentRow;

            IntUnaryOperator currentNode = columnIdx -> finalRow*columns + columnIdx;
            IntFunction<Boolean> isPresent = columnIdx -> board.getElement(finalType, finalRow, columnIdx);

            IntStream.range(0, columnsOf(type, columns))
                    .forEach(columnIdx -> boardString.append(convertToString(isPresent.apply(columnIdx), finalType, currentNode.applyAsInt(columnIdx), maxLength)));

            //after finishing a column
            if (type == VERTICAL)
                currentRow += 1;
            String lineEnd = (type == HORIZONTAL) ? indent(lastRowNumber.apply(currentRow), maxLength) : "";
            boardString.append(lineEnd).append("\n");

            type = other(type);
        }

        return boardString.toString();
    }

    private static Integer columnsOf(Move.Which lk,Integer cols){
        if((lk== HORIZONTAL)) return cols-1;
        return cols;
    }

    private static Move.Which other(Move.Which lk){
        if(lk==HORIZONTAL) return VERTICAL;
        return HORIZONTAL;
    }

    private static String convertToString(Boolean present, Move.Which type, Integer currNode,Integer maxLength) {
        String nodeString=String.valueOf(currNode);
        String indented=indent(nodeString,maxLength);
        if(present){
            if(type==VERTICAL)  return " ".repeat(maxLength/2)+"| "+ " ".repeat((maxLength+1)/2);
            if(type==HORIZONTAL)return indented+"——";
        }
        if(type==VERTICAL)return " ".repeat(maxLength+2);
        return  indented+"  ";
    }

    private static String indent(String nodeString, Integer maxLength){
        return "0".repeat(maxLength-nodeString.length())+nodeString;
    }

}