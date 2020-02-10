package dotsandboxes.gui.frames;


import dotsandboxes.gui.components.DBbuttons.board.*;
import dotsandboxes.gui.components.DBlabels.labelSetters.CurrentPlayerLabel;
import dotsandboxes.gui.components.DBlabels.labelSetters.PlayersLabelSetter;
import dotsandboxes.gui.components.DBlabels.labelSetters.ScoreLabels;
import dotsandboxes.gui.components.BackgroundPanel;
import dotsandboxes.gui.components.DBbuttons.DBTextButton;
import dotsandboxes.gui.components.DBlabels.DBLabel;
import dotsandboxes.gui.components.DBbuttons.board.Board;
import dotsandboxes.gui.components.DBlabels.LabelsList;
import dotsandboxes.gui.components.ObjSpecifics;
import gamesuite.game.Game;
import gamesuite.move.Move;


public class GameFrame extends InputFrame<Move> {

    private BoardManager boardManager;

    private DBLabel currentPlayerLabel;
    private Move currentMove;
    private LabelsList labels;
    private boolean endGame;
    private boolean reset;
    private Integer boxesRows;
    private Integer boxesColumns;
    private Board board;
    private Game targetGame;


    public GameFrame(BackgroundPanel bP, Game game) {

        super(bP);
        board =new Board();
        boxesRows=game.getBoard().getRows()-1;
        boxesColumns=game.getBoard().getColumns()-1;

        targetGame = game;
    }

    public Integer getBoxesRows() {return boxesRows;}
    public Integer getBoxesColumns() {return boxesColumns;}
    public LabelsList getLabels() {return labels;}
    public boolean getReset() {return reset;}
    public boolean getEndGame() {return endGame;}
    public Board getBoard() {return board;}

    public void setReset(boolean bool) {reset=bool;}
    public void setEndGame(boolean bool) {endGame=bool;}


    @Override
    public void setPanel() {
        System.out.println("chiamato");
        clear();
        currentPlayerLabel = new DBLabel();
        endGame = false;
        reset = false;
        labels= new LabelsList();


        boardManager = new BoardManager(boxesRows,boxesColumns);

        PlayersLabelSetter.setLabels(this,targetGame.getPlayers(), BACKGROUND_PANEL);

        ButtonInserter.addEndButton(this, BACKGROUND_PANEL);
        ButtonInserter.addResetButton(this, BACKGROUND_PANEL);

        CurrentPlayerLabel.setPosition(BACKGROUND_PANEL,currentPlayerLabel);

        boardManager.createLines(this, BACKGROUND_PANEL);

        boardManager.createDots(this,BACKGROUND_PANEL);

        boardManager.createBoxes(this,BACKGROUND_PANEL);

        updatePanel();
    }


    @Override
    public Move getInput() {

        waitInput();
        return currentMove;
    }



    public void updateFrame(Game game) {

        CurrentPlayerLabel.setName(game, currentPlayerLabel);

        if(currentMove!=null) boardManager.paintLine(currentMove,this);

        ScoreLabels.setLabels(game, labels);

        boardManager.paintBox(game,this);

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
            synchronized (gameFrame) {
                gameFrame.notify();
            }
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
            synchronized (gameFrame){
                gameFrame.notify();
            }
            resetGameButton.setDark();
        });

        backgroundPanel.add(resetGameButton);
    }

}
