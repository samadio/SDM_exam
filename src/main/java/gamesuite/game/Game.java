package gamesuite.game;

import gamesuite.board.Board;
import gamesuite.board.BoardManager;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.players.PlayersFactory;
import gamesuite.status.GameStatus;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import java.util.ArrayList;
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




    public void start(){

        /*GAMEPLAY CODE HERE*/
    }

    public boolean notEnded(){

        return status.isNotFinished();
    }

}
