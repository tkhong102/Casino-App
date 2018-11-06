package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.List;

public class Players<Player> {

    private final static Players INSTANCE = new Players();
    ArrayList<Player> playerList = new ArrayList<Player>();

    private Players(Player player) {
        playerList.add(player);
    }

    private Players(Player ... players) {
        for (Player player : players) {
            playerList.add(player);
        }
    }

    public Players() {
    }

    public static Players getInstance() {
        return INSTANCE;
    }


    public void addPlayer(Player player) {
        playerList.add(player);
    }
    public void addPlayers(Player ... players) {
        for (Player player : players) {
            playerList.add(player);
        }
    }


    public void removePlayer(final Player player) {
        playerList.removeIf(Player -> Player.equals(player));
    }

}
