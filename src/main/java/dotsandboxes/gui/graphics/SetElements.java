package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.lists.DotsList;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

public class SetElements {

    public static LinesList setGrid(ObjSpecifics objSpec, GridSpecifics gridSpec, BackgroundPanel bPanel){

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
}