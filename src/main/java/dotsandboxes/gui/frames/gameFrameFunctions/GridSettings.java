package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import java.awt.*;

public class GridSettings {

    private GridSpecifics horizontalGridSpec;
    private GridSpecifics verticalGridSpec;
    private GridSpecifics dotsGridSpec;

    private final Integer xOffset;
    private final Integer yOffset;
    private final Integer dimOne=45;
    private final Integer dimTwo=15;
    private final Integer LEFT_MARGIN=120; //trasformare in punto
    private final Integer TOP_MARGIN=50;


    public GridSettings(Integer rows, Integer cols){

        xOffset=LEFT_MARGIN+(340-(dimOne+dimTwo)*cols)/2;  //risistemare tutte costanti
        yOffset=TOP_MARGIN+(300-(dimOne+dimTwo)*rows)/2;
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
