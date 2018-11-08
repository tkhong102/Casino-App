package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.interfaces.Gamble;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;
import io.zipcoder.casino.utilities.abstracts.DiceGame;

import java.util.ArrayList;

public class Craps extends DiceGame implements Gamble {
    Console console = new Console();
    private ArrayList<CrapsPlayer> crapsPlayers = new ArrayList<>();
    long bet;

    public Craps() {
        readyPlayers();
        runGame();
    }
    //for test purposes
    public Craps(ArrayList<CrapsPlayer> playerz){
        crapsPlayers.addAll(playerz);
        runGame();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
            crapsPlayers.add(new CrapsPlayer(player));
        }
    }

    @Override
    public void runGame(){
        for(int i = 0; i < crapsPlayers.size(); i++){
            greetPlayer(crapsPlayers.get(i).getP());
            play(crapsPlayers.get(i));
        }
    }

    public void placeBet() {
        this.bet = console.integerInputSameLine("Enter your bet: ");
    }

    @Override
    public void placeBet(Player player) {
        BlackJackPlayer blackJackPlayer = (BlackJackPlayer) player;
        long bet = Console.getLongInput("Please enter your bet.");
        blackJackPlayer.setBet(bet);
    }

    public void evaluateBet(Player player, long payout) {
        player.setChipBalance(player.getChipBalance()+payout);
    }

    public void play(CrapsPlayer currentPlayer) {
        placeBet();

        promptEnterKey("roll dice");

        int sum = rollDie(2);

        console.println("Your roll sum equals: " + sum);

        if (sum == 7 || sum == 11) {
            evalWin(currentPlayer.getP());
        } else if (sum == 2 || sum == 3 || sum == 12) {
            evalLoss(currentPlayer.getP());
        } else {
            int point = sum;
            do {
                printRollAgain(point);
                sum = rollDie(2);
                evalReRoll(currentPlayer, sum , point);
            } while (sum != point && sum != 7);
        }
    }

    public void print(){
        for(int i = 0; i < crapsPlayers.size(); i++){
            System.out.println(crapsPlayers.get(i).getP().getChipBalance());
        }
    }

    public void printRollAgain(int point){
        console.println("\n--------------------");
        console.println("Point to roll for: " + point);
        console.println("--------------------");
        promptEnterKey("roll again");
    }

    public void evalReRoll(CrapsPlayer currentPlayer, int sum, int point){
        console.println("You rolled a " + sum);
        if (sum == 7) {
            evalLoss(currentPlayer.getP());
        } else if (sum == point) {
            evalWin(currentPlayer.getP());
        }
    }

    public void evalLoss(Player player){
        console.println("\n*********\nYOU LOSE!\n*********\n");
        evaluateBet(player, -bet);
    }
    public void evalWin(Player player){
        console.println("\n*******************************\n" +
                "WINNER WINNER CHICKEN DINNER!\n" +
                "*******************************\n");
        evaluateBet(player, bet);
    }

    public void greetPlayer(Player playa){
        console.println("Ok " + playa.getName() + ", you're up...\n");
    }

    public void promptEnterKey(String str){
        String input = console.getStringInput("\nPress \"ENTER\" to " + str);
    }

    @Override
    public void promptContinue(){};
}