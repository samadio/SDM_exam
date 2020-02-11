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
import java.util.stream.IntStream;

public abstract class GameFactory {

    private final InputManager iManager;
    private final OutputManager oManager;

    public GameFactory(InputManager iManager, OutputManager oManager){

        this.iManager = iManager;
        this.oManager = oManager;
    }

   public final Game newGame() {

        oManager.initialMessage();
        List<Player> players = setPlayers();
        BoardManager bManager = createBoard();
        MoveValidator mValidator = setValidator(bManager);
        GameStatus gStatus = setStatus(players, bManager, mValidator);

       return new Game(iManager, oManager, bManager, mValidator, gStatus, players);
   }

    private BoardManager createBoard(){
        List<Integer> dimensions = iManager.getGridDimensions();
        return  setBoard(dimensions.get(0), dimensions.get(1));
    }

    private List<Player> setPlayers(){

        Integer nPlayers = iManager.getPlayersNumber();
        List<Player> players = new ArrayList<>(nPlayers);
        PlayersFactory playerGenerator= new PlayersFactory();

        boolean custom = iManager.customPlayers();
        if (custom) {
            int idx = 0;
            while(idx < nPlayers) {

                String name = iManager.getPlayerName();
                try {

                    Player newPlayer = playerGenerator.newPlayer(name);
                    players.add(newPlayer);
                    oManager.outputMessage("You were assigned the name: " + newPlayer);
                    idx++;

                }catch(NameAlreadyUsedException | ReservedNameException e){
                    oManager.errorMessage(e.getMessage());
                }
            }
        }
        else  IntStream.range(0, nPlayers).forEach(x -> players.add(playerGenerator.newPlayer()));

        return players;
    }

    protected abstract GameStatus setStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator);

    protected abstract MoveValidator setValidator(BoardManager bManager);

    protected abstract BoardManager setBoard(Integer rows, Integer cols);
}
