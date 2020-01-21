package dotsandboxes.gui.graphics;

import javax.swing.*;

public class DBTextField extends JTextField {
    Integer x_position;
    Integer y_position;
    Integer width;
    Integer height;

    public DBTextField(Integer cols, Integer x, Integer y, Integer w, Integer h ){
        super(cols);
        x_position=x;
        y_position=y;
        width=w;
        height=h;
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBounds(x_position, y_position, width, height);
        this.setFont(FontSetter.setFont());
    }
}
