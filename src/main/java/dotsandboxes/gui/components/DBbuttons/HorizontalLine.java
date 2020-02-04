package dotsandboxes.gui.components.DBbuttons;
import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.components.ObjSpecifics;

public class HorizontalLine extends Line {


    public  HorizontalLine(ObjSpecifics oS, Integer r, Integer c) {
        super(oS,r,c);
        image = FileManager.getHorizontalEmptyIcon();
        image2 = FileManager.getHorizontalFullIcon();
        DBButtonLayoutSetter.setImageFile(this,image,SPECIFICS);
    }
}
