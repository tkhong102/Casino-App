package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJack extends CardGame implements Gamble {
    private Deck deck = new Deck();
    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();

    public BlackJack(){
        readyPlayers();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().playerList) {
            blackJackPlayers.add(new BlackJackPlayer(player));
        }
    }
    public void dealCards(Player player, int numberOfCards) {

    }

    public void revealCard() {

    }

    public void placeBet() {

    }

    public void winBet() {

    }

    public void loseBet() {

    }
}
