package dotsandboxes.gui.DBbuttons;
import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.graphics.ObjSpecifics;


public class DBNumButton extends DBButton {

    private final Integer NUMBER;

    public DBNumButton(Integer num, ObjSpecifics objSpecifics){
        super(objSpecifics);
        image= FileManager.getWoodIcon();
        image2=FileManager.getWoodDarkIcon();
        NUMBER=num;
        setText(Integer.toString(num));

        DBButtonLayoutSetter.setImageFile(this,image,SPECIFICS);
    }

    public Integer getNumber() {return NUMBER;}
}
