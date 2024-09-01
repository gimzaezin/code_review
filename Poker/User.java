import java.util.*;

public class User {
    private String userName;
    private List<Card> hands;
    private Rank userRank;
    private Suit highSuit;
    private int highNumber;

    public User(String userName, List<Card> hands) {
        this.userName = userName;
        this.hands = hands;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public Rank calcRank() {
        Collections.sort(hands, Collections.reverseOrder());

        if (checkStraightFlush()) {
            userRank = Rank.STRAIGHTFLUSH;
        } else if (checkFourCard()) {
            userRank = Rank.FOURCARD;
        } else if (checkFullHouse()) {
            userRank = Rank.FULLHOUSE;
        } else if (checkFlush()) {
            userRank = Rank.FLUSH;
        } else if (checkStraight()) {
            userRank = Rank.STRIAGHT;
        } else if (checkTriple()) {
            userRank = Rank.TRIPLE;
        } else if (checkTwoPair()) {
            userRank = Rank.TWOPAIR;
        } else if (checkOnePair()) {
            userRank = Rank.ONEPAIR;
        } else {
            userRank = Rank.HIGHCARD;
            highNumber = hands.get(0).getNumber();
        }
        this.userRank = userRank;
        return userRank;
    }

    private boolean checkFlush() {
        Suit s = hands.get(0).getSuit();
        for (Card card : hands) {
            if (card.getSuit() != s) {
                return false;
            }
        }
        highSuit = s;
        highNumber = hands.get(0).getNumber();
        return true;
    }

    private boolean checkFourCard() {
        for (int i = 0; i <= 1; i++) {
            int count = 1;
            int number = hands.get(i).getNumber();
            for (int j = i + 1; j < 5; j++) {
                if (hands.get(j).getNumber() == number) {
                    count++;
                }
            }
            if (count == 4) {
                highNumber = number;
                return true;
            }
        }
        return false;
    }

    private boolean checkStraight() {
        if (hands.get(0).getNumber() == 14 && hands.get(1).getNumber() == 5 &&
                hands.get(2).getNumber() == 4 && hands.get(3).getNumber() == 3 &&
                hands.get(4).getNumber() == 2) {
            highNumber = 14; //A
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (hands.get(i).getNumber() != hands.get(i + 1).getNumber() + 1) {
                return false;
            }
        }
        highNumber = hands.get(0).getNumber();
        return true;
    }

    private boolean checkStraightFlush() {
        return checkStraight() && checkFlush();
    }

    private boolean checkFullHouse() {  // ex) 33444 or 33344
        return (hands.get(0).getNumber() == hands.get(1).getNumber() &&
                hands.get(1).getNumber() == hands.get(2).getNumber() &&
                hands.get(3).getNumber() == hands.get(4).getNumber()) ||
                (hands.get(0).getNumber() == hands.get(1).getNumber() &&
                        hands.get(2).getNumber() == hands.get(3).getNumber() &&
                        hands.get(3).getNumber() == hands.get(4).getNumber());
    }

    private boolean checkTriple() {
        for (int i = 0; i <= 2; i++) {
            if (hands.get(i).getNumber() == hands.get(i + 1).getNumber() &&
                    hands.get(i).getNumber() == hands.get(i + 2).getNumber()) {
                highNumber = hands.get(i).getNumber();
                return true;
            }
        }
        return false;
    }

    private boolean checkTwoPair() { // ex) 33445 or 33455 or 34455
        return (hands.get(0).getNumber() == hands.get(1).getNumber() &&
                hands.get(2).getNumber() == hands.get(3).getNumber()) ||
                (hands.get(0).getNumber() == hands.get(1).getNumber() &&
                        hands.get(3).getNumber() == hands.get(4).getNumber()) ||
                (hands.get(1).getNumber() == hands.get(2).getNumber() &&
                        hands.get(3).getNumber() == hands.get(4).getNumber());
    }

    private boolean checkOnePair() {
        for (int i = 0; i < 4; i++) {
            if (hands.get(i).getNumber() == hands.get(i + 1).getNumber()) {
                highNumber = hands.get(i).getNumber();
                return true;
            }
        }
        return false;
    }

    public String getUserName() {
        return userName;
    }

    public int getHighNumber() {
        return highNumber;
    }

    public Suit getHighSuit() {
        return highSuit;
    }

    public void setHands(List<Card> hands) {
        this.hands = hands;
    }
}