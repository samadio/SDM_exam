package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;

public class VerticalLine extends Line {

    public  VerticalLine(ObjSpecifics oS, Integer r, Integer c) {
        super(oS,r,c);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/vertical_empty.png").getImage().getScaledInstance(objSpecifics.getSize().width, objSpecifics.getSize().height, objSpecifics.getHints()));
        this.setIcon(imageIcon);

    }

    @Override
    public void setDark(){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/vertical_full.png").getImage().getScaledInstance(objSpecifics.getSize().width, objSpecifics.getSize().height, objSpecifics.getHints()));
        this.setIcon(imageIcon);
    }
}
