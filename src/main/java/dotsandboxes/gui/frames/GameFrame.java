package dotsandboxes.gui.frames;


import dotsandboxes.gui.frames.gameFrameFunctions.ComponentSetter;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.Grid;
import dotsandboxes.gui.graphics.lists.LabelsList;
import gamesuite.game.Game;
import gamesuite.move.Move;

import java.io.File;


public class GameFrame extends InputFrame<Move> {

    ComponentSetter componentSetter;

    private DBLabel currentPlayerLabel;
    private Move currentMove;
    private LabelsList labels;
    private boolean endGame;
    private boolean reset;
    private Integer boxesRows;
    private Integer boxesColumns;
    private boolean[][] boxes;
    private Grid grid;
    private Game targetGame;


    public GameFrame(BackgroundPanel bP, Game game) {

        super(bP);
        grid=new Grid();
        boxesRows=game.getBoard().getRows()-1;
        boxesColumns=game.getBoard().getColumns()-1;

        targetGame = game;
    }

    public Integer getBoxesRows() {return boxesRows;}
    public Integer getBoxesColumns() {return boxesColumns;}
    public boolean[][] getBoxes() {return boxes;}
    public LabelsList getLabels() {return labels;}
    public boolean getReset() {return reset;}
    public boolean getEndGame() {return endGame;}
    public Grid getGrid() {return grid;}


    public void setReset(boolean bool) {reset=bool;}
    public void setEndGame(boolean bool) {endGame=bool;}



    @Override
    public Move getInput() {

        waitInput();
        return currentMove;
    }



    public void updateFrame(Game game) {

        componentSetter.updateCurrentPlayer(game, currentPlayerLabel);

        if(currentMove!=null) componentSetter.paintLine(currentMove,this);

        componentSetter.setScores(game, labels);

        componentSetter.addBox(game,this, BACKGROUND_PANEL);

        updatePanel();

    }


    public void resetFrame(BackgroundPanel backgroundPanel) {

        boxes=new boolean[boxesRows][boxesColumns];
        clear();

    }


    public void setCurrentMove(Move currentMove) {
        this.currentMove = currentMove;
    }

    @Override
    public void setPanel() {

        clear();
        currentPlayerLabel = new DBLabel();
        boxes=new boolean[boxesRows][boxesColumns];
        endGame = false;
        reset = false;
        labels= new LabelsList();

        componentSetter= new ComponentSetter(boxesRows,boxesColumns);

        componentSetter.playersLabels(this,targetGame.getPlayers(), BACKGROUND_PANEL);

        componentSetter.endResetButtons(this, BACKGROUND_PANEL);

        componentSetter.currentPlayerLabel(BACKGROUND_PANEL,currentPlayerLabel);

        componentSetter.lines(this, BACKGROUND_PANEL);

        componentSetter.dots(BACKGROUND_PANEL);

        updatePanel();
    }
}



