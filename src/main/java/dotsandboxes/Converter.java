package dotsandboxes;

import gamesuite.board.Board;
import gamesuite.move.Move;

public class Converter {

    private final Integer ROWS;

    public Converter(Integer nRows){

        this.ROWS = nRows;
    }


    public  Move convert(InputMove im){
        return new Move(toWhichLine(im),toBoardRowIndex(im),toBoardColIndex(im));
    }


    private  Move.Which toWhichLine(InputMove m){
        if (m.getDirection()== InputMove.Direction.LEFT || m.getDirection()==InputMove.Direction.RIGHT)
            return Move.Which.HORIZONTAL;
        else
            return Move.Which.VERTICAL;
    }

    private  Integer  toBoardRowIndex(InputMove m) {
        if(m.getDirection()== InputMove.Direction.UP)
            return m.getNode()/ROWS-1;
        else
            return m.getNode()/ROWS;
    }

    private  Integer  toBoardColIndex(InputMove m) {
        if(m.getDirection()== InputMove.Direction.LEFT)
            return m.getNode()%ROWS -1;
        else
            return m.getNode()%ROWS;
    }
}
