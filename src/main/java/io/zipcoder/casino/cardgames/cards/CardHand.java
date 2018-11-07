package io.zipcoder.casino.cardgames.cards;

import java.util.ArrayList;

public class CardHand {

    int numberOfCards;
//    private java.util.ArrayList<Card> cardHand;
//
//    public CardHand(int numberOfCards) {
//        this.numberOfCards = numberOfCards;
//    }
//
//    public CardHand() {
//
//    }

    private ArrayList<Card> cardHand = new ArrayList<>();
    private int numberofCards = cardHand.size();

    public void addCard(Card card) {
        cardHand.add(card);

    }

    public void removeCard(Card card) {
        cardHand.remove(card);

    }

    public String display() {
        String result = "";
        for (Card each : cardHand)
            result = each.getCardValue() + " of " + each.getSuit();
        System.out.println(result);
        return result;
    }
}