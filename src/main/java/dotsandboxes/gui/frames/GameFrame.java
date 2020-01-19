package dotsandboxes.gui.frames;


import dotsandboxes.gui.frames.gameFrameFunctions.ComponentSetter;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.Grid;
import dotsandboxes.gui.graphics.lists.LabelsList;
import gamesuite.game.EndGameException;
import gamesuite.game.Game;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;


public class GameFrame extends InputFrame<Move> {

    ComponentSetter componentSetter;

    private DBLabel currentPlayerLabel;
    private Move currentMove;
    private LabelsList labels;
    public boolean endGame;
    public boolean reset;
    private Integer boxesRows;
    private Integer boxesColumns;
    private boolean[][] boxes;
    public Grid grid;

    public GameFrame(BackgroundPanel bP, Game game) {

        super(bP);
        grid=new Grid();
        boxesRows=game.getBoard().getRows()-1;
        boxesColumns=game.getBoard().getColumns()-1;
        currentPlayerLabel = new DBLabel();
        boxes=new boolean[boxesRows][boxesColumns];
        endGame = false;
        reset = false;
        labels= new LabelsList();

        componentSetter= new ComponentSetter(boxesRows,boxesColumns);

        componentSetter.playersLabels(this,game.getPlayers(), backgroundPanel);

        componentSetter.endResetButtons(this,backgroundPanel);

        componentSetter.currentPlayerLabel(backgroundPanel,currentPlayerLabel);

        componentSetter.lines(this, backgroundPanel);

        componentSetter.dots(backgroundPanel);

        updatePanel(backgroundPanel);

    }


    public Integer getBoxesRows() {return boxesRows;}
    public Integer getBoxesColumns() {return boxesColumns;}
    public boolean[][] getBoxes() {return boxes;}
    public LabelsList getLabels() {return labels;}
    public boolean getReset() {return reset;}
    public boolean getEndGame() {return endGame;}


    @Override
    public Move getInput() {

        waitInput();
        return currentMove;
    }



    public void updateFrame(Game game) {

        componentSetter.updateCurrentPlayer(game, currentPlayerLabel);

        if(currentMove!=null) componentSetter.paintLine(currentMove,this);

        componentSetter.setScores(game, labels);

        componentSetter.addBox(game,this,backgroundPanel);

        updatePanel(backgroundPanel);

    }


    public void resetFrame(BackgroundPanel backgroundPanel) {

        boxes=new boolean[boxesRows][boxesColumns];
        clear(backgroundPanel);

    }


    public Move getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(Move currentMove) {
        this.currentMove = currentMove;
    }

    @Override
    public void setPanel() {

    }
}



