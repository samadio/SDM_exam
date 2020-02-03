package dotsandboxes.gui.DBbuttons;
import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.graphics.ObjSpecifics;

public class HorizontalLine extends Line {


    public  HorizontalLine(ObjSpecifics oS, Integer r, Integer c) {
        super(oS,r,c);
        image = FileManager.getHorizontalEmptyIcon();
        image2 = FileManager.getHorizontalFullIcon();
        DBButtonLayoutSetter.setImageFile(this,image,SPECIFICS);
    }
}
