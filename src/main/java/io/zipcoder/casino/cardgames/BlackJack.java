package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.utilities.Card;
import io.zipcoder.casino.utilities.containers.CardHand;
import io.zipcoder.casino.utilities.containers.Deck;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Gamble;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;

import java.util.ArrayList;

public class BlackJack extends CardGame implements Gamble {

    private Deck deck = new Deck();
    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();
    CardHand dealerHand = new CardHand();
    long bet;


    public BlackJack(){
        readyPlayers();
        dealCards(2);
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
        placeBet();
        // this.bet = bet;

        Console.println("The dealer is dealing cards to the players.");

        dealerHand.add(deck.removeFirst());
        dealerHand.add(deck.removeFirst());

        Console.println(String.format("%s, you're up!", currentPlayer.getP().getName()));

        if (getSum(dealerHand) == 21){
            Console.println("Dealer has +," +  dealerHand.display());
            Console.println("You have " + currentPlayer.getHand().display());
            Console.println("Dealer has blackjack. Dealer wins.");
        }


        Console.println(String.format("%s, you're up!", currentPlayer.getP().getName()));

        if (getSum(currentPlayer.getHand()) == 21){
            Console.println("Dealer has " + dealerHand.display());
            Console.println("You have " + currentPlayer.getHand().display());
            Console.println("You have blackjack. You win.");
        }
        
        while(true) {

            Console.println("You have: " + currentPlayer.getHand().display() + "\nYour sum is " + getSum(currentPlayer.getHand()));

            String hitOrStand = Console.getStringInput("Do you want to Hit or Stand? \n Enter H for Hit or S for Stand");

            while (getSum(currentPlayer.getHand()) < 21) {
                if (hitOrStand.equalsIgnoreCase("H")) {
                    dealCard(currentPlayer,1);
                } else if (hitOrStand.equalsIgnoreCase("S")) {
                    break;
                } else {
                    hitOrStand = Console.getStringInput("Invalid input. Please enter H for Hit or S for Stand");
                }
            }

            Console.println("You have: " + currentPlayer.getHand().display());
            Console.println("The sum of your cards is " + getSum(currentPlayer.getHand()));

            if (getSum(currentPlayer.getHand()) > 21){
                Console.println("You busted. House wins.");
                return false;
            }

            Console.println("Dealer's card are: " + dealerHand.display());
            Console.println("The sum of dealer's cards is " + getSum(dealerHand));

            while (getSum(dealerHand) < 17) {
                revealCard();
                Console.println("Dealer's sum is " + getSum(dealerHand));
            }

            if (getSum(dealerHand) > 21) {
                Console.println("Dealer busted. You win.");
                return false;
            }

            if (getSum(dealerHand) == getSum(currentPlayer.getHand())) {
                Console.println("It's a tie. You lose.");
                return false;
            } else if (getSum(dealerHand) <=21 && getSum(dealerHand) > getSum(currentPlayer.getHand())) {
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
        this.bet = Console.getLongInput("Please enter your bet.");
    }


    public void evaluateBet(Player player, long payout) {

    }


    public Card drawCard() {
        // draws card from deck and adds it to "upcard" total
        Card card = deck.removeFirst();
        return card;
    }


    public int  getSum(CardHand cardHand) {
        int cardSum = 0;
        boolean ace = false;

        for (int i = 0; i < cardHand.size(); i++) {
            int cardValue = cardHand.get(i).getCardValue().getCardValue();

            if (cardValue > 10) {
                cardValue = 10;   // For a Jack, Queen, or King.
            }
            if (cardValue == 1) {
                ace = true;
            }
            cardSum = cardSum + cardValue;
        }
        if (cardHand.size() == 2 && ace == true && cardSum + 10 == 21) {
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
