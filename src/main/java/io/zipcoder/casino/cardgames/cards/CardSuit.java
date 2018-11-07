package io.zipcoder.casino.cardgames.cards;

public enum CardSuit {
    HEARTS('♥'),
    SPADES('♠'),
    CLUBS('♣'),
    DIAMONDS('♦');

    private char cardGraphic;

    CardSuit (char cardGraphic) {
        this.cardGraphic = cardGraphic;
    }

    public char getCardGraphic() {
        return cardGraphic;
    }

}
