package io.zipcoder.casino.utilities.abstracts;

public abstract class Game {
    String className = this.getClass().getName();

    public abstract void promptContinue();

    public abstract void runGame();

    public String getClassName() {
        return className;
    }
}
