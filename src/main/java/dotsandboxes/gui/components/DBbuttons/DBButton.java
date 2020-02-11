package dotsandboxes.gui.components.DBbuttons;

import dotsandboxes.gui.components.ObjSpecifics;

import javax.swing.*;

public abstract class DBButton extends JButton {

    protected ImageIcon image;
    protected ImageIcon image2;
    protected final ObjSpecifics SPECIFICS;

    DBButton(ObjSpecifics objSpecifics){

        SPECIFICS=objSpecifics;
        DBButtonLayoutSetter.setLayout(this,SPECIFICS);

    }

    public void setDark() {
        DBButtonLayoutSetter.setImageFile(this,image2,SPECIFICS);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
