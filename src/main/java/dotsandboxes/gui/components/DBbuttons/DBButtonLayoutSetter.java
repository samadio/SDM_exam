package dotsandboxes.gui.components.DBbuttons;

import dotsandboxes.gui.filesAndFont.FontSetter;
import dotsandboxes.gui.components.ObjSpecifics;

import javax.swing.*;

class DBButtonLayoutSetter {

    public static void setLayout(AbstractButton element, ObjSpecifics objSpecifics){
        element.setBorder(null);
        element.setOpaque(false);
        element.setContentAreaFilled(false);
        element.setBorderPainted(false);
        element.setFocusPainted(false);
        element.setFont(FontSetter.setFont());
        element.setVerticalTextPosition(SwingConstants.CENTER);
        element.setHorizontalTextPosition(SwingConstants.CENTER);
        element.setBounds(objSpecifics.getPosition().x, objSpecifics.getPosition().y, objSpecifics.getSize().width, objSpecifics.getSize().height);
    }
    
    public static void setImageFile(AbstractButton element, ImageIcon imageIcon, ObjSpecifics objSpecifics){

        imageIcon=new ImageIcon(imageIcon.getImage().getScaledInstance(objSpecifics.getSize().width,objSpecifics.getSize().height, objSpecifics.getHints()));
        element.setIcon(imageIcon);
    }
}
