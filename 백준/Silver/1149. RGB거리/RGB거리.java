import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] red = new int[N];
        int[] green = new int[N];
        int[] blue = new int[N];

        for (int i = 0; i < N; i++) {
            red[i] = sc.nextInt();
            green[i] = sc.nextInt();
            blue[i] = sc.nextInt();
        }

        int[][] dp = new int[N][3];

        dp[0][0] = red[0];
        dp[0][1] = green[0];
        dp[0][2] = blue[0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue[i];
        }

        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }
}
