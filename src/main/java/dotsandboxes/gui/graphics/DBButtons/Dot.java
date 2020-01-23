package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.specifics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public class Dot extends JButton {

    private final File IMAGE;
    private final ObjSpecifics SPECIFICS;

    public Dot(ObjSpecifics objSpecifics) {
        super();
        IMAGE= FileManager.getDotFile();
        SPECIFICS=objSpecifics;
        DBLayoutSetter.setLayout(this,SPECIFICS);
        DBLayoutSetter.setImageFile(this,IMAGE,SPECIFICS);
    }

}




