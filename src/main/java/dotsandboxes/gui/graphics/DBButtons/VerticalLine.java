package dotsandboxes.gui.graphics.DBButtons;
import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.specifics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

public class VerticalLine extends Line {


    public  VerticalLine(ObjSpecifics oS, Integer r, Integer c) {
        super(oS,r,c);
        image = FileManager.getVerticalLineEmptyFile();
        image2 = FileManager.getVerticalLineFullFile();
        DBLayoutSetter.setImageFile(this,image,SPECIFICS);
    }
}
