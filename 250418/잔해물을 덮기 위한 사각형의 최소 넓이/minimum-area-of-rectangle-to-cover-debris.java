import java.util.*;

public class Main {

    public static final int OFFSET = 1000;
    public static int[][] grid = new int[2 * OFFSET + 1][2 * OFFSET + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 2; i++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    grid[j][k] = i;
                }
            }
        }

        int minX = 2 * OFFSET + 1, minY = 2 * OFFSET + 1;
        int maxX = -1, maxY = -1;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                minX = Math.min(minX, i); minY = Math.min(minY, j);
                maxX = Math.max(maxX, i); maxY = Math.max(maxY, j);
            }
        }
        
        int area = 0;
        for(int i = minX; i <= maxX; i++) {
            for(int j = minY; j <= maxY; j++) {
                area++;
            }
        }
        System.out.println(area);
    }
}