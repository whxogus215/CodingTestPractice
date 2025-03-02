import java.util.*;

public class Main {

    public static int K;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();

        int[][] result = new int[K][N + 1];

        for(int i = 0; i < K; i++) {
            for(int j = 1; j <= N; j++) {
                result[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        for(int a = 1; a <= N; a++) {
            for(int b = 1; b <= N; b++) {
                if (a == b) {
                    continue;
                }
                if (isRight(result, a, b)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isRight(int[][] result, int a, int b) {
        for(int i = 0; i < K; i++) {
            int[] match = result[i];
            boolean isBeforeB = false;
            for(int j = 1; j <= N; j++) {
                if (match[j] == b) {
                    isBeforeB = true;
                }
                if (match[j] == a && isBeforeB) {
                    return false;
                }
            }
        }
        return true;
    }
}