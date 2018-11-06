package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class Craps extends DiceGame implements Gamble {

    Scanner stdin = new Scanner(System.in);

    private ArrayList<CrapsPlayer> crapsPlayers = new ArrayList<>();
    int bet = 1;

    public Craps() {
        readyPlayers();
        run();
    }
    //for test purposes
    public Craps(ArrayList<CrapsPlayer> playerz){
        crapsPlayers.addAll(playerz);
        run();
    }

    public void readyPlayers() {
        crapsPlayers.addAll(Players.getInstance().playerList);
    }


    public void run(){
        for(int i = 0; i < crapsPlayers.size(); i++){
            play(crapsPlayers.get(i));
        }
    }



    public int placeBet() {
        //call console function
         System.out.println("How much do you want to bet? ");
         bet = stdin.nextInt();
         return bet;
    }

//    public void evaluateRoll() {
//
//    }

    public void evaluateBet(Player player, long payout) {
        player.setChipBalance(payout);
    }

    public void play(CrapsPlayer currentPlayer) {

       bet = placeBet();

        int sum = rollDie(2); // roll two dice, store sum in sum field.

        if (sum == 7 || sum == 11) {
            evaluateBet(currentPlayer.crapsPlayer, bet*2);
        } else if (sum == 2 || sum == 3 || sum == 12) {
            evaluateBet(currentPlayer.crapsPlayer, -(bet*2));
        } else {
            int point = sum;
            do {
                sum = rollDie(2);
                if (sum == 7) {
                    evaluateBet(currentPlayer.crapsPlayer, -bet);
                } else if (sum == point) {
                    evaluateBet(currentPlayer.crapsPlayer, bet);
                }
            } while (sum != point && sum != 7);
        }
    }


    public void print(){
        for(int i = 0; i < crapsPlayers.size(); i++){
            System.out.println(crapsPlayers.get(i).crapsPlayer.getChipBalance());
        }
    }

}