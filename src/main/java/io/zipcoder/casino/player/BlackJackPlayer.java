package io.zipcoder.casino.player;

import io.zipcoder.casino.cardgames.cards.CardHand;

public class BlackJackPlayer {
    private CardHand hand;

    Player blackJackPlayer;

    public BlackJackPlayer(Player player) {
        this.blackJackPlayer = player;
    }

    public void hit(Player player) {
    }

    public void stay(Player player) {
    }

    public Player getP() {
        return blackJackPlayer;
    }

    public CardHand getHand() {
        return hand;
    }

    public void setHand(CardHand hand) {
        this.hand = hand;
    }

}
