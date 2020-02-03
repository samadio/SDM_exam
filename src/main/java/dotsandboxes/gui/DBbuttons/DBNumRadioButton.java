package dotsandboxes.gui.DBbuttons;

import dotsandboxes.gui.filesAndFont.FileManager;
import dotsandboxes.gui.graphics.ObjSpecifics;

import javax.swing.*;

public class DBNumRadioButton extends JRadioButton {

    private final ObjSpecifics SPECIFICS;
    private  ImageIcon image;
    private ImageIcon image_2;
    private final Integer NUMBER;


    public DBNumRadioButton( Integer num, ObjSpecifics objSpecifics){

        super(Integer.toString(num));
        image=FileManager.getWoodIcon();
        image_2=FileManager.getWoodDarkIcon();
        SPECIFICS=objSpecifics;
        NUMBER = num;

        setAlignment(JLabel.CENTER);
        DBButtonLayoutSetter.setLayout(this,SPECIFICS);
        DBButtonLayoutSetter.setImageFile(this,image,SPECIFICS);

        image_2=new ImageIcon(image_2.getImage().getScaledInstance(getWidth(), getHeight(), objSpecifics.getHints()));
        this.setSelectedIcon(image_2);
    }

    private void setAlignment(Integer alignment){

        this.setHorizontalAlignment(alignment);
        this.setVerticalAlignment(alignment);
    }

    public Integer getNumber() {
        return NUMBER;
    }
}
