package io.zipcoder.casino;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
//        ArrayList<Player> players = Players.getInstance().playerList;
        for (Player player : Players.getInstance().playerList)
        System.out.println(Players.getInstance().playerList);
    }

    @Test
    public void removePlayer() {
    }
}