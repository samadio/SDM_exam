package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public abstract class Line extends JButton {

    protected final ObjSpecifics SPECIFICS;
    private Integer row;
    private Integer column;
    protected File image;
    protected File image2;

    public Line(ObjSpecifics oS, Integer r, Integer c) {
        super();
        SPECIFICS=oS;
        row=r;
        column=c;
        DBLayoutSetter.setLayout(this,SPECIFICS);

    }


    public Integer getRow() {return this.row;}

    public Integer getColumn() { return column;}

    public void setDark(){
        DBLayoutSetter.setImageFile(this,image2,SPECIFICS);
    }

}
