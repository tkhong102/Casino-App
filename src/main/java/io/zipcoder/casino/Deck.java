package io.zipcoder.casino;

public class Deck {

    int numberOfDecks;
    private Card card;
    protected java.util.ArrayList<Card> deckOfCards;

    public Deck() {
        this.numberOfDecks = 1;
    }

    enum suits {

    }

    enum ranks {

    }

    public Deck(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
    }

    public void cut() {
    }

    public void shuffle() {
    }

}
