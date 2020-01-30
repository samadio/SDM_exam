package dotsandboxes.gui.graphics;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BackgroundPanel extends JPanel {

    private final ImageIcon IMAGE;

    public BackgroundPanel() {
        super();
        IMAGE= FileManager.getBackgroundIcon();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        this.setLayout(null);
        IMAGE.paintIcon(this,g,0,0);
    }
}
