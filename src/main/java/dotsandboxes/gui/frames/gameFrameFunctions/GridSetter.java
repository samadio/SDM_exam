package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.lists.DBButtonList;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.Move;

public class GridSetter {

    private final GridSettings GRID_SETTINGS;


    public GridSetter(Integer rows, Integer cols){

        GRID_SETTINGS=new GridSettings(rows,cols);

    }



    public void lines(GameFrame gameFrame, BackgroundPanel backgroundPanel){

        DBButtonList horizontalLines = SetElementsInGrid.set( GRID_SETTINGS.getHorizontalGridSpec(),gameFrame, backgroundPanel);
        DBButtonList verticalLines = SetElementsInGrid.set(GRID_SETTINGS.getVerticalGridSpec(), gameFrame,backgroundPanel);

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

        SetElementsInGrid.set(GRID_SETTINGS.getDotsGridSpec(),gameFrame, backgroundPanel);

    }


    public  void addBox(Game game, GameFrame gameFrame,  BackgroundPanel backgroundPanel) {
        BoxSetter.addBox(game.getBoard(),GRID_SETTINGS,gameFrame,backgroundPanel);
    }


}
