package gamesuite.players;

import java.util.ArrayList;

public class PlayersFactory {

    private Integer numberOfPlayers = 1;
    private ArrayList<String> usedNames= new ArrayList<>();


    public Player newPlayer(String name) throws NameAlreadyUsedException, ReservedNameException {
        if(usedNames.contains(name)) throw new NameAlreadyUsedException();
        boolean isNumeric = name.trim().chars().allMatch( Character::isDigit );
        if(isNumeric) throw new ReservedNameException();
        numberOfPlayers++;
        usedNames.add(name);
        return new Player(name);
    }

    public Player newPlayer() {
        return new Player((numberOfPlayers++).toString());
    }
}