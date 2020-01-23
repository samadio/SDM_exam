package dotsandboxes.gui.graphics;

import javax.swing.*;
import java.awt.*;

public class DBNumButton extends DBTextButton {

    public DBNumButton(Integer num, Icon image,  Point position, Rectangle size){
        super(Integer.toString(num), image,position,size);
    }

    public Integer getNumber() {return Integer.valueOf(getText());}
}
