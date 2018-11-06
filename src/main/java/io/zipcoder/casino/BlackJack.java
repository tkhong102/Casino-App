package io.zipcoder.casino;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Vector;

public class BlackJack extends CardGame implements Gamble {
    long upcardsValue = 0;

    private Deck deck = new Deck();
    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();
    BlackJackPlayer blackJackPlayer = new BlackJackPlayer();
    ArrayList<CardHand> cardHands;

    public BlackJack(){
        readyPlayers();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().playerList) {
            blackJackPlayers.add(new BlackJackPlayer(player));
        }
    }

    public void dealCards(BlackJackPlayer player, int numberOfCards) {
        dealerHand.cardHand.add(); //deals 2 cards for dealer

        for(BlackJackPlayer p: blackJackPlayers){ //deal 2 cards to each player
            super.dealCards(p, 2);
        }
    }

    public void drawCard() {
        // draws card from deck and adds it to "upcard" total
        dealerHand.cardHand.add(deck.deckOfCards.get(0));
        deck.deckOfCards.remove(0);

        upcardsValue += dealerHand.cardHand.(0);
//        System.out.println("You have the following cards");
//        for(CardHand c:cardHands){
//            System.out.println(c);
//        }
    }

    public void evaluateDealerHand() {
        int cardSum = 0;
        boolean ace = false;

        for (Card card : dealerHand) {
            cardSum += card.getCardValue;
        }

        if (cardSum < 17) {
            drawCard();
        } else if (cardSum > 21) {
//            currentPlayer.win <- WE WILL FIGURE THIS PART OUT LATER
        } else {
            //player has opportunity to hit or stay
        }
    }

    public long placeBet(long currentBet) {
        return blackJackPlayer.getChipBalance() - currentBet;
    }


    public void getSum(ArrayList<CardHand> cardHands) {
        int cardSum = 0;
        boolean ace = false;

        for (int i = 0; i < cardHands.size(); i++) {
            int cardValue = cardHands.getCardValue(i);

            if (cardValue > 10) {
                cardValue = 10;   // For a Jack, Queen, or King.
            }
            if (cardValue == 1) {
                ace = true;
            }
            cardSum = cardSum + cardValue;
        }
        if (ace == true && cardSum + 10 <= 21) {
            cardSum = cardSum + 10;
        }

    }

    public void evaluateBet(BlackJackPlayer player, long payout){

    }

    public int revealCard(CardHand cardHand, int index){
        return cardHand.getCardValue(index);
    }

    public void evaluatePlayerHand(){

        while (true){
            System.out.println("You have:");
            for (int i = 0; i < cardHands.size(); i++) {
                System.out.println(" " + revealCard(cardHand, i));
            }
            System.out.println("The dealer is showing a " + revealCard(dealerHand,0));
            System.out.println("Would you like to Hit (H) or Stand (S)?");
        }
        // print player's cardHands and sum
        //if player has blackjack (ace + face)
        //show dealer's card, player win or tie?

        //while player's sum is <21
        //prompt player to "Stand" or "Hit"




    }

    public void run(){
        boolean quit = false;
        while (quit == false) {
            drawCard();



            // at the end of each loop, ask players if they would like to continue
        }
    }


}
