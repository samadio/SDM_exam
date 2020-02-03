package dotsandboxes.gui.DBlabels;

import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.filesAndFont.FontSetter;
import dotsandboxes.gui.graphics.ObjSpecifics;

import javax.swing.*;


public class DBLabel extends JLabel {
    private String text;
    private ImageIcon image;

    public DBLabel(String t, ObjSpecifics objSpecifics) {
        image= FileManager.getWoodIcon();
        setLabelProperties(t,objSpecifics);
    }

    public DBLabel(){
        super();
        image=FileManager.getWoodIcon();
    }


    public void setLabelProperties(String t, ObjSpecifics objSpecifics){
        text=t;
        this.setText(text);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBounds(objSpecifics.getPosition().x, objSpecifics.getPosition().y, objSpecifics.getSize().width, objSpecifics.getSize().height);
        this.setFont(FontSetter.setFont());
        this.setOpaque(false);
        image = new ImageIcon(image.getImage().getScaledInstance(objSpecifics.getSize().width,objSpecifics.getSize().height, objSpecifics.getHints()));
        this.setIcon(image);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }
}
