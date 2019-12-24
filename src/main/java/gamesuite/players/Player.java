package gamesuite.players;

import java.util.Objects;

public class Player {

    private final String PLAYER_NAME;

    Player(String name){

        PLAYER_NAME = name;
    }

    public String getName(){

        return PLAYER_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(PLAYER_NAME, player.PLAYER_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PLAYER_NAME);
    }
}
