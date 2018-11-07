package io.zipcoder.casino;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Vector;

public class BlackJack extends CardGame implements Gamble {
    long upcardsValue = 0;

    private Deck deck = new Deck();
    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();
    ArrayList<Card> playerHand = new ArrayList<>();
    ArrayList<Card> dealerHand = new ArrayList<>();
    long bet;


    public BlackJack(){

        readyPlayers();
        placeBet();
        run();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().playerList) {
            blackJackPlayers.add(new BlackJackPlayer(player));
        }
    }

    public void run(){
        for(int i = 0; i < blackJackPlayers.size(); i++){
            play(blackJackPlayers.get(i),blackJackPlayers.get(i).getBet());
        }
    }

    public boolean play(BlackJackPlayer currentPlayer, long bet) {

        this.bet = bet;

        dealCards(currentPlayer, 2);

        if (getSum(dealerHand) == 21){
            Console.println("Dealer has " + dealerHand.(0)) + " and " + dealerHand.get(1);
            Console.println(("You have " + playerHand.get(0)) + " and " + playerHand.get(1));
            Console.println("Dealer wins.");
        }

        if (getSum(playerHand) == 21){
            Console.println("Dealer has " + dealerHand.get(0)) + " and " + dealerHand.get(1));
            Console.println(("You have " + playerHand.get(0)) + " and " + playerHand.get(1));
            Console.println("You wins.");
        }

        while(true) {

            Console.println("You have: ");
            for (int i = 0; i < playerHand.size(); i++) {
                Console.println(" " + playerHand.getCardValue(i) + playerHand.getSuit(i));
            }
            Console.println("Dealer is showing a " + dealerHand.getCardValue(0) + " of " + dealerHand.getSuit(0));
            String hitOrStand = Console.getStringInput("Do you want to Hit or Stand? \n Enter H for Hit or S for Stand");

            while (getSum(playerHand) < 21){
            if (hitOrStand.equals("H")) {
                dealCards(currentPlayer, 1);
            } else if (hitOrStand.equals("S")){
                break;
            }else {
                Console.println("Invalid input. Please enter H for Hit or S for Stand");
            }
            Console.println("You have: ");
                for (int i = 0; i < playerHand.size(); i++) {
                    Console.println(" " + playerHand.getVardValue(i) + playerHand.getSuit(i));
                }
                Console.println("Do you want to Hit or Stand? \n Enter H for Hit or S for Stand");
                }
                return false;
            }

            Console.println("Dealer's card are: ");
            for (int i = 0; i < dealerHand.size(); i++) {
            Console.println(" " + dealerHand.getVardValue(i) + dealerHand.getSuit(i));
            }
            while (getSum(dealerHand) < 17) {
                Card newCard = drawCard();
                Console.println("Dealer drew a " + newCard.getCardValue() + " of " + newCard.getSuit());
                if (getSum(dealerHand) > 21) {
                    Console.println("Dealer busted. " + currentPlayer + " wins.");
                }
            }
}

    public void dealCards(BlackJackPlayer player, int numberOfCards) {

        for(BlackJackPlayer p: blackJackPlayers){ //deal 2 cards to each player
            super.dealCards(p, 2);

        }
    }

    public void placeBet() {

        bet = Console.getLongInput("Please enter your bet.");
    }

    public void evaluateBet(Player player, long payout) {

    }


    public Card drawCard() {
        // draws card from deck and adds it to "upcard" total
        Card card = dealerHand.add(deck.deckOfCards.get(0));
        deck.deckOfCards.remove(0);

        return card;
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


    public int  getSum(ArrayList<Card> cardHands) {
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
        return cardSum;
    }


    public void revealCard(){

    }

}
