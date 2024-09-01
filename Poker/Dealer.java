import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Dealer {
    static List<Card> deck;

    //13 * 4
    public void makeDeck() {
        deck = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++){
                if (i == 0) {
                    deck.add(new Card(Suit.CLOVER, j));
                } else if (i == 1) {
                    deck.add(new Card(Suit.HEART, j));
                } else if (i == 2) {
                    deck.add(new Card(Suit.DIAMOND, j));
                } else {
                    deck.add(new Card(Suit.SPADE, j));
                }
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card[] handsToUser() {
        Card[] hands = new Card[5];
        for (int i = 0; i < 5; i++) {
            hands[i] = deck.get(i);
            deck.remove(0);
        }
        return hands;
    }
}
