import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0; i < n; i++) {
            String line = sc.next();
            for(int j = 0; j < m; j++) {
                int number = Integer.parseInt(String.valueOf(line.charAt(j)));
                if (i > 0 && j > 0 && number == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = number;    
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max * max);
    }
}
