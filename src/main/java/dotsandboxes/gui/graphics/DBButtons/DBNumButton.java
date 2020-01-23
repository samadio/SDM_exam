package dotsandboxes.gui.graphics.DBButtons;
import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.FileManager;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;


public class DBNumButton extends DBButton {

    private final Integer NUMBER;

    public DBNumButton(Integer num, ObjSpecifics objSpecifics){
        super(objSpecifics);
        image= FileManager.getWoodFile();
        image2=FileManager.getWoodDarkFile();
        NUMBER=num;
        setText(Integer.toString(num));

        DBLayoutSetter.setImageFile(this,image,SPECIFICS);
    }

    public Integer getNumber() {return NUMBER;}
}
