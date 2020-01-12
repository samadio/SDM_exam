package dotsandboxes.gui.graphics;

import javax.swing.*;

public class DBButton extends JButton {
    String text;
    Integer x_position;
    Integer y_position;
    Integer width;
    Integer height;

    public DBButton(String t, Integer x, Integer y, Integer w, Integer h ){
        super();
        text=t;
        x_position=x;
        y_position=y;
        width=w;
        height=h;
        this.setText(text);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBounds(x_position, y_position, width, height);


        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/woodTable.jpg").getImage().getScaledInstance(w,h, 80));
        this.setIcon(imageIcon);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }
}
