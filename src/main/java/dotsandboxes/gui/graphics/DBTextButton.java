package dotsandboxes.gui.graphics;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DBTextButton extends JButton {

    private final File IMAGE_DIR;

    public DBTextButton(File imgDir, String t, Point position, Rectangle size ){

        super();
        IMAGE_DIR=imgDir;
        setText(t);
        setLocation(position);
        setSize(size.width,size.height);


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
