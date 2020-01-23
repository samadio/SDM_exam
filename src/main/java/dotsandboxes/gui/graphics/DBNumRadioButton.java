package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public class DBNumRadioButton extends JRadioButton {

    private final Integer NUMBER;
    private final File IMAGE_DIR;

    public DBNumRadioButton(File imgDir, Integer num, ObjSpecifics objSpecifics){

        super(Integer.toString(num));
        IMAGE_DIR=imgDir;
        NUMBER = num;
        setLocation(objSpecifics.getPosition());
        setSize(objSpecifics.getSize().width,objSpecifics.getSize().height);

        setAlignment(JLabel.CENTER);

        this.setBounds(getX(),getY(),getWidth(),getHeight());

        setStyle();

        setTextPosition(SwingConstants.CENTER);

        ImageIcon radio_on = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTableDark.png").getImage().getScaledInstance(getWidth(), getHeight(), objSpecifics.getHints()));
        this.setSelectedIcon(radio_on);
    }

    private void setAlignment(Integer alignment){

        this.setHorizontalAlignment(alignment);
        this.setVerticalAlignment(alignment);
    }

    private void setStyle(){
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setFont(FontSetter.setFont());
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTable.png").getImage().getScaledInstance(getWidth(), getHeight(), 80));
        this.setIcon(imageIcon);
    }

    private void setTextPosition(Integer position){

        this.setVerticalTextPosition(position);
        this.setHorizontalTextPosition(position);
    }

    public Integer getNumber() {
        return NUMBER;
    }
}
