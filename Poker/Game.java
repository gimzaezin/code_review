import java.util.*;

public class Game {
    private List<User> players;
    private Dealer dealer;
    private Scanner scanner;

    public Game() {
        players = new ArrayList<>();
        dealer = new Dealer();
        scanner = new Scanner(System.in);
    }

    public void gameStart() {
        System.out.println("poker start");

        int numPlayers = 0;
        while (true) {
            System.out.print("number of players 2 ~ 5");
            numPlayers = scanner.nextInt();
            scanner.nextLine();

            if (numPlayers >= 2 && numPlayers <= 5) {
                break;  // Exit the loop if input is valid
            } else {
                System.out.println("invalid input 2 ~ 5");
            }
        }


        System.out.print("your name:");
        String userName = scanner.nextLine();

        createPlayers(numPlayers, userName);

        dealer.makeDeck();
        dealer.shuffle();

        distributeCards();

        gameResult();

        System.out.println("END OF GAME.");
    }

    private void createPlayers(int numPlayers, String userName) {
        players.add(new User(userName));
        for (int i = 1; i < numPlayers; i++) {
            players.add(new User("Player " + i));
        }
    }

    private void distributeCards() {
        for (User player : players) {
            List<Card> hands = new ArrayList<>(Arrays.asList(dealer.handsToUser()));
            player.setHands(hands);
        }
    }

    private void gameResult() {
        User winner = null;
        Rank highestRank = null;

        for (User player : players) {
            Rank playerRank = player.calcRank();
            System.out.println(player.getUserName() + "'s Rank: " + playerRank);

            if (winner == null ||
                    playerRank.getRank() > highestRank.getRank() ||
                    (playerRank == highestRank && player.getHighNumber() > winner.getHighNumber())) {
                highestRank = playerRank;
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("Winner: " + winner.getUserName() + " (" + highestRank + ")");
        } else {
            System.out.println("Draw");
        }
    }
}