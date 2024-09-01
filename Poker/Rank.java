public enum Rank {
    STRAIGHTFLUSH(8),
    FOURCARD(7),
    FULLHOUSE(6),
    FLUSH(5),
    STRIAGHT(4),
    TRIPLE(3),
    TWOPAIR(2),
    ONEPAIR(1),
    HIGHCARD(0);

    private final int rank;

    Rank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }
}
