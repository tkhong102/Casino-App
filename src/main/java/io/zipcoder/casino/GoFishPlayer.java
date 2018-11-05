package io.zipcoder.casino;

public class GoFishPlayer {
    private CardHand hand;

    Player goFishPlayer;

    public GoFishPlayer(Player player) {
        this.goFishPlayer = player;
    }

    public CardHand getHand() {
        return hand;
    }

    public void setHand(CardHand hand) {
        this.hand = hand;
    }
}
