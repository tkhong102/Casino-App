package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList();
        for (int i = 0; i < 13; i++){
            CardValue value = CardValue.values()[i];

            for (int j =0; j < 4;j++){
                Card card = new Card (value, CardSuit.values()[j]);
                this.deck.add(card);
            }
        }

//        Collections.shuffle(deck);

        for (Card aCard : deck) {
            Card oneCard = aCard;

            System.out.println(oneCard.getCardValue() + " of " + oneCard.getSuit());
//            CardValue.values();
        }
    }

    public static void main(String[] args) {
//        CardValue[] cards = CardValue.values();
//        for (CardValue value : cards) {
//            System.out.println(value.getCardValue());
//        }
        Deck deck = new Deck();
        for (Card card : deck.deck) {
//            System.out.println(card.getCardValue() + " " + card.getSuit());
        }
    }

}
