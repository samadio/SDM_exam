package dotsandboxes.gui.components.DBbuttons;

import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.components.ObjSpecifics;


public class Dot extends DBButton {

    public Dot(ObjSpecifics objSpecifics) {
        super(objSpecifics);
        image= FileManager.getDotIcon();
        DBButtonLayoutSetter.setImageFile(this,image,SPECIFICS);
    }

}




