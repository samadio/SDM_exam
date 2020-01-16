package gamesuite.players;

import java.util.ArrayList;

public class PlayersFactory {

    private Integer numberOfPlayers = 1;
    private ArrayList<String> usedCustomNames= new ArrayList<>();


    public Player newPlayer(String name) throws NameAlreadyUsedException, ReservedNameException {
        if(usedCustomNames.contains(name)) throw new NameAlreadyUsedException();
        boolean isNumeric = name.trim().chars().allMatch( Character::isDigit );
        if(isNumeric) throw new ReservedNameException();
        numberOfPlayers++;
        usedCustomNames.add(name);
        return new Player(name);
    }

    public Player newPlayer() {
        return new Player((numberOfPlayers++).toString());
    }
}