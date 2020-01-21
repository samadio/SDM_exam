package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;

public class GridGraphicalObject extends JButton {
    protected ObjSpecifics objSpec;


    public GridGraphicalObject(ObjSpecifics os) {
        super();
        objSpec=os;
        this.setBorder(null);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(objSpec.getFileName()).getImage().getScaledInstance(objSpec.getWidth(), objSpec.getHeight(), objSpec.getHints()));
        this.setIcon(imageIcon);


    }

    public void setButtonProperties(int x, int y, int w, int h)  {this.setBounds(x,y,w,h);}

}




