package dotsandboxes.gui.frames;


import dotsandboxes.gui.frames.gameFrameFunctions.*;
import dotsandboxes.gui.frames.labels.CurrentPlayerLabel;
import dotsandboxes.gui.frames.labels.PlayersLabelSetter;
import dotsandboxes.gui.frames.labels.ScoreLabels;
import dotsandboxes.gui.graphics.BackgroundPanel;
import dotsandboxes.gui.graphics.DBButtons.DBTextButton;
import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.Grid;
import dotsandboxes.gui.graphics.lists.LabelsList;
import dotsandboxes.gui.graphics.specifics.ObjSpecifics;
import gamesuite.game.Game;
import gamesuite.move.Move;


public class GameFrame extends InputFrame<Move> {

    GridSetter gridSetter;

    private DBLabel currentPlayerLabel;
    private Move currentMove;
    private LabelsList labels;
    private boolean endGame;
    private boolean reset;
    private Integer boxesRows;
    private Integer boxesColumns;
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
    public LabelsList getLabels() {return labels;}
    public boolean getReset() {return reset;}
    public boolean getEndGame() {return endGame;}
    public Grid getGrid() {return grid;}

    public void setReset(boolean bool) {reset=bool;}
    public void setEndGame(boolean bool) {endGame=bool;}


    @Override
    public void setPanel() {

        clear();
        currentPlayerLabel = new DBLabel();
        endGame = false;
        reset = false;
        labels= new LabelsList();


        gridSetter = new GridSetter(boxesRows,boxesColumns);

        PlayersLabelSetter.setLabels(this,targetGame.getPlayers(), BACKGROUND_PANEL);

        ButtonInserter.addEndButton(this, BACKGROUND_PANEL);
        ButtonInserter.addResetButton(this, BACKGROUND_PANEL);

        CurrentPlayerLabel.setPosition(BACKGROUND_PANEL,currentPlayerLabel);

        gridSetter.lines(this, BACKGROUND_PANEL);

        gridSetter.dots(this,BACKGROUND_PANEL);

        gridSetter.boxes(this,BACKGROUND_PANEL);

        updatePanel();
    }


    @Override
    public Move getInput() {

        waitInput();
        return currentMove;
    }



    public void updateFrame(Game game) {

        CurrentPlayerLabel.setName(game, currentPlayerLabel);

        if(currentMove!=null) gridSetter.paintLine(currentMove,this);

        ScoreLabels.setLabels(game, labels);

        gridSetter.paintBox(game,this);

        updatePanel();

    }


    public void resetFrame(BackgroundPanel backgroundPanel) {
        clear();
    }


    public void setCurrentMove(Move currentMove) {
        this.currentMove = currentMove;
    }


}



class ButtonInserter {

    public static void addEndButton(GameFrame gameFrame, BackgroundPanel backgroundPanel) {
        DBTextButton endGameButton = new DBTextButton("END GAME", new ObjSpecifics(470, 290, 120, 30, 80));

        endGameButton.addActionListener(x ->
        {
            gameFrame.setEndGame(true);
            gameFrame.setInputGiven(true);
            endGameButton.setDark();

        });
        backgroundPanel.add(endGameButton);
    }

    public static void addResetButton(GameFrame gameFrame, BackgroundPanel backgroundPanel) {

        DBTextButton resetGameButton = new DBTextButton("RESET GAME",new ObjSpecifics(470, 330, 120, 30,80));

        resetGameButton.addActionListener(x ->
        {
            gameFrame.setReset(true);
            gameFrame.setInputGiven(true);
            resetGameButton.setDark();
        });

        backgroundPanel.add(resetGameButton);
    }

}
