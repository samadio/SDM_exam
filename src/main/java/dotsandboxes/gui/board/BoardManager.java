package dotsandboxes.gui.board;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.lists.DBButtonList;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.Move;


public class BoardManager {

    private final BoardSettings GRID_SETTINGS;

    public BoardManager(Integer rows, Integer cols){
        GRID_SETTINGS=new BoardSettings(rows,cols);
    }


    public void createLines(GameFrame gameFrame, BackgroundPanel backgroundPanel){

        DBButtonList horizontalLines = BoardButtonGenerator.create( GRID_SETTINGS.getHorizontalGridSpec(),gameFrame, backgroundPanel);
        DBButtonList verticalLines = BoardButtonGenerator.create(GRID_SETTINGS.getVerticalGridSpec(), gameFrame,backgroundPanel);

        gameFrame.getGrid().setHorizontalLines(horizontalLines);
        gameFrame.getGrid().setVerticalLines(verticalLines);
    }


    public void paintLine(Move currentMove, GameFrame gameFrame) {

        if(currentMove.getLineKind()== Move.Which.HORIZONTAL){
            gameFrame.getGrid().getHorizontalLines().get(currentMove.getRow()*gameFrame.getBoxesColumns()+currentMove.getCol()).setDark();
        }
        else{
            gameFrame.getGrid().getVerticalLines().get(currentMove.getRow()*(gameFrame.getBoxesColumns()+1)+currentMove.getCol()).setDark();
        }
    }


    public void createDots(GameFrame gameFrame, BackgroundPanel backgroundPanel) {

        BoardButtonGenerator.create(GRID_SETTINGS.getDotsGridSpec(),gameFrame, backgroundPanel);

    }

    public void createBoxes(GameFrame gameFrame, BackgroundPanel backgroundPanel){

        DBButtonList boxesList= BoardButtonGenerator.create(GRID_SETTINGS.getBoxesGridSpec(),gameFrame,backgroundPanel);
        gameFrame.getGrid().setBoxes(boxesList);
    }


    public  void paintBox(Game game, GameFrame gameFrame) {

        for (int i = 0; i < gameFrame.getBoxesRows(); i++) {
            for (int j = 0; j < gameFrame.getBoxesColumns(); j++) {

                if (isSquare(game.getBoard(),i,j))
                    gameFrame.getGrid().getBoxes().get(i*GRID_SETTINGS.getRows()+j).setDark();

                }
            }
        }

    private  boolean isSquare(AbstractBoard board, Integer i, Integer j) {
        return board.getElement(Move.Which.HORIZONTAL, i, j) && board.getElement(Move.Which.HORIZONTAL, i + 1, j)
                && board.getElement(Move.Which.VERTICAL, i, j) && board.getElement(Move.Which.VERTICAL, i, j + 1);
    }


}



