import java.util.*;

public class Main {

    public static int N;
    public static int[][] arr, preSum;
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

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                calculate(i, j, i, j);
            }
        }

        System.out.println(max);
    }

    public static void calculate(int i1, int j1, int i2, int j2) {
        if (!inRange(i2, j2)) {
            return ;
        }
        int sum = getRangeSum(i1, j1, i2, j2);

        max = Math.max(max, sum);

        calculate(i1, j1, i2 + 1, j2);
        calculate(i1, j1, i2, j2 + 1);
        calculate(i1, j1, i2 + 1, j2 + 1);

        return ;
    }

    public static boolean inRange(int row, int col) {
        return row >= 1 && row <= N && col >= 1 && col <= N;
    }

    public static int getRangeSum(int i1, int j1, int i2, int j2) {
        return preSum[i2][j2] 
        - preSum[i1 - 1][j2]
        - preSum[i2][j1 - 1] 
        + preSum[i1 - 1][j1 - 1];
    }
}