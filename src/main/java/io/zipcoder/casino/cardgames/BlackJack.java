package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.cards.Card;
import io.zipcoder.casino.cardgames.cards.CardHand;
import io.zipcoder.casino.cardgames.cards.CardValue;
import io.zipcoder.casino.cardgames.cards.Deck;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Gamble;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Vector;

public class BlackJack extends CardGame implements Gamble {
    long upcardsValue = 0;

    private Deck deck = new Deck();
    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();
    CardHand dealerHand = new CardHand();
    long bet;


    public BlackJack(){
        readyPlayers();
        placeBet();
        run();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
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

        dealCards(2);
        dealerHand.add(deck.removeFirst());
        dealerHand.add(deck.removeFirst());

        if (getSum(dealerHand) == 21){
            Console.println("Dealer has +," +  dealerHand.display());
            Console.println("You have " + currentPlayer.getHand().display());
            Console.println("Dealer win.");
        }

        if (getSum(currentPlayer.getHand()) == 21){
            Console.println("Dealer has " + dealerHand.display());
            Console.println("You have " + currentPlayer.getHand().display());
            Console.println("You win.");
        }

        while(true) {

            Console.println("You have: " + currentPlayer.getHand().display());
            Console.println("Dealer is showing a " + dealerHand.get(0).getCard());
            String hitOrStand = Console.getStringInput("Do you want to Hit or Stand? \n Enter H for Hit or S for Stand");

            while (getSum(currentPlayer.getHand()) < 21) {
                if (hitOrStand.equals("H")) {
                    dealCard(currentPlayer,1);
                } else if (hitOrStand.equals("S")) {
                    break;
                } else {
                    hitOrStand = Console.getStringInput("Invalid input. Please enter H for Hit or S for Stand");
                }
            }

            Console.println("You have: " + currentPlayer.getHand().display());
            Console.println("Dealer's card are: " + dealerHand.display());

            while (getSum(dealerHand) < 17) {
                revealCard();
                if (getSum(dealerHand) > 21) {
                    Console.println("Dealer busted. " + currentPlayer + " wins.");
                }
            }

            if (getSum(dealerHand) == getSum(currentPlayer.getHand())) {
                Console.println("It's a tie. You lose.");
                return false;
            } else if (getSum(dealerHand) > getSum(currentPlayer.getHand())) {
                Console.println("Dealer wins.");
                return false;
            } else {
                Console.println("You win!");
                return false;
            }

        }

}

    public void dealCards(int numberOfCards) {

        for(BlackJackPlayer p: blackJackPlayers){ //deal 2 cards to each player
            for (int i = 0; i < numberOfCards; i++) {
                Card card = deck.removeFirst();
                p.getHand().add(card);
            }
        }
    }

    public void dealCard(BlackJackPlayer p, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            Card card = deck.removeFirst();
            p.getHand().add(card);
        }
    }

    public void placeBet() {
        bet = Console.getLongInput("Please enter your bet.");
    }


    public void evaluateBet(Player player, long payout) {

    }


    public Card drawCard() {
        // draws card from deck and adds it to "upcard" total
        Card card = deck.removeFirst();
        return card;
    }


    public int  getSum(CardHand cardHands) {
        int cardSum = 0;
        boolean ace = false;

        for (int i = 0; i < cardHands.size(); i++) {
            int cardValue = cardHands.get(i).getCardValue().getCardValue();

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
        Card newCard = drawCard();
        Console.println("Dealer drew a " + newCard.getCardValue() + " of " + newCard.getSuit());
        dealerHand.add(newCard);
    }


}
