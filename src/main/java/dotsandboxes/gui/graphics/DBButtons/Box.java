package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;


public class Box extends DBButton {


    public Box(ObjSpecifics oS) {
        super(oS);
        image2= FileManager.getBoxIcon();
    }
}
