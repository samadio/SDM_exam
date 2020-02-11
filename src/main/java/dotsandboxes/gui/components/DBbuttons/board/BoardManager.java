package dotsandboxes.gui.components.DBbuttons.board;

import dotsandboxes.gui.components.BackgroundPanel;
import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.components.DBbuttons.DBButtonList;
import gamesuite.board.BoardHandle;
import gamesuite.game.Game;
import gamesuite.move.Move;


public class BoardManager {

    private final BoardSettings BOARD_SETTINGS;

    public BoardManager(Integer rows, Integer cols){
        BOARD_SETTINGS =new BoardSettings(rows,cols);
    }


    public void createLines(GameFrame gameFrame, BackgroundPanel backgroundPanel){

        DBButtonList horizontalLines = BoardButtonGenerator.create( BOARD_SETTINGS.getHorizontalGridSpec(),gameFrame, backgroundPanel);
        DBButtonList verticalLines = BoardButtonGenerator.create(BOARD_SETTINGS.getVerticalGridSpec(), gameFrame,backgroundPanel);

        gameFrame.getBoard().setHorizontalLines(horizontalLines);
        gameFrame.getBoard().setVerticalLines(verticalLines);
    }


    public void paintLine(Move currentMove, GameFrame gameFrame) {

        if(currentMove.getLineKind()== Move.Orientation.HORIZONTAL){
            gameFrame.getBoard().getHorizontalLines().get(currentMove.getRow()*gameFrame.getBoxesColumns()+currentMove.getCol()).setDark();
        }
        else{
            gameFrame.getBoard().getVerticalLines().get(currentMove.getRow()*(gameFrame.getBoxesColumns()+1)+currentMove.getCol()).setDark();
        }
    }


    public void createDots(GameFrame gameFrame, BackgroundPanel backgroundPanel) {

        BoardButtonGenerator.create(BOARD_SETTINGS.getDotsGridSpec(),gameFrame, backgroundPanel);

    }

    public void createBoxes(GameFrame gameFrame, BackgroundPanel backgroundPanel){

        DBButtonList boxesList= BoardButtonGenerator.create(BOARD_SETTINGS.getBoxesGridSpec(),gameFrame,backgroundPanel);
        gameFrame.getBoard().setBoxes(boxesList);
    }


    public  void paintBox(Game game, GameFrame gameFrame) {

        for (int i = 0; i < gameFrame.getBoxesRows(); i++) {
            for (int j = 0; j < gameFrame.getBoxesColumns(); j++) {

                if (isSquare(game.getBoard(),i,j))
                    gameFrame.getBoard().getBoxes().get(i* BOARD_SETTINGS.getColumns()+j).setDark();

                }
            }
        }

    private  boolean isSquare(BoardHandle board, Integer i, Integer j) {
        return board.getElement(Move.Orientation.HORIZONTAL, i, j) && board.getElement(Move.Orientation.HORIZONTAL, i + 1, j)
                && board.getElement(Move.Orientation.VERTICAL, i, j) && board.getElement(Move.Orientation.VERTICAL, i, j + 1);
    }


}



