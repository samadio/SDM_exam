package dotsandboxes.gui.graphics.DBButtons;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;


public abstract class Line extends DBButton {

    private Integer row;
    private Integer column;

    public Line(ObjSpecifics oS, Integer r, Integer c) {
        super(oS);
        row=r;
        column=c;
    }


    public Integer getRow() {return this.row;}

    public Integer getColumn() { return column;}

}
