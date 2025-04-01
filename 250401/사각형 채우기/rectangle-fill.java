import java.util.*;

public class Main {
    
    public static final int MOD = 10007;
    public static int N;
    public static int[] dp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1];

        dp[0] = 1; dp[1] = 1; dp[2] = 2;

        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}