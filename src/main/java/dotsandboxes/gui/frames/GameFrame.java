package dotsandboxes.gui.frames;


import dotsandboxes.gui.frames.gameFrameFunctions.ComponentSetter;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.lists.LabelsList;
import gamesuite.game.EndGameException;
import gamesuite.game.Game;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;


public class GameFrame extends Frame {

    ComponentSetter componentSetter;

    private DBLabel currentPlayerLabel;
    public Move currentMove;
    private LabelsList labels;
    public boolean endGame;
    public boolean reset;
    private Integer boxesRows;
    private Integer boxesColumns;
    private boolean[][] boxes;

    public GameFrame(BackgroundPanel backgroundPanel, Game game) {

        super();
        boxesRows=game.getBoard().getRows()-1;
        boxesColumns=game.getBoard().getColumns()-1;
        boxes=new boolean[boxesRows][boxesColumns];
        endGame = false;
        reset = false;
        labels= new LabelsList();

        componentSetter= new ComponentSetter(boxesRows,boxesColumns);

        componentSetter.playersLabels(this,game.getPlayers(), backgroundPanel);
        componentSetter.endResetButtons(this,backgroundPanel);

        currentPlayerLabel = new DBLabel("",230, 10, 200, 30);
        backgroundPanel.add(currentPlayerLabel);

        componentSetter.lines(this, backgroundPanel);

        componentSetter.dots(backgroundPanel);

        updatePanel(backgroundPanel);
    }


    public Integer getBoxesRows() {return boxesRows;}
    public Integer getBoxesColumns() {return boxesColumns;}
    public boolean[][] getBoxes() {return boxes;}
    public LabelsList getLabels() {return labels;}
    public boolean getReset() {return reset;}
    public Move getMove() {return currentMove;}


    public void readMove() throws EndGameException, ResetGameException {
        waitInput();
        if(endGame==true) throw new EndGameException();
        if(reset==true) throw new ResetGameException();
    }


    public void updateFrame(BackgroundPanel backgroundPanel, Game game) {

        currentPlayerLabel.setText("CURRENT PLAYER:  "+game.nextPlayer().getName());

        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setText(game.getPlayers().get(i).getName() + "   " + game.getScore().get(game.getPlayers().get(i)));
        }

        componentSetter.add(game,this,backgroundPanel);
        updatePanel(backgroundPanel);
    }


    public void resetFrame(BackgroundPanel backgroundPanel) {

        boxes=new boolean[boxesRows][boxesColumns];
        clear(backgroundPanel);

    }

}



