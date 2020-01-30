package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;


public class Dot extends DBButton {

    public Dot(ObjSpecifics objSpecifics) {
        super(objSpecifics);
        image= FileManager.getDotIcon();
        DBLayoutSetter.setImageFile(this,image,SPECIFICS);
    }

}




