package dotsandboxes.gui.DBbuttons;

import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.graphics.ObjSpecifics;


public class Dot extends DBButton {

    public Dot(ObjSpecifics objSpecifics) {
        super(objSpecifics);
        image= FileManager.getDotIcon();
        DBButtonLayoutSetter.setImageFile(this,image,SPECIFICS);
    }

}




