package io.zipcoder.casino;

import java.util.ArrayList;

public class Craps extends DiceGame implements Gamble {

    private ArrayList<CrapsPlayer> crapsPlayers = new ArrayList<>();
    long bet;

    public Craps() {
        readyPlayers();
        placeBet();
        run();
    }
    //for test purposes
    public Craps(ArrayList<CrapsPlayer> playerz){
        crapsPlayers.addAll(playerz);
        run();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().playerList) {
            crapsPlayers.add(new CrapsPlayer(player));
        }
    }

    public void run(){
        for(int i = 0; i < crapsPlayers.size(); i++){
            play(crapsPlayers.get(i),crapsPlayers.get(i).getBet());
        }
    }

    public void placeBet() {
        bet = 5;
    }

    public void evaluateBet(Player player, long payout) {
        player.setChipBalance(player.getChipBalance()+payout);
    }

    public void play(CrapsPlayer currentPlayer, long bet) {

        this.bet = bet;

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