package Backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1463 {
    static Integer[] dp; // 메모이제이션 배열, 여기서 dp[N]은 N에서 1까지 가는데 연산하는 횟수를 저장함.
    private static int dp(int N) {
        // dp[N]에는 연산에 필요한 횟수 중 최솟값이 저장된다. 각각의 단계마다 사용될 수 있는 연산을 조건별로 나눈 뒤에
        // 가장 적게 걸리는 연산 방법을 선택한다. dp[N]이 최솟값을 갖기 위해서는 1에서 N까지 가는 과정에서 모든 연산이 최솟값의 합으로 이루어져야 한다.
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(dp(N - 1), Math.min(dp(N / 3), dp(N / 2))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(dp(N / 3), dp(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(dp(N / 2), dp(N - 1)) + 1;
            } else {
                dp[N] = dp(N - 1) + 1;
            }
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = dp[1] = 1;
        int result = dp(N);
        System.out.println(result);
    }
}
