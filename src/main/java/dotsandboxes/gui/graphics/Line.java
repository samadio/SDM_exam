package dotsandboxes.gui.graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Line extends GraphicObj {

    private Integer row;
    private Integer column;

    public Line(ObjSpecifics os, Integer r, Integer c) {
        super(os);
        row=r;
        column=c;

    }


    public Integer getRow() {return this.row;}

    public Integer getColumn() { return column;}

    public String newFileName() {return objSpec.fileName2;}

    public Integer getLineW() {return objSpec.width;}

    public Integer getLineH() {return objSpec.height;}

    public Integer getLineHints() {return objSpec.hints;}

}
