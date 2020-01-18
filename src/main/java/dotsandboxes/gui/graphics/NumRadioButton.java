package dotsandboxes.gui.graphics;

import javax.swing.*;
import java.awt.*;

public class NumRadioButton extends JRadioButton {

    private final Integer NUMBER;
    private final Rectangle COMPONENT_AREA;

    public NumRadioButton(Integer num, Integer x, Integer y, Integer w, Integer h ){

        super(Integer.toString(num));
        NUMBER = num;
        COMPONENT_AREA = new Rectangle(x, y, w, h);

        setAlignment(JLabel.CENTER);

        this.setBounds(COMPONENT_AREA);

        setStyle();

        setTextPosition(SwingConstants.CENTER);

        ImageIcon radio_on = new ImageIcon(new ImageIcon("images/woodTableDark.png").getImage().getScaledInstance((int) COMPONENT_AREA.getWidth(),
                (int) COMPONENT_AREA.getHeight(),
                80));
        this.setSelectedIcon(radio_on);
    }

    private void setAlignment(Integer alignment){

        this.setHorizontalAlignment(alignment);
        this.setVerticalAlignment(alignment);
    }

    private void setStyle(){

        //this.setOpaque(false);
        this.setContentAreaFilled(false);
        //this.setBorderPainted(false);
        this.setFocusPainted(false);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/woodTable.png").getImage().getScaledInstance((int) COMPONENT_AREA.getWidth(),
                (int) COMPONENT_AREA.getHeight(),
                80));
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
