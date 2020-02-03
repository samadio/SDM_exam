package dotsandboxes.gui.DBbuttons.board;

import java.awt.*;

class BoardButtonSpecifics {


    private final Rectangle ELEMENT_SIZE;
    private final Point GRID_OFFSETS;
    private final Integer HINTS;
    private final Integer ROWS;
    private final Integer COLS;
    private final Integer DIST;
    private final BoardSettings.ElementType TYPE;

    public BoardButtonSpecifics(BoardSettings.ElementType type, Integer r, Integer c, Rectangle elementSize, Point gridOffsets, Integer d, Integer hi){

        TYPE=type;
        ELEMENT_SIZE = elementSize;
        GRID_OFFSETS= gridOffsets;
        HINTS=hi;
        ROWS=r;
        COLS=c;
        DIST=d;

    }

    public BoardSettings.ElementType getType() {return TYPE;}

    public Integer getRows() {
        return ROWS;
    }

    public Integer getCols() {
        return COLS;
    }

    public Rectangle getElementSize() {
        return ELEMENT_SIZE;
    }

    public Point getOffset() {
        return GRID_OFFSETS;
    }


    public Integer getDist() {
        return DIST;
    }

    public Integer getHints() {
        return HINTS;
    }
}
