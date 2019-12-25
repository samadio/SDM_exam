package gamesuite.game;

import gamesuite.board.Board;
import gamesuite.board.BoardManager;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.players.PlayersFactory;
import gamesuite.status.GameStatus;
import iomanagement.InputManager;

import java.util.ArrayList;

public class Game {

    private final Integer ROWS;
    private final Integer COLUMNS;
    private InputManager iManager;
    private BoardManager boardManager;
    private MoveValidator validator;
    private GameStatus status;
    private OutputManager oManager;
    private ArrayList<Player> players;

    public Game(BoardManager boardManager, MoveValidator validator, GameStatus status, InputManager iManager, OutputManager oManager){
        this.boardManager=boardManager;
        this.validator=validator;
        this.status=status;
        this.iManager=iManager;
        this.oManager = oManager;
        this.status=status;
    }

    private void setGrid() {
        ArrayList<Integer> dimensions = iManager.getGrid(); //function that asks for grid dimensions and returns it
        this.ROWS = dimensions[0];
        this.COLUMNS = dimensions[1];
        this.boardManager = new boardManager(ROWS, COLUMNS);
    }

    private void setPlayers() {
        Integer number = iManager.getPlayersNumber(); //how many players are there?
        this.players= new ArrayList<Player>(number);

        PlayersFactory playerGenerator= new PlayersFactory();
        boolean costumize = iManager.customizePlayers(); //do you want to customize Players name? Yes=True
        if (costumize) {
            for (Integer i = 0; i < number ; i++) {
                String name = iManager.getCustomName();
                if (name.isEmpty()) players[i]=playerGenerator.newPlayer();
                else players.set(i, playerGenerator.newPlayer(name));
            }
        }
        //no custom
        else{
            for(Integer i=0;i<number;i++) players[i]=playerGenerator.newPlayer();
        }
    }


    public void start(){
        setGrid();
        setPlayers();
    }



        public boolean notEnded();

}
