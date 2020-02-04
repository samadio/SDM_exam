package dotsandboxes.gui.components.DBbuttons;

import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.components.ObjSpecifics;


public class DBTextButton extends DBButton {


    public DBTextButton(String t, ObjSpecifics objSpecifics){

        super(objSpecifics);
        image= FileManager.getWoodIcon();
        image2=FileManager.getWoodDarkIcon();
        setText(t);
        DBButtonLayoutSetter.setImageFile(this,image,SPECIFICS);
    }

}
