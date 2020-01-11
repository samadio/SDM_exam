package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.GraphicObj;

import javax.swing.*;

public class NumButton extends JButton {
    public Integer number;
    public NumButton(Integer num){
        super(Integer.toString(num));
        number=num;
    }
}
