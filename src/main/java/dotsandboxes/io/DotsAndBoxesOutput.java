package dotsandboxes.io;

import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;
import gamesuite.players.Player;
import iomanagement.OutputManager;

import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import static gamesuite.move.Move.Which.HORIZONTAL;
import static gamesuite.move.Move.Which.VERTICAL;

public class DotsAndBoxesOutput implements OutputManager {


    @Override
    public void startMatch(Game game) {
        outputMessage("Start Game");
    }

    @Override
    public void printGame(Game game) {
        outputMessage("\n");
        printBoard(game.getBoard());
        outputMessage("\n Players score:");
        for (Player i : game.getPlayers()) {
            outputPrint(i.getName() + ": ");
            outputPrint(game.getScore().get(i) + "        ");
        }
        outputMessage("\n");
        printCurrentPlayer(game);
        outputMessage("\n");

    }

    private void printCurrentPlayer(Game game) { outputMessage("Next player: " + game.nextPlayer()); }

    @Override
    public void printInvalidMove(InvalidMoveException e) { errorMessage(e.getMessage());}

    @Override
    public void outputMessage(String message) {
        System.out.println(message);
    }

    private void outputPrint(String s) {
        System.out.print(s);
    }

    @Override
    public void errorMessage(String s) {
        System.err.println(s);
    }


    @Override
    public void resetMatch(Game game) {
        outputMessage("The game has been reset...");
    }


    @Override
    public void printWinner(Game game) {

        List<Player> winners = game.getWinner();

        if (winners.size() == 1)
            outputMessage("The winner is " + winners.get(0));
        else {
            outputMessage("Game is a draw, the following players have the same score:");
            for (Player p : winners)
                outputMessage(p.toString());
        }
    }

    private void printBoard(AbstractBoard board) {
        outputMessage(BoardDrawer.boardToString(board));
    }

}

class BoardDrawer{

    static String boardToString(AbstractBoard board) {
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