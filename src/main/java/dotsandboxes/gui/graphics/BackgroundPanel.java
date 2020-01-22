package dotsandboxes.gui.graphics;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BackgroundPanel extends JPanel {

    private File imageDir;

    public BackgroundPanel(File iD) {
        super();
        imageDir=iD;

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        this.setLayout(null);
        ImageIcon img=new ImageIcon(imageDir.getPath()+"/background.jpg");
        img.paintIcon(this,g,0,0);
    }
}
