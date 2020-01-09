package dotsandboxes.gui.graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicObj extends JButton {
    protected ObjSpecifics objSpec;


    public GraphicObj(ObjSpecifics os) {
        super();
        objSpec=os;
        this.setBorder(null);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(objSpec.fileName).getImage().getScaledInstance(objSpec.width, objSpec.height, objSpec.hints));
        this.setIcon(imageIcon);


    }

    public void setButtonProperties(int x, int y, int w, int h){this.setBounds(x,y,w,h);}



}




