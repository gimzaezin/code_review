import java.util.Random;
import java.util.Scanner;

public class JBGW08_016_Tictactoe {
    static int drawCount = 0;
    static char[][] board = {
        {' ',' ',' '},
        {' ',' ',' '},
        {' ',' ',' '}
    };

    static boolean isEnd(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

        static boolean isOkay(int a, int b) {
            if (board[a][b] != ' ') return false;
                return true;
        }

        static void printBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + board[i][j] + " ");
                    if(j != 2) System.out.print(" | ");
                    
                }
                System.out.println();
                System.out.println("---------------");
            }
            System.out.println("\n");

        }

        static void userCheck(Scanner s) {
            while (true) {
                System.out.println(" Users turn 'row, column' ");
                String[] input = s.nextLine().split(",");
                if (input.length != 2) {
                    System.out.println("format is row, column");
                    continue;
                }
                try {
                    int a = Integer.parseInt(input[0].trim());
                    int b = Integer.parseInt(input[1].trim());
                    if (isOkay(a, b)) {
                        board[a][b] = 'O';
                        drawCount++;
                        break;
                    } else {
                        System.out.println("try again");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("invalid input");
                }
            }
        }

        static void computerCheck() {
            System.out.println("Computers turn");
            Random random = new Random();
            int a, b;
            while (true) {

                a = random.nextInt(3);
                b = random.nextInt(3);
                if (isOkay(a ,b)) {
                    if(isOkay(a, b)) {
                        board[a][b] = 'X';
                        drawCount++;
                        break;
                    } 
                }
            }
        }


    static void gameStart(Scanner s) {

        while (true) {
            if (isEnd('X')) { printBoard(); System.out.println("Computer Win");return; }
            if (drawCount == 9) { printBoard();System.out.println("Draw");return; }
            printBoard();
            userCheck(s);
            printBoard();
            if (isEnd('O')) { printBoard(); System.out.println("User Win");return; }
            if (drawCount == 9) { printBoard();System.out.println("Draw");return; }
            computerCheck();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        gameStart(scanner);
    }    
}
