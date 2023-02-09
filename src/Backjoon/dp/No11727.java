package Backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11727 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 3;

        int result = square2byN2(n);
        System.out.println(result);
    }

    private static int square2byN2(int N) {
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
        }

        return dp[N];
    }
}
