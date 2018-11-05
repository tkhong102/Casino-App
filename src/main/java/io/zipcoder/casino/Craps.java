package io.zipcoder.casino;

import java.util.ArrayList;

public class Craps extends DiceGame implements Gamble {
    private ArrayList<CrapsPlayer> crapsPlayers = new ArrayList<>();

    public Craps(){
        readyPlayers();
    }

    public void readyPlayers() {
        crapsPlayers.addAll(Players.getInstance().playerList);
    }

    public void placeBet() {

    }

    public void evaluateRoll() {

    }

    public void winBet() {

    }

    public void loseBet() {

    }
}
