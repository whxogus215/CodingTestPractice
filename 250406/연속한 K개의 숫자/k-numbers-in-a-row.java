import java.util.*;

public class Main {

    public static int N, K, B;
    public static int[] sum, arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); K = sc.nextInt(); B = sc.nextInt();

        arr = new int[N + 1];
        while(B > 0) {
            int idx = sc.nextInt();
            arr[idx] = 1;
            B--;
        }

        sum = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int minCount = Integer.MAX_VALUE;
        for(int i = 1; i + K - 1 <= N; i++) {
            int count = getSum(i, i + K - 1);
            minCount = Math.min(minCount, count);
        }

        System.out.println(minCount);
    }

    public static int getSum(int start, int end) {
        return sum[end] - sum[start - 1];
    }
}