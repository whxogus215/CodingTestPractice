import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            String line = sc.next();
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        
        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i++) {
            dp[0][i] = arr[0][i];
        }
        for(int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if (arr[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        int maxLength = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        
        System.out.println(maxLength * maxLength);
    }
}
