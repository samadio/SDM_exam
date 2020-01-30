package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.DBButtons.DBButton;
import dotsandboxes.gui.graphics.lists.DBButtonList;

public class Grid {

    private DBButtonList horizontalLines;
    private DBButtonList verticalLines;
    private DBButtonList boxes;

    public Grid(){}

    public void setGrid(DBButtonList hl, DBButtonList vl){
        horizontalLines=hl;
        verticalLines=vl;
    }

    public void setBoxes(DBButtonList bx){boxes=bx;}

    public DBButtonList getHorizontalLines() { return horizontalLines; }
    public DBButtonList getVerticalLines() {return verticalLines; }
    public DBButtonList getBoxes() {return boxes;}
}
