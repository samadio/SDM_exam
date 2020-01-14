package dotsandboxes.gui.graphics;

import dotsandboxes.gui.frames.gameFrameFunctions.SetElementsInGrid;
import dotsandboxes.gui.graphics.lists.LinesList;

public class Grid {

    public LinesList horizontalLines;
    public LinesList verticalLines;

    public Grid(){}

    public void setGrid(LinesList hl, LinesList vl){
        horizontalLines=hl;
        verticalLines=vl;
    }
}
