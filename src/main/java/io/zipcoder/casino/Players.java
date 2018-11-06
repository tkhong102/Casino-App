package io.zipcoder.casino;

import java.util.ArrayList;

public class Players {

    private static Players INSTANCE = null;

    ArrayList<Player> playerList = new ArrayList<>();

    public Players() {
    }

    public static Players getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Players();
        }
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
