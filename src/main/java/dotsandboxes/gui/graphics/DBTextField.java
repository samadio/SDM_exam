package dotsandboxes.gui.graphics;

import dotsandboxes.gui.filesAndFont.FontSetter;

import javax.swing.*;

public class DBTextField extends JTextField {

    public DBTextField(Integer cols, ObjSpecifics objSpecifics){
        super(cols);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBounds(objSpecifics.getPosition().x, objSpecifics.getPosition().y, objSpecifics.getSize().width, objSpecifics.getSize().height);
        this.setFont(FontSetter.setFont());
    }
}
