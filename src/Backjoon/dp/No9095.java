package Backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095 {

    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(OneTwoThreeSum(n));
        }
    }

    private static int OneTwoThreeSum(int N) {
        if(dp[N] != 0) return dp[N];

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        return dp[N];
    }
}
