package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class Craps extends DiceGame implements Gamble {
    private ArrayList<CrapsPlayer> crapsPlayers = new ArrayList<>();

    public Craps(){
        readyPlayers();
    }

    public void readyPlayers() {
        crapsPlayers.addAll(Players.getInstance().playerList);
    }

    public void placeBet() {
        System.out.println("How much money do you want to bet");
        Scanner mBet=new Scanner(System.in);
        int chipBet=mBet.nextInt();
    }

    public void evaluateRoll() {

    }

    public void winBet() {

    }

    public void loseBet() {

    }
}
