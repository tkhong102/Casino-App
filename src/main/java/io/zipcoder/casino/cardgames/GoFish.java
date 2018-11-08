package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;
import io.zipcoder.casino.utilities.Card;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.abstracts.CardGame;
import io.zipcoder.casino.utilities.containers.Deck;

import java.util.ArrayList;

public class GoFish extends CardGame {
    private static Deck drawPile = new Deck();
    private ArrayList<GoFishPlayer> goFishPlayers = new ArrayList<>();

    public void goFish() {
        readyPlayers();
        dealCards(getNumberOfCards());
        runGame();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
            goFishPlayers.add(new GoFishPlayer(player));
        }
    }

    @Override
    public void runGame() {                                 // run the game as longa s the drawPile is more than 0 cards
        for (int i = drawPile.size(); i > 0; i++) {
            playGoFish();
        }
    }

    public int getNumberOfCards() {                 //generate numberOfCards param for below based on number of players
        int numberOfCards;
        if (goFishPlayers.size() <= 3) {            //RULES: For 3 players or less, deal each player 7 cards;
            numberOfCards = 7;
        } else {                                    //RULES contd: if more than three players, deal 5 cards each.
            numberOfCards = 5;
        }
        return numberOfCards;
    }

    @Override
    public void dealCards(Player player, int numberOfCards) {           //populate the cardHand of players
        GoFishPlayer fishie = (GoFishPlayer) player;                    // depending on how many players
        for (int i = 0; i < numberOfCards; i++) {
            Card card = drawPile.removeFirst();
            fishie.getHand().add(card);
        }
    }

    @Override
    public void dealCards(int numberOfCards) {
        for (GoFishPlayer p : goFishPlayers) {
            for (int i = 0; i < numberOfCards; i++) {
                Card card = drawPile.removeFirst();
                p.getHand().add(card);
            }
        }
    }

    @Override
    public void promptContinue() {
    }                                      //WHAT?


    public void playGoFish() {
        for (int i = 0; i < goFishPlayers.size(); i++) {
        askForOpponent();
        searchCard();
        //matchCards();
        }
    }

    public String askForOpponent() {
        String opponent = Console.getStringInput("Which player would you like to question?");
        return opponent;
    }

    public Integer searchCard() {
        Integer wantedCard = Console.getIntegerInput("Which card would you like to request?");
        return wantedCard;
    }

    public void matchCards(GoFishPlayer opponent, Integer wantedCard) {
        GoFishPlayer fishie = new GoFishPlayer();
        for (int i = 0; i < goFishPlayers.size(); i++) {
            if (opponent.equals(goFishPlayers.get(i).getName())) {
                for (int j = 0; j < opponent.getHand().size(); j++) {
                    if (wantedCard.equals(opponent.getHand().get(i).getCardValue())) {
                        fishie.getHand().add(opponent.getHand().get(i));
                        opponent.getHand().remove(i);
                    } else fishie.getHand().add(drawPile.removeFirst());
                }
            }
        }
    }


    }

    //take userInput [console input?]
    //askPlayerCard(); Prompt w/question of what card (rank) to look for [console output?]
    //take userInput[console input?]
    //for cardHand(chosen player)
    //evalCards(userInput): If userInput.equals(card[i].cardGetValue)
    //swap();
    //repeat until userInput != cardGetValue


    //else
    //goFish(); draw a card from Deck - (deck - 1)
    //move to next player;
    //checkSets: run through each cardHand and looks for 4 of a kind;
    //if found, setsCount++;


//       public void evalCards() {
//        //    if for cards in dealerHand:
////        swap cards or go fish
//    }
//
//    public void goFish() {
//        //pull from top of deck
//    }
//
//    public void checkSets() {
//        // check if 4 in dealerHand have same value
//    }
}


