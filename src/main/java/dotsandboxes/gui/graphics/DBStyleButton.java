package dotsandboxes.gui.graphics;

import javax.swing.*;
import java.awt.*;

public class DBStyleButton extends JButton {

    public DBStyleButton(String text, Icon image, Point position, Rectangle size){
        super(text, image);
        setProperties();
        this.setBounds((int) position.getX(), (int) position.getY(), (int) size.getWidth(), (int) size.getHeight());
    }

    private void setProperties(){

        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setFont(FontSetter.setFont());
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }

}
