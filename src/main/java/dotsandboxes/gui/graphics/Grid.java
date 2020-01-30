package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.lists.DBButtonList;

public class Grid {

    private DBButtonList horizontalLines;
    private DBButtonList verticalLines;

    public Grid(){}

    public void setGrid(DBButtonList hl, DBButtonList vl){
        horizontalLines=hl;
        verticalLines=vl;
    }

    public DBButtonList getHorizontalLines() { return horizontalLines; }

    public DBButtonList getVerticalLines() {return verticalLines; }
}
