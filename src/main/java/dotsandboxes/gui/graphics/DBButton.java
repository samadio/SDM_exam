package dotsandboxes.gui.graphics;

import javax.swing.*;

public class DBButton extends JButton {

    public DBButton(String t, Integer x, Integer y, Integer w, Integer h ){

        super();

        setText(t);
        setSize(w, h);
        setLocation(x,y);

        setAlignment(JLabel.CENTER);

        this.setBounds(getX(), getY(), getWidth(), getHeight());

        setStyle();

        setTextPosition(SwingConstants.CENTER);
    }

    public void setDark() {
        ImageIcon darkIcon = new ImageIcon(new ImageIcon("images/woodTableDark.png").getImage().getScaledInstance(getWidth(), getHeight(), 80));
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
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/woodTable.png").getImage().getScaledInstance(getWidth(), getHeight(), 80));
        this.setIcon(imageIcon);
    }
    private void setTextPosition(Integer position) {

        this.setVerticalTextPosition(position);
        this.setHorizontalTextPosition(position);
    }
}
