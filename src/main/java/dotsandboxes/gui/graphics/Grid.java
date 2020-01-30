package dotsandboxes.gui.graphics;
import dotsandboxes.gui.graphics.lists.DBButtonList;

public class Grid {

    private DBButtonList horizontalLines;
    private DBButtonList verticalLines;
    private DBButtonList boxes;

    public Grid(){}

    public void setHorizontalLines(DBButtonList hl){ horizontalLines=hl;}
    public void setVerticalLines(DBButtonList vl) { verticalLines = vl;}
    public void setBoxes(DBButtonList bx){boxes=bx;}

    public DBButtonList getHorizontalLines() { return horizontalLines; }
    public DBButtonList getVerticalLines() {return verticalLines; }
    public DBButtonList getBoxes() {return boxes;}
}
