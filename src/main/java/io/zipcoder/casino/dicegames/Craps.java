package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Gamble;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;

import java.util.ArrayList;

public class Craps extends DiceGame implements Gamble {
    Console console = new Console();
    private ArrayList<CrapsPlayer> crapsPlayers = new ArrayList<>();
    long bet;

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
        for (Player player : Players.getInstance().getPlayers()) {
            crapsPlayers.add(new CrapsPlayer(player));
        }
    }

    public void run(){
        for(int i = 0; i < crapsPlayers.size(); i++){
            greetPlayer(crapsPlayers.get(i).getP());
            play(crapsPlayers.get(i));
        }
    }

    public void placeBet() {
        this.bet = console.getIntegerInput("Enter your bet");
    }

    public void evaluateBet(Player player, long payout) {
        player.setChipBalance(player.getChipBalance()+payout);
    }

    public void play(CrapsPlayer currentPlayer) {
        placeBet();
        promptEnterKey("roll dice");
        int sum = rollDie(2); // roll two dice, store sum in sum field.
        console.println("Your roll sum equals: " + sum);
        if (sum == 7 || sum == 11) {
            console.println("\n*********");
            console.println("YOU WIN!");
            console.println("*********\n");
            evaluateBet(currentPlayer.getP(), bet*2);
        } else if (sum == 2 || sum == 3 || sum == 12) {
            console.println("\n*********");
            console.println("YOU LOSE!");
            console.println("*********\n");
            evaluateBet(currentPlayer.getP(), -(bet*2));
        } else {
            int point = sum;
            do {
                console.println("\n--------------------");
                console.println("Point to roll for: " + point);
                console.println("--------------------");
                promptEnterKey("roll again");
                sum = rollDie(2);
                console.println("You rolled a " + sum);
                if (sum == 7) {
                    console.println("\n*********");
                    console.println("YOU LOSE!");
                    console.println("*********\n");
                    evaluateBet(currentPlayer.getP(), -bet);
                } else if (sum == point) {
                    console.println("\n*********");
                    console.println("YOU WIN!");
                    console.println("*********\n");
                    evaluateBet(currentPlayer.getP(), bet);
                }
            } while (sum != point && sum != 7);
        }
    }

    public void print(){
        for(int i = 0; i < crapsPlayers.size(); i++){
            System.out.println(crapsPlayers.get(i).getP().getChipBalance());
        }
    }

    public void greetPlayer(Player playa){
        console.println("Ok " + playa.getName() + ", you're up...\n");
    }

    public void promptEnterKey(String str){
        String input = console.getStringInput("\nPress \"ENTER\" to " + str);
    }
}