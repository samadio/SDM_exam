package dotsandboxes.gui.graphics;
import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.specifics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

public class HorizontalLine extends Line {



    public  HorizontalLine(ObjSpecifics oS, Integer r, Integer c) {
        super(oS,r,c);
        image = FileManager.getHorizontalEmptyFile();
        image2 = FileManager.getHorizontalFullFile();
        DBLayoutSetter.setImageFile(this,image,SPECIFICS);

    }


}
