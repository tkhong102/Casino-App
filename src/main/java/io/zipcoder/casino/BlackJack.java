package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJack extends CardGame implements Gamble {
    private Deck deck = new Deck();
    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();

    public BlackJack(){
        readyPlayers();
    }

    public void readyPlayers() {
        blackJackPlayers.addAll(Players.getInstance().playerList);
    }

    public void dealCards(Player player, int numberOfCards) {

    }

    public void revealCard() {

    }

    public void placeBet() {

    }

    public void evaluateBet(Player player, long payout){
        
    }
}
