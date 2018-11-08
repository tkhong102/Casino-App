package io.zipcoder.casino.cardgames;


import io.zipcoder.casino.utilities.abstracts.CardGame;
import io.zipcoder.casino.utilities.containers.Deck;

import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;

public class GoFish extends CardGame {
    private static Deck drawPile = new Deck();
    private ArrayList<GoFishPlayer> goFishPlayers = new ArrayList<>();

    public GoFish() {
        readyPlayers();
        //dealCards(getNumberOfCards());
       // playGoFish();
    }

    @Override
    public void runGame(){

    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
            goFishPlayers.add(new GoFishPlayer(player));
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


//    //@Override
//    void dealCards(GoFishPlayer player, int numberOfCards) {          //will this dealing remove from the drawPile automatically?
//        //super.dealCards(player, numberOfCards);
//        for (int i = 0; i < numberOfCards; i++) {
//            Card card = drawPile.removeFirst();
//            //GoFishPlayer.getHand().add(card);
//        }
//    }


    @Override
    public void dealCards(Player player, int numberOfCards) {
        // dealPile = dealPile - numberOfCards;
    }

    @Override
    public void dealCards(int numberOfCards) {

    }

    @Override
    public void promptContinue(){};
    //
    public void updateDrawPile() {
//
//    public void playGoFish() {
//        while ((drawPile.size() > 0) && goFishPlayers.size() > 0) {
//            //Console.print(goFishPlayers.cardHand);
//            askForOpponent();
//            askForOpponentCards();
//
//
//        }
    }

    public void askForOpponent() {
        String opponent = Console.getStringInput("Which player would you like to question?");
    }

    public void askForOpponentCards() {
        Integer opponentCard = Console.getIntegerInput("Which card would you like to request?");
    }
        //public void questionPlayer(String cardRank, Player player) {
    public void evalCards(String opponent, Integer opponentCard) {
        for (int i = 0; i < goFishPlayers.size(); i++) {
            if (opponent.equals(goFishPlayers.get(i))) {
//                if (opponentCard == )
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

