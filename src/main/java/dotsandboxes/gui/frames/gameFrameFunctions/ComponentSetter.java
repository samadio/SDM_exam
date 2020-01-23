package dotsandboxes.gui.frames.gameFrameFunctions;

import dotsandboxes.gui.frames.GameFrame;
import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.graphics.lists.LabelsList;
import dotsandboxes.gui.graphics.lists.LinesList;
import dotsandboxes.gui.graphics.specifics.GridSpecifics;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.board.AbstractBoard;
import gamesuite.game.Game;
import gamesuite.move.Move;
import gamesuite.players.Player;

import java.awt.*;
import java.io.File;
import java.util.List;

public class ComponentSetter{

    private final File IMAGE_DIR;
    private ObjSpecifics horizontalLinesSpec;
    private ObjSpecifics verticalLinesSpec;
    private ObjSpecifics dotsSpec;
    private GridSpecifics horizontalGridSpec;
    private GridSpecifics verticalGridSpec;
    private GridSpecifics dotsGridSpec;

    private Integer xOffset;
    private Integer yOffset;
    private Integer dimOne;
    private Integer dimTwo;


    public ComponentSetter(File imgDir,Integer rows, Integer cols){

        IMAGE_DIR=imgDir;
        dimOne=45;
        dimTwo=15;
        xOffset=120+(340-(dimOne+dimTwo)*cols)/2;
        yOffset=50+(300-(dimOne+dimTwo)*rows)/2;


        horizontalLinesSpec = new ObjSpecifics("images/horizontal_empty.png", "images/horizontal_full.png", dimOne, dimTwo, 50);
        horizontalGridSpec = new GridSpecifics(rows+1, cols, dimOne, dimTwo, xOffset+dimTwo, yOffset, dimOne+dimTwo);

        verticalLinesSpec = new ObjSpecifics("images/vertical_empty.png", "images/vertical_full.png", dimTwo, dimOne, 50);
        verticalGridSpec = new GridSpecifics(rows, cols+1, dimTwo, dimOne, xOffset, yOffset+dimTwo, dimOne+dimTwo);

        dotsSpec = new ObjSpecifics("images/dot.png", "", 10, 10, 50);
        dotsGridSpec = new GridSpecifics(rows+1, cols+1, dimTwo, dimTwo, xOffset, yOffset, dimOne+dimTwo);

    }


    public Integer getXOffset(){return  xOffset;}
    public Integer getYOffset(){return  yOffset;}
    public Integer getDimOne() {return  dimOne;}
    public Integer getDimTwo() {return  dimTwo;}


    public void playersLabels(GameFrame gameFrame,List<Player>  players, BackgroundPanel backgroundPanel){

        Integer yOffset=40;

        DBLabel score= new DBLabel("SCORE",10, yOffset, 100, 30);
        backgroundPanel.add(score);


        for (int i=0; i<players.size(); i++) {
            yOffset+=40;
            DBLabel label= new DBLabel(players.get(i).getName(),10, yOffset, 100, 30);
            gameFrame.getLabels().add(label);
            backgroundPanel.add(label);
        }
    }


    public void currentPlayerLabel(BackgroundPanel backgroundPanel,DBLabel currentPlayerLabel) {
        currentPlayerLabel.setLabelProperties("",180, 10, 250, 30);
        backgroundPanel.add(currentPlayerLabel);
    }



    public void endResetButtons(GameFrame gameFrame, BackgroundPanel backgroundPanel){
        DBTextButton endGameButton = new DBTextButton(IMAGE_DIR,"END GAME", new Point(470, 290), new Rectangle(120, 30));

        endGameButton.addActionListener(x ->
        {
            gameFrame.setEndGame(true);
            gameFrame.setInputGiven(true);
            endGameButton.setDark();

        });

        DBTextButton resetGameButton = new DBTextButton(IMAGE_DIR,"RESET GAME",new Point(470, 330),new Rectangle( 120, 30));

        resetGameButton.addActionListener(x ->
        {
            gameFrame.setReset(true);
            gameFrame.setInputGiven(true);
            resetGameButton.setDark();
        });

        backgroundPanel.add(endGameButton);
        backgroundPanel.add(resetGameButton);
    }





    public void lines(GameFrame gameFrame, BackgroundPanel backgroundPanel){


        LinesList horizontalLines = SetElementsInGrid.setHorizontalLines(horizontalLinesSpec, horizontalGridSpec, backgroundPanel);
        LinesList verticalLines = SetElementsInGrid.setVerticalLines(verticalLinesSpec, verticalGridSpec, backgroundPanel);

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

        SetElementsInGrid.setDots(dotsSpec, dotsGridSpec, backgroundPanel);

    }


    public void updateCurrentPlayer(Game game, DBLabel currentPlayerLabel){
        currentPlayerLabel.setText("CURRENT PLAYER:  "+game.nextPlayer().getName());
    }


    public void setScores(Game game, LabelsList labels) {
        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setText(game.getPlayers().get(i).getName() + "   " + game.getScore().get(game.getPlayers().get(i)));
        }
    }


    public  void addBox(Game game, GameFrame gameFrame,  BackgroundPanel backgroundPanel) {
        AbstractBoard board = game.getBoard();

        for (int i = 0; i < gameFrame.getBoxesRows(); i++) {
            for (int j = 0; j < gameFrame.getBoxesColumns(); j++) {

                if (board.getElement(Move.Which.HORIZONTAL, i, j) && board.getElement(Move.Which.HORIZONTAL, i + 1, j)
                        && board.getElement(Move.Which.VERTICAL, i, j) && board.getElement(Move.Which.VERTICAL, i, j + 1)) {

                    if (gameFrame.getBoxes()[i][j] == false) {
                        SetElementsInGrid.setBox(i, j,this, backgroundPanel);
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
