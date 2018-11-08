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

    public void play(BlackJackPlayer currentPlayer, long bet) {
        boolean continueGame = true;
        boolean dealerWins = false;

        placePlayerBets();

        evalBlackjack(); // all players evaluate hand for blackjack. Winners are paid out and removed.
        dealerWins = dealerCheck(); //TO ADD: if both player and dealer have blackjack, player keeps bet
        if (dealerWins == true) continueGame = false; // all players lose

        while (continueGame == true) {
            dealerDraw();

            Console.println("Dealer is showing a " + dealerHand.get(0).getCard()); // dealer reveals upcard

            playersTurn();

            continueGame = dealersTurn(); // IMPLEMENT: if dealer loses, all players should receive payout

            evalWinner();

        }

        if (dealerWins == true) {
            dealerCollectAll();
        }

    }

    public boolean dealerCheck() {
        if (getSum(dealerHand) == 21){
            Console.println("Dealer has " +  dealerHand.display());
            Console.println("Dealer has blackjack. Dealer wins.");
            return true;
        }
        return false;
    }

    public void dealerCollectAll() {
        for (BlackJackPlayer p: this.blackJackPlayers){ // collects bet from all players
            evaluateBet(p, -p.getBet());
        }
    }

    public void payoutAll() {
        for (BlackJackPlayer p: this.blackJackPlayers){ // collects bet from all players
            long winnings = p.getBet()*2;
            evaluateBet(p, winnings);
        }
    }

    public void dealerCollect(BlackJackPlayer p) {
        evaluateBet(p, -p.getBet());
    }

    public void placePlayerBets() {
        for (BlackJackPlayer p: this.blackJackPlayers){ //gets bet from each player
            Console.println(p.getName());
            placeBet(p);
        }
    }

    public void dealerDraw() {
        dealerHand.add(deck.removeFirst());
        dealerHand.add(deck.removeFirst());
    }

    public boolean evalWinner() {
        for (BlackJackPlayer currentPlayer : blackJackPlayers) {
            if (getSum(dealerHand) == getSum(currentPlayer.getHand())) {
                Console.println("Dealer wins on a tie.");
                evaluateBet(currentPlayer, -currentPlayer.getBet());
                return false;
            } else if (getSum(dealerHand) <= 21 && getSum(dealerHand) > getSum(currentPlayer.getHand())) {
                Console.println("Dealer wins.");
                evaluateBet(currentPlayer, -currentPlayer.getBet());
                return false;
            } else {
                Console.println("You win!");
                evaluateBet(currentPlayer, currentPlayer.getBet());
                return false;
            }
        }
        return true;
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
            payoutAll();
            return true;
        }

        return false;
    }

    public void playersTurn() {
        BlackJackPlayer currentPlayer;

        for (int i = 0; i < blackJackPlayers.size(); i++) {
            currentPlayer = blackJackPlayers.get(i);

            Console.println(String.format("%s, you're up!", currentPlayer.getP().getName()));
            Console.println("You have: " + currentPlayer.getHand().display() + "\nYour sum is " + getSum(currentPlayer.getHand()));

            hitOrStand(currentPlayer);

            if (getSum(currentPlayer.getHand()) > 21){

                Console.println("You busted. House wins.");
                dealerCollect(currentPlayer);
                blackJackPlayers.remove(currentPlayer);

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
        BlackJackPlayer p;
        for (int i = 0; i < blackJackPlayers.size(); i++) {
            p = blackJackPlayers.get(i);
            if (getSum(p.getHand()) == 21) {
                Console.println(p.getName() + ", you have " + p.getHand().display());
                Console.println(p.getName() + ", you have blackjack. You win!");
                evaluateBet(p, p.getBet());
                blackJackPlayers.remove(i);
            }
        }
    }

    @Override
    public void dealCards(int numberOfCards) {
        Console.println("The dealer is dealing cards to the players.");
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

    @Override
    public void placeBet(Player player) {
        BlackJackPlayer blackJackPlayer = (BlackJackPlayer) player;
        long bet = Console.getLongInput("Please enter your bet.");
        blackJackPlayer.setBet(bet);
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
        if (cardHand.size() == 2 && ace && cardSum + 10 == 21) {
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
