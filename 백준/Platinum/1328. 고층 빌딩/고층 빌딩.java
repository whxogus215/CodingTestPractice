import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final long DIV = 1000000007;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        long[][][] dp = new long[N + 1][L + 1][R + 1];
        dp[1][1][1] = 1;

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= L; j++) {
                for(int k = 1; k <= R; k++) {
                    dp[i][j][k] = (dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + (i - 2) * dp[i - 1][j][k]) % DIV;
                }
            }
        }
        
        System.out.println(dp[N][L][R]);
    }
}
