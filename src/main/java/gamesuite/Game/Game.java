package gamesuite.Game;

import gamesuite.board.Board;
import gamesuite.board.BoardManager;
import gamesuite.move.Move;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.players.PlayersFactory;
import gamesuite.status.GameScore;
import iomanagement.InputManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    /*
    private InputManager imanager;
    private BoardManager boardManager;
    private MoveValidator validator;
    private GameStatus status;
    private OutputManager outmanager;
    private ArrayList<Player> players;

    public Game(Board boardManager, MoveValidator validator,GameStatus status,InputManager imanager){
        this.boardManager=boardManager;
        this.validator=validator;
        this.status=status;
        this.imanager=imanager;
        this.status=status;
    }

    private void setGrid() {
        int m, n;
        Array<Integer> dimensions = imanager.getGrid(); //function that asks for grid dimensions and returns it
        n = dimensions[0];
        m = dimensions[1];
        this.boardManager = new boardManager(n, m);
    }

    private void setPlayers() {
        Integer number = imanager.getPlayersNumber(); //how many players are there?
        this.players= new ArrayList<Player>(number);

        PlayersFactory playerGenerator= new PlayersFactory();
        boolean costumize = imanager.customizePlayers(); //do you want to customize Players name? Yes=True
        if (costumize) {
            for (Integer i = 0; i < number ; i++) {
                String name = imanager.getCustomName();
                if (name.isEmpty()) players[i]=playerGenerator.newPlayer();
                else players[i]=playerGenerator.newPlayer(name);
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
 */
}
