package dotsandboxes.gui.DBbuttons;

import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.graphics.ObjSpecifics;


public class Box extends DBButton {


    public Box(ObjSpecifics oS) {
        super(oS);
        image2= FileManager.getBoxIcon();
    }
}
