package gametests.statustest;

import gamesuite.Player;
import gamesuite.PlayersFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void defaultNameTest() {

        PlayersFactory pFactory = new PlayersFactory();
        Player p1 = pFactory.newPlayer();
        Player p2 = pFactory.newPlayer();

        assertEquals("1" , p1.getName());
        assertEquals("2" , p2.getName());
    }

    @Test
    void customNameTest() {

        PlayersFactory pFactory = new PlayersFactory();
        Player p1 = pFactory.newPlayer("Federico");
        Player p2 = pFactory.newPlayer("Simone");
        Player p3 = pFactory.newPlayer("Andrea");

        assertEquals("Federico" , p1.getName());
        assertEquals("Simone" , p2.getName());
        assertEquals("Andrea" , p3.getName());
    }
}