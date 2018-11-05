package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJackPlayer {
    ArrayList<Player> blackJackPlayers = Players.getInstance().playerList;

    public BlackJackPlayer() {
        for (Object player : Players.getInstance().playerList) blackJackPlayers.add((Player) player);
    }

    public void hit(Player player) {
    }

    public void stay(Player player) {

    }

}
