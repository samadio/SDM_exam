package gamesuite.game;

import gamesuite.board.BoardHandle;
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
    private Boolean endedWithException = false;

    public Game(InputManager iManager, OutputManager oManager, BoardManager bManager, MoveValidator mValidator, GameStatus gStatus, List<Player> players){
        this.iManager = iManager;
        this.oManager = oManager;
        this.boardManager = bManager;
        this.validator = mValidator;
        this.status = gStatus;
        this.players = players;
    }

    public void play(){

        oManager.startMatch(this);

        oManager.printGame(this);

        while (notEnded()) {

            try {
                boolean invalidMove = true;

                Move m = iManager.getMove();

                while (invalidMove) {
                    try {
                        validator.validateMove(m);
                        invalidMove = false;
                    } catch (InvalidMoveException e) {
                        oManager.printInvalidMove(e);

                        m = iManager.getMove();
                    }
                }

                boardManager.updateBoard(m);
                status.update(m);

                oManager.printGame(this);
            }
            catch (EndGameException e) {
                endedWithException = true;
                break;
            }
            catch (ResetGameException e){
                this.reset();
                oManager.startMatch(this);
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

    private boolean notEnded(){   return status.isNotFinished(); }

    public BoardHandle getBoard(){
        return boardManager.getBoard();
    }

    public void reset(){
        status.reset();
        boardManager.reset();
        endedWithException = false;
    }

    public List<Player> getWinner(){  return status.getWinner(); }

    public Boolean endedManually(){ return endedWithException; }
}
