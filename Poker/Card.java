public class Card implements Comparable<Card> {
    private final Suit suit;
    private final int number;

    //A(14) → K(13) → Q(12) → J(11) → 10 → 9 → 8 → 7 → 6 → 5 → 4 → 3 → 2

    Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }
    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Card o) {
        if (this.getNumber() == o.getNumber()) {
            return o.getSuit().getNumber() - this.getSuit().getNumber();
        } else {
            return this.getNumber() - o.getNumber();
        }
    }
}
