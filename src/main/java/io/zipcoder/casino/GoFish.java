package io.zipcoder.casino;

import java.util.ArrayList;

public class GoFish extends CardGame {

    private ArrayList<GoFishPlayer> goFishPlayers = new ArrayList<>();

    public GoFish(){
        readyPlayers();
    }

    public void readyPlayers() {
        goFishPlayers.addAll(Players.getInstance().playerList);
    }

    int setsCount;

    @Override
    void dealCards(Player player, int numberOfCards) {              //not sure if we should be taking in an int
        super.dealCards(player, numberOfCards);                     // of cards as a param. Maybe save that for
            if (goFishPlayers.size() <= 3) {                        // if/else statement to determine #ofcards??
                numberOfCards = 7;                                  // or initialize numberOfCards as 0 before?
            } else {
                numberOfCards = 5;
            }
        //RULES: For 3 players or less, deal each player 7 cards; If more than three players, deal 5 cards each.
    }

    //while (Deck.cards(?) > 0) {
    public void questionPlayer(String cardRank, Player player) {
        //start w player
        //askFishQuestion(); Prompt w/ question of who to ask [console output?]
        //take userInput [console input?]
        //Prompt w/question of what card (rank) to look for [console output?]
        //take userInput[console input?]

    }

    public void evalCards() {
        //for cards in dealerHand:
//        swap cards or go fish
    }

    public void goFish() {
        //pull from top of deck
    }

    public void checkSets() {
        // check if 4 in dealerHand have same value
    }

}
