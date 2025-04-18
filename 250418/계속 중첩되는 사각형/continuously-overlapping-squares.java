import java.util.*;

public class Main {

    public static final int RED = 0;
    public static final int BLUE = 1;

    public static final int OFFSET = 100;
    public static int[][] grid = new int[2 * OFFSET + 1][2 * OFFSET + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int color = RED;
        for(int i = 0; i < N; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    grid[j][k] = color;
                }
            }

            color = (color + 1) % 2;
        }

        int area = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == BLUE) {
                    area++;
                }
            }
        }
        System.out.println(area);
    }
}