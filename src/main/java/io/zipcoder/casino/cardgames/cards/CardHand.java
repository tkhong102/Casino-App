package io.zipcoder.casino.cardgames.cards;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;

public class CardHand extends ArrayList<Card> {

    int numberOfCards = this.size();
//    private java.util.ArrayList<Card> cardHand;
//
//    public CardHand(int numberOfCards) {
//        this.numberOfCards = numberOfCards;
//    }
//
//    public CardHand() {
//
//    }

//    public void addCard(Card card) {
//        add(card);
//    }
//
//    public void removeCard(Card card) {
//        remove(card);
//
//    }

    public String display() {
        String result = "";
        for (Card each : this)
            result = each.getCardValue() + " of " + each.getSuit();
        Console.println(result);
        return result;
    }

    public Card getCard(int position){

        return cardHand.get(position);

    }

    public int getSize() {
        return cardHand.size();
    }
    

}