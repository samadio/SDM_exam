package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.specifics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DBNumButton extends JButton {
    final private File IMAGE;
    final private File IMAGE_2;
    final private Integer NUMBER;
    final private ObjSpecifics SPECIFICS;


    public DBNumButton(Integer num, ObjSpecifics objSpecifics){
        super(Integer.toString(num));
        IMAGE= FileManager.getWood();
        IMAGE_2=FileManager.getWoodDark();
        NUMBER=num;
        SPECIFICS=objSpecifics;

        DBLayoutSetter.setLayout(this,SPECIFICS);
        DBLayoutSetter.setImageFile(this,IMAGE,SPECIFICS);

    }

    public void setDark() {
        DBLayoutSetter.setImageFile(this,IMAGE_2,SPECIFICS);
    }

    public Integer getNumber() {return NUMBER;}
}
