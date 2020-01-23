package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;

public class Box extends JButton {

    public Box(ObjSpecifics objSpecifics) {
        super();
        this.setBorder(null);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setBounds(objSpecifics.getPosition().x,objSpecifics.getPosition().y,objSpecifics.getSize().width,objSpecifics.getSize().height);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/box.png").getImage().getScaledInstance(objSpecifics.getSize().width, objSpecifics.getSize().width, objSpecifics.getHints()));
        this.setIcon(imageIcon);
    }

}
