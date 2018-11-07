package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.cards.Deck;
import io.zipcoder.casino.utilities.Gamble;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;

import java.util.ArrayList;

public class BlackJack extends CardGame implements Gamble {
    private Deck deck = new Deck();
    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();

    public BlackJack(){
        readyPlayers();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
            blackJackPlayers.add(new BlackJackPlayer(player));
        }
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
