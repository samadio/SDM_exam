package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.specifics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public class DBTextButton extends JButton {

    private final File IMAGE;
    private final File IMAGE_2;
    private final ObjSpecifics SPECIFICS;

    public DBTextButton(String t, ObjSpecifics objSpecifics){

        super();
        IMAGE= FileManager.getWood();
        IMAGE_2=FileManager.getWoodDark();
        SPECIFICS=objSpecifics;
        setText(t);
        DBLayoutSetter.setLayout(this,SPECIFICS);
        DBLayoutSetter.setImageFile(this,IMAGE,SPECIFICS);

    }

    public void setDark() {
        DBLayoutSetter.setImageFile(this, IMAGE_2,SPECIFICS);
    }
}
