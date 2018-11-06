package io.zipcoder.casino;

public interface Gamble {
    public int placeBet();

    void evaluateBet(Player player, long payout);

}
