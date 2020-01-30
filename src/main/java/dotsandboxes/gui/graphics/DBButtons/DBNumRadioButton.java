package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public class DBNumRadioButton extends JRadioButton {

    private final ObjSpecifics SPECIFICS;
    private  ImageIcon image;
    private ImageIcon image_2;
    private final Integer NUMBER;


    public DBNumRadioButton( Integer num, ObjSpecifics objSpecifics){

        super(Integer.toString(num));
        image=FileManager.getWoodIcon();
        image_2=FileManager.getWoodDarkIcon();
        SPECIFICS=objSpecifics;
        NUMBER = num;

        setAlignment(JLabel.CENTER);
        DBLayoutSetter.setLayout(this,SPECIFICS);
        DBLayoutSetter.setImageFile(this,image,SPECIFICS);

        image_2=new ImageIcon(image_2.getImage().getScaledInstance(getWidth(), getHeight(), objSpecifics.getHints()));
        this.setSelectedIcon(image_2);
    }

    private void setAlignment(Integer alignment){

        this.setHorizontalAlignment(alignment);
        this.setVerticalAlignment(alignment);
    }

    public Integer getNumber() {
        return NUMBER;
    }
}
