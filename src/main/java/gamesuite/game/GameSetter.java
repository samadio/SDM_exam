package gamesuite.game;

import gamesuite.board.BoardManager;
import gamesuite.move.MoveValidator;
import gamesuite.players.NameAlreadyUsedException;
import gamesuite.players.Player;
import gamesuite.players.PlayersFactory;
import gamesuite.players.ReservedNameException;
import gamesuite.status.GameStatus;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import java.util.ArrayList;
import java.util.List;

public abstract class GameSetter {

    private final InputManager iManager;
    private final OutputManager oManager;

    public GameSetter(InputManager iManager, OutputManager oManager){

        this.iManager = iManager;
        this.oManager = oManager;
    }

   public final Game newGame(){

       List<Player> players = setPlayers();
       BoardManager bManager = createBoard();
       MoveValidator mValidator = setValidator(bManager);
       GameStatus gStatus = setStatus(players, bManager, mValidator);

       return new Game(iManager, oManager, bManager, mValidator, gStatus, players);
   }

    private BoardManager createBoard(){

        List<Integer> dimensions = iManager.getGridDimensions(); //function that asks for grid dimensions and returns it
        return  setBoard(dimensions.get(0), dimensions.get(1));
    }

    private List<Player> setPlayers(){

        Integer nPlayers = iManager.getPlayersNumber(); //how many players are there?

        List<Player> players = new ArrayList<>(nPlayers);
        PlayersFactory playerGenerator= new PlayersFactory();

        boolean custom = iManager.customPlayers(); //do you want to customize Players name? Yes=True
        if (custom) {
            int idx=0;
            while(idx < nPlayers) {

                String name = iManager.getPlayerName();
                try {
                    if (name.isEmpty()) {
                        oManager.outputPrintln("You were assigned the name: "+(idx+1));
                        players.add(idx, playerGenerator.newPlayer());
                        idx++;
                    }
                    else {
                        players.add(idx, playerGenerator.newPlayer(name));
                        idx++;
                    }
                }catch(NameAlreadyUsedException e){
                    oManager.errorPrintln("Error: name already taken. Please select a different one");
                }
                catch (ReservedNameException e){
                    oManager.errorPrintln("Error: Integer numbers cannot be chosen as names");
                }
            }
        }
        else{
            for (int i=0;i<nPlayers;i++){
                players.add(i, playerGenerator.newPlayer());
            }
        }

        return players;
    }

    protected abstract GameStatus setStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator);

    protected abstract MoveValidator setValidator(BoardManager bManager);

    protected abstract BoardManager setBoard(Integer rows, Integer cols);
}
