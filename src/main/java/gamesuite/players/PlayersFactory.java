package gamesuite.players;

import java.util.ArrayList;

public class PlayersFactory {

    private Integer numberOfPlayers = 0;
    private ArrayList<String> usedNames= new ArrayList<>();

    public Player newPlayer(String name) throws NameAlreadyUsedException {
        if(usedNames.contains(name)) throw new NameAlreadyUsedException();
        numberOfPlayers+=1;
        usedNames.add(name);
        return new Player(name);
    }

    public Player newPlayer() throws NameAlreadyUsedException {
        if(usedNames.contains(String.valueOf(numberOfPlayers+1))) throw new NameAlreadyUsedException();
        numberOfPlayers+=1;
        usedNames.add(String.valueOf(numberOfPlayers));
        return new Player((numberOfPlayers).toString());
    }
}