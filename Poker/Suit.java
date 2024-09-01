public enum Suit {
    SPADE("♠︎", 4),
    HEART("♥︎", 3),
    DIAMOND("♦︎", 2),
    CLOVER("♣︎", 1);

    private final int number;
    private final String suit;

    Suit(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }
}
