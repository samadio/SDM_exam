package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.GraphicObj;
import dotsandboxes.gui.graphics.Line;
import dotsandboxes.gui.graphics.lists.DotsList;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

public class SetElementsInGrid {

    public static LinesList setLines(ObjSpecifics objSpec, GridSpecifics gridSpec, BackgroundPanel bPanel){

        LinesList lines= new LinesList();
        for (int i = 0; i < gridSpec.rows; i++) {
            for (int j = 0; j < gridSpec.cols; j++) {
                Line line = new Line(objSpec,i,j);
                line.setButtonProperties(gridSpec.dist * j + gridSpec.xOffset, gridSpec.dist * i + gridSpec.yOffset, gridSpec.width, gridSpec.height);
                bPanel.add(line);
                lines.add(line);
            }
        }
        return lines;

    }

    public static void setDots(ObjSpecifics objSpec, GridSpecifics gridSpec,BackgroundPanel bPanel){

        DotsList dots= new DotsList();
        for (int i = 0; i < gridSpec.rows; i++) {
            for (int j = 0; j < gridSpec.cols; j++) {
                GraphicObj dot = new GraphicObj(objSpec);
                dot.setButtonProperties(gridSpec.dist * j + gridSpec.xOffset, gridSpec.dist * i + gridSpec.yOffset, gridSpec.width, gridSpec.height);
                bPanel.add(dot);
                dots.add(dot);
            }
        }

    }


    public static void setBox(int i, int j,ComponentSetter componentSetter,BackgroundPanel backgroundPanel){

        Integer xOffset=componentSetter.getXOffset();
        Integer yOffset=componentSetter.getYOffset();
        Integer dimOne=componentSetter.getDimOne();
        Integer dimTwo=componentSetter.getDimTwo();

        ObjSpecifics boxSpec= new ObjSpecifics("images/box.png","",dimOne,dimOne, 50);
        GraphicObj box = new GraphicObj(boxSpec);
        box.setButtonProperties(xOffset+dimTwo +j*(dimOne+dimTwo), yOffset+dimTwo+i*(dimOne+dimTwo), dimOne, 50);
        backgroundPanel.add(box);
    }
}