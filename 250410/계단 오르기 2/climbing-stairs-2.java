import java.util.*;

public class Main {

    public static final int INT_MIN = Integer.MIN_VALUE;
    public static int N;
    public static int[] arr;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1][1] = arr[1];
        dp[2][0] = arr[2]; dp[2][2] = arr[1] + arr[2];

        for(int i = 3; i <= N; i++) {
            for(int j = 0; j <= 3; j++) {
                if (dp[i - 2][j] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + arr[i]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + arr[i]);
                }
            }
        }

        int max = INT_MIN;
        for(int i = 0; i <= 3; i++) {
            max = Math.max(max, dp[N][i]);
        }
        System.out.println(max);
    }
}