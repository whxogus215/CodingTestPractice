import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[N + 1][3];
        dp[1][1] = arr[1];

        for(int i = 2; i <= N; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + arr[i];
            dp[i][2] = dp[i - 1][1] + arr[i];
        }
        
        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }
}