package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;

public class VerticalLine extends Line {

    public  VerticalLine(ObjSpecifics oS, Integer r, Integer c) {
        super(oS,r,c);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(objSpecifics.getFileName()).getImage().getScaledInstance(objSpecifics.getWidth(), objSpecifics.getHeight(), objSpecifics.getHints()));
        this.setIcon(imageIcon);

    }
}
