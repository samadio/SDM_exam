package gamesuite.players;

import java.util.ArrayList;

public class PlayersFactory {

    private Integer numberOfPlayers = 0;
    private ArrayList<String> usedCustomNames= new ArrayList<>();


    public Player newPlayer(String name) throws NameAlreadyUsedException, ReservedNameException {

        name = name.trim();

        if(name.isEmpty()){

            numberOfPlayers += 1;
            return newPlayer();
        }

        checkNameValidity(name);

        numberOfPlayers += 1;
        usedCustomNames.add(name);
        return new Player(name);
    }

    public Player newPlayer() {
        numberOfPlayers += 1;
        return new Player((numberOfPlayers).toString());
    }

    private void checkNameValidity(String name) throws NameAlreadyUsedException, ReservedNameException {

        if(nameAlreadyUsed(name))
            throw new NameAlreadyUsedException("Error: name already taken. Please select a different one");

        if(isNumericName(name))
            throw new ReservedNameException("Error: Integer numbers cannot be chosen as names");
    }

    private boolean nameAlreadyUsed(String name){
        return usedCustomNames.contains(name);
    }

    private boolean isNumericName(String name){

        return name.chars().allMatch( Character::isDigit );
    }
}