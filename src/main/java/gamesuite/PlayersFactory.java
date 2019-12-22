package gamesuite;

public class PlayersFactory {

    private Integer numberOfPlayers = 1;

    public Player newPlayer(String name){

        numberOfPlayers++;
        return new Player(name);
    }

    public Player newPlayer(){

        return new Player((numberOfPlayers++).toString());
    }
}
