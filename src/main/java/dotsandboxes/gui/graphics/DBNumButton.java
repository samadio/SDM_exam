package dotsandboxes.gui.graphics;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DBNumButton extends JButton {
    final private File IMAGE_DIR;
    final private Integer NUMBER;
    final private Point POSITION;
    final private Rectangle SIZE;


    public DBNumButton(File imgDir, Integer num, Point position, Rectangle size){
        super(Integer.toString(num));
        IMAGE_DIR=imgDir;
        NUMBER=num;
        POSITION=position;
        SIZE=size;
        this.setBounds(POSITION.x, POSITION.y, SIZE.width, SIZE.height);




        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setFont(FontSetter.setFont());
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTable.png").getImage().getScaledInstance(SIZE.width,SIZE.height, 80));
        this.setIcon(imageIcon);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);

    }

    public void setDark() {
        ImageIcon darkIcon = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTableDark.png").getImage().getScaledInstance(SIZE.width, SIZE.height, 80));
        this.setIcon(darkIcon);
    }

    public Integer getNumber() {return NUMBER;}
}
