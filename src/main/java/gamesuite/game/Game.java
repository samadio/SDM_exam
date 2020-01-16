package gamesuite.game;

import gamesuite.board.AbstractBoard;
import gamesuite.board.BoardManager;
import gamesuite.move.*;
import gamesuite.players.Player;
import gamesuite.status.GameScore;
import gamesuite.status.GameStatus;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import java.util.List;

public class Game {

    private InputManager iManager;
    private BoardManager boardManager;
    private MoveValidator validator;
    private GameStatus status;
    private OutputManager oManager;
    private List<Player> players;

    public Game(InputManager iManager, OutputManager oManager, BoardManager bManager, MoveValidator mValidator, GameStatus gStatus, List<Player> players){
        this.iManager=iManager;
        this.oManager = oManager;
        this.boardManager = bManager;
        this.validator = mValidator;
        this.status = gStatus;
        this.players = players;
    }

    public void play(){

        oManager.printGame(this);

            while (notEnded()) {

                try {
                    boolean invalidMove = true;
                    iManager.readMove();
                    Move m = iManager.getMove();

                    while (invalidMove) {
                        try {
                            validator.validateMove(m);
                            invalidMove = false;
                        } catch (InvalidMoveException e) {

                            oManager.printInvalidMove(e);
                            iManager.readMove();
                            m = iManager.getMove();
                        }
                    }


                    boardManager.updateBoard(m);
                    status.update(m);

                    oManager.printGame(this);
                }
                catch (EndGameException e) {
                    oManager.outputPrintln("The game has been manually ended");
                    oManager.printWinner(this);
                    return;
                }
                catch (ResetGameException e){
                    oManager.outputPrintln("The game has been reset...");
                    this.reset();
                    oManager.printGame(this);
                }
            }
        oManager.printWinner(this);
    }



    public GameScore getScore(){  return status.getScore(); }

    public List<Player> getPlayers(){
        return players;
    }

    public Player nextPlayer(){  return status.currentPlayer(); }

    public boolean notEnded(){   return status.isNotFinished(); }

    public AbstractBoard getBoard(){
        return boardManager.getBoard();
    }

    public void reset(){
        status.reset();
        boardManager.reset();
    }

    public List<Player> getWinner(){  return status.getWinner(); }
}
