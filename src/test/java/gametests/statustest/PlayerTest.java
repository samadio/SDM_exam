package gametests.statustest;

import gamesuite.players.NameAlreadyUsedException;
import gamesuite.players.Player;
import gamesuite.players.PlayersFactory;
import gamesuite.players.ReservedNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void noExceptionThrown(){
        PlayersFactory pFactory = new PlayersFactory();
        assertDoesNotThrow(()->pFactory.newPlayer());
        assertDoesNotThrow(()->pFactory.newPlayer("Pluto1996"));
    }

    @Test
    void ExceptionsThrown(){
        PlayersFactory pFactory = new PlayersFactory();
        assertDoesNotThrow(()->pFactory.newPlayer("Pippo"));
        assertThrows(NameAlreadyUsedException.class,()->pFactory.newPlayer("Pippo"));
        assertThrows(ReservedNameException.class,()->pFactory.newPlayer(" 10000000 "));
    }

    @Test
    void defaultNameTest(){

        PlayersFactory pFactory = new PlayersFactory();
        Player p1 = pFactory.newPlayer();
        Player p2 = pFactory.newPlayer();

        assertEquals("1" , p1.getName());
        assertEquals("2" , p2.getName());
    }

    @Test
    void customNameTest() throws NameAlreadyUsedException, ReservedNameException {

        PlayersFactory pFactory = new PlayersFactory();
        Player p1 = pFactory.newPlayer("Federico");
        Player p2 = pFactory.newPlayer("Simone");
        Player p3 = pFactory.newPlayer("Andrea");

        assertEquals("Federico" , p1.getName());
        assertEquals("Simone" , p2.getName());
        assertEquals("Andrea" , p3.getName());
    }

}