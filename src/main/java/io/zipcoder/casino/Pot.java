package io.zipcoder.casino;

public class Pot {

    private static final Pot INSTANCE = new Pot();

    private long bettingPool;
    private long currentBet;
    private long currentAmount;

    private Pot(){}

    public static Pot getInstance(){
        return INSTANCE;
    }

    public static Pot getINSTANCE() {
        return INSTANCE;
    }

    public long getBettingPool() {
        return bettingPool;
    }

    public void setBettingPool(long bettingPool) {
        this.bettingPool = bettingPool;
    }

    public long getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(long currentBet) {
        this.currentBet = currentBet;
    }

    public long getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(long currentAmount) {
        this.currentAmount = currentAmount;
    }
}
