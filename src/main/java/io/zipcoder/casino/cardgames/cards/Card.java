package io.zipcoder.casino.cardgames.cards;

public final class Card {

    private CardSuit suit;
    private CardValue cardValue;
    private String card;

    public Card (CardValue cardValue, CardSuit suit){
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public CardSuit getSuit(){
        return suit;
    }

    public CardValue getCardValue(){
        return cardValue;
    }

    public String getCard() {
        return cardValue + " of " + suit.getCardGraphic();
    }

}