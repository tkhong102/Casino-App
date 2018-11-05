package io.zipcoder.casino;

public class Player {

    private String name = "";
    private long chipBalance;

    private CardHand hand;

    public Player(String name, long startingBalance) {
        this.name = name;
        this.chipBalance = startingBalance;
    }

    public Player(String name) {
        this.name = name;
        this.chipBalance = 500;
    }

    public CardHand getHand() {
        return hand;
    }

    public void setHand(CardHand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getChipBalance() {
        return chipBalance;
    }

    public void setChipBalance(long chipBalance) {
        this.chipBalance = chipBalance;
    }
}
