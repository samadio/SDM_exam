package dotsandboxes.gui.DBbuttons;
import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.graphics.ObjSpecifics;

public class VerticalLine extends Line {


    public  VerticalLine(ObjSpecifics oS, Integer r, Integer c) {
        super(oS,r,c);
        image = FileManager.getVerticalLineEmptyIcon();
        image2 = FileManager.getVerticalLineFullIcon();
        DBButtonLayoutSetter.setImageFile(this,image,SPECIFICS);
    }
}
