package gamesuite.players;

import java.util.ArrayList;

public class PlayersFactory {

    private Integer numberOfPlayers = 0;
    private ArrayList<String> usedCustomNames= new ArrayList<>();


    public Player newPlayer(String name) throws NameAlreadyUsedException, ReservedNameException {
        name = name.trim();
        if(name.isEmpty()) return newPlayer();
        if(usedCustomNames.contains(name)) throw new NameAlreadyUsedException("Error: name already taken. Please select a different one");
        boolean isNumeric = name.trim().chars().allMatch( Character::isDigit );
        if(isNumeric) throw new ReservedNameException("Error: Integer numbers cannot be chosen as names");
        numberOfPlayers += 1;
        usedCustomNames.add(name);
        return new Player(name);
    }

    public Player newPlayer() {
        numberOfPlayers += 1;
        return new Player((numberOfPlayers).toString());
    }
}