package dotsandboxes.gui.board;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.DBButtons.*;
import dotsandboxes.gui.graphics.lists.DBButtonList;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.Move;

import java.awt.*;


public class BoardManager {

    private final BoardElementsSpecifics GRID_SETTINGS;

    public BoardManager(Integer rows, Integer cols){
        GRID_SETTINGS=new BoardElementsSpecifics(rows,cols);
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



class BoardButtonGenerator {

    public static DBButtonList create(BoardButtonSpecifics gridSpec, GameFrame gameFrame, BackgroundPanel bPanel){

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


    private static void setAction(Move.Which type, Line line, GameFrame gameFrame) {
        line.addActionListener(x ->
        {
            gameFrame.setCurrentMove( new Move(type, line.getRow(), line.getColumn() ) );
            gameFrame.setInputGiven(true);
        });
    }

}