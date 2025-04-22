import java.util.Scanner;

public class Main {

    public static final int COMFORTABLE = 3;
    public static final int DIR = 4;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][n];
        for(int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            grid[r][c] = 1;
            int count = 0;
            for(int j = 0; j < DIR; j++) {
                int nc = c + dx[j];
                int nr = r + dy[j];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                if (grid[nr][nc] == 1) {
                    count++;
                }
            }
            if (count == COMFORTABLE) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}