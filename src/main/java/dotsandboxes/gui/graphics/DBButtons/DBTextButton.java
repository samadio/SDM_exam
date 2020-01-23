package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.specifics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;


public class DBTextButton extends DBButton {


    public DBTextButton(String t, ObjSpecifics objSpecifics){

        super(objSpecifics);
        image= FileManager.getWood();
        image2=FileManager.getWoodDark();
        setText(t);
        DBLayoutSetter.setImageFile(this,image,SPECIFICS);
    }

}
