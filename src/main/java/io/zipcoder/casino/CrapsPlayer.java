package io.zipcoder.casino;

public class CrapsPlayer {
    Player crapsPlayer;
    long bet;

    public CrapsPlayer(Player player) {
        this.crapsPlayer = player;
    }

    public CrapsPlayer(Player player, long bet) {
        this.crapsPlayer = player;
        this.bet = bet;
    }

    public long getBet() {
        return bet;
    }
}
