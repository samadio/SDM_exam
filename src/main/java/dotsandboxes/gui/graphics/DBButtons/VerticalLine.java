package dotsandboxes.gui.graphics.DBButtons;
import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

public class VerticalLine extends Line {


    public  VerticalLine(ObjSpecifics oS, Integer r, Integer c) {
        super(oS,r,c);
        image = FileManager.getVerticalLineEmptyIcon();
        image2 = FileManager.getVerticalLineFullIcon();
        DBLayoutSetter.setImageFile(this,image,SPECIFICS);
    }
}
