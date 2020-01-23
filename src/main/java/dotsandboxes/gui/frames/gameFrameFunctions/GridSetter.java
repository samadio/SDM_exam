package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.DBButtons.Line;
import dotsandboxes.gui.graphics.lists.LinesList;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.Move;

public class GridSetter {

    private final GridSettings GRID_SETTINGS;


    public GridSetter(Integer rows, Integer cols){

        GRID_SETTINGS=new GridSettings(rows,cols);

    }



    public void lines(GameFrame gameFrame, BackgroundPanel backgroundPanel){

        LinesList horizontalLines = SetElementsInGrid.setHorizontalLines( GRID_SETTINGS.getHorizontalGridSpec(), backgroundPanel);
        LinesList verticalLines = SetElementsInGrid.setVerticalLines(GRID_SETTINGS.getVerticalGridSpec(), backgroundPanel);

        gameFrame.getGrid().setGrid(horizontalLines,verticalLines);

        for (Line l : horizontalLines) {
            l.addActionListener(x ->
            {
                gameFrame.setCurrentMove( new Move(Move.Which.HORIZONTAL, l.getRow(), l.getColumn() ) );
                gameFrame.setInputGiven(true);
            });
        }

        for (Line l : verticalLines) {
            l.addActionListener(x ->
            {
                gameFrame.setCurrentMove( new Move(Move.Which.VERTICAL, l.getRow(), l.getColumn() ) );
                gameFrame.setInputGiven(true);
            });
        }
    }


    public void dots(BackgroundPanel backgroundPanel) {

        SetElementsInGrid.setDots(GRID_SETTINGS.getDotsGridSpec(), backgroundPanel);

    }


    public  void addBox(Game game, GameFrame gameFrame,  BackgroundPanel backgroundPanel) {
        AbstractBoard board = game.getBoard();

        for (int i = 0; i < gameFrame.getBoxesRows(); i++) {
            for (int j = 0; j < gameFrame.getBoxesColumns(); j++) {

                if (board.getElement(Move.Which.HORIZONTAL, i, j) && board.getElement(Move.Which.HORIZONTAL, i + 1, j)
                        && board.getElement(Move.Which.VERTICAL, i, j) && board.getElement(Move.Which.VERTICAL, i, j + 1)) {

                    if (!gameFrame.getBoxes()[i][j]) {
                        SetElementsInGrid.setBox(i, j,GRID_SETTINGS, backgroundPanel);
                        gameFrame.getBoxes()[i][j] = true;
                    }
                }
            }
        }
    }


    public void paintLine(Move currentMove, GameFrame gameFrame) {

        if(currentMove.getLineKind()== Move.Which.HORIZONTAL){
            gameFrame.getGrid().getHorizontalLines().get(currentMove.getRow()*gameFrame.getBoxesColumns()+currentMove.getCol()).setDark();
        }
        else{
            gameFrame.getGrid().getVerticalLines().get(currentMove.getRow()*(gameFrame.getBoxesColumns()+1)+currentMove.getCol()).setDark();
        }
    }
}
