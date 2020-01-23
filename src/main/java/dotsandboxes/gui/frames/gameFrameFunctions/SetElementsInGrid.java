package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.DBButtons.Box;
import dotsandboxes.gui.graphics.DBButtons.Dot;
import dotsandboxes.gui.graphics.DBButtons.HorizontalLine;
import dotsandboxes.gui.graphics.DBButtons.VerticalLine;
import dotsandboxes.gui.graphics.lists.DotsList;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import java.awt.*;

public class SetElementsInGrid {


    public static LinesList setHorizontalLines(GridSpecifics gridSpec, BackgroundPanel bPanel){

        LinesList lines= new LinesList();
        for (int i = 0; i < gridSpec.getRows(); i++) {
            for (int j = 0; j < gridSpec.getCols(); j++) {
                Point position= new Point(gridSpec.getDist() * j + gridSpec.getOffset().x,gridSpec.getDist() * i + gridSpec.getOffset().y);
                ObjSpecifics lineSpecs= new ObjSpecifics(position,gridSpec.getElementSize(),gridSpec.getHints());
                HorizontalLine line = new HorizontalLine(lineSpecs,i,j);
                bPanel.add(line);
                lines.add(line);
            }
        }
        return lines;

    }


    public static LinesList setVerticalLines(GridSpecifics gridSpec, BackgroundPanel bPanel){

        LinesList lines= new LinesList();
        for (int i = 0; i < gridSpec.getRows(); i++) {
            for (int j = 0; j < gridSpec.getCols(); j++) {
                Point position= new Point(gridSpec.getDist() * j + gridSpec.getOffset().x,gridSpec.getDist() * i + gridSpec.getOffset().y);
                ObjSpecifics lineSpecs= new ObjSpecifics(position,gridSpec.getElementSize(),gridSpec.getHints());
                VerticalLine line = new VerticalLine(lineSpecs,i,j);
                bPanel.add(line);
                lines.add(line);
            }
        }
        return lines;

    }


    public static void setDots(GridSpecifics gridSpec,BackgroundPanel bPanel){

        DotsList dots= new DotsList();
        for (int i = 0; i < gridSpec.getRows(); i++) {
            for (int j = 0; j < gridSpec.getCols(); j++) {

                Point position= new Point(gridSpec.getDist() * j + gridSpec.getOffset().x,gridSpec.getDist() * i + gridSpec.getOffset().y);
                ObjSpecifics dotSpecs= new ObjSpecifics(position,gridSpec.getElementSize(),gridSpec.getHints());
                Dot dot = new Dot(dotSpecs);
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
        Point boxPosition=new Point(xOffset+dimTwo +j*(dimOne+dimTwo),yOffset+dimTwo+i*(dimOne+dimTwo));
        ObjSpecifics boxSpec= new ObjSpecifics(boxPosition,new Rectangle(dimOne,dimOne), 50);
        Box box = new Box(boxSpec);
        backgroundPanel.add(box);
    }
}