package dotsandboxes.gui.graphics;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BackgroundPanel extends JPanel {

    private final File IMAGE;

    public BackgroundPanel() {
        super();
        IMAGE= FileManager.getBackgroundFile();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        this.setLayout(null);
        ImageIcon img=new ImageIcon(IMAGE.getPath());
        img.paintIcon(this,g,0,0);
    }
}
