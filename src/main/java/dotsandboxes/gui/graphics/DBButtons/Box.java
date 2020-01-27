package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;


public class Box extends DBButton {


    public Box(ObjSpecifics objSpecifics) {
        super(objSpecifics);
        image= FileManager.getBoxFile();
        DBLayoutSetter.setImageFile(this,image,SPECIFICS);
    }

}
