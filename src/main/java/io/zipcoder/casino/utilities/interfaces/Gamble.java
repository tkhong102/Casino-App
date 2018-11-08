package io.zipcoder.casino.utilities.interfaces;

import io.zipcoder.casino.player.Player;

public interface Gamble {
    public void placeBet(Player player);

    void evaluateBet(Player player, long payout);
}
