package io.zipcoder.casino;

public class DiceGame extends Game {
    private Dice dice = new Dice(1);

    public int rollDie(int num) {
        Dice dice = new Dice(num);
        int sum = dice.tossAndSum();
        return sum;
    }

}
