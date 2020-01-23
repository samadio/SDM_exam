package dotsandboxes.gui.graphics.graficalFunctions;

import dotsandboxes.gui.graphics.FontSetter;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public class DBLayoutSetter {

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
    
    public static void setImageFile(AbstractButton element, File imageFile, ObjSpecifics objSpecifics){

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageFile.getPath()).getImage().getScaledInstance(objSpecifics.getSize().width,objSpecifics.getSize().height, objSpecifics.getHints()));
        element.setIcon(imageIcon);
    }
}
