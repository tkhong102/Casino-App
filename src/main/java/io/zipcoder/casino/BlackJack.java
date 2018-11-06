package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Vector;

public class BlackJack extends CardGame implements Gamble {
    private Deck deck = new Deck();
    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();
    private Vector cardHands;
    private Vector dealerHands;

    public BlackJack(){
        readyPlayers();
    }

    public void readyPlayers() {
        blackJackPlayers.addAll(Players.getInstance().playerList);
    }

    public void dealCards(BlackJackPlayer player, int numberOfCards) {
        for(BlackJackPlayer p: blackJackPlayers){
            super.dealCards(p, 2);
        }
    }

    public void revealCard(ArrayList<CardHand> cardHands) {

    }

    public void placeBet() {

    }

    public void winBet() {

    }

    public void loseBet() {

    }

    public int getValue(ArrayList<CardHand> cardHands){
        int value = 0;
        boolean ace = false;
        int cards= cardHands.size();

        for (int i = 0; i < cards; i++) {
            int cardValue;
            i = getCard(cardHands,i);
            cardValue = getCardValue(i);

            if (cardValue > 10)
            {
                cardValue = 10;   // For a Jack, Queen, or King.
            }
            if (cardValue == 1)
            {
                ace = true;     // There is at least one ace.
            }
            value = value + cardValue;
        }
        if (ace == true && value + 10 <= 21)
        {
            value = value + 10;
        }
        return value;

    }

    public int getCardValue(int numberOfCards){
        int result = Card;
        switch(Card){
            case 11: result = 10;
            case 12: result = 10;
            case 13: result = 10;
        }
        return result;
    }

    public int getCard(Vector cardHands, int position) {
        if (position >= 0 && position < cardHands.size())
        {
            return ((Integer)cardHands.elementAt(position)).intValue();
        } else
        {
            return 0;
        }
    }

}
