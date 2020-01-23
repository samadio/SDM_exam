package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;

public class Line extends JButton {

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

    }


    public Integer getRow() {return this.row;}

    public Integer getColumn() { return column;}

    public void setButtonProperties(int x, int y, int w, int h)  {this.setBounds(x,y,w,h);}

    public void setDark(){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(objSpecifics.getFileName2()).getImage().getScaledInstance(objSpecifics.getWidth(), objSpecifics.getHeight(), objSpecifics.getHints()));
        this.setIcon(imageIcon);
    }

}
