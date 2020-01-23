package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;


public class DBTextButton extends DBButton {


    public DBTextButton(String t, ObjSpecifics objSpecifics){

        super(objSpecifics);
        image= FileManager.getWoodFile();
        image2=FileManager.getWoodDarkFile();
        setText(t);
        DBLayoutSetter.setImageFile(this,image,SPECIFICS);
    }

}
