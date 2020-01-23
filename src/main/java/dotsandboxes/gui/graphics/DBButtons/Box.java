package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.specifics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public class Box extends JButton {

    private final File IMAGE;
    private final ObjSpecifics SPECIFICS;

    public Box(ObjSpecifics objSpecifics) {
        super();
        IMAGE= FileManager.getBoxFile();
        SPECIFICS=objSpecifics;
        DBLayoutSetter.setLayout(this,SPECIFICS);
        DBLayoutSetter.setImageFile(this,IMAGE,SPECIFICS);

    }

}
