package io.zipcoder.casino.utilities;

import io.zipcoder.casino.player.Player;

public interface Gamble {
    public void placeBet();

    void evaluateBet(Player player, long payout);

}
