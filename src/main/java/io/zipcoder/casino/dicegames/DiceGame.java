package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.dicegames.dice.Dice;
import io.zipcoder.casino.utilities.Game;

public class DiceGame extends Game {

    private Dice dice = new Dice(1);

    public void rollDie() {
    }
    public int rollDie(int num) {
        Dice dice = new Dice(num);
        int sum = dice.tossAndSum();
        return sum;
    }

}
