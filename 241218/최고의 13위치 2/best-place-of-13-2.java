import java.util.*;

public class Main {

    private static int N;
    private static final int MAX_N = 20;
    private static int[][] grid = new int[MAX_N][MAX_N];

    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 2; j++) {
                int start = j;
                int end = j + 2;
                int result = grid[i][start] + grid[i][start + 1] + grid[i][end];

                for(int k = i; k < N; k++) {
                    for(int l = 0; l < N - 2; l++) {
                        // 두 개의 격자가 같은 행일 때 열이 겹치면 안된다.
                        if (k == i && l <= end) {
                            continue;
                        }
                        int secondResult = grid[k][l] + grid[k][l + 1] + grid[k][l + 2];
                        max = Math.max(max, result + secondResult);
                    }
                }
            }
        }

        System.out.println(max);
    }
}