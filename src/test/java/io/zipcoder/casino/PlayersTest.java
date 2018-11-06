package io.zipcoder.casino;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayersTest {

    Player player1 = new Player("Bobbert");
    Player player2 = new Player("Nedmond");
    Player player3 = new Player("Beauseph");


    @Before
    public void getInstance() {
        Players.getInstance().addPlayers(player1,player2,player3);
    }

    @Test
    public void addPlayer() {
        Assert.assertTrue(Players.getInstance().playerList.size() == 3);
    }

    @Test
    public void removePlayer() {
        Players.getInstance().removePlayer(player1);
        Assert.assertTrue(Players.getInstance().playerList.size() == 2);
    }
}