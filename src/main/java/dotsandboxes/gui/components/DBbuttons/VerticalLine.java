package dotsandboxes.gui.components.DBbuttons;
import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.components.ObjSpecifics;

public class VerticalLine extends Line {


    public  VerticalLine(ObjSpecifics oS, Integer r, Integer c) {
        super(oS,r,c);
        image = FileManager.getVerticalLineEmptyIcon();
        image2 = FileManager.getVerticalLineFullIcon();
        DBButtonLayoutSetter.setImageFile(this,image,SPECIFICS);
    }
}
