package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public class DBNumRadioButton extends JRadioButton {

    private final ObjSpecifics SPECIFICS;
    private final File IMAGE;
    private final File IMAGE_2;
    private final Integer NUMBER;


    public DBNumRadioButton( Integer num, ObjSpecifics objSpecifics){

        super(Integer.toString(num));
        IMAGE=FileManager.getWoodFile();
        IMAGE_2=FileManager.getWoodDarkFile();
        SPECIFICS=objSpecifics;
        NUMBER = num;

        setAlignment(JLabel.CENTER);
        DBLayoutSetter.setLayout(this,SPECIFICS);
        DBLayoutSetter.setImageFile(this,IMAGE,SPECIFICS);

        ImageIcon radio_on = new ImageIcon(new ImageIcon(IMAGE_2.getPath()).getImage().getScaledInstance(getWidth(), getHeight(), objSpecifics.getHints()));
        this.setSelectedIcon(radio_on);
    }

    private void setAlignment(Integer alignment){

        this.setHorizontalAlignment(alignment);
        this.setVerticalAlignment(alignment);
    }

    public Integer getNumber() {
        return NUMBER;
    }
}
