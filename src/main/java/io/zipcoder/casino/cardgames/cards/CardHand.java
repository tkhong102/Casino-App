package io.zipcoder.casino.cardgames.cards;

public class CardHand {

    int numberOfCards;
    protected java.util.ArrayList<Card> cardHand;

    public CardHand(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public CardHand() {
    }

    public Card getCard(int position){

        return cardHand.get(position);

    }

}
