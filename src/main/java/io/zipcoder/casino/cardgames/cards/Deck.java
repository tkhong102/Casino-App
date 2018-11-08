package io.zipcoder.casino.cardgames.cards;

import io.zipcoder.casino.utilities.Console;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Deck extends ArrayDeque<Card> {
    // private ArrayList<Card> deck;

    public Deck(){
        ArrayList<Card> freshDeck = new ArrayList<>();
        for (int i = 0; i < 13; i++){
            CardValue value = CardValue.values()[i];

            for (int j =0; j < 4;j++){
                Card card = new Card (value, CardSuit.values()[j]);
                freshDeck.add(card);
            }
        }

        Collections.shuffle(freshDeck);

        this.addAll(freshDeck);

//        for (Card aCard : this) {
//            Card oneCard = aCard;
//
////            Console.println(oneCard.getCardValue() + " of " + oneCard.getSuit());
////            CardValue.values();
//
//        }
    }

    public static void main(String[] args) {
//        CardValue[] cards = CardValue.values();
//        for (CardValue value : cards) {
//            System.out.println(value.getCardValue());
//        }
        Deck deck = new Deck();
        int cardCount = 0;
        for (Card card : deck) {
            cardCount++;
//            System.out.println(card.getCardValue() + " " + card.getSuit());
        }

    }


}
