package dotsandboxes.io;

import gamesuite.move.Move;

public class Converter {

    private final Integer COLS;

    public Converter(Integer nCols){
        this.COLS = nCols;
    }


    public  Move convert(InputMove im){
        return new Move(toWhichLine(im),toBoardRowIndex(im),toBoardColIndex(im));
    }


    private Move.Orientation toWhichLine(InputMove m){
        if (m.getDirection() == InputMove.Direction.LEFT || m.getDirection()==InputMove.Direction.RIGHT)
            return Move.Orientation.HORIZONTAL;
        else
            return Move.Orientation.VERTICAL;
    }

    private  Integer  toBoardRowIndex(InputMove m) {
        if(m.getDirection() == InputMove.Direction.UP)
            return (m.getNode() / COLS) - 1;
        else
            return m.getNode() / COLS;
    }

    private  Integer  toBoardColIndex(InputMove m) {
        if(m.getDirection() == InputMove.Direction.LEFT)
            return (m.getNode() % COLS) - 1;
        else
            return m.getNode() % COLS;
    }
}
