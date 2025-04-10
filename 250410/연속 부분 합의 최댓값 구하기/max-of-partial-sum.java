import java.util.*;

public class Main {

    public static final int INT_MIN = Integer.MIN_VALUE;
    public static int N;
    public static int[] dp, arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N + 1];
        dp = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = arr[1];
        for(int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int max = INT_MIN;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}