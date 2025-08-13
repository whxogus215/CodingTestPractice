import java.util.Scanner;

class Main {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    private static int[][] rgb;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        rgb = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N][3];
        dp[0][RED] = rgb[0][RED];
        dp[0][GREEN] = rgb[0][GREEN];
        dp[0][BLUE] = rgb[0][BLUE];

        for(int i = 1; i < N; i++) {
            dp[i][RED] = Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]) + rgb[i][RED];
            dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + rgb[i][GREEN];
            dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + rgb[i][BLUE];
        }

        System.out.println(Math.min(Math.min(dp[N - 1][RED], dp[N - 1][GREEN]), dp[N - 1][BLUE]));
    }
}
