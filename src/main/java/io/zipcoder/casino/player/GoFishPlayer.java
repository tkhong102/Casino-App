package io.zipcoder.casino.player;

import io.zipcoder.casino.cardgames.cards.CardHand;

public class GoFishPlayer {
    private CardHand hand;

    Player goFishPlayer;

    public GoFishPlayer(Player player) {
        this.goFishPlayer = player;
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
