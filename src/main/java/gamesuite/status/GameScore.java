package gamesuite.status;

import gamesuite.players.Player;

import java.util.HashMap;

public class GameScore extends HashMap<Player, Integer> {

    public void reset() {

        this.keySet().stream().forEach(x -> this.replace(x, 0));
    }
}
