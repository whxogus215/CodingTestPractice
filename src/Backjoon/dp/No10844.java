package Backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10844 {

    static final long MOD = 1_000_000_000L;
    static Long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];

        // NullPoitner 막기 위해서는 0인 경우도 초기화 해야 함 -> 계단수의 마지막이 0으로 끝나는 경우도 있으므로
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L; // 1개 짜리 수에서 가질 수 있는 경우의 수는 각각 1가지
        }

        long result = 0;

        for (int i = 1; i < 10; i++) {
            result += makeStair(N, i); // N개의 길이를 갖는 수에서 i로 시작하는 계단수의 갯수
        }
        System.out.println(result % MOD);

    }

    private static long makeStair(int n, int i) {
        if (dp[n][i] != null) return dp[n][i]; // 계단수의 개수가 이전에 계산되었다면 반복 연산 X

        /*
        재귀 함수) N개의 계단수의 경우의 수는 N-1개의 계단수를 통해 얻을 수 있다. - Optimal Substructure
         */
        // base case : (n == 1) main 함수에서 정의했다고 가정
        if (n == 1) return dp[n][i];
        if (i == 0){
            dp[n][i] = makeStair(n - 1, 1) % MOD; // 0 다음에 올 수 있는 수는 1밖에 없음
        } else if (i == 9) {
            dp[n][i] = makeStair(n - 1, 8) % MOD; // 9 다음에 올 수 있는 수는 8밖에 없음
        } else {
            dp[n][i] = (makeStair(n - 1, i + 1) + makeStair(n - 1, i - 1)) % MOD;
        }

        return dp[n][i];
    }


}
