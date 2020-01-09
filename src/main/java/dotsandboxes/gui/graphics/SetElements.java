package dotsandboxes.gui.graphics;

import java.util.LinkedList;
import java.util.List;

public class SetElements {

    public static LinesGrid setGrid(ObjSpecifics objSpec, GridSpecifics gridSpec, BackgroundPanel bPanel){

        LinesGrid lines= new LinesGrid();
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

    public static void setDots(GraphicObj[][] graphicObj, ObjSpecifics objSpec, GridSpecifics gridSpec,BackgroundPanel bPanel, Boolean isLine){

        for (int i = 0; i < gridSpec.rows; i++) {
            for (int j = 0; j < gridSpec.cols; j++) {
                graphicObj[i][j] = new GraphicObj(objSpec);
                graphicObj[i][j].setButtonProperties(gridSpec.dist * j + gridSpec.xOffset, gridSpec.dist * i + gridSpec.yOffset, gridSpec.width, gridSpec.height);
                bPanel.add(graphicObj[i][j]);
            }
        }

    }
}