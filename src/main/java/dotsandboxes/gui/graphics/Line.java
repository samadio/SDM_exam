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

    public Integer getLineW() {return objSpec.getWidth();}

    public Integer getLineH() {return objSpec.getHeight();}

    public Integer getLineHints() {return objSpec.getHints();}

    public void setDark(){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(objSpec.getFileName2()).getImage().getScaledInstance(objSpec.getWidth(), objSpec.getHeight(), objSpec.getHints()));
        this.setIcon(imageIcon);
    }

}
