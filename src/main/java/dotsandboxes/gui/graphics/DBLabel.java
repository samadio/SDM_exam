package dotsandboxes.gui.graphics;

import javax.swing.*;

public class DBLabel extends JLabel {
    String text;
    Integer x_position;
    Integer y_position;
    Integer width;
    Integer height;

    public DBLabel(String t, Integer x, Integer y, Integer w, Integer h ){
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
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/woodTable.png").getImage().getScaledInstance(w,h, 80));
        this.setIcon(imageIcon);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    public DBLabel(){
        super();
    }

    public void setLabelProperties(String t, Integer x, Integer y, Integer w, Integer h ){
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
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/woodTable.png").getImage().getScaledInstance(w,h, 80));
        this.setIcon(imageIcon);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }
}
