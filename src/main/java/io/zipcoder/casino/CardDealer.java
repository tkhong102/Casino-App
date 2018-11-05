package io.zipcoder.casino;

public interface CardDealer {

    Deck deck = new Deck();
    CardHand hand = new CardHand();

    void dealCards(Player player, int numberOfCards);

    void revealCard();

}
