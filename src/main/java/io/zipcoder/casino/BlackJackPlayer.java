package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJackPlayer extends Player{
    private CardHand hand;

    Player blackJackPlayer;

    public BlackJackPlayer() {
    }

    public BlackJackPlayer(Player player) {
        this.blackJackPlayer = player;
    }

    public void hit(Player player) {
    }

    public void stay(Player player) {
    }

    public CardHand getHand() {
        return hand;
    }

    public void setHand(CardHand hand) {
        this.hand = hand;
    }

}
