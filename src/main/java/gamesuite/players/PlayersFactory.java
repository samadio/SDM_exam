package gamesuite.players;

import java.util.HashMap;

public class PlayersFactory {

    private Integer numberOfPlayers = 1;
    private NamesOccurrencies names= new NamesOccurrencies();

    public Player newPlayer(String name){
        numberOfPlayers++;

        if (names.containsKey(name)){
            Integer newValue= names.get(name)+1;
            names.replace(name,newValue);
            name+=" "+newValue.toString();
        }
        else names.put(name,1);
        return new Player(name);
    }

    public Player newPlayer(){
        return new Player((numberOfPlayers++).toString());
    }
}

class NamesOccurrencies extends HashMap<String, Integer>{}