package dotsandboxes.gui.graphics.specifics;

import gamesuite.move.Move;

public class LineSpecifics extends ObjSpecifics {
    Move.Which orientation;

    public LineSpecifics(String fn, String fn2, Integer w, Integer h, Integer hi, Move.Which or) {
        super(fn, fn2, w, h, hi);
        orientation=or;

    }
}
