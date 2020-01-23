package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;

public class Dot extends JButton {


    public Dot(ObjSpecifics objSpecifics) {
        super();
        this.setBorder(null);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(objSpecifics.getFileName()).getImage().getScaledInstance(objSpecifics.getWidth(), objSpecifics.getHeight(), objSpecifics.getHints()));
        this.setIcon(imageIcon);


    }

    public void setButtonProperties(int x, int y, int w, int h)  {this.setBounds(x,y,w,h);}

}




