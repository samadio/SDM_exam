package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;
import java.io.File;

public class DBTextButton extends JButton {

    private final File IMAGE_DIR;

    public DBTextButton(File imgDir, String t, ObjSpecifics objSpecifics){

        super();
        IMAGE_DIR=imgDir;
        setText(t);
        setLocation(objSpecifics.getPosition());
        setSize(objSpecifics.getSize().width,objSpecifics.getSize().height);


        setAlignment(JLabel.CENTER);

        this.setBounds(getX(), getY(), getWidth(), getHeight());

        setStyle();

        setTextPosition(SwingConstants.CENTER);
    }

    public void setDark() {
        ImageIcon darkIcon = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTableDark.png").getImage().getScaledInstance(getWidth(), getHeight(), 80));
        this.setIcon(darkIcon);
    }

    private void setAlignment(Integer alignment){

        this.setHorizontalAlignment(alignment);
        this.setVerticalAlignment(alignment);
    }
    private void setStyle() {

        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setFont(FontSetter.setFont());
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTable.png").getImage().getScaledInstance(getWidth(), getHeight(), 80));
        this.setIcon(imageIcon);
    }
    private void setTextPosition(Integer position) {

        this.setVerticalTextPosition(position);
        this.setHorizontalTextPosition(position);
    }
}
