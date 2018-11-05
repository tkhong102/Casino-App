package io.zipcoder.casino;

public class Player {

    private String name = "";
    private long balance;

    public Player(String name, long startingBalance) {
        this.name = name;
        this.balance = startingBalance;
    }

    public Player(String name) {
        this.name = name;
        this.balance = 500;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
