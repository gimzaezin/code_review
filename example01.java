public class JBGW08_016_Maze {
    static int[][] maze = {
        { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 1, 0, 1, 0, 1, 1, 1, 0, 0},
        { 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
        { 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
        { 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
        { 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
        { 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
        { 0, 1, 1, 1, 0, 1, 0, 1, 0, 0},
        { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
        { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0}
    };

    private static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static int cnt = 0;

    public static boolean navigate(int x, int y) {
        if (x == 9 && y == 9) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];

            if (newX >= 0 && newX < 10 && newY >= 0 && newY < 10 && maze[newX][newY] == 0) {
                maze[x][y] = 2;
                cnt++;
                if (navigate(newX, newY)) {
                    return true;
                }
                maze[x][y] = 0;
                cnt--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        if (navigate(0, 0)) {
            System.out.println("Pass, " + cnt);
        } else {
            System.out.println("Fail, " + cnt);
        }
    }
}