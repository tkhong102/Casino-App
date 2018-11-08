package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.containers.CardHand;

public class GoFishPlayer extends Player{
    private CardHand hand;

    Player goFishPlayer;

    public GoFishPlayer(Player player) {
        this.goFishPlayer = player;
    }

    public GoFishPlayer() {

    }

    public Player getP() {
        return goFishPlayer;
    }

    public CardHand getHand() {
        return hand;
    }

    public void setHand(CardHand hand) {
        this.hand = hand;
    }
}
