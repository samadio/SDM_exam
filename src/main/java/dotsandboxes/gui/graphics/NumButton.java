package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.GraphicObj;

import javax.swing.*;

public class NumButton extends JButton {
    public Integer number;
    Integer x_position;
    Integer y_position;
    Integer width;
    Integer height;


    public NumButton(Integer num,Integer x,Integer y, Integer w, Integer h){
        super(Integer.toString(num));
        number=num;
        x_position=x;
        y_position=y;
        width=w;
        height=h;
        this.setBounds(x_position, y_position, width, height);


        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/woodTable.png").getImage().getScaledInstance(w,h, 80));
        this.setIcon(imageIcon);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon darkIcon = new ImageIcon(new ImageIcon("images/woodTableDark.png").getImage().getScaledInstance(width, height, 80));
        this.setSelectedIcon(darkIcon);
    }

    public void setDark() {
        ImageIcon darkIcon = new ImageIcon(new ImageIcon("images/woodTableDark.png").getImage().getScaledInstance(width, height, 80));
        this.setIcon(darkIcon);
        System.out.println("ciojfkslaò");
    }
}
