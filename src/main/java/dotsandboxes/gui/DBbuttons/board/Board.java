package dotsandboxes.gui.DBbuttons.board;
import dotsandboxes.gui.DBbuttons.DBButtonList;

public class Board {

    private DBButtonList horizontalLines;
    private DBButtonList verticalLines;
    private DBButtonList boxes;

    public Board(){}

    public void setHorizontalLines(DBButtonList hl){ horizontalLines=hl;}
    public void setVerticalLines(DBButtonList vl) { verticalLines = vl;}
    public void setBoxes(DBButtonList bx){boxes=bx;}

    public DBButtonList getHorizontalLines() { return horizontalLines; }
    public DBButtonList getVerticalLines() {return verticalLines; }
    public DBButtonList getBoxes() {return boxes;}
}
