package dotsandboxes.gui.graphics;

public class SetElements {

    public static void setGrid(Line[][] lines, ObjSpecifics objSpec, GridSpecifics gridSpec,BackgroundPanel bPanel){

        for (int i = 0; i < gridSpec.rows; i++) {
            for (int j = 0; j < gridSpec.cols; j++) {
                lines[i][j] = new Line(objSpec,i,j);
                lines[i][j].setButtonProperties(gridSpec.dist * j + gridSpec.xOffset, gridSpec.dist * i + gridSpec.yOffset, gridSpec.width, gridSpec.height);
                bPanel.add(lines[i][j].getButton());
            }
        }

    }

    public static void setDots(GraphicObj[][] graphicObj, ObjSpecifics objSpec, GridSpecifics gridSpec,BackgroundPanel bPanel, Boolean isLine){

        for (int i = 0; i < gridSpec.rows; i++) {
            for (int j = 0; j < gridSpec.cols; j++) {
                graphicObj[i][j] = new GraphicObj(objSpec);
                graphicObj[i][j].setButtonProperties(gridSpec.dist * j + gridSpec.xOffset, gridSpec.dist * i + gridSpec.yOffset, gridSpec.width, gridSpec.height);
                bPanel.add(graphicObj[i][j].getButton());
            }
        }

    }
}