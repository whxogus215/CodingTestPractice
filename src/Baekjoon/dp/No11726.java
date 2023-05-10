package Backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11726 {
    static Integer[] dp; // 메모이제이션 할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 2]; // dp[n]에도 값이 들어가야 하기 때문이다.
        dp[1] = 1;
        dp[2] = 2;

        int result = square2byN(n); // 2 X N 직사각형의 조합의 수

        System.out.println(result); // 문제에서 요구한 양식대로 출력
    }

    private static int square2byN(int N) {
        if (dp[N] != null) return dp[N];

        dp[N] = (square2byN(N - 2) + square2byN(N - 1)) % 10007;

        return dp[N];
    }
}
