package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;

public abstract class Line extends JButton {

    protected ObjSpecifics objSpecifics;
    private Integer row;
    private Integer column;

    public Line(ObjSpecifics oS, Integer r, Integer c) {
        super();
        objSpecifics=oS;
        row=r;
        column=c;
        this.setBorder(null);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setBounds(objSpecifics.getPosition().x,objSpecifics.getPosition().y,objSpecifics.getSize().width,objSpecifics.getSize().height);

    }


    public Integer getRow() {return this.row;}

    public Integer getColumn() { return column;}

    public void setDark(){}

}
