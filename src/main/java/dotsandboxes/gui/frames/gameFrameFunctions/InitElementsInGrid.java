package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.DBButtons.*;
import dotsandboxes.gui.graphics.lists.DBButtonList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.move.Move;

import java.awt.*;

public class InitElementsInGrid {


    public static DBButtonList set(GridSpecifics gridSpec, GameFrame gameFrame, BackgroundPanel bPanel){

        DBButtonList elementList= new DBButtonList();
        for (int i = 0; i < gridSpec.getRows(); i++) {
            for (int j = 0; j < gridSpec.getCols(); j++) {

                Point position = new Point(gridSpec.getDist() * j + gridSpec.getOffset().x, gridSpec.getDist() * i + gridSpec.getOffset().y);
                ObjSpecifics objSpecifics = new ObjSpecifics(position, gridSpec.getElementSize(), gridSpec.getHints());

                switch (gridSpec.getType()) {
                    case HORIZONTAL_LINE:
                        HorizontalLine hLine = new HorizontalLine(objSpecifics, i, j);
                        setAction(Move.Which.HORIZONTAL,hLine,gameFrame);
                        elementList.add(hLine);
                        break;

                    case VERTICAL_LINE:
                        VerticalLine vLine = new VerticalLine(objSpecifics,i,j);
                        setAction(Move.Which.VERTICAL,vLine,gameFrame);
                        elementList.add(vLine);
                        break;

                    case DOT:
                        Dot dot = new Dot(objSpecifics);
                        elementList.add(dot);
                        break;

                    case BOX:
                        Box box = new Box(objSpecifics);
                        elementList.add(box);
                        break;
                }
                bPanel.add(elementList.getLast());
            }

        }
        return elementList;

    }


    private static void setAction(Move.Which type,Line line, GameFrame gameFrame) {
        line.addActionListener(x ->
        {
            gameFrame.setCurrentMove( new Move(type, line.getRow(), line.getColumn() ) );
            gameFrame.setInputGiven(true);
        });
    }




}