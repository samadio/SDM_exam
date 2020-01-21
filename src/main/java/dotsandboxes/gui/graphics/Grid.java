package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.lists.LinesList;

public class Grid {

    private LinesList horizontalLines;
    private LinesList verticalLines;

    public Grid(){}

    public void setGrid(LinesList hl, LinesList vl){
        horizontalLines=hl;
        verticalLines=vl;
    }

    public LinesList getHorizontalLines() { return horizontalLines; }

    public LinesList getVerticalLines() {return verticalLines; }
}
