package dotsandboxes.gui.components.DBbuttons;

import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.components.ObjSpecifics;


public class Box extends DBButton {


    public Box(ObjSpecifics oS) {
        super(oS);
        image2= FileManager.getBoxIcon();
    }
}
