package io.zipcoder.casino.player;

import io.zipcoder.casino.cardgames.cards.CardHand;

public class BlackJackPlayer{
    private CardHand hand;
    Player blackJackPlayer;
    private long bet;

    public long getBet() {
        return bet;
    }

    public void setBet(long bet) {
        this.bet = bet;
    }

    public BlackJackPlayer() {
    }

    public BlackJackPlayer(Player player) {
        this.blackJackPlayer = player;
        this.hand = new CardHand();
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
