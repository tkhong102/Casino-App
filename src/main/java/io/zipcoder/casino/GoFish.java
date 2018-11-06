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
    void dealCards(BlackJackPlayer player, int numberOfCards) {
        super.dealCards(player, numberOfCards);
        //For 2 to 3 players you deal each player 7 cards.
        //If there are more than three players, deal 5 cards each.
    }

    public void questionPlayer(String cardRank, Player player) {
        //player surrenders cards of specified rank
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
