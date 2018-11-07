package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.cardgames.cards.Deck;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;

import java.util.ArrayList;

public class GoFish extends CardGame {
    private static Deck drawPile = new Deck();
    // Change Deck to deque;
    private ArrayList<GoFishPlayer> goFishPlayers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println();
    }

    public GoFish() {
        readyPlayers();
        runGame();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
            goFishPlayers.add(new GoFishPlayer(player));
        }
    }

    public int getNumberOfCards() {      //generate numberOfCards param for below based on number of players
        int numberOfCards;
        if (goFishPlayers.size() <= 3) {  //RULES: For 3 players or less, deal each player 7 cards;
            numberOfCards = 7;
        } else {                           //RULES contd: if more than three players, deal 5 cards each.
            numberOfCards = 5;
        }
        return numberOfCards;
    }

    @Override
    void dealCards(Player player, int numberOfCards) {
        super.dealCards(player, numberOfCards);
        // dealPile = dealPile - numberOfCards;
    }

    //
    public void updateDrawPile() {

//    public void play() {
//        for (int i = 0; i }

//    int setsCount;


        //while (drawPile > 0) {
        //public void questionPlayer(String cardRank, Player player) {
        //start w/ player
        //for (deck.size aka (52 cards - numOfCards per player))
        //askPlayerQuestion(); Prompt w/ question of who to ask [console output?]
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


//    public void evalCards() {
//        //for cards in dealerHand:
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
}
