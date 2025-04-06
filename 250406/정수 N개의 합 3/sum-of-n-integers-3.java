import java.util.*;

public class Main {

    public static int N, K;
    public static int[][] arr;
    public static int[][] preSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N + 1][N + 1];
        preSum = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + arr[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i + (K - 1) <= N; i++) {
            for(int j = 1; j + (K - 1) <= N; j++) {
                int x1 = i; int y1 = j;
                int x2 = i + (K - 1); int y2 = j + (K - 1);

                int curSum = preSum[x2][y2] - preSum[x1 - 1][y2] - preSum[x2][y1 - 1] + preSum[x1 - 1][y1 - 1];
                max = Math.max(max, curSum);
            }
        }

        System.out.println(max);
    }
}