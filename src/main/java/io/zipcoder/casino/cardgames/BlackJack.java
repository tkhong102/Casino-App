package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.utilities.Card;
import io.zipcoder.casino.utilities.abstracts.CardGame;
import io.zipcoder.casino.utilities.containers.CardHand;
import io.zipcoder.casino.utilities.containers.Deck;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.interfaces.Gamble;
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
        runGame();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
            blackJackPlayers.add(new BlackJackPlayer(player));
        }
    }

    @Override
    public void runGame(){
        for(int i = 0; i < blackJackPlayers.size(); i++){
            play(blackJackPlayers.get(i),blackJackPlayers.get(i).getBet());
        }
    }

    public boolean play(BlackJackPlayer currentPlayer, long bet) {
        // this.bet = bet;

        Console.println("The dealer is dealing cards to the players.");

        for (BlackJackPlayer p: this.blackJackPlayers){ //gets bet from each player
            placeBet(p);
        }

        dealerHand.add(deck.removeFirst());
        dealerHand.add(deck.removeFirst());

        Console.println("Dealer is showing a " + dealerHand.get(0).getCard()); // dealer reveals upcard


        if (getSum(dealerHand) == 21){
            Console.println("Dealer has +," +  dealerHand.display());
            Console.println("You have " + currentPlayer.getHand().display());
            Console.println("Dealer has blackjack. Dealer wins.");
            for (BlackJackPlayer p: this.blackJackPlayers){ // collects bet from all players
                evaluateBet(p.getP(), bet);
            }
        }
            evalBlackjack();

            playersTurn();


        if (dealersTurn()) return false;

        return evalWinner(currentPlayer, bet);

    }

    public boolean evalWinner(BlackJackPlayer currentPlayer, long bet) {
        if (getSum(dealerHand) == getSum(currentPlayer.getHand())) {
            Console.println("Dealer wins on a tie.");
            evaluateBet(currentPlayer.getP(), -bet);
            return false;
        } else if (getSum(dealerHand) <=21 && getSum(dealerHand) > getSum(currentPlayer.getHand())) {
            Console.println("Dealer wins.");
            evaluateBet(currentPlayer.getP(), -bet);
            return false;
        } else {
            Console.println("You win!");
            evaluateBet(currentPlayer.getP(), bet);
            return false;
        }
    }

    public boolean dealersTurn() {
        Console.println("Dealer's card are: " + dealerHand.display());
        Console.println("The sum of dealer's cards is " + getSum(dealerHand));

        while (getSum(dealerHand) < 17) {
            revealCard();
            Console.println("Dealer's sum is " + getSum(dealerHand));
        }

        if (getSum(dealerHand) > 21) {
            Console.println("Dealer busted. You win.");
            return true;
        }
        return false;
    }

    public void playersTurn() {

        for (BlackJackPlayer currentPlayer : this.blackJackPlayers) {

            Console.println(String.format("%s, you're up!", currentPlayer.getP().getName()));

            Console.println("You have: " + currentPlayer.getHand().display() + "\nYour sum is " + getSum(currentPlayer.getHand()));

            hitOrStand(currentPlayer);

            Console.println("You have: " + currentPlayer.getHand().display());
            Console.println("The sum of your cards is " + getSum(currentPlayer.getHand()));

            if (getSum(currentPlayer.getHand()) > 21){
                Console.println("You busted. House wins.");
            }
        }
    }

    public void hitOrStand(BlackJackPlayer currentPlayer) {
        String hitOrStand = Console.getStringInput("Do you want to Hit or Stand? \n Enter H for Hit or S for Stand");

        while (getSum(currentPlayer.getHand()) < 21) {
            if (hitOrStand.equalsIgnoreCase("H")) {
                dealCards(currentPlayer, 1);
            } else if (hitOrStand.equalsIgnoreCase("S")) {
                break;
            } else {
                hitOrStand = Console.getStringInput("Invalid input. Please enter H for Hit or S for Stand");
            }
        }
    }

    public void evalBlackjack() {
        for (BlackJackPlayer p: this.blackJackPlayers)
        if (getSum(p.getHand()) == 21){
            Console.println("Dealer has " + dealerHand.display());
            Console.println("You have " + p.getHand().display());
            Console.println("You have blackjack. You win.");
        }
    }

    @Override
    public void dealCards(int numberOfCards) {

        for(BlackJackPlayer p: blackJackPlayers){ //deal 2 cards to each player
            for (int i = 0; i < numberOfCards; i++) {
                Card card = deck.removeFirst();
                p.getHand().add(card);
            }
        }
    }

    @Override
    public void dealCards(Player p, int numberOfCards) {
        BlackJackPlayer bjp = (BlackJackPlayer) p;
        for (int i = 0; i < numberOfCards; i++) {
            Card card = deck.removeFirst();
            bjp.getHand().add(card);
        }
    }

    public void placeBet(Player player) {
        this.bet = Console.getLongInput("Please enter your bet.");
    }


    public void evaluateBet(Player player, long payout) {
        player.setChipBalance(player.getChipBalance()+payout);
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

    @Override
    public void promptContinue(){};

}
