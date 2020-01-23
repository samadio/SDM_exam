package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import java.awt.*;

public class GridSettings {

    private GridSpecifics horizontalGridSpec;
    private GridSpecifics verticalGridSpec;
    private GridSpecifics dotsGridSpec;

    private Integer xOffset;
    private Integer yOffset;
    private Integer dimOne;
    private Integer dimTwo;


    public GridSettings(Integer rows, Integer cols){

        dimOne=45;
        dimTwo=15;
        xOffset=120+(340-(dimOne+dimTwo)*cols)/2;
        yOffset=50+(300-(dimOne+dimTwo)*rows)/2;
        Integer hints=50;

        horizontalGridSpec = new GridSpecifics(rows+1, cols, new Rectangle(dimOne, dimTwo), new Point(xOffset+dimTwo, yOffset), dimOne+dimTwo,hints);
        verticalGridSpec = new GridSpecifics(rows, cols+1, new Rectangle(dimTwo, dimOne),new Point( xOffset, yOffset+dimTwo), dimOne+dimTwo,hints);
        dotsGridSpec = new GridSpecifics(rows+1, cols+1,new Rectangle( dimTwo, dimTwo),new Point( xOffset, yOffset), dimOne+dimTwo,hints);

    }

    public Integer getXOffset(){return  xOffset;}
    public Integer getYOffset(){return  yOffset;}
    public Integer getDimOne() {return  dimOne;}
    public Integer getDimTwo() {return  dimTwo;}

    public GridSpecifics getHorizontalGridSpec() {return horizontalGridSpec; }
    public GridSpecifics getVerticalGridSpec() {return verticalGridSpec; }
    public GridSpecifics getDotsGridSpec() {return dotsGridSpec;}

}
