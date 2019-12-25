package dotsandboxes;

import gamesuite.board.Board;
import gamesuite.move.Move;

public class Converter {

    private final Integer COLS;

    public Converter(Integer nRows){

        this.COLS = nRows;
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
            return m.getNode()/COLS-1;
        else
            return m.getNode()/COLS;
    }

    private  Integer  toBoardColIndex(InputMove m) {
        if(m.getDirection()== InputMove.Direction.LEFT)
            return m.getNode()%COLS -1;
        else
            return m.getNode()%COLS;
    }
}
