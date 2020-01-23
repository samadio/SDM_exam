package dotsandboxes.gui.graphics.specifics;

import java.awt.*;

public class ObjSpecifics {

    private final Point POSITION;
    private final Rectangle SIZE;
    private final Integer HINTS;

    public ObjSpecifics(Point position,Rectangle size ,Integer hints) {
        POSITION = position;
        SIZE = size;
        HINTS = hints;
    }

    public ObjSpecifics(Integer x, Integer y, Integer width, Integer height,Integer hints){
        POSITION = new Point(x,y);
        SIZE = new Rectangle(width,height);
        HINTS = hints;
    }



    public Point getPosition() {
        return POSITION;
    }

    public Rectangle getSize() {
        return SIZE;
    }

    public Integer getHints() {
        return HINTS;
    }
}

