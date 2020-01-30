package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.DBButtons.DBButton;
import dotsandboxes.gui.graphics.lists.DBButtonList;
import dotsandboxes.gui.graphics.lists.LinesList;

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
