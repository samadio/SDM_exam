package dotsandboxes.gui.graphics.specifics;

import java.awt.*;

public class GridSpecifics {

    private Rectangle gridArea;
    private Integer rows;
    private Integer cols;
    private Integer dist;

    public GridSpecifics(Integer r, Integer c, Integer w, Integer h, Integer xO, Integer yO, Integer d){

        gridArea = new Rectangle(xO, yO, w, h);
        rows=r;
        cols=c;
        dist=d;

    }

    public Integer getRows() {
        return rows;
    }

    public Integer getCols() {
        return cols;
    }

    public Integer getWidth() {
        return (int) gridArea.getWidth();
    }

    public Integer getHeight() {
        return (int) gridArea.getHeight();
    }

    public Integer getyOffset() {
        return (int) gridArea.getY();
    }

    public Integer getDist() {
        return dist;
    }

    public Integer getxOffset() {
        return (int) gridArea.getX();
    }
}