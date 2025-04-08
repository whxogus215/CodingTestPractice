import java.util.*;

public class Main {

    public static int N;
    public static int[][] arr, preSum, visited;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

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
        for (int i1 = 1; i1 <= N; i1++) {
            for (int j1 = 1; j1 <= N; j1++) {
                for (int i2 = i1; i2 <= N; i2++) {
                    for (int j2 = j1; j2 <= N; j2++) {
                        int sum = preSum[i2][j2] - preSum[i1-1][j2] - preSum[i2][j1-1] + preSum[i1-1][j1-1];
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.println(max);
    }

}