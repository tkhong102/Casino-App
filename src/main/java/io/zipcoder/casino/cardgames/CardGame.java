package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.utilities.containers.Deck;
import io.zipcoder.casino.utilities.Game;
import io.zipcoder.casino.player.Player;

public abstract class CardGame extends Game {

    Deck deck = new Deck();

    public abstract void dealCards(Player player, int numberOfCards);

    public void playCard() {

    }

    public abstract void dealCards(int numberOfCards);

    void revealCard() {

    }

}
