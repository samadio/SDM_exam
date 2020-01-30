package dotsandboxes.gui.graphics.DBButtons;

import dotsandboxes.gui.graphics.graficalFunctions.DBLayoutSetter;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public abstract class DBButton extends JButton {

    protected ImageIcon image;
    protected ImageIcon image2;
    protected final ObjSpecifics SPECIFICS;

    public DBButton(){
        SPECIFICS=null;
    }

    DBButton(ObjSpecifics objSpecifics){

        SPECIFICS=objSpecifics;
        DBLayoutSetter.setLayout(this,SPECIFICS);

    }

    public void setDark() {
        DBLayoutSetter.setImageFile(this,image2,SPECIFICS);
    }
}
