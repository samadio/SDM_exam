package dotsandboxes.io;

import gamesuite.board.BoardHandle;
import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;
import gamesuite.players.Player;
import iomanagement.OutputManager;

import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import static gamesuite.move.Move.Orientation.HORIZONTAL;
import static gamesuite.move.Move.Orientation.VERTICAL;

public class DotsAndBoxesOutput implements OutputManager {


    @Override
    public void startMatch(Game game) {
        outputMessage("A move is encoded as [Number] [Direction]\n To connect nodes 11 12 please write '11 R' or '12 L'. Same for U (up) and D(down)");
    }

    @Override
    public void initialMessage(){
        outputMessage(" Welcome to our Dots And Boxes: for an overview of the rules please consult\n" +
                " https://en.wikipedia.org/wiki/Dots_and_Boxes\n" +
                "\n" +
                "PLAYER NAMES:\n" +
                "Default player names are integer numbers.\n" +
                "Custom names can be chosen with the following rules:\n" +
                "  -You are not allowed to choose an integer number as name.\n" +
                "  -Repeated occurrences of the same name are not permitted.\n" +
                "  -If no custom name is given, you will be assigned an increasing integer number.");
    }

    @Override
    public void printGame(Game game) {
        outputMessage("\n");
        printBoard(game.getBoard());
        outputMessage("\n Players score:");
        for (Player p : game.getPlayers()) {
            outputPrint(p.getName() + ": ");
            outputPrint(game.getScore().get(p) + "        ");
        }
        outputMessage("\n");
        printCurrentPlayer(game);
        outputMessage("\n");
    }

    private void printCurrentPlayer(Game game) { outputMessage("Player " + game.nextPlayer() + " its your turn!"); }

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

    private void printBoard(BoardHandle board) {
        outputMessage(BoardDrawer.boardToString(board));
    }

}

class BoardDrawer{

    static String boardToString(BoardHandle board) {
        Integer rows = board.getRows();
        Integer columns = board.getColumns();

        //maximum number of digits needed
        int maxLength = String.valueOf(rows * columns - 1).length();

        IntFunction<String> lastRowNumber = row -> String.valueOf(row * columns + columns - 1);

        StringBuilder boardString = new StringBuilder();

        rowToString(0, HORIZONTAL, maxLength, board, boardString);
        boardString.append(indent(lastRowNumber.apply(0), maxLength)).append("\n");

        for(int currentRow = 1; currentRow < rows; currentRow++){

            rowToString(currentRow - 1, VERTICAL, maxLength, board, boardString);
            boardString.append("\n");
            rowToString(currentRow , HORIZONTAL, maxLength, board, boardString);
            boardString.append(indent(lastRowNumber.apply(currentRow), maxLength)).append("\n");
        }

        return boardString.toString();
    }

    private static void rowToString(final int rowIdx, final Move.Orientation type, final int maxLength, final BoardHandle board, StringBuilder outputString){

        IntUnaryOperator currentNode = columnIdx -> rowIdx * board.getColumns() + columnIdx;
        IntFunction<Boolean> isPresent = columnIdx -> board.getElement(type, rowIdx, columnIdx);

        IntFunction<String> toString = columnIdx -> convertToString(isPresent.apply(columnIdx), type, currentNode.applyAsInt(columnIdx), maxLength);
        IntStream.range(0, columnsOf(type, board.getColumns()))
                .forEach(columnIdx -> outputString.append(toString.apply(columnIdx)));

    }

    private static Integer columnsOf(Move.Orientation lk, Integer cols){
        if((lk == HORIZONTAL)) return cols - 1;
        return cols;
    }

    private static Move.Orientation other(Move.Orientation lk){
        if(lk == HORIZONTAL) return VERTICAL;
        return HORIZONTAL;
    }

    private static String convertToString(Boolean present, Move.Orientation type, Integer currNode, Integer maxLength) {
        String nodeString = String.valueOf(currNode);
        String indented = indent(nodeString,maxLength);
        if(present){
            if(type == VERTICAL)  return " ".repeat( maxLength / 2 ) + "| " +  " ".repeat((maxLength + 1) / 2);
            if(type == HORIZONTAL) return indented + "——";
        }
        if(type == VERTICAL) return " ".repeat(maxLength + 2);
        return  indented + "  ";
    }

    private static String indent(String nodeString, Integer maxLength){
        return "0".repeat(maxLength - nodeString.length()) + nodeString;
    }

}