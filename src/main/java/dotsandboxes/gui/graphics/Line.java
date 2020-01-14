package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;

public class Line extends GraphicObj {

    private Integer row;
    private Integer column;
    private String darkLineFile;

    public Line(ObjSpecifics oS, Integer r, Integer c) {
        super(oS);
        row=r;
        column=c;

    }


    public Integer getRow() {return this.row;}

    public Integer getColumn() { return column;}

    //public String newFileName() {return objSpec.fileName2;}

    public Integer getLineW() {return objSpec.width;}

    public Integer getLineH() {return objSpec.height;}

    public Integer getLineHints() {return objSpec.hints;}

    public void setDark(){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(objSpec.fileName2).getImage().getScaledInstance(objSpec.width, objSpec.height, objSpec.hints));
        this.setIcon(imageIcon);
    }

}
