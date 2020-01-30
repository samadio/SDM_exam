package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.DBButtons.Box;
import dotsandboxes.gui.graphics.lists.DBButtonList;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.Move;

import java.awt.*;

public class GridSetter {

    private final GridSettings GRID_SETTINGS;


    public GridSetter(Integer rows, Integer cols){

        GRID_SETTINGS=new GridSettings(rows,cols);

    }



    public void lines(GameFrame gameFrame, BackgroundPanel backgroundPanel){

        DBButtonList horizontalLines = InitElementsInGrid.set( GRID_SETTINGS.getHorizontalGridSpec(),gameFrame, backgroundPanel);
        DBButtonList verticalLines = InitElementsInGrid.set(GRID_SETTINGS.getVerticalGridSpec(), gameFrame,backgroundPanel);

        gameFrame.getGrid().setGrid(horizontalLines,verticalLines);
    }


    public void paintLine(Move currentMove, GameFrame gameFrame) {

        if(currentMove.getLineKind()== Move.Which.HORIZONTAL){
            gameFrame.getGrid().getHorizontalLines().get(currentMove.getRow()*gameFrame.getBoxesColumns()+currentMove.getCol()).setDark();
        }
        else{
            gameFrame.getGrid().getVerticalLines().get(currentMove.getRow()*(gameFrame.getBoxesColumns()+1)+currentMove.getCol()).setDark();
        }
    }


    public void dots(GameFrame gameFrame,BackgroundPanel backgroundPanel) {

        InitElementsInGrid.set(GRID_SETTINGS.getDotsGridSpec(),gameFrame, backgroundPanel);

    }

    public void boxes(GameFrame gameFrame,BackgroundPanel backgroundPanel){

        DBButtonList boxesList= new DBButtonList();

        Integer xOffset=GRID_SETTINGS.getXOffset();
        Integer yOffset=GRID_SETTINGS.getYOffset();
        Integer dimOne=GRID_SETTINGS.getDimOne();
        Integer dimTwo=GRID_SETTINGS.getDimTwo();
        for (int i = 0; i < GRID_SETTINGS.getRows()-1; i++) {
            for (int j = 0; j < GRID_SETTINGS.getColumns()-1; j++) {
                Point boxPosition = new Point(xOffset + dimTwo + j * (dimOne + dimTwo), yOffset + dimTwo + i * (dimOne + dimTwo));
                ObjSpecifics boxSpec = new ObjSpecifics(boxPosition, new Rectangle(dimOne, dimOne), GRID_SETTINGS.getHints());
                Box box = new Box(boxSpec);
                backgroundPanel.add(box);
                boxesList.add(box);
            }
        }

        gameFrame.getGrid().setBoxes(boxesList);
    }


    public  void paintBox(Game game, GameFrame gameFrame, BackgroundPanel backgroundPanel) {
        AbstractBoard board=game.getBoard();
        for (int i = 0; i < gameFrame.getBoxesRows(); i++) {
            for (int j = 0; j < gameFrame.getBoxesColumns(); j++) {

                if (BoxSetter.isSquare(game.getBoard(),i,j))
                    gameFrame.getGrid().getBoxes().get(i*(GRID_SETTINGS.getRows()-1)+j).setDark();

                }
            }
        }


}
