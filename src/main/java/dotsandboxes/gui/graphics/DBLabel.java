package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;


public class DBLabel extends JLabel {
    private String text;
    private final File IMAGE;

    public DBLabel(String t, ObjSpecifics objSpecifics) {
        super();
        IMAGE= FileManager.getWoodFile();
        setLabelProperties(t,objSpecifics);
    }

    public DBLabel(){
        super();
        IMAGE=FileManager.getWoodFile();;
    }


    public void setLabelProperties(String t, ObjSpecifics objSpecifics){
        text=t;
        this.setText(text);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBounds(objSpecifics.getPosition().x, objSpecifics.getPosition().y, objSpecifics.getSize().width, objSpecifics.getSize().height);
        this.setFont(FontSetter.setFont());
        this.setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(IMAGE.getPath()).getImage().getScaledInstance(objSpecifics.getSize().width,objSpecifics.getSize().height, objSpecifics.getHints()));
        this.setIcon(imageIcon);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }
}
