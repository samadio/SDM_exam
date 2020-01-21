package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;

public class Line extends GridGraphicalObject {

    private Integer row;
    private Integer column;

    public Line(ObjSpecifics oS, Integer r, Integer c) {
        super(oS);
        row=r;
        column=c;

    }


    public Integer getRow() {return this.row;}

    public Integer getColumn() { return column;}

    public void setDark(){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(objSpec.getFileName2()).getImage().getScaledInstance(objSpec.getWidth(), objSpec.getHeight(), objSpec.getHints()));
        this.setIcon(imageIcon);
    }

}
