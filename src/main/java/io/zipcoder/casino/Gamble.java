package io.zipcoder.casino;

public interface Gamble {
    public void placeBet();

    void evaluateBet(Player player, long payout);
}
