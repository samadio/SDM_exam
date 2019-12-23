package dotsandboxes;

import gamesuite.board.Board;
import gamesuite.move.Move;

public class Converter {
    private Move.Which whichLine;
    private Integer rowIndex;
    private Integer columnIndex;


    

    public static Move converter(InputMove im, Integer rows){
        return new Move(toWhichLine(im),toBoardRowIndex(im,rows),toBoardColIndex(im,rows));
    }


    public static Move.Which toWhichLine(InputMove m){
        if (m.getDirection()== InputMove.Direction.LEFT || m.getDirection()==InputMove.Direction.RIGHT)
            return Move.Which.HORIZONTAL;
        else
            return Move.Which.VERTICAL;
    }

    public static Integer  toBoardRowIndex(InputMove m, Integer rows) {
        if(m.getDirection()== InputMove.Direction.UP)
            return m.getNode()/rows-1;
        else
            return m.getNode()/rows;
    }

    public static Integer  toBoardColIndex(InputMove m, Integer rows) {
        if(m.getDirection()== InputMove.Direction.LEFT)
            return m.getNode()%rows -1;
        else
            return m.getNode()%rows;
    }
}
